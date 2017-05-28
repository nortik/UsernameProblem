package com.vgorbatiouk.test;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import com.vgorbatiouk.domain.Result;
import com.vgorbatiouk.service.RestrictedService;
import com.vgorbatiouk.service.RestrictedServiceImpl;

/**
 * @author vitaliy gorbatiouk
 */

public class RestrictedServiceTest {
	
	@Test
	public void testListRestrictedOK() {
		RestrictedService restrictedService = new RestrictedServiceImpl();
		Result<Boolean, List<String>> answer = restrictedService.listRestricted("pepitosone");
		assertEquals(true,answer.getFlag());	
	}
	
}
