package com.smart.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smart.contact.entities.MstUserBo;

@Repository
public interface UserRepo extends JpaRepository<MstUserBo,Integer>{
    
	@Query(value = "from MstUserBo where email_id=:email_id")
	public MstUserBo getUserByUserName(@Param("email_id") String email_id);
}
