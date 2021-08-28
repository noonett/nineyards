package appcurate.capstone.nineyards.controller;

import appcurate.capstone.nineyards.entity.User;
import appcurate.capstone.nineyards.service.UserService;
import appcurate.capstone.nineyards.util.NineyardsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller //有这样的注解的bean才会被扫描或者@service, @Repository
@RequestMapping("/alpha")
public class AlphaController {

    //controller依赖service执行服务
    @Autowired
    private UserService userService;

    // Hello World
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello Spring Boot.";
    }

    /*
        GET请求
     */

    // /register?name=tyh&password=123456  (在请求Url上带参数)
    @RequestMapping(path = "register", method = RequestMethod.GET)
    @ResponseBody
    public String register(   //传入的参数,RequestParam还可以设置参数
                                 @RequestParam(name = "name", required = false, defaultValue = "tyh") String name,
                                 @RequestParam(name = "password", required = false, defaultValue = "123456") String password) {
        User user = User.builder()
                .username(name)
                .password(password)
                .build();

        Map<String, Object> map = userService.addUser(user);
        return NineyardsUtil.getJSONString(200, (String) map.get("userMsg"));
    }

    // /student/123 （直接将参数编排到路径中）
    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(   //传入的参数,RequestParam还可以设置参数
                                @PathVariable("id") int id) {
        System.out.println(id);
        return "a student";
    }

    /*
        POST请求
     */
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name, int age) {
        System.out.println(name);
        System.out.println(age);
        return "success";
    }


    /*
        返回一个页面HTML的两种方法
     */
    //返回响应HTML数据
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)  //不加responsebody，默认返回html
    public ModelAndView getTeacher() {   //给DispatcherServlet返回的model和view
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "张三");
        mav.addObject("age", "30");
        // 动态页面的路径
        mav.setViewName("/demo/view");
        return mav;
    }

    //上面是把view和对象装进model返回model给DispatcherServlet
    //这里是传入前端控制器创建的model实例，然后往里装数据
    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getSchool(Model model) {   //返回html的路径
        model.addAttribute("name", "悉尼大学");
        model.addAttribute("age", 150);
        return "/demo/view";
    }


    /*
        JSON请求，流程如下：
        JAVA对象 -> JSON字符串 -> JS对象 ：通过JSON实现Java对象与JS对象的交互，本质是JSON字符串
     */

    // Map型Json
    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody       //为了返回字符串
    public Map<String, Object> getEmp() {    //DispatcherServlet看到key-value结构和@Responsebody会自动转为Json字符串传给浏览器
        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "张三");
        emp.put("age", 23);
        emp.put("salary", 8000.00);
        return emp;
    }

    // List<Map>型Json
    @RequestMapping(path = "/emps", method = RequestMethod.GET)
    @ResponseBody       //为了返回字符串
    public List<Map<String, Object>> getEmps() {    //DispatcherServlet看到key-value结构和@Responsebody会自动转为Json字符串传给浏览器
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "张三");
        emp.put("age", 23);
        emp.put("salary", 8000.00);
        list.add(new HashMap<>(emp));

        emp.put("name", "李四");
        emp.put("age", 24);
        emp.put("salary", 9000.00);
        list.add(new HashMap<>(emp));

        emp.put("name", "王五");
        emp.put("age", 25);
        emp.put("salary", 10000.00);
        list.add(new HashMap<>(emp));
        return list;
    }

    // AJAX demo
    @RequestMapping(path = "/ajax", method = RequestMethod.POST)
    @ResponseBody
    public String testAjax(String name, int age) {
        System.out.println(name);
        System.out.println(age);
        return NineyardsUtil.getJSONString(0, "Success！");
    }

}
