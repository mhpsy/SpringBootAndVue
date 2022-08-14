package top.mhpsy.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import top.mhpsy.springboot.pojo.User;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
