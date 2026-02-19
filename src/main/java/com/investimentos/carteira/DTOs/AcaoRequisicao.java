package com.investimentos.carteira.DTOs;

import com.investimentos.carteira.enums.Situacao;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

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
    @Schema(description = "Data de criação da Ação", example = "2026-01-01 00:00:00")
    private LocalDateTime dataCadastro;
    @Schema(description = "Data de alteração da Ação", example = "2026-01-01 00:00:00")
    private LocalDateTime dataAlteracao;
    @Schema(description = "Situacao da Ação", example = "INATIVO")
    private Situacao situacao;
}
