package com.usoft.service;

import com.usoft.dao.EmployeeRepository;
import com.usoft.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zc
 * @create 2019-05_11-17:41
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Transactional(readOnly=true)
    public Page<Employee> getAllEmps(int pageNum, int pageSize){
        PageRequest pageRequest = new PageRequest(pageNum - 1, pageSize);
        Page<Employee> page = employeeRepository.findAll(pageRequest);
        return page;
    }

    public void saveEmp(Employee employee){
        employeeRepository.save(employee);
    }

    public void deleteEmp(Integer id){
        employeeRepository.delete(id);
    }

    public Employee getEmp(Integer id){
        return employeeRepository.findOne(id);
    }

}
