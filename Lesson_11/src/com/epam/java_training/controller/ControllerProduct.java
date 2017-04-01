package com.epam.java_training.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.epam.java_training.comparator.Comparator_Category;
import com.epam.java_training.comparator.Comparator_Code;
import com.epam.java_training.comparator.Comparator_annotation;
import com.epam.java_training.comparator.Comparator_category_code;
import com.epam.java_training.comparator.Comparator_releasedate;
import com.epam.java_training.dao.ProductListDao;
import com.epam.java_training.model.Product;

public class ControllerProduct {
	
	List<Product> result_list;
	ProductListDao product_listDAO;
	
	public ControllerProduct(){
		result_list = new ArrayList<Product>();
		product_listDAO = new ProductListDao();
	}
	
	public void addNewElement(String category, String code, String release, String annotation){
		
		product_listDAO.addProduct(category, code, release, annotation);
		
	}
	
	public void findByParameterList(String category_find, String code_find, String release_find, String annotation_find, int type_sort){
		
		this.result_list = product_listDAO.findByParameter(category_find, code_find, release_find, annotation_find);
		
		switch(type_sort){
		
		case 1: this.result_list = sortByCategory();
			  break;
		case 2: this.result_list =  sortByCode();
			break;
		case 3: this.result_list = sortByReleaseDate();
			break;
		case 4: this.result_list = sortByAnnotation();
			break;
		case 5: this.result_list = sortByCategoryCode();
			break;
		default: this.result_list = sortByCategory();
		}
		
		this.printList();
		
	}
	
	public void findByParameterString(String string_find, int type_sort){
		
		this.result_list = product_listDAO.findByString(string_find);
		
		switch(type_sort){
		
		case 1: this.result_list = sortByCategory();
			  break;
		case 2: this.result_list =  sortByCode();
			break;
		case 3: this.result_list = sortByReleaseDate();
			break;
		case 4: this.result_list = sortByAnnotation();
			break;
		case 5: this.result_list = sortByCategoryCode();
			break;
		default: this.result_list = sortByCategory();
		}
		
		this.printList();
		
	}

	public List<Product> sortByCategory(){
		Comparator<Product> comparator = new Comparator_Category();
		List<Product> collection_sort = new ArrayList<Product>();
		
		collection_sort.addAll(this.result_list);	
		
		collection_sort.sort(comparator);
		
		return collection_sort;
	}
	
	public List<Product> sortByCode(){
		Comparator<Product> comparator = new Comparator_Code();
		List<Product> collection_sort = new ArrayList<Product>();
		
		collection_sort.addAll(this.result_list);	
		
		collection_sort.sort(comparator);
		
		return collection_sort;
	}
	
	public List<Product> sortByReleaseDate(){
		Comparator<Product> comparator = new Comparator_releasedate();
		List<Product> collection_sort = new ArrayList<Product>();
		
		collection_sort.addAll(this.result_list);	
		
		collection_sort.sort(comparator);
		
		return collection_sort;
	}
	
	public List<Product> sortByAnnotation(){
		Comparator<Product> comparator = new Comparator_annotation();
		List<Product> collection_sort = new ArrayList<Product>();
		
		collection_sort.addAll(this.result_list);	
		
		collection_sort.sort(comparator);
		
		return collection_sort;
	}
	
	public List<Product> sortByCategoryCode(){
		Comparator<Product> comparator = new Comparator_category_code();
		List<Product> collection_sort = new ArrayList<Product>();
		
		collection_sort.addAll(this.result_list);	
		
		collection_sort.sort(comparator);
		
		return collection_sort;
	}
	
	public void printList(){
		
		
		if (this.result_list.isEmpty()){
			System.out.println("The collection is empty.");
		}
		
		for (Product product : this.result_list){
			System.out.println(product);		
		}
		
	}
	
	public void printcurrentList(){
		
		product_listDAO.printList();
		
	}
	
	public void saveToFile(){
		
		product_listDAO.saveToFile();
		
	}
	
}
