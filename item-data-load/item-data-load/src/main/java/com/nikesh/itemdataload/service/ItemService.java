package com.nikesh.itemdataload.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikesh.itemdataload.Model.Item;
import com.nikesh.itemdataload.respository.ItemDataRepository;

@Service
public class ItemService {
	
	@Autowired
	ItemDataRepository repository;
	
	public Item FindItemById(Long id) {
		
		Optional<Item> itemOptional= repository.findById(id);
		if(!itemOptional.isEmpty()) {
			Item foundItem=itemOptional.get();
			return foundItem;
		}
		return null;

	}

	public Item updateItem(Item item, Item newItem) {

	
			item.setShip(newItem.getShip());
			item.setCost(newItem.getCost());
			item.setQuantity(newItem.getQuantity());
			item.setPack(newItem.getPack());
			item.setContents(newItem.getContents());
			item.setDimensions(newItem.getDimensions());
			item.setOriginLocation(newItem.getOriginLocation());
			item.setCompany(newItem.getCompany());
			
			repository.save(item);
		
		return item;
	}



}
