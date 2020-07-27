package com.dear.financas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("production") // Significa que essa classe vai ser disponivel apenas no profile de production
public class MensagemService {


    // Definindo o valor da variavel com o valor padrão do application.properties

    @Value("${application.name}")
    private String appname;

}
