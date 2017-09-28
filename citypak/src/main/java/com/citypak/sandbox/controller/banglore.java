package com.citypak.sandbox.controller;


import com.citypak.sandbox.dao.bangloreDao;
import com.citypak.sandbox.model.response;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpHeaders;
import org.springframework.http.*;

@RestController
@CrossOrigin
public class banglore {

    @Autowired
    private bangloreDao bDao;

    @RequestMapping(value = "/banglore", method = RequestMethod.GET)
    public @ResponseBody List<response> get() {
        HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setOrigin("*");
        HashMap<String, String> params = new HashMap<String, String>();
        List<response> list = bDao.list(params);
        System.out.println(list);
        
        
        return list;

    }

}
