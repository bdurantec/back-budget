package br.com.dutech.backbudget.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class Hello {

    @GetMapping
    fun sayHello(): String{
        return "Hello! :)"
    }

}