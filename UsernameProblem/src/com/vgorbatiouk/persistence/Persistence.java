package com.vgorbatiouk.persistence;

/**
 * @author vitaliy gorbatiouk
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;


public class Persistence {
	
	String path = null;
	
	public Persistence(String filePath){
		this.path = filePath;
	}
	
	public HashSet<String> listAll(){
		HashSet<String> collection = new HashSet<String>();
		
        FileInputStream fis = null;
        BufferedReader reader = null;
        //System.out.println("-------------");
        //System.out.println(filePath);
        try {
            fis = new FileInputStream(path);
            reader = new BufferedReader(new InputStreamReader(fis));
                    
            String line = reader.readLine();
            while(line != null){
                //System.out.println(line);
                if (!line.equals("")){
                	collection.add(line);	
                }                
                line = reader.readLine();        		
            }           
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
        	System.out.println(ex);  
        } finally {
            try {
                reader.close();
                fis.close();
            } catch (IOException ex) {
            	System.out.println(ex);
            }
        }
        return collection;
	}
	
	public void addElem(String elem){		
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
			pw.println("");
			pw.println(elem);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}         
        pw.close();		 
	}
}
