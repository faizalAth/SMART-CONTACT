package com.smart.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.contact.entities.MstUserBo;

@Repository
public interface UserRepo extends JpaRepository<MstUserBo,Integer>{
    
}
