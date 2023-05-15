package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClineServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                System.out.println("DeptClineServiceFallbackFactory+get");
                return new Dept().setDeptno(id).setDb_source("no this database in Mysql").setDname("该id" + id + "没有对应信息,Consumer客户端提供的降级信息，此刻provider服务已经关闭");
            }

            @Override
            public List<Dept> list() {
                System.out.println("DeptClineServiceFallbackFactory+list");
                return null;
            }
        };
    }
}
