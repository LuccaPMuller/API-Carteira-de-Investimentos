package com.investimentos.carteira.DTOs.transacao;

import com.investimentos.carteira.enums.Situacao;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransacaoResposta {
        private Long id;
        private Long acaoId;
        private Long quantidade;
        private BigDecimal preco;
        private LocalDateTime dataAlteracao;
        private Situacao situacao;
}
