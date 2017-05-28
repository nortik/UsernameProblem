package com.vgorbatiouk.domain;

/**
 * @author vitaliy gorbatiouk
 */

public class Result<T1, T2> {
	private T1 flag; 
    private T2 list; 

    public Result(T1 flag, T2 sList) 
    {
        this.flag = flag;
        this.list = sList;
    }

	public T1 getFlag() 
	{
		return flag;
	}

	public void setFlag(T1 flag) 
	{
		this.flag = flag;
	}

	public T2 getList() 
	{
		return list;
	}

	public void setList(T2 list) 
	{
		this.list = list;
	} 
    
}
