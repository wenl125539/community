package com.wenl.controller;

import com.alibaba.fastjson.JSONObject;
import com.wenl.pojo.User;
import com.wenl.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/register",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public Map<String,Object> register(@RequestBody JSONObject jsonObject){
        //获取json数据
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        //封装
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setCreated(new Date());
        user.setUpdated(new Date());
        //查看是否储存成功 返回值为0 则保存失败
        int i = userService.insertSelective(user);
        Map<String,Object> map = new HashMap<>();
        if(i==0){
            map.put("msg","保存失败");
            return map;
        }
        map.put("msg","保存成功");
        return map;
    }

    @RequestMapping(value = "/findAllUser",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<User> findAllUser(){
        return userService.selectAllUser();
    }


    @ResponseBody
    @RequestMapping(value = "/upload/{username}",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public Map<String,Object> upload(MultipartFile file,@PathVariable String username) throws IOException {
            Map<String,Object> map = new HashMap<>();
           if(file != null){
               //将文件转换为字节
               byte[] bytes = file.getBytes();
               //获取项目根目录
               String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
               //根据时间给文件命名
               String path2 = new Date().getTime()+".jpg";
               //创建文件
               BufferedOutputStream stream = new BufferedOutputStream(
                       new FileOutputStream(new File(path+"static/img/"+path2)));
               //将字节写进文件中
               stream.write(bytes);
               stream.close();

               //保存数据库
               User user = new User();
               user.setUsername(username);
               user.setHead(path2);
               userService.addHead(user);

               System.out.println("图片上传完毕，存储地址为："+path+"static/img/"+path2);
               map.put("msg","保存成功");
           }else{
               map.put("msg","保存失败");
           }
            return map;
    }
}
