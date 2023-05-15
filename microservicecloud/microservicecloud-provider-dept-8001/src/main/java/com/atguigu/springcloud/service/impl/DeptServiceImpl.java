package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.DeptDao;
import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptMapper;
    @Override
    public boolean add(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept findById(Long id) {
        System.out.println("DeptServiceImpl+findById");
        return deptMapper.findById(id);
    }

    @Override
    public List<Dept> findAll() {
        System.out.println("DeptServiceImpl+list");
        return deptMapper.findAll();
    }
}
