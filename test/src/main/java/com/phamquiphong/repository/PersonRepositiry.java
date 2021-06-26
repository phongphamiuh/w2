package com.phamquiphong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.phamquiphong.entity.Person;

@Repository
public interface PersonRepositiry extends JpaRepository<Person, Integer>{
	
}
