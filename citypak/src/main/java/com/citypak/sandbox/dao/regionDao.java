package com.citypak.sandbox.dao;

import com.banglore.App.Model.region;
import java.util.HashMap;
import java.util.List;



public interface regionDao {
	
	public void saveOrUpdate(region region);
	public void delete(int id);
	public region get(int regionID);
	public List<region> list(HashMap<String, String> params);
	

}
