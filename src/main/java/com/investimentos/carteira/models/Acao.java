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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String ticker;
    @Column(nullable = false)
    private String nome;
    private String setor;
    @CreatedDate
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dataCadastro;
    @LastModifiedDate
    @Column(name = "dt_alteracao")
    private LocalDateTime dataAlteracao;
    @Enumerated(value = EnumType.STRING)
    private Situacao situacao;

    @PrePersist
    public void prePersist() {
        if (this.getDataCadastro() == null) {
            this.setDataCadastro(LocalDateTime.now());
        }
        if (setor == null || setor.trim().isEmpty()) {
            setor = "Setor indefinido";
        }
        this.ticker = ticker.toUpperCase();
        this.dataAlteracao = LocalDateTime.now();
        if (this.situacao == null) {
            this.situacao = Situacao.ATIVO;
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.dataAlteracao = LocalDateTime.now();
        this.ticker = ticker.toUpperCase();
    }
}
