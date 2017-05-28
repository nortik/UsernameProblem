package com.vgorbatiouk.service;
import java.util.List;

import com.vgorbatiouk.domain.Result;

/**
 * @author vitaliy gorbatiouk
 */

public interface UserService {

	public Result<Boolean,List<String>> checkUsername(String username);
	
	public Boolean checkUserSize(String username);
	
}
