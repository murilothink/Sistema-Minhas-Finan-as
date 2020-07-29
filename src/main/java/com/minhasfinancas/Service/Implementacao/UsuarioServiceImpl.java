package com.minhasfinancas.Service.Implementacao;

import com.minhasfinancas.Exception.ErroDeAutenticacao;
import com.minhasfinancas.Model.Entity.Usuario;
import com.minhasfinancas.Exception.RegraNegocioException;
import com.minhasfinancas.Repository.UsuarioRepository;
import com.minhasfinancas.Service.UsuasrioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuasrioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario autenticar(String email, String senha) {

        //vou chamar o Respository para buscar se o email do usuario esta presente no bamco de dados
        //Ele vai me retornar um Optional dizendo se ele esta presente ou n e vou salvar em uma variavel chamada usuario
        Optional<Usuario> usuario = repository.findByEmail(email);
        //Se o usuario n estiver presente eu lanço uma RuinTimeException
        if(!usuario.isPresent()){
            throw new ErroDeAutenticacao("Usuário não encontrado");
        }
        //Caso o email estiver correto vou no banco e busco pelo usuario e senha e faço uma comparação de senha
        //Caso as senhas não sejam verdadeira eu lanço uma RuinTimeExeception
        if(!usuario.get().getSenha().equals(senha)){
            throw new ErroDeAutenticacao("Senha Inválida");
        }

        return usuario.get();
    }

    @Override
    @Transactional
    public Usuario salvarUsuario(Usuario usuario) {
        //Busca o email do usuario e salva na base de dados
        validarEmail(usuario.getEmail());
        return repository.save(usuario);
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
