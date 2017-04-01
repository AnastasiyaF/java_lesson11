package com.epam.java_training.comparator;

import java.util.Comparator;

import com.epam.java_training.model.Product;

public class Comparator_annotation implements Comparator<Product>{
	@Override
	public int compare(Product product1, Product product2) {
		
		String string_1 = product1.getAnnotation();
		String string_2 = product2.getAnnotation();
		
		return string_1.compareTo(string_2);
	}
}

