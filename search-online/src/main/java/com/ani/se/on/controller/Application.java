package com.ani.se.on.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yeh on 15-5-29.
 */
@Controller
public class Application {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/alive", method = RequestMethod.GET)
    @ResponseBody
    public String alive() {
        return "0";
    }
}
