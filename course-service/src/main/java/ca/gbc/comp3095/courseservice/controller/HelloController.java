package ca.gbc.comp3095.courseservice.controller;


import ca.gbc.comp3095.courseservice.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService){

        this.helloService = helloService;
    }

    @GetMapping
    public String hello(){

        return helloService.getMessage();
    }

}
