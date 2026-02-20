package com.investimentos.carteira.DTOs.transacao;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TransacaoRequisicao {
    @NotNull
    @NotBlank
    @Schema(description = "Id da Ação", example = "1")
    private Long acao_id;
    @NotNull
    @NotBlank
    @Schema(description = "Quantidade de Ações", example = "10")
    private Long quantidade;
}
