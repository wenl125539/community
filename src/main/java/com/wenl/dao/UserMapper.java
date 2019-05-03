package com.wenl.dao;

import com.wenl.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository//去掉service层的报红，【即使 报红 也不影响运行】
public interface UserMapper {

    int insertSelective(User record);

    List<User> selectAllUser();

    int addHead(User user);
}