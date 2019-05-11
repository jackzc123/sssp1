package com.usoft.dao;

import com.usoft.entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

/**
 * @author zc
 * @create 2019-05_11-18:27
 */
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
}
