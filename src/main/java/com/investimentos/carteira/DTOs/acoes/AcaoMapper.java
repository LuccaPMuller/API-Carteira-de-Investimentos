package com.investimentos.carteira.DTOs.acoes;

import java.util.List;

import com.investimentos.carteira.models.Acao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcaoMapper {
    //toEntity
    Acao toEntity (AcaoRequisicao acaoRequisicao);
    //toDto
    AcaoResposta toDto (Acao acao);
    List<AcaoResposta> toDto (List<Acao> acoes);
}
