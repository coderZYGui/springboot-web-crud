package com.gzy.controller;

import com.gzy.dao.DepartmentDao;
import com.gzy.dao.EmployeeDao;
import com.gzy.pojo.Department;
import com.gzy.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Map;

/**
 * Description: 员工控制器
 *
 * @author zygui
 * @date 2020/4/14 20:09
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        // 放入请求域中
        model.addAttribute("emps", employees);
        // 模板引擎thymeleaf会自动拼接
        // classpath:/templates/xxx.html
        return "emp/list";
    }

    // 来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Map<String, Collection<Department>> map) {
        // 来到添加页面,查出所有的部门,在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("depts", departments);
        return "emp/add";
    }

    // 员工添加
    // SpringMVC自动将请求参数和入参对象的属性进行一一绑定: 请求参数名和JavaBean中的属性名相同
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        // 来到员工页面
        employeeDao.save(employee); // 保存员工
        System.out.println("保存的员工信息:" + employee);
        // redirect: 表示重定向到一个地址, /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/emps";
    }

    // 编辑员工
    @GetMapping("/emp/{id}") // RESTFUL风格传参
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        // 用于回显数据到表单
        model.addAttribute("emp", employee);

        // 页面显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/edit";
    }

    // 完成修改员工信息
    @PostMapping("/editEmp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    // 删除员工
    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id") int id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
