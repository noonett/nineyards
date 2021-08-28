package appcurate.capstone.nineyards.service;

import appcurate.capstone.nineyards.controller.advice.ExceptionAdvice;
import appcurate.capstone.nineyards.dao.UserMapper;
import appcurate.capstone.nineyards.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    //Service依赖Dao层实现查询
    @Autowired
    private UserMapper userMapper;

    // 初始化后自动调用。
    @PostConstruct
    public void init() {
        System.out.println("初始化UserService");
    }

    //销毁前调用，用于释放资源。
    @PreDestroy
    public void destroy() {
        System.out.println("销毁UserService");
    }

    //模拟一个查询
    public User findUserById(int id) {
        return userMapper.selectById(id);
    }

    public Map<String, Object> addUser(User user){
        userMapper.insertUser(user);
        return Map.of("userMsg", "Put user success!");
    }
}
