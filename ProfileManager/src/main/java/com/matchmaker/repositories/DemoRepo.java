package com.matchmaker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matchmaker.pojo.ComplexPojo;

public interface DemoRepo extends JpaRepository<ComplexPojo,String>{

}
