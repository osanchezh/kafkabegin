package com.buffer.cab.book.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buffer.cab.book.driver.service.CabLocationService;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class CabLocationController {

    @Autowired
    private CabLocationService cabLocationService;

    //Business Logic



    @PutMapping
    public ResponseEntity updateLocation() throws InterruptedException {

        int range = 100;
        while (range > 0) {
        	String val =Math.random() + " , " + Math.random();
            cabLocationService.updateLocation(val);
            System.out.println(val);
            //Thread.sleep(1);
            range --;
        }

        return new ResponseEntity<>(Map.of("message", "Location Updated")
        , HttpStatus.OK);
    }
}
