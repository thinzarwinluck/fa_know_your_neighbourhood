package com.assignment3.kyn_project;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StoreService {
	
	@Autowired
	private storeRepository store_repo;
	
	//call storeDao class to store the data 
	public Store save_store(Store store) {
		return store_repo.save(store);
	}
	
	//get data from the storeDao
	public List<Store> getStoreList(){
		return store_repo.findAll();
	}
	
	public void delete_store(long id) {
		store_repo.deleteById(id);
	}
	
	public Store getDataById(long id) {
		return store_repo.getById(id);
		
	}
	
}
