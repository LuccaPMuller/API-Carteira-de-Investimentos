package com.investimentos.carteira.services;

import com.investimentos.carteira.DTOs.acoes.AcaoAtualiza;
import com.investimentos.carteira.DTOs.acoes.AcaoMapper;
import com.investimentos.carteira.DTOs.acoes.AcaoRequisicao;
import com.investimentos.carteira.DTOs.acoes.AcaoResposta;
import com.investimentos.carteira.enums.Situacao;
import com.investimentos.carteira.exception.http.ResourceNotFoundException;
import com.investimentos.carteira.models.Acao;
import com.investimentos.carteira.repositories.AcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public AcaoResposta salvar(AcaoRequisicao acaoRequisicao) {
        Acao acaoSalvar = acaoRepository.save(acaoMapper.toEntity(acaoRequisicao));
        return acaoMapper.toDto(acaoSalvar);
    }

    @Transactional
    public AcaoResposta atualizar(AcaoAtualiza acaoAtualiza) {
        Acao acao = acaoRepository.findById(acaoAtualiza.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Ação não encontrada com ID: " + acaoAtualiza.getId()));

        if (acaoAtualiza.getTicker() != null) acao.setTicker(acaoAtualiza.getTicker());
        if (acaoAtualiza.getNome() != null) acao.setNome(acaoAtualiza.getNome());
        if (acaoAtualiza.getSetor() != null) acao.setSetor(acaoAtualiza.getSetor());
        if (acaoAtualiza.getSituacao() != null) acao.setSituacao(acaoAtualiza.getSituacao());

        Acao atualizado = acaoRepository.saveAndFlush(acao);
        return acaoMapper.toDto(atualizado);
    }

    @Transactional
    public Long deletar(Long id) {
        if (!acaoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Não é possível deletar: Ação não encontrada.");
        }
        acaoRepository.deleteById(id);
        return id;
    }

    public Long quantidade() {
        return acaoRepository.count();
    }

    public AcaoResposta procurarId(Long id) {
        return acaoMapper.toDto(acaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ação não encontrada com ID: " + id)));
    }

    public List<AcaoResposta> procurarTicker(String ticker) {
        return acaoMapper.toDto(acaoRepository.findByTickerContainingIgnoreCase(ticker));
    }

    public List<AcaoResposta> procurarNome(String nome) {
        return acaoMapper.toDto(acaoRepository.findByNomeContainingIgnoreCase(nome));
    }

    public List<AcaoResposta> procurarSituacao(Situacao situacao) {
        return acaoMapper.toDto(acaoRepository.findBySituacao(situacao));
    }
}