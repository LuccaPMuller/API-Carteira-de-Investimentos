package com.investimentos.carteira.DTOs.transacao;

import com.investimentos.carteira.models.Transacao;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransacaoMapper {
    //toEntity
    Transacao toEntity (TransacaoRequisicao transacaoRequisicao);
    //toDto
    TransacaoResposta toDto (Transacao transacao);
    List<TransacaoResposta> toDto (List<Transacao> transacaos);
}
