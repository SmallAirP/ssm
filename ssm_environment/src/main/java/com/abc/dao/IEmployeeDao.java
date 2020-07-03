package com.abc.dao;

import com.abc.bean.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IEmployeeDao {

    //添加人员
    @Insert("insert into employee(age,name,address) values (#{age},#{name},#{address})")
    void addEmployee(Employee employee);

    //查询所有
    @Select("select * from employee")
    List<Employee> findALll();


    //删除人员
    @Delete("delete from employee where id = #{id}")
    void deleteEmployeeById(int id);

    @Update("update employee set age = #{age},name = #{name},address = #{address} where id = #{id}")
    void updateEmployee(Employee employee,int id);

}
