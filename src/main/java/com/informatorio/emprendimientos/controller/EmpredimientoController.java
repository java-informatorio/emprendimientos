package com.informatorio.emprendimientos.controller;

import com.informatorio.emprendimientos.entity.Emprendimiento;
import com.informatorio.emprendimientos.repository.EmpredimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/emprendimiento")
public class EmpredimientoController {

    private final EmpredimientoRepository empredimientoRepository;

    @Autowired
    public EmpredimientoController(EmpredimientoRepository empredimientoRepository) {
        this.empredimientoRepository = empredimientoRepository;
    }

    @PostMapping
    public ResponseEntity<?> createCarrito(@Valid @RequestBody Emprendimiento emprendimiento) {
        return new ResponseEntity<>(empredimientoRepository.save(emprendimiento), HttpStatus.CREATED);
    }
}
