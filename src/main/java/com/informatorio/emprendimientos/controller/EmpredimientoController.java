package com.informatorio.emprendimientos.controller;

import com.informatorio.emprendimientos.dto.OperacionEmprendimiento;
import com.informatorio.emprendimientos.service.EmprendimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/emprendimiento")
public class EmpredimientoController {

    private final EmprendimientoService emprendimientoService;

    @Autowired
    public EmpredimientoController(EmprendimientoService emprendimientoService) {
        this.emprendimientoService = emprendimientoService;
    }

    @PostMapping
    public ResponseEntity<?> createEmprendimiento(@Valid @RequestBody OperacionEmprendimiento operacionEmprendimiento) {
        return new ResponseEntity<>(emprendimientoService.createEmprendimiento(operacionEmprendimiento), HttpStatus.CREATED);
    }
}
