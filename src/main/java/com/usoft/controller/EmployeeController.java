package com.usoft.controller;

import com.usoft.entity.Employee;
import com.usoft.service.DepartmentService;
import com.usoft.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author zc
 * @create 2019-05_11-17:41
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/emps", method = RequestMethod.GET)
    public String getAllEmps(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum, Map<String, Object> map){
        map.put("emps", employeeService.getAllEmps(pageNum, 5));
        //System.out.println(employeeService.getAllEmps(pageNum, 5));
        return "empList";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String toEmpAdd(Map<String, Object> map){
        map.put("employee", new Employee());
        map.put("depts", departmentService.getAllDept());
        return "empAdd";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String empAdd(Employee employee){
        System.out.println(employee);
        employeeService.saveEmp(employee);
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("id")Integer id){
         employeeService.deleteEmp(id);
        return "redirect:/emps";
    }

    @ModelAttribute("employee")
    public void beforeUpdate(@RequestParam(value = "id", required = false) Integer id,
                             Map<String, Object> map){
        map.put("depts", departmentService.getAllDept());
        if (id == null) {
            map.put("employee", new Employee());
        } else {
            map.put("employee", employeeService.getEmp(id));
        }
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String toUdpate(@PathVariable("id")Integer id, Map<String, Object> map){
        map.put("employee", employeeService.getEmp(id));
        return "empAdd";
    }


    @RequestMapping(value = "/emp", method = RequestMethod.PUT)
    public String empUpdate(Employee employee){
        employeeService.saveEmp(employee);
        return "redirect:/emps";
    }

}
