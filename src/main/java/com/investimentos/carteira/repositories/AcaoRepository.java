package com.investimentos.carteira.repositories;

import com.investimentos.carteira.models.Acao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AcaoRepository extends JpaRepository <Acao, Long> {
    Optional<Acao> findById(Long id);
    List<Acao> findByNomeContainingIgnoreCase(String nome);
}
