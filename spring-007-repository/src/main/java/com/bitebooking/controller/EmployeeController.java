package com.certidevs.controller;

import com.bitebooking.model.Employee;
import com.bitebooking.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeRepository repo;

    /*
    Cómo realizar filtros sobre empleados en un controlador REST

    OK http://localhost:8080/employees --> repo.findAll()

    OK http://localhost:8080/employees?companyCity=Madrid --> repo.findByCompany_City("Madrid")

    OK http://localhost:8080/employees?postalCode=28002 --> findByCompany_PostalCode("28002")

    OK http://localhost:8080/employees?companyCity=Madrid&postalCode=28001 --> findByCompany_CityAndCompany_PostalCode("Madrid", "28001")
     */
    @GetMapping("employees")
    public List<Employee> findAll(
            @RequestParam(required = false) String companyCity,
            @RequestParam(required = false) String postalCode
    ) {
        if(StringUtils.hasLength(companyCity) && StringUtils.hasLength(postalCode))
            return repo.findByCompany_CityAndCompany_PostalCode(companyCity, postalCode);

        else if (StringUtils.hasLength(companyCity))
            return repo.findByCompany_City(companyCity);

        else if (StringUtils.hasLength(postalCode))
            return repo.findByCompany_PostalCode(postalCode);

        else
            return repo.findAll();
    }

    /*
    Filtro más dinámico. Recibimos un objeto Employee y usa como filtro para findAll sin tener que crear
    múltiples métodos para filtrar por cada atributo diferente.
    POST http://localhost:8080/employees/filter
    Ejemplo para enviar en el body de postman:
    {
        "salary": 2000.0,
        "company": {
            "city": "Madrid",
            "postalCode": "28002"
        }
    }
     */
    @PostMapping("employees/filter")
    public List<Employee> findAllFiltering(@RequestBody Employee employee) {
        Example<Employee> filter = Example.of(employee);
        return repo.findAll(filter);
    }

}
