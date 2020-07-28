package com.minhasfinancas.Service.Implementacao;

import com.minhasfinancas.Entidade.Entity.Usuario;
import com.minhasfinancas.Exception.RegraNegocioException;
import com.minhasfinancas.Repository.UsuarioRepository;
import com.minhasfinancas.Service.UsuasrioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuasrioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
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
        //Vai receber o boolean, caso for verdadeiro ele vai retornar o verdadeiro
        boolean existe = repository.existsByEmail(email);
        if(existe){
            //Exception tratada em Exception
            throw new RegraNegocioException("Ja existe um usuario cadastrado com esse email.");
        }
    }
}
