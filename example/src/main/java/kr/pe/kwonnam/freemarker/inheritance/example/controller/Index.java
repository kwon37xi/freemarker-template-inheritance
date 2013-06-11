package kr.pe.kwonnam.freemarker.inheritance.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: kwon37xi
 * Date: 13. 6. 9
 * Time: 오후 11:20
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class Index {
    @RequestMapping("/index")
    public String index() {
        return "/index";
    }
}
