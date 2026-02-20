package com.investimentos.carteira.models;

import com.investimentos.carteira.enums.Situacao;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "transacoes")
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "acao_id", updatable = false)
    private Long acaoId;
    private Long quantidade;
    private BigDecimal preco;
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
        this.dataAlteracao = LocalDateTime.now();
        if (this.situacao == null) {
            this.situacao = Situacao.APROVADA;
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.dataAlteracao = LocalDateTime.now();
    }
}
