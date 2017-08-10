package com.ltaake.kata.sps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for Web UI.
 */
@Controller
public class FrontendController {

    private static final String INDEX_TEMPLATE = "index";

    @RequestMapping("/")
    public String index() {
        return INDEX_TEMPLATE;
    }
}
