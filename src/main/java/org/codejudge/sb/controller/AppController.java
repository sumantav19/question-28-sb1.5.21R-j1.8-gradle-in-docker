package org.codejudge.sb.controller;

import io.swagger.annotations.ApiOperation;

import org.springframework.http.MediaType;
import org.codejudge.sb.model.Numbers;
import org.codejudge.sb.model.Sum;
import org.codejudge.sb.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AppController {

	@Autowired
	NumberService numberService;
	
    @GetMapping("/")
    @ApiOperation("This is the hello world api")
    public String hello() {
        return "Hello World!!";
    }
    
    @PostMapping(path= "/api/add")
    @ApiOperation("This is the number addition api")
    @ResponseBody
    public Sum addNumbers(@RequestBody Numbers numbers) {
        return numberService.addNumbers(numbers);
    }


}
