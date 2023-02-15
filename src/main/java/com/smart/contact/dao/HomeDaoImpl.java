package com.smart.contact.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smart.contact.entities.MstUserBo;
import com.smart.contact.repository.UserRepo;

@Component
public class HomeDaoImpl implements HomeDao{

    @Autowired UserRepo userRepo;

    @Override
    public MstUserBo registerUser(MstUserBo bo) {
        return userRepo.save(bo);
    }
    
}
