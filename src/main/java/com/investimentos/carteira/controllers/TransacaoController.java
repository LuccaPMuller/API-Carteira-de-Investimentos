package com.investimentos.carteira.controllers;

import com.investimentos.carteira.DTOs.acoes.AcaoRequisicao;
import com.investimentos.carteira.DTOs.acoes.AcaoResposta;
import com.investimentos.carteira.DTOs.transacao.TransacaoRequisicao;
import com.investimentos.carteira.DTOs.transacao.TransacaoResposta;
import com.investimentos.carteira.services.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
@Tag(name = "Transação", description = "Controller de Transação")
public class TransacaoController {

    private final TransacaoService transacaoService;

    @Autowired
    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping("/comprar")
    @Operation(summary = "Comprar Ação(s)", description = "Realiza a ompra de ação(s) da bolsa de valores e salva a transação")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Sucesso na transação"),
            @ApiResponse(responseCode = "404", description = "Erro na transação")
    })
    public ResponseEntity<TransacaoResposta> comprar(@RequestBody TransacaoRequisicao transacaoRequisicao) {
        return ResponseEntity.ok(transacaoService.compra(transacaoRequisicao));
    }
}
