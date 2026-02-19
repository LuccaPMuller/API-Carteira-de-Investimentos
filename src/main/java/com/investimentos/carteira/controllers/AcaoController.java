package com.investimentos.carteira.controllers;

import com.investimentos.carteira.DTOs.AcaoAtualiza;
import com.investimentos.carteira.DTOs.AcaoRequisicao;
import com.investimentos.carteira.DTOs.AcaoResposta;
import com.investimentos.carteira.services.AcaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@Tag(name = "Ação", description = "Controller de Ação")
public class AcaoController {

    private final AcaoService acaoService;

    public AcaoController(AcaoService acaoService) {
        this.acaoService = acaoService;
    }

    @PostMapping("/salvar")
    @Operation(summary = "Salvar Ação", description = "Salva a ação da bolsa de valores")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ação salva"),
            @ApiResponse(responseCode = "404", description = "Ação não salva")
    })
    public ResponseEntity<AcaoResposta> Salvar(@RequestBody AcaoRequisicao acaoRequisicao) {
        return ResponseEntity.ok(acaoService.Salvar(acaoRequisicao));
    }

    @PostMapping("/atualizar")
    @Operation(summary = "Atualizar Ação", description = "Atualizar a ação da bolsa de valores")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ação salva"),
            @ApiResponse(responseCode = "404", description = "Ação não salva")
    })
    public ResponseEntity<AcaoResposta> Atualizar(@RequestBody AcaoAtualiza acaoAtualiza) {
        return ResponseEntity.ok(acaoService.Atualizar(acaoAtualiza));
    }
}
