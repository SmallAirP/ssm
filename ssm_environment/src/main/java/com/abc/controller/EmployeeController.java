package com.abc.controller;

import com.abc.bean.Employee;
import com.abc.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
//        System.out.println("表现层 查询账户");
//        return "succeed";

        iEmployeeService.addEmployee(new Employee(-12,"xiaoming","成都"));
        System.out.println("dsd");
        return "succeed";
    }

    /**
     * 新增
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ModelAndView addEmployee(@Validated Employee employee, BindingResult bindingResult){
        ModelAndView mv = new ModelAndView();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        if (allErrors.size() > 0){
            if (bindingResult.getFieldError("age") != null){
                mv.addObject("ageError",bindingResult.getFieldError("age"));
            }if (bindingResult.getFieldError("name") != null){
                mv.addObject("nameError",bindingResult.getFieldError("name"));
            }if (bindingResult.getFieldError("address") != null){
                mv.addObject("addressError",bindingResult.getFieldError("address"));
            }

        }
        mv.setViewName("failed");
        iEmployeeService.addEmployee(new Employee(12,"xiaoming","成都"));
        return mv;
    }

    /**
     * 修改
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView updateEmployee(@Validated Employee employee, BindingResult bindingResult){
        ModelAndView mv = new ModelAndView();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        if (allErrors.size() > 0){
            if (bindingResult.getFieldError("age") != null){
                mv.addObject("ageError",bindingResult.getFieldError("age"));
            }if (bindingResult.getFieldError("name") != null){
                mv.addObject("nameError",bindingResult.getFieldError("name"));
            }if (bindingResult.getFieldError("address") != null){
                mv.addObject("addressError",bindingResult.getFieldError("address"));
            }

        }
        mv.setViewName("failed");
        iEmployeeService.updateEmployee(new Employee(12,"xiaoming","成都"),1);
        return mv;
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
