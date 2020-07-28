package com.minhafinancas.Service.Implementacao;

import com.minhafinancas.Entidade.Entity.Usuario;
import com.minhafinancas.Service.UsuasrioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuasrioService {

    @Autowired
    private UsuasrioService repository;

    public UsuarioServiceImpl(UsuasrioService repository) {
        this.repository = repository;
    }

    @Override
    public Usuario autenticar(String email, String senha) {
        return null;
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public void validarEmail(String email) {

    }
}
