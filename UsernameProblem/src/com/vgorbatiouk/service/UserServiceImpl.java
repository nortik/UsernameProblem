package com.vgorbatiouk.service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.vgorbatiouk.domain.Result;
import com.vgorbatiouk.persistence.Persistence;

/**
 * @author vitaliy gorbatiouk
 */

public class UserServiceImpl implements UserService {
	
	private static final String USERNAMEFILE = "username.txt" ;
	private static final Integer USERSUGGESTED = 14;
	private static final Integer USERLENGHT = 6;
	
	@Override
	public Result<Boolean,List<String>> checkUsername(String username){

		RestrictedService restrictedService = new RestrictedServiceImpl();
		
		if(restrictedService.listRestricted(username).getFlag() ||  !isExistUser(username))
		{
			 List<String> auxList = new ArrayList<String>();
			 Random random = new Random();
			 String usernameAux = username;
			 //if the username contain restricted word
			 if(restrictedService.listRestricted(username).getFlag()){
				 usernameAux = usernameNew(usernameAux,restrictedService.listRestricted(username).getList());			 
			 }
			 
			 int count = 0;
			 //The app should try to generate 14 possible usernames
			 //from these rules at least three times
			 while(count<3)
			 {
				 for(int i = 0 ; i < USERSUGGESTED; i++)
				 {
					 String username2 = usernameAux+random.nextInt(555);
					 if(isExistUser(username2) && !auxList.contains(username2) 
							 && (auxList.size() < USERSUGGESTED)){
						 auxList.add(username2);
					 }
				 }
				 count++;
			 }
			Collections.sort(auxList);			
			return new Result<Boolean, List<String>>(false,auxList);
		}
		//if the list is null
		return new Result<Boolean, List<String>>(true, null);
	}
	
	private String usernameNew(String usernameAux, List<String> list) {
		 for(String elem : list){
				 usernameAux = usernameAux.replace(elem.substring(0, elem.length()), "");			 
		 }
		 return usernameAux;
	}

	private boolean isExistUser(String username){
		Persistence userList = new Persistence(USERNAMEFILE);
		
		if(userList.listAll().contains(username))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
		
	@Override
	public Boolean checkUserSize(String username) {
		if(username != null && username.length() < USERLENGHT){
			return false;

		}else{
			return true;
		}
		
	}	
	
	
	
}
