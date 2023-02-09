package com.matancita.yngreni.dao;

import com.matancita.yngreni.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteDao extends JpaRepository<Cliente, Long> {
}
