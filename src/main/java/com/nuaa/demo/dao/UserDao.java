package com.nuaa.demo.dao;

import com.nuaa.demo.entity.TUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {
    public void adduser(TUserEntity user);
    public int selectuserByname(TUserEntity user);
    public void updateUser(TUserEntity user);
    public List<TUserEntity> selectUser();
    public void delUser(int id);
    public void updatestatus(TUserEntity user);
    public List<TUserEntity> search(TUserEntity user);
}
