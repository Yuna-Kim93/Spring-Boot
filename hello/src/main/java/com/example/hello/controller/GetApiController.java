package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello")        // http://localhost:9090/api/get/hello
    public String hello(){
        System.out.println("hello() Controller");
        return "get Hello";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET)  // get  http://localhost:9090/api/get/hi
    public String hi(){
        System.out.println("hi() Controller");
        return "hi";
    }

    // http://loaclhost:9090/api/get/path-variable/{name}
    @GetMapping("/path-variable/{id}")
    public String pathVariable(@PathVariable(name = "id") String pathName){
        System.out.println("PathVariable : " + pathName);

        return pathName;
    }

    //  ?key=value&key2=value2

    // http://localhost:9090/api/get/query-param?user=yuna&email=yuna@gmail.com&age=29
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryparam){

        StringBuilder sb = new StringBuilder();

        queryparam.entrySet().forEach( entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue()+"\n");
        });
        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name + " " + email + " " + age;
    }

    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getAge());
        return userRequest.toString();
    }





}
