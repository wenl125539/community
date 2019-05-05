package com.wenl.service;

import com.wenl.pojo.User;

import java.util.List;


public interface UserService {
    /**
     * 添加用户
     * @param record
     * @return
     */
    int insertSelective(User record);

    /**
     * 获取所有用户信息
     * @return
     */
    List<User> selectAllUser();

    /**
     * 添加头像
     * @param user
     * @return
     */
    int addHead(User user);
}
