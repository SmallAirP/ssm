package com.abc.bean;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Employee implements Serializable {
    private Integer id;



    @Min(value = 0,message = "年龄不能小于{value}")
    @Max(value = 0,message = "年龄不能大于{value}")
    private int age;

    @NotEmpty(message = "姓名不能不为空")
    @Size(min = 2,max = 5,message = "姓名长度应在{min}-{max}之间")
    private String name;

    @NotEmpty(message = "地址不能不为空")
    private String address;

    public Employee() {
    }

    public Employee(int age, String name, String address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
