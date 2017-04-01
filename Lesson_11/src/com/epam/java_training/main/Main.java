/*
 * Задача 11.
 * Date: 27.03.2017
   Author: Anastasiya Findziukevich
   
Склад
Разработать консольное приложение, работающее с Товарами в Складе. Каждый Товар это: Товар(категория, код производителя, дата выпуска, аннотацию).

Общие пояснения к практическому заданию.
В начале работы приложения данные должны считываться из файла, в конце работы – сохраняться в файл.
У пользователя должна быть возможность найти запись по любому параметру или по группе параметров 
(группу параметров можно определить самостоятельно), получить требуемые записи в отсортированном виде, найти записи,
 текстовое поле которой содержит определенное слово, а также добавить новую запись.
Правильно обрабатывайте исключительные ситуации.
!!! Попытайтесь при реализации приложения применить шаблон MVC
 * 
 */

package com.epam.java_training.main;

import com.epam.java_training.controller.ControllerProduct;


public class Main {
	
	
	public static void main(String[] args) {
		
		ControllerProduct product_controller = new ControllerProduct();
		
		System.out.println("Все элементы текущие:");
		
		product_controller.printcurrentList();
		
		System.out.println("Добавим новый элемент: category_8, code_8, 2009/08/09, annotation_8");
		
		product_controller.addNewElement("category_8", "code_8", "2009/08/09", "annotation_8");
		
		System.out.println("Добавим новый элемент: category_9, code_9, 2015/08/07 annotation_9");
		
		product_controller.addNewElement("category_9", "code_9", "2015/08/07", "annotation_9");
		
		System.out.println("Добавим новый элемент: category_10, code_10, 2015/08/07 annotation_9");
		
		product_controller.addNewElement("category_10", "code_10", "2015/08/07", "annotation_9");
		
		System.out.println("Все элементы текущие:");
		
		product_controller.printcurrentList();
		
		System.out.println("Сохранить в файл:");
		
		product_controller.saveToFile();
		
		System.out.println("Найти все элементы у которых строковое поле имеет подстроку str453. Сортировка по категории и коду");
		
		product_controller.findByParameterString("str453", 5);
		
		System.out.println("Найти все элементы у которых строковое поле имеет подстроку str45. Сортировка по дате. Формат: YYYY/MM/DD");
		
		product_controller.findByParameterString("str45", 3);
		
		
		System.out.println("Найти все элементы у которых category = category_8. Сортировка по коду");
		
		product_controller.findByParameterList("category_8", null, null, null, 2);
		
		System.out.println("Найти все элементы у которых category = category_8 и дата = 2009/01/08. Сортировка по аннотации");
		
		product_controller.findByParameterList("category_8", null, "2009/01/08", null, 4);
		
		
		
		
		
		
	}

}
