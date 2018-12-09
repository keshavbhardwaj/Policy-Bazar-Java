package com.interfaces;

public interface DaoInterface<objT,searchT>
{
	public objT insertData(objT a);
	public objT updateData(objT a);
	public objT searchData(searchT a);
	public objT dropData(objT a);
}
