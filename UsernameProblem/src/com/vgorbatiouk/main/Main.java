package com.vgorbatiouk.main;

/**
 * @author vitaliy gorbatiouk
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.vgorbatiouk.domain.Result;
import com.vgorbatiouk.persistence.Persistence;
import com.vgorbatiouk.service.UserService;
import com.vgorbatiouk.service.UserServiceImpl;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Username:");
        String username = bufferedReader.readLine();	
        //String username = "pepione";
		UserService userService = new UserServiceImpl();

		if (userService.checkUserSize(username)){			
			if( userService.checkUsername(username).getList() != null ){
				List<String> resultList = userService.checkUsername(username).getList();
				System.out.println("Username is invalid!");
				for(String aux : resultList){
					System.out.println(aux);
				}
			}
			else
			{
				System.out.println("Username is valid!");
			}
		}
		else
		{
			throw new Exception("The Username should be at least 6 characters!");
		}
		
	}

}
