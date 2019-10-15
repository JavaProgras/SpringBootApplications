package com.Inventory.MWJ.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Inventory.MWJ.Model.User;



public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("SELECT u FROM User u WHERE u.reg_new_user_name_input = :reg_new_user_name_input")
    public User find(@Param("reg_new_user_name_input") String reg_new_user_name_input);

}
