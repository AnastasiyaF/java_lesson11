package com.epam.java_training.source;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.epam.java_training.model.Product;

public class FileSource {
	private String filename = "file.txt";
	private String filename_output = "file_output.txt";
	
	private File file;
	private File file_output;
	
	List<Product> product_list;
	
	FileSource(){
		file = new File(filename);
		file_output = new File(filename_output);
		
		product_list = new ArrayList<Product>();
		this.readDataFromFile();
	}
	
	public String getFilename(){
		return this.filename;
	}
	
	public File getFile(){
		return this.file;
	}
	
	public List<Product> getProduct_list(){
		
		return this.product_list;
	}
	
	public void setProduct_list(List<Product> product_list){
		
		this.product_list = product_list;
	}
	
	public void parseString(String read_string){
		
		Product product = new Product();
		
		String delimeters = ";";
		String[] tokens = read_string.split(delimeters);
		
		product.setCategory(tokens[0]);
		product.setCode(tokens[1]);
		product.setRelease_date(tokens[2]);
		product.setAnnotation(tokens[3]);
		
		product_list.add(product);
	}
	public void readDataFromFile(){  
		
		try {
			
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String sringFromReader;

			while ((sringFromReader = br.readLine()) != null) {
					this.parseString(sringFromReader);
			}
	
			br.close();
		}
		catch (FileNotFoundException e) {

				e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
    }
	
	public void writeToFile(){
		
		if(this.file_output.exists() == false){
            try {
            	this.file_output.createNewFile() ;
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
		
		try {
			FileWriter fw = new FileWriter(file_output); 
			BufferedWriter bw = new BufferedWriter(fw);
		
	    	
	    	for (Product product : product_list) {
		    	
	    		bw.write(product.stringFormat());
		    	bw.newLine();
			}
	    	
	    	bw.close();
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
	}	

}
