package com.informatorio.emprendimientos.service;

import com.informatorio.emprendimientos.dto.OperacionEmprendimiento;
import com.informatorio.emprendimientos.entity.Emprendimiento;
import com.informatorio.emprendimientos.entity.Tag;
import com.informatorio.emprendimientos.entity.Usuario;
import com.informatorio.emprendimientos.repository.EmprendimientoRepository;
import com.informatorio.emprendimientos.repository.TagRepository;
import com.informatorio.emprendimientos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EmprendimientoService {

    private final EmprendimientoRepository emprendimientoRepository;
    private final UsuarioRepository usuarioRepository;
    private final TagRepository tagRepository;

    @Autowired
    public EmprendimientoService(EmprendimientoRepository emprendimientoRepository,
                                 UsuarioRepository usuarioRepository,
                                 TagRepository tagRepository) {
        this.emprendimientoRepository = emprendimientoRepository;
        this.usuarioRepository = usuarioRepository;
        this.tagRepository = tagRepository;
    }

    public Emprendimiento createEmprendimiento(OperacionEmprendimiento operacionEmprendimiento) {
        Usuario usuario = usuarioRepository.findById(operacionEmprendimiento.getIdUsuario())
                .orElseThrow(() -> new EntityNotFoundException("Usuario No Encontrado"));
        List<Tag> tags = tagRepository.findAllById(operacionEmprendimiento.getTags());
        Emprendimiento emprendimiento = new Emprendimiento();
        emprendimiento.setNombre(operacionEmprendimiento.getNombre());
        emprendimiento.setDescripcion(operacionEmprendimiento.getDescripcion());
        emprendimiento.setOwner(usuario);
        emprendimiento.getTags().addAll(tags);

        return emprendimientoRepository.save(emprendimiento);
    }
}
