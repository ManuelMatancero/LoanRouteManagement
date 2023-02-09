package com.matancita.yngreni.dao;

import com.matancita.yngreni.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaDao extends JpaRepository<Empresa, Long> {
}
