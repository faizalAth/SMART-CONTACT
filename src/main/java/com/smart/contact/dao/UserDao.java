package com.smart.contact.dao;

import org.springframework.stereotype.Service;

import com.smart.contact.entities.MstUserBo;

@Service
public interface UserDao {
    public MstUserBo registerUser(MstUserBo bo);
}
