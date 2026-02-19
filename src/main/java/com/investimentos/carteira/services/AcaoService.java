package com.investimentos.carteira.services;

import com.investimentos.carteira.DTOs.AcaoAtualiza;
import com.investimentos.carteira.DTOs.AcaoMapper;
import com.investimentos.carteira.DTOs.AcaoRequisicao;
import com.investimentos.carteira.DTOs.AcaoResposta;
import com.investimentos.carteira.models.Acao;
import com.investimentos.carteira.repositories.AcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AcaoService {

    private final AcaoRepository acaoRepository;
    private final AcaoMapper acaoMapper;

    @Autowired
    public AcaoService(AcaoRepository acaoRepository, AcaoMapper acaoMapper) {
        this.acaoRepository = acaoRepository;
        this.acaoMapper = acaoMapper;
    }

    @Transactional
    public AcaoResposta Salvar(AcaoRequisicao acaoRequisicao) {
        Acao acaoSalvar = acaoRepository.save(acaoMapper.toEntity(acaoRequisicao));
        return acaoMapper.toDto(acaoSalvar);
    }

    @Transactional
    public AcaoResposta Atualizar(AcaoAtualiza acaoAtualiza) {
        Acao acaoAtualizar = acaoRepository.save(acaoMapper.toEntity(acaoAtualiza));
        return acaoMapper.toDto(acaoAtualizar);
    }
}
