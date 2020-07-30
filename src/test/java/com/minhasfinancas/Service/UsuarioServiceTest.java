package com.minhasfinancas.Service;

import com.minhasfinancas.exception.ErroAutenticacao;
import com.minhasfinancas.Model.Entity.Usuario;
import com.minhasfinancas.Repository.UsuarioRepository;
import com.minhasfinancas.Service.Implementacao.UsuarioServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {

    UsuasrioService service;

    @MockBean
    UsuarioRepository repository;

    @Before
    public void setUp(){

        service = new UsuarioServiceImpl(repository);

    }

    @Test
    public void deveValidarEmail(){

        Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(false);

        service.validarEmail("email@email.com");

    }

    @Test
    public void deveLancarErroQuandoExistirEmailCadastrado(){

        //Canário
        Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(true);

        service.validarEmail("email@email.com");

    }

    @Test
    public void autenticacaoComEmailComSucesso(){

        String email = "email@email.com";
        String senha = "asdaasddds";

        Usuario usuario = Usuario.builder().email(email).senha(senha).id(1l).build();

        Mockito.when( repository.findByEmail(email) ).thenReturn(Optional.of(usuario));

        Usuario result = service.autenticar(email, senha);

        Assertions.assertThat(result).toString().isEmpty();
    }

    @Test
    public void deveLancarErroQuandoNaoEncontrarOUsuarioInformado (){

        //cenário
        Mockito.when(repository.findByEmail(Mockito.anyString())).thenReturn(Optional.empty());

        //acao
        Throwable exception = Assertions.catchThrowable( () -> service.autenticar("email@email.com", "senha") );

        //verificacao
        Assertions.assertThat(exception)
                .isInstanceOf(ErroAutenticacao.class)
                .hasMessage("Usuário não encontrado para o email informado.");

    }

    @Test
    public void deveLançarErroQuandoASenhaNaoBater(){

        String senha = "senha";
        Usuario usuario = Usuario.builder().email("email@email.com").nome("asdasd").id(1l).senha(senha).build();
        Mockito.when(repository.findByEmail(Mockito.anyString())).thenReturn(Optional.of(usuario));

        //acao
        Throwable exception = Assertions.catchThrowable( () -> service.autenticar("email@email.com", "senha123") );
        Assertions.assertThat(exception).isInstanceOf(ErroAutenticacao.class).hasMessage("Senha");

    }


    public static Usuario CriarUusarioJaExistente(){
        return Usuario
                .builder()
                .email("email@email.com")
                .nome("Joao")
                .id(1l)
                .build();

    }

}
