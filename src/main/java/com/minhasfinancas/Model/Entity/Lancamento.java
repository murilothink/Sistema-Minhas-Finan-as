package com.minhasfinancas.Model.Entity;


import com.minhasfinancas.Model.Enum.StatusLancamento;
import com.minhasfinancas.Model.Enum.TipoLancamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Lancamento", schema = "financas")
@Data // Lombok, gera os getters e setters, toString entre outros.
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "ano")
    private Integer ano;

    @Column(name = "mes")
    private Integer mes;

    @ManyToOne // Muitos lançamentos para um usuario
    @JoinColumn(name = "id_usuario") //JoinColumn quando tem relacionamento e chave estrangeira
    private Usuario usuario;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "data_cadastro")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate dataCadastro;

    @Column(name = "tipo")
    @Enumerated(value = EnumType.STRING)
    private TipoLancamento tipo;

    @Column(name = "Status")
    @Enumerated(value = EnumType.STRING)
    private StatusLancamento status;

}
