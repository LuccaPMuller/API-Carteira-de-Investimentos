package com.investimentos.carteira.DTOs;

import com.investimentos.carteira.enums.Situacao;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AcaoRequisicao {
    @NotNull
    @NotBlank
    @Schema(description = "Ticker da Ação", example = "ORCL")
    private String ticker;
    @NotNull
    @NotBlank
    @Schema(description = "Nome da empresa", example = "Oracle Corporation")
    private String nome;
    @Schema(description = "Setor da empresa", example = "Softwares")
    private String setor;
    @Schema(description = "Situacao da Ação", example = "ATIVO")
    private Situacao situacao;
}
