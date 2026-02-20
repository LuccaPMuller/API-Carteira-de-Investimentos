package com.investimentos.carteira.DTOs;

import com.investimentos.carteira.enums.Situacao;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AcaoResposta {
        private Long id;
        private String ticker;
        private String nome;
        private String setor;
        private LocalDateTime dataAlteracao;
        private LocalDateTime dataCadastro;
        private Situacao situacao;
}
