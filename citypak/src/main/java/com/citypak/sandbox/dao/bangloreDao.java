package com.citypak.sandbox.dao;

import com.citypak.sandbox.model.banglore;
import com.citypak.sandbox.model.response;
import java.util.HashMap;
import java.util.List;

public interface bangloreDao {
	
	public void saveOrUpdate(banglore banglore);
	public void delete(int id);
	public banglore get(int regionID);
	public List<response> list(HashMap<String, String> params);

}
