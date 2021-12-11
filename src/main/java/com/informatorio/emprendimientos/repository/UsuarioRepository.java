package com.informatorio.emprendimientos.repository;

import com.informatorio.emprendimientos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByFechaDeCreacionAfter(LocalDateTime fechaDesde);
}
