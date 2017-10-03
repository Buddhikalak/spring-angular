package com.citypak.sandbox.dao;

import com.citypak.sandbox.model.region;
import java.util.HashMap;
import java.util.List;



public interface regionDao {
	public void saveOrUpdate(region region);
	public void delete(int id);
	public region getdetails(String name);
	public List<com.citypak.sandbox.model.region> list(HashMap<String, String> params);
	

}
