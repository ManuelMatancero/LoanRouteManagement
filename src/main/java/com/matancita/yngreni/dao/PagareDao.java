package com.matancita.yngreni.dao;

import com.matancita.yngreni.domain.Pagare;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagareDao extends JpaRepository<Pagare, Long> {
}
