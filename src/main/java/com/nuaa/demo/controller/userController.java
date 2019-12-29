package com.nuaa.demo.controller;

import com.nuaa.demo.entity.TUserEntity;
import com.nuaa.demo.exception.UserNameExistsException;
import com.nuaa.demo.service.UserService;
import com.nuaa.demo.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class userController {
    @Autowired
    private UserService userService;

    @RequestMapping("/start")
    public String mainpage(){
        return "index";
    }

    @ResponseBody
    @RequestMapping("/add")
    //添加用户
    public ResponseResult adduser(TUserEntity user) {
        System.out.println(user.getName() + "," + user.getPhone() + "," + user.getAddress());
        ResponseResult result = new ResponseResult();
        try {
            userService.adduser(user);
            return ResponseResult.success("添加成功！");
        } catch ( UserNameExistsException e ) {
            return ResponseResult.fail(e.getMessage());
        }
    }
    //修改用户
    @RequestMapping("/update")
    @ResponseBody
    //boolean issame表示姓名有没有修改，因为数据库里的姓名是不能重复的，所以做判断用
    public ResponseResult updateUser(TUserEntity user,boolean issame){
        ResponseResult result = new ResponseResult();
        System.out.println("issame"+issame);
        try {
            System.out.println(issame);
            userService.updateUser(user,issame);
            return ResponseResult.success("修改成功！");
        } catch ( UserNameExistsException e ) {
            return ResponseResult.fail(e.getMessage());
        }
    }

    @RequestMapping("/select")
    @ResponseBody
    public ResponseResult selectall(){
        List<TUserEntity> list = userService.selectUser();
        if(list == null){
           return ResponseResult.fail("查询失败！");
        }
        System.out.println(list.get(0));
        return ResponseResult.success(list);
    }
    @ResponseBody
    @RequestMapping("/deluser")
    public  ResponseResult deluser(TUserEntity user){
        if(userService.deleteUser(user.getId())){
            return ResponseResult.success("删除成功！");
        }else {
            return ResponseResult.fail("删除失败！");
        }
    }

    @ResponseBody
    @RequestMapping("/updatestatus")
    public ResponseResult updateStatus(TUserEntity user){
        System.out.println(user.getId()+","+user.getStatus());
        if (user.getStatus()==0){
            user.setStatus(1);
        }else {
            user.setStatus(0);
        }
        if(userService.updatestatus(user)){
            return ResponseResult.success();
        }else {
            return ResponseResult.fail("修改失败");
        }
    }

    @ResponseBody
    @RequestMapping("/search")
    public ResponseResult search(TUserEntity user){

        System.out.println(user.getName()+","+user.getPhone()+","+user.getStatus());
        List<TUserEntity> list = userService.search(user);

        for (TUserEntity users:list ) {
            System.out.println(users.getName()+","+users.getPhone());
        }
        System.out.println(list.size());
        if (list == null){
            return ResponseResult.fail("查询出错！");
        }else {
            return ResponseResult.success(list);
        }
    }
}