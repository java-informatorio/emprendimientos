package com.informatorio.emprendimientos.controller;

import com.informatorio.emprendimientos.dto.OperacionEmprendimiento;
import com.informatorio.emprendimientos.entity.Emprendimiento;
import com.informatorio.emprendimientos.entity.Tag;
import com.informatorio.emprendimientos.entity.Usuario;
import com.informatorio.emprendimientos.repository.EmpredimientoRepository;
import com.informatorio.emprendimientos.repository.TagRepository;
import com.informatorio.emprendimientos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/emprendimiento")
public class EmpredimientoController {

    private final EmpredimientoRepository empredimientoRepository;
    private final UsuarioRepository usuarioRepository;
    private final TagRepository tagRepository;

    @Autowired
    public EmpredimientoController(EmpredimientoRepository empredimientoRepository,
                                   UsuarioRepository usuarioRepository,
                                   TagRepository tagRepository) {
        this.empredimientoRepository = empredimientoRepository;
        this.usuarioRepository = usuarioRepository;
        this.tagRepository = tagRepository;
    }

    @PostMapping
    public ResponseEntity<?> createEmprendimiento(@Valid @RequestBody OperacionEmprendimiento operacionEmprendimiento) {
        Usuario usuario = usuarioRepository.findById(operacionEmprendimiento.getIdUsuario())
                .orElseThrow(() -> new EntityNotFoundException("Usuario No Encontrado"));
        List<Tag> tags = tagRepository.findAllById(operacionEmprendimiento.getTags());
        Emprendimiento emprendimiento = new Emprendimiento();
        emprendimiento.setNombre(operacionEmprendimiento.getNombre());
        emprendimiento.setDescripcion(operacionEmprendimiento.getDescripcion());
        emprendimiento.setOwner(usuario);
        emprendimiento.getTags().addAll(tags);
        return new ResponseEntity<>(empredimientoRepository.save(emprendimiento), HttpStatus.CREATED);
    }
}
