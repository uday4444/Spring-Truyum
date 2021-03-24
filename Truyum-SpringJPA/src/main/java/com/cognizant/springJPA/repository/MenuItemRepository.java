package com.cognizant.springJPA.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.springJPA.model.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

	
	public List<MenuItem> findByActiveAndDateOfLaunchBefore(boolean active,Date date);
}
