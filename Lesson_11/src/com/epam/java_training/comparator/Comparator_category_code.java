package com.epam.java_training.comparator;

import java.util.Comparator;

import com.epam.java_training.model.Product;

public class Comparator_category_code implements Comparator<Product>{
	@Override
	public int compare(Product product1, Product product2) {
		
		String string_1 = product1.getCategory();
		String string_2 = product2.getCategory();
		
		if (string_1.compareTo(string_2) > 0){
		
			return string_1.compareTo(string_2);
		}
		
		string_1 = product1.getCode();
		string_2 = product2.getCode();
		
		return string_1.compareTo(string_2);
	}
}
