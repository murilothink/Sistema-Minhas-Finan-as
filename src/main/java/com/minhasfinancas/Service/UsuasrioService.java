package com.minhasfinancas.Service;

import com.minhasfinancas.Model.Entity.Usuario;

public interface UsuasrioService {

    Usuario autenticar(String email, String senha); //Vai na BD verificar se existe o usuario e senha

    Usuario salvarUsuario(Usuario usuario); //Cadastrar Usuario que ainda não foi salvo na base de dados

    void validarEmail(String email); //Caso já existe o email cadastrado ele ira retornar uma mensagem de erro,

}
