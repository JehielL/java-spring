package com.techchef.holamundo;

import org.springframework.stereotype.Component;

@Component
public class UserRegistration {

    private NotificationService notificador;

    public UserRegistration(NotificationService notificador) {
        this.notificador = notificador;
    }

    public void holaMundo(){
        notificador.holaMundo();

    }
}
