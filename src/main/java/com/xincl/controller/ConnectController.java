package com.xincl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnectController {

    @RequestMapping("/connect")
    public String connect(){
        return "θΏζ₯ζε";
    }
}
