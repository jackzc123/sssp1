package com.usoft.service;

import com.usoft.dao.DepartmentRepository;
import com.usoft.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zc
 * @create 2019-05_12-0:55
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDept(){
        return departmentRepository.findAll();
    }
}
