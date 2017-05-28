package com.vgorbatiouk.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import com.vgorbatiouk.domain.Result;
import com.vgorbatiouk.persistence.Persistence;

/**
 * @author vitaliy gorbatiouk
 */

public class RestrictedServiceImpl implements RestrictedService {
	
	private static final String RESTRICTEDFILE = "restricted.txt" ;
	
	public Result<Boolean,List<String>> listRestricted(String word){
		Persistence restricted = new Persistence(RESTRICTEDFILE);
		Set<String> restrictedList = restricted.listAll();		
		boolean restrictedFound = false;
		List<String> restrictedListAux = new ArrayList<String>();
		for(String wordAux : restrictedList)
		{
			if(word.toLowerCase().contains(wordAux.toLowerCase())){
				restrictedFound = true;
				int begin = word.toLowerCase().indexOf(wordAux.toLowerCase());
				restrictedListAux.add(word.substring(begin, begin+wordAux.length()));
			}
		}		
		return new Result<Boolean, List<String>>(restrictedFound, restrictedListAux);	
	}
	
	public void addRestricted(String elem){
		Persistence restricted = new Persistence(RESTRICTEDFILE);
		restricted.addElem(elem);
	}
	
}
