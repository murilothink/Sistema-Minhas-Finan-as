package com.minhasfinancas.Repository;

// Teste de integração com banco de dados

import com.minhasfinancas.Model.Entity.Usuario;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;


@ExtendWith(SpringExtension.class)
@DataJpaTest //Fazendo Rollback no banco
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("appliation-test") // procurando o properties de teste
public class UsuarioRepositoryTest {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void deveVerificarAExistenciaDeUmEmail() {
        //cenário
        //Criando um objeto usuario e salvando no banco
        Usuario usuario = criarUsuario();
        entityManager.persist(usuario);

        //ação/ execução
        //true ou false caso o email exista no banco de dados
        boolean result = repository.existsByEmail("usuario@email.com");

        //verificacao
        //Caso seja True
        Assertions.assertThat(result).isTrue();

    }

    @Test
    public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComOEmail(){

        boolean result = repository.existsByEmail("usuario@email.com");
        Assertions.assertThat(result).isFalse();

    }

    @Test
    public void devePersistirUmUsuarioNaBaseDeDados(){

        Usuario usuario = criarUsuario();
        entityManager.persist(usuario);

        Usuario usuarioSalvo = repository.save(usuario);

        Assertions.assertThat(usuarioSalvo.getId()).isNotNull();
    }

    @Test
    public void deveBuscarUmUsuarioPorEmail(){

        Usuario usuario = criarUsuario();
        entityManager.persist(usuario);

        Optional<Usuario> usuarioComEmail = repository.findByEmail(usuario.getEmail());

        Assertions.assertThat(usuarioComEmail.isPresent()).isTrue();

    }

    @Test
    public void deveRetornarNenhumUsuarioNaBaseQuandoNãoExistir(){

        Usuario usuario = criarUsuario();
        entityManager.persist(usuario);

        Optional<Usuario> usuarioSemEmail = repository.findByEmail("asdasdasdsa");

        Assertions.assertThat(usuarioSemEmail).isNotPresent().isEmpty();
    }


    public static Usuario criarUsuario() {
        return Usuario
                .builder()
                .nome("usuario")
                .email("usuario@email.com")
                .senha("senha")
                .build();
    }


}
