package com.investimentos.carteira.models;

import com.investimentos.carteira.enums.Situacao;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "acoes")
public class Acao {
    @Id
    private Long id;
    @Column(nullable = false)
    private String ticker;
    @Column(nullable = false)
    private String nome;
    private String setor;
    @CreatedDate
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dataCadastro = LocalDateTime.now();
    @LastModifiedDate
    @Column(name = "dt_alteracao")
    private LocalDateTime dataAlteracao;
    @Enumerated(value = EnumType.STRING)
    private Situacao situacao;

    public Acao() {
    }

    public Acao(Long id, String ticker, String nome, String setor, LocalDateTime dataCadastro, LocalDateTime dataAlteracao) {
        this.id = id;
        this.ticker = ticker;
        this.nome = nome.toUpperCase();
        this.setor = setor;
        this.dataCadastro = dataCadastro;
        this.dataAlteracao = dataAlteracao;
    }

    @PrePersist
    public void prePersist() {
        if (this.getDataCadastro() == null) {
            this.setDataCadastro(LocalDateTime.now());
        }
        this.dataAlteracao = LocalDateTime.now();
        if (this.situacao == null) {
            this.situacao = Situacao.ATIVO;
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.dataAlteracao = LocalDateTime.now();
    }
}
