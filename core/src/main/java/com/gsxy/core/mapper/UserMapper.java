package com.gsxy.core.mapper;

import com.gsxy.core.pojo.User;
import com.gsxy.core.pojo.bo.UserLoginBo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * @author hln 2023-10-23
     *      用户登录
     * @param userLoginBo
     * @return
     */
    User userLogin(UserLoginBo userLoginBo);

    /**
     * @author hln 2023-10-23
     *      根据用户名查询用户是否存在
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * @author hln 2023-10-23
     *      用户注册
     * @param user
     * @return
     */
    Long userReg(User user);

    /**
     * @author hln 2023-10-23
     *      通过id查找用户
     * @param id
     * @return
     */
    User selectByUserId(Long id);

    /**
     * @author hln 2023-10-23
     *      通过id删除用户
     * @param id
     * @return
     */
    Long deleteByUserId(String id);

    /**
     * @author hln 2023-10-23
     *      通过id修改用户
     * @param user
     * @return
     */
    Long updateByUserId(User user);

    /**
     * @author hln 2023-10-23
     *      查找所有信息
     * @return
     */
    List<User> userFindAll();
}
