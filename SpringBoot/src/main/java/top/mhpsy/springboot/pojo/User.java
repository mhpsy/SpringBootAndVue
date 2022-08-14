package top.mhpsy.springboot.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

@Data
public class User {
    @TableId
    private Integer id;

    private String username;
    private String password;

    @TableLogic
    private Integer isDelete;

}
