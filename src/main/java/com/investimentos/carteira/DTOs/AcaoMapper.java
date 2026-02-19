package com.investimentos.carteira.DTOs;

import java.util.List;
import java.util.Optional;

import com.investimentos.carteira.models.Acao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcaoMapper {
    //toEntity
    Acao toEntity (AcaoRequisicao acaoRequisicao);
    Acao toEntity (AcaoAtualiza acaoAtualiza);
    //toDto
    AcaoResposta toDto (Acao acao);
    List<AcaoResposta> toDto (List<Acao> acoes);
}
