package com.nikesh.itemdataload.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nikesh.itemdataload.Model.Item;

@Repository
public interface ItemDataRepository extends JpaRepository<Item, Long>{

	public List<Item> findByName(String name); 
	
}
