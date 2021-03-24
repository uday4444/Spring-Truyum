package com.cognizant.springJPA.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springJPA.model.MenuItem;
import com.cognizant.springJPA.repository.MenuItemRepository;

import java.util.Date;

@Service
public class MenuItemService {

	@Autowired
	private MenuItemRepository menuItemRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemService.class);

	@Transactional
	public void modifyMenuItem(MenuItem menuItem) {
		LOGGER.info("Start");
		menuItemRepository.save(menuItem);
		LOGGER.info("End");

	}

	@Transactional
	public MenuItem getMenuItem(Integer menuItemId) {
		LOGGER.info("Start");
		return menuItemRepository.findById(menuItemId).get();

	}

	@Transactional
	public List<MenuItem> getMenuItemListCustomer() {
		LOGGER.info("Start");
		return menuItemRepository.findByActiveAndDateOfLaunchBefore(true, new Date());
	}

	@Transactional
	public List<MenuItem> getMenuItemListAdmin() {
		LOGGER.info("Start");
		return menuItemRepository.findAll();
	}

}