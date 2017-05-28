package com.vgorbatiouk.test;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import com.vgorbatiouk.domain.Result;
import com.vgorbatiouk.service.UserService;
import com.vgorbatiouk.service.UserServiceImpl;

/**
 * @author vitaliy gorbatiouk
 */

public class UserServiceTest {
	
	@Test
	public void testCheckAddNewUsernameOK() {
		UserService userService = new UserServiceImpl();
		Result<Boolean, List<String>> answer = userService.checkUsername("pepitonew");
		assertEquals(true,answer.getFlag());	
	}
	
	@Test
	public void testCheckLess6Characters() {
		UserService userService = new UserServiceImpl();	
		Boolean answer = userService.checkUserSize("pepip");
		assertEquals(false,answer);
	}
	
	@Test
	public void testCheckNullUsername() {
		UserService userService = new UserServiceImpl();	
		Result<Boolean, List<String>> answer = userService.checkUsername("");
		assertNull(answer.getList());
	}
	
}
