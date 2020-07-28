package com.minhasfinancas.Repository;

import com.minhasfinancas.Entidade.Entity.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
}
