package com.assignment3.kyn_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class homeController {

	@Autowired
	StoreService store_service;
	
	 @GetMapping("/")
	 public String getHome(){
		 return "Home";
	 }
	
	  @GetMapping("/store-list")
    public String getStoreList(Model model) {
        List<Store> stores = store_service.getStoreList(); // Assuming StoreService provides a method to get all stores
        model.addAttribute("allStores", stores);
        return "StoreList";
    }
	
	//To display the Form
	@GetMapping("/stores")
	public String getstoreForm(Model model) {
		Store contact = new Store();
		model.addAttribute(contact);

		return "CreateStoreForm";
	}

	//To save all data from the list
	@PostMapping("/save_store")
	public String save_store(@ModelAttribute Store store) {

		// Current Date
		Date today = new Date();
		System.out.println("today date is " + today);
		store.setAddedDate(today);
		System.out.println(store);
		store_service.save_store(store);
		

		return "redirect:/store-list";

	}
	
	@GetMapping("store-delete")
	public String storeDelete(@RequestParam long id){
		store_service.delete_store(id);//call the delete from the service
		return "redirect:/store-list";
	}
	
	@GetMapping("store-update")
	public String storeUpdate(@RequestParam long id , Model model){
Store old_store = store_service.getDataById(id);//get the old data form the service
model.addAttribute("store",old_store);//add the old store data 
		return "CreateStoreForm";
	}
	


}
