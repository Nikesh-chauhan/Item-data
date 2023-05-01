package com.nikesh.itemdataload.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.nikesh.itemdataload.Model.Item;
import com.nikesh.itemdataload.exceptionhandling.ItemNotFoundException;
import com.nikesh.itemdataload.respository.ItemDataRepository;
import com.nikesh.itemdataload.service.ItemService;

@RestController
public class ItemDataController {
	
	@Autowired
	ItemDataRepository repository;
	
	@Autowired
	ItemService service;
	
	@GetMapping("{item}/{id}")
	public ResponseEntity<Item> read(@PathVariable("item")String item, @PathVariable("id")Long id ) {
		
		Item item1 = service.FindItemById(id);
		
		if(item1==null) {
			throw new ItemNotFoundException("Item Not Found");
		}
		return new ResponseEntity<Item>(item1,HttpStatus.OK);
		
		
	}
	
//---------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@PostMapping("{item}/save")
	public ResponseEntity<Item> create(@RequestBody Item item){
		
		if(item.getPack().equals("N")) {
			item.setContents(0);
		}
		repository.save(item);
		
		return new ResponseEntity<Item>(item,HttpStatus.CREATED);
	}
	
//---------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	@PutMapping("{item}/{id}")
	public ResponseEntity<Item> update(@PathVariable("item")String item, @PathVariable("id")Long id,@RequestBody Item itemObj ){
		
		Item foundItem=service.FindItemById(id);
		if(foundItem!=null) {
			Item updatedItem = service.updateItem(foundItem, itemObj);
			return new ResponseEntity<Item>(updatedItem,HttpStatus.CREATED);	
		}else {
			throw new ItemNotFoundException("Item Not Found");
		}
		
	}

//---------------------------------------------------------------------------------------------------------------------------------------------------------------

	@DeleteMapping("{item}/{id}")
	public ResponseEntity<Item> delete(@PathVariable("item")String item, @PathVariable("id")Long id)
	{
		
		Item item1 = service.FindItemById(id);
		
		if(item1==null) {
			throw new ItemNotFoundException("Item Not Found");
		}else {
			repository.deleteById(id);
		}
		return new ResponseEntity<Item>(item1,HttpStatus.ACCEPTED);
		
		
	}
	
	
	
	

}
