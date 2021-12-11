package com.informatorio.emprendimientos.repository;

import com.informatorio.emprendimientos.entity.Emprendimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpredimientoRepository extends JpaRepository<Emprendimiento, Long> {
}
