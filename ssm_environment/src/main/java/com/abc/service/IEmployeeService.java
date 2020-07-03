package com.abc.service;

import com.abc.bean.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.validation.annotation.Validated;

import java.util.List;

public interface IEmployeeService {
    //查询所有
    List<Employee> findALll();

    //添加人员
    void addEmployee(@Validated Employee employee);

    //删除人员
    void deleteEmployeeById(int id);

    //修改人员
    void updateEmployee(Employee employee,int id);
}
