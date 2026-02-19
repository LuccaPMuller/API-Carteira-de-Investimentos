package com.investimentos.carteira.DTOs;

import com.investimentos.carteira.enums.Situacao;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
public class AcaoAtualiza {
    @NotNull
    @NotBlank
    @Schema(description = "Id da Ação", example = "1")
    private Long id;
    @Schema(description = "Ticker da Ação", example = "ORCL")
    private String ticker;
    @Schema(description = "Nome da empresa", example = "Oracle Corporation")
    private String nome;
    @Schema(description = "Setor da empresa", example = "Softwares")
    private String setor;
    @Schema(description = "Situacao da Ação", example = "INATIVO")
    private Situacao situacao;
}
