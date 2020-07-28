package com.minhafinancas.Repository;

import com.minhafinancas.Entidade.Entity.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
}
