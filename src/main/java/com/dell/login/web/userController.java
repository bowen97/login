package com.dell.login.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.dell.login.entity.userEntity;
import com.dell.login.mapper.userMapper;
import java.util.UUID;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import redis.clients.jedis.Jedis;
import org.junit.Test;

@Controller

@CrossOrigin(origins = {"http://localhost:8080", "null"})
public class userController {

    @Autowired
    private userMapper UserMapper;

    private static Jedis jedis;

    static{
        jedis = new Jedis("127.0.0.1",6379);
    }

    @Test
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String getUsers(@RequestParam(value = "username",required = true) String userName,
                               @RequestParam(value = "password",required = true) String userPassword){
        userEntity users=UserMapper.getAll(userName, userPassword);

        String token = UUID.randomUUID().toString().replace("-","");

        if (users != null){
            jedis.set(userName,token);
            System.out.println(jedis.get(userName));
            return(token);//if username and password matchs return token
        }
        else{
            return("0");//else return 0
        }
    }


    @ResponseBody
    @RequestMapping(value = "/addNewBlog")
    public void addNewBlog(userEntity user){

        UserMapper.insert(user);
        
    }

    @ResponseBody
    @RequestMapping(value = "/changeContent")
    public void changeContent(userEntity user){
        UserMapper.update(user);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteBlog")
    public void deleteBlog(int id){
        UserMapper.delete(id);
    }

    @ResponseBody
    @RequestMapping(value = "/showBlog", method = RequestMethod.GET)
    public List<userEntity> showBlog(){ //start and end represent the interval of the page number.
        int numberOfBlog=UserMapper.count();//total amount of blog

        List<userEntity> blog = UserMapper.getBlog(0);

        return blog;

    }

    @ResponseBody
    @RequestMapping(value = "/showContent")
    public String showContent(int id){
        String result = UserMapper.getContent(id);

        return result;
    }







}
