package com.minhafinancas.Repository;

import com.minhafinancas.Entidade.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
