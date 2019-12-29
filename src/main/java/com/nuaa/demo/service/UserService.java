package com.nuaa.demo.service;

import com.nuaa.demo.entity.TUserEntity;
import com.nuaa.demo.exception.UserNameExistsException;

import java.util.List;

public interface UserService {
   public void adduser(TUserEntity user) throws UserNameExistsException;
   public void updateUser(TUserEntity user,boolean issame) throws UserNameExistsException;
   public List<TUserEntity> selectUser();
   public boolean deleteUser(int id);
   public boolean updatestatus(TUserEntity user);
   public List<TUserEntity> search(TUserEntity user);
}
