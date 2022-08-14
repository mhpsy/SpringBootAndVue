package top.mhpsy.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import top.mhpsy.springboot.mapper.UserMapper;
import top.mhpsy.springboot.pojo.User;


import java.util.List;

@RequestMapping("/user")
@RestController
public class getUser {

    private final UserMapper userMapper;

    public getUser(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        if (!StringUtils.isEmpty(user.getUsername()) || !StringUtils.isEmpty(user.getPassword())) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.setEntity(user);
            List<User> users = userMapper.selectList(queryWrapper);
            if (!(users.size() == 1)) {
                return null;
            }else{
                return users.get(0);
            }
        }
        throw new IllegalStateException("cannot find user");
    }

    @GetMapping("/All")
    public List<User> getAllUsers() {
        return userMapper.selectList(null);
    }

    @GetMapping("/ById/{id}")
    public User getUserBy(@PathVariable Integer id) {
        return userMapper.selectById(id);
    }

    @GetMapping("/ByName/{name}")
    public List<User> getUserByName(@PathVariable String name) {
        QueryWrapper<User> query = new QueryWrapper<>();
        User user = new User();
        user.setUsername(name);
        query.setEntity(user);
        return userMapper.selectList(query);
    }

    @GetMapping("/hasUserByName/{name}")
    public boolean hasUserByName(@PathVariable String name) {
        QueryWrapper<User> query = new QueryWrapper<>();
        User user = new User();
        user.setUsername(name);
        query.setEntity(user);
        List<User> users = userMapper.selectList(query);
        return users.size() > 0;
    }

    @PutMapping("/updateUserByID")
    public String updateUserByID(@RequestBody User user) {
        if ((user.getId() == null)
                || (StringUtils.isEmpty(user.getUsername()))
                || (StringUtils.isEmpty(user.getPassword()))) {
            throw new RuntimeException("参数错误");
        }
        userMapper.updateById(user);
        return user.getId() + user.getUsername() + " updateUserByID Done!";
    }


    @DeleteMapping("/deleteById/{userId}")
    public Boolean deleteUserById(@PathVariable Integer userId) {
        if (userId == null) {
            throw new IllegalArgumentException("userId cannot be null");
        }
        return userMapper.deleteById(userId) == 1;
    }

}
