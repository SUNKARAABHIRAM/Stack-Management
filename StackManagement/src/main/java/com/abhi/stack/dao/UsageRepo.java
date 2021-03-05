package com.abhi.stack.dao;

import java.util.*;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abhi.stack.model.InUsage;


public interface UsageRepo extends JpaRepository<InUsage,Integer>{

	
	  @Query("from InUsage where instancename=?1 order by id desc")
	  List<InUsage> getUsages(String instanceName);
	  
	  List<InUsage> findAllByinstancename(String instancename,Pageable pageable);
	 
}
