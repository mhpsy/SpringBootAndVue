package top.mhpsy.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class oneView {

    @GetMapping("/{msg}")
    public String getViewName(@PathVariable String msg) {
        return "Hello "+msg;
    }
}
