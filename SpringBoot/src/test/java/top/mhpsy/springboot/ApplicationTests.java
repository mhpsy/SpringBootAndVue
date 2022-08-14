package top.mhpsy.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.mhpsy.springboot.mapper.UserMapper;
import top.mhpsy.springboot.pojo.User;

import java.util.List;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testMybatis(){
        List<User> users = userMapper.selectList(null);
        users.forEach(user-> System.out.println("user = " + user));
    }

}
