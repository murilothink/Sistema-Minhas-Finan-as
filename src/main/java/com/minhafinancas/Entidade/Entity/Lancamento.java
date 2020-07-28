package com.minhafinancas.Entidade.Entity;


import com.minhafinancas.Entidade.Enum.StatusLancamento;
import com.minhafinancas.Entidade.Enum.TipoLancamento;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "Lancamento", schema = "financas")
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

//    @Column(name = "data_cadastro")
//    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
//    private LocalDate dataCadastro;

    @Column(name = "tipo")
    @Enumerated(value = EnumType.STRING)
    private TipoLancamento tipo;


    @Column(name = "Status")
    @Enumerated(value = EnumType.STRING)
    private StatusLancamento status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoLancamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoLancamento tipo) {
        this.tipo = tipo;
    }

    public StatusLancamento getStatus() {
        return status;
    }

    public void setStatus(StatusLancamento status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lancamento that = (Lancamento) o;
        return id.equals(that.id) &&
                descricao.equals(that.descricao) &&
                ano.equals(that.ano) &&
                mes.equals(that.mes) &&
                usuario.equals(that.usuario) &&
                valor.equals(that.valor) &&
                tipo == that.tipo &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, ano, mes, usuario, valor, tipo, status);
    }

    @Override
    public String toString() {
        return "Lancamento{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", ano=" + ano +
                ", mes=" + mes +
                ", usuario=" + usuario +
                ", valor=" + valor +
                ", tipo=" + tipo +
                ", status=" + status +
                '}';
    }
}
