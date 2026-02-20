package com.investimentos.carteira.services;

import com.investimentos.carteira.DTOs.AcaoMapper;
import com.investimentos.carteira.models.Transacao;
import com.investimentos.carteira.repositories.AcaoRepository;
import com.investimentos.carteira.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    private final AcaoRepository acaoRepository;
    private final AcaoMapper acaoMapper;
    private final TransacaoRepository transacaoRepository;

    @Autowired
    public TransacaoService(AcaoRepository acaoRepository, AcaoMapper acaoMapper, TransacaoRepository transacaoRepository) {
        this.acaoRepository = acaoRepository;
        this.acaoMapper = acaoMapper;
        this.transacaoRepository = transacaoRepository;
    }
}
