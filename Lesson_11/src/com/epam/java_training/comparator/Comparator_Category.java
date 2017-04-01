package com.epam.java_training.comparator;

import java.util.Comparator;

import com.epam.java_training.model.Product;

public class Comparator_Category implements Comparator<Product>{
	@Override
	public int compare(Product product1, Product product2) {
		
		String string_1 = product1.getCategory();
		String string_2 = product2.getCategory();
		
		return string_1.compareTo(string_2);
	}
}
