package com.techchef.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController

public class PruebaLogController {

    @GetMapping("logs")
    public String prueba(){

        log.info("Log Nivel info");
        log.warn("log nivel Warm");
        Integer num = 2;
        log.error("El numero obtenido es incorrecto {}", num);

        return "prueba";
    }
}
