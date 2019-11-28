package com.fh.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.fh.model.User;

public interface UserDao extends JpaRepository<User, Integer>{
	/**
	    * 查询user集合
	    * 若是nativeQuery = true则写表名，反之是实体类名
	    * @return
	    */
	@Query(value = "select * from User ",nativeQuery = true)
			@Modifying
			List<User> userList();
}
