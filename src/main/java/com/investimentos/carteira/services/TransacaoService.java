package com.investimentos.carteira.services;

import com.investimentos.carteira.DTOs.acoes.AcaoMapper;
import com.investimentos.carteira.DTOs.transacao.TransacaoMapper;
import com.investimentos.carteira.DTOs.transacao.TransacaoRequisicao;
import com.investimentos.carteira.DTOs.transacao.TransacaoResposta;
import com.investimentos.carteira.exception.http.ResourceNotFoundException;
import com.investimentos.carteira.models.Acao;
import com.investimentos.carteira.models.Transacao;
import com.investimentos.carteira.repositories.AcaoRepository;
import com.investimentos.carteira.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.MathContext;

@Service
public class TransacaoService {

    private final AcaoMapper acaoMapper;
    private final AcaoRepository acaoRepository;
    private final TransacaoRepository transacaoRepository;
    private final TransacaoMapper transacaoMapper;
    private final BrapiService brapiServce;

    @Autowired
    public TransacaoService(AcaoMapper acaoMapper, AcaoRepository acaoRepository, TransacaoRepository transacaoRepository, TransacaoMapper transacaoMapper, BrapiService brapiServce) {
        this.acaoMapper = acaoMapper;
        this.acaoRepository = acaoRepository;
        this.transacaoRepository = transacaoRepository;
        this.transacaoMapper = transacaoMapper;
        this.brapiServce = brapiServce;
    }

    @Transactional
    public TransacaoResposta compra(TransacaoRequisicao transacaoRequisicao) {
        Acao acao = acaoRepository.findById(transacaoRequisicao.getAcao_id())
                .orElseThrow(() -> new ResourceNotFoundException("Ação não encontrada com ID: " + transacaoRequisicao.getAcao_id()));
        String ticker = acao.getTicker();
        Transacao compra = new Transacao();
        compra.setAcaoId(transacaoRequisicao.getAcao_id());
        compra.setPreco(brapiServce.getPreco(ticker).multiply(new BigDecimal(transacaoRequisicao.getQuantidade())));
        compra.setQuantidade(transacaoRequisicao.getQuantidade());
        transacaoRepository.save(compra);
        return transacaoMapper.toDto(compra);
    }
}
