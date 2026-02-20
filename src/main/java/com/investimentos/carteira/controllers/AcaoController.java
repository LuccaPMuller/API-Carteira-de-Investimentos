package com.investimentos.carteira.controllers;

import com.investimentos.carteira.DTOs.AcaoAtualiza;
import com.investimentos.carteira.DTOs.AcaoRequisicao;
import com.investimentos.carteira.DTOs.AcaoResposta;
import com.investimentos.carteira.enums.Situacao;
import com.investimentos.carteira.exception.http.ResourceNotFoundException;
import com.investimentos.carteira.services.AcaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acao")
@Tag(name = "Ação", description = "Controller de Ação")
public class AcaoController {

    private final AcaoService acaoService;

    public AcaoController(AcaoService acaoService) {
        this.acaoService = acaoService;
    }

    //Posts

    @PostMapping("/salvar")
    @Operation(summary = "Salvar Ação", description = "Salva a ação da bolsa de valores")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ação salva"),
            @ApiResponse(responseCode = "404", description = "Ação não salva")
    })
    public ResponseEntity<AcaoResposta> salvar(@RequestBody AcaoRequisicao acaoRequisicao) {
        return ResponseEntity.ok(acaoService.salvar(acaoRequisicao));
    }

    //Puts

    @PutMapping("/atualizar")
    @Operation(summary = "Atualizar Ação", description = "Atualizar a ação da bolsa de valores")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ação salva"),
            @ApiResponse(responseCode = "404", description = "Ação não salva")
    })
    public ResponseEntity<AcaoResposta> atualizar(@RequestBody AcaoAtualiza acaoAtualiza) {
        try{
            return ResponseEntity.ok(acaoService.atualizar(acaoAtualiza));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }

    }

    //Deletes

    @DeleteMapping("/deletar")
    @Operation(summary = "Deletar Ação", description = "Deletar a ação da bolsa de valores (Não deve ser usado. Usar o PUT para atualzar a 'situação')")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ação deletada"),
            @ApiResponse(responseCode = "404", description = "Ação não deletada")
    })
    public ResponseEntity<AcaoResposta> deletar(@RequestParam("id") Long id) {
        try{
            acaoService.deletar(id);
            return ResponseEntity.status(202).build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
    }

    //Gets

    @GetMapping("/quantidade")
    @Operation(summary = "Quantidade de registros de Ações no banco de dados", description = "Retorna a quantidade de registros de Ações no banco de dados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Quantidade de Ações retornada"),
            @ApiResponse(responseCode = "404", description = "Quantidade de Ações não retornada")
    })
    public ResponseEntity<Long> quantidade() {
        return ResponseEntity.ok(acaoService.quantidade());
    }

    @GetMapping("/procurarId")
    @Operation(summary = "Procurar Ação(s) por id", description = "Procurar a ação(s) da bolsa de valores")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ação(s) encontrada"),
            @ApiResponse(responseCode = "404", description = "Ação(s)  não deletada")
    })
    public ResponseEntity<AcaoResposta> procurarId(@RequestParam("id") Long id) {
        return ResponseEntity.ok(acaoService.procurarId(id));
    }

    @GetMapping("/procurarTicker")
    @Operation(summary = "Procurar Ação(s) por ticker", description = "Procurar a ação(s) da bolsa de valores")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ação(s) encontrada"),
            @ApiResponse(responseCode = "404", description = "Ação(s)  não deletada")
    })
    public ResponseEntity<List<AcaoResposta>> procurarTicker(@RequestParam("ticker") String ticker) {
        return ResponseEntity.ok(acaoService.procurarTicker(ticker));
    }

    @GetMapping("/procurarNome")
    @Operation(summary = "Procurar Ação(s) por nome", description = "Procurar a ação(s) da bolsa de valores")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ação(s) encontrada"),
            @ApiResponse(responseCode = "404", description = "Ação(s)  não deletada")
    })
    public ResponseEntity<List<AcaoResposta>> procurarNome(@RequestParam("nome") String nome) {
        return ResponseEntity.ok(acaoService.procurarNome(nome));
    }

    @GetMapping("/procurarSituacao")
    @Operation(summary = "Procurar Ação(s) por situacao", description = "Procurar a ação(s) da bolsa de valores")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ação(s) encontrada"),
            @ApiResponse(responseCode = "404", description = "Ação(s)  não deletada")
    })
    public ResponseEntity<List<AcaoResposta>> procurarSituacao(@RequestParam("situacao") Situacao situacao) {
        return ResponseEntity.ok(acaoService.procurarSituacao(situacao));
    }
}
