package com.techchef.service;

import com.techchef.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * Javadoc
 * Clase de operaciones para trabajar con objetos tipos User
 * Principalmente metodos CRUD
 */

@Service
@AllArgsConstructor


public class UserService {
    /**
     * Metodo ficticio que simula obtener un usuario de
     * base de datos utilizando como filtro su clave primaria
     * que es el id.
     * @param id
     * @return objeto usuario de la clase User ficticio Hard-coded
     */

// comentado para evitar referencia circular
    //private ProductService productService;
    public User findById(Long id){

       // if (productService == null)
          //  System.out.println("Error product services es null");
        return new User(id,"usuario1","u1@lombok.com", "admin");


    }




}
