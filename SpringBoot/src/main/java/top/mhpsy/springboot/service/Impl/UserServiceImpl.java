package top.mhpsy.springboot.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.mhpsy.springboot.mapper.UserMapper;
import top.mhpsy.springboot.pojo.User;
import top.mhpsy.springboot.service.UserService;

public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
