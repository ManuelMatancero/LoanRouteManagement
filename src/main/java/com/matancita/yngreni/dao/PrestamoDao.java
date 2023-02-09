package com.matancita.yngreni.dao;

import com.matancita.yngreni.domain.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoDao extends JpaRepository<Prestamo, Long> {
}
