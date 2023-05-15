package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class DeptController {
    @Autowired
    private DeptService deptService = null;

    @RequestMapping(value = "/dept/get/{id}", method=RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = this.deptService.get(id);
        if(null == dept){
            throw new RuntimeException("该Id" + id + "没有对应数据");
        }
        return dept;
    }


    public Dept processHystrix_Get(@PathVariable("id") Long id){
        return new Dept().setDeptno(id).setDb_source("no this database in Mysql").setDname("该id" + id + "没有对应信息,null-@HystrixComman");
    }
}
