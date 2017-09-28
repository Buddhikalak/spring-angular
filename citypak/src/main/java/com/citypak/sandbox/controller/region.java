package com.citypak.sandbox.controller;

import com.citypak.sandbox.dao.regionDao;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class region {

    @Autowired
    private regionDao bDao;

    @RequestMapping(value = "/region", method = RequestMethod.GET)
    public @ResponseBody List<com.banglore.App.Model.region> get() {
        HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setOrigin("*");
        HashMap<String, String> params = new HashMap<String, String>();
        List<com.banglore.App.Model.region> list = bDao.list(params);
        System.out.println(list);
        
        
        return list;

    }
}
