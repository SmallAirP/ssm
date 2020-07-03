package com.abc.controller;

import com.abc.bean.Employee;
import com.abc.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    /**
     * 查询所有
     * @return
     */
    @GetMapping("/all")
    public String findAll(){
        System.out.println("表现层 查询账户");
        return "succeed";
    }

    /**
     * 新增
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public String addEmployee(){
        iEmployeeService.addEmployee(new Employee(12,"xiaoming","成都"));
        return "succeed";
    }

    /**
     * 修改
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String updateEmployee(){
        iEmployeeService.updateEmployee(new Employee(12,"xiaoming","成都"),1);
        return "succeed";
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteEmployee(){
        iEmployeeService.deleteEmployeeById(2);
        return "succeed";
    }
}
