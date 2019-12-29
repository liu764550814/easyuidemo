package com.nuaa.demo.service.Impl;

import com.nuaa.demo.constant.UserStatus;
import com.nuaa.demo.dao.UserDao;
import com.nuaa.demo.entity.TUserEntity;
import com.nuaa.demo.exception.UserNameExistsException;
import com.nuaa.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void adduser(TUserEntity user) throws UserNameExistsException{
        if(userDao.selectuserByname(user)>0){
            System.out.println("该用户已经存在！");
            throw new UserNameExistsException("该用户已经存在！");
        }else {
            user.setStatus(UserStatus.USER_STATUS_ENABLE);
            userDao.adduser(user);
        }
    }

    @Override
    public void updateUser(TUserEntity user,boolean issame) throws UserNameExistsException {

        if (issame){
            userDao.updateUser(user);
        }else {
            if(userDao.selectuserByname(user)>0){
                System.out.println("该用户已经存在！");
                throw new UserNameExistsException("该用户已经存在！");
            }else {
                System.out.println("执行了！");
                userDao.updateUser(user);
            }
        }



    }

    public List<TUserEntity> selectUser(){
        List<TUserEntity> list;
        try {
            list = userDao.selectUser();
            for (TUserEntity user :list) {
                System.out.println(user);
            }
            return list;
        }catch ( Exception e){
            System.out.println("查询数据失败！");
            return null;
        }
    }
    //删除用户
    public boolean deleteUser(int id){
        try {
            userDao.delUser(id);
            return true;
        }catch ( Exception e){
            return false;
        }
    }


    public boolean updatestatus(TUserEntity user){
        try {
            userDao.updatestatus(user);
            return true;
        }catch ( Exception e ){
            return false;
        }
    }

    public List<TUserEntity> search(TUserEntity user){
        List<TUserEntity> list;
        System.out.println("search");
        try {
            list = userDao.search(user);
            for (TUserEntity users :list) {
                System.out.println(users);
            }
            return list;
        }catch ( Exception e ){
            return null;
        }

    }
}
