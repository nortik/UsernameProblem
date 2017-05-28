package com.vgorbatiouk.service;

import java.util.List;

import com.vgorbatiouk.domain.Result;

/**
 * @author vitaliy gorbatiouk
 */

public interface RestrictedService {

	public Result<Boolean,List<String>> listRestricted(String word);
	
	public void addRestricted(String word);
}
