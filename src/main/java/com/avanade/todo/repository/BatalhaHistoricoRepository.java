package com.avanade.todo.repository;

import com.avanade.todo.model.BatalhaHistorico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatalhaHistoricoRepository extends JpaRepository<BatalhaHistorico, Long> {

}
