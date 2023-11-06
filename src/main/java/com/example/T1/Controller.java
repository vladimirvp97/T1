package com.example.T1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    Service service;

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/countChars")
    @ResponseBody
    public String countCharacters(@RequestParam String input) {
        if (input.isEmpty()) return "You entered an empty string";
        return service.compute(input);
    }
}
