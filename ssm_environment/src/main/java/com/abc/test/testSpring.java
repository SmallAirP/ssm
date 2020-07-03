package com.abc.test;


import com.abc.bean.Employee;
import com.abc.dao.IEmployeeDao;
import com.abc.service.IEmployeeService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class testSpring {

    @Test
    public void run1(){
//        ApplicationContext ac =
//                new ClassPathXmlApplicationContext("applicationContext.xml");
//        IEmployeeService iEmployeeService = ac.getBean("employeeService",IEmployeeService.class);
//        iEmployeeService.findALll();
        Employee e = new Employee(-14,"121","ds");
        System.out.println(e);

    }

    @Test
    public void test02() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IEmployeeDao mapper = (IEmployeeDao) sqlSession.getMapper(IEmployeeDao.class);

        List<Employee> aLll = mapper.findALll();
        for (Employee employee : aLll) {
            System.out.println(employee);
        }
    }

    @Test
    public void test3() throws Exception{
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IEmployeeDao mapper = (IEmployeeDao) sqlSession.getMapper(IEmployeeDao.class);
        mapper.addEmployee(new Employee(23,"蜘蛛侠","纽约"));

    }
}
