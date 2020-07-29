package com.minhasfinancas.Service;



import com.minhasfinancas.Model.Entity.Usuario;
import com.minhasfinancas.Repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;



@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("appliation-test") // procurando o properties de teste
public class UsuarioServiceTest {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    UsuasrioService service;

    @Test
    public void deveValidarEmail(){

        //Cenário
        repository.deleteAll();

        //Ação
        service.validarEmail("email@email.com");

    }

    @Test
    public void deveLancarErroQuandoExistirEmailCadastrado(){

        //Canário
        Usuario usuario = CriarUusarioJaExistente();
        repository.save(usuario);

        service.validarEmail("email@email.com");

    }

    public static Usuario CriarUusarioJaExistente(){
        return Usuario
                .builder()
                .email("email@email.com")
                .nome("Joao")
                .build();

    }

}
