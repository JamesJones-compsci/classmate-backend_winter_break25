package ca.gbc.comp3095.courseservice.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService{

    public String getMessage(){

        return "Hello from Course Service";
    }

}
