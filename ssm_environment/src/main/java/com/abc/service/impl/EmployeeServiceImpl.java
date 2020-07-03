package com.abc.service.impl;

import com.abc.bean.Employee;
import com.abc.dao.IEmployeeDao;
import com.abc.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeDao dao;

    @Override
    public List<Employee> findALll() {
        List<Employee> list = dao.findALll();
        return list;
    }

    @Override
    public void addEmployee(@Validated Employee employee) {
        dao.addEmployee(employee);

    }

    @Override
    public void deleteEmployeeById(int id) {
        dao.deleteEmployeeById(id);

    }

    @Override
    public void updateEmployee(@Validated Employee employee,int id) {
        dao.updateEmployee(employee,id);
    }
}
