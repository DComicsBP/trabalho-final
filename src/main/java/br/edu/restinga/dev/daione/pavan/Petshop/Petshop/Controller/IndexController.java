package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping(path = "/")
    public String HelloWorld(){
        return "<h1>Hello World</h1>";
    }
}