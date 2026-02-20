package com.investimentos.carteira.services;

import com.investimentos.carteira.DTOs.brapi.BrapiResposta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Slf4j
@Service
public class BrapiService {

    private final RestTemplate restTemplate;
    @Value("${api.brapi.token}")
    private String apiToken;

    @Autowired
    public BrapiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public BigDecimal getPreco(String ticker) {
        String urlBase = "https://brapi.dev/api/quote/" + ticker;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", apiToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<BrapiResposta> brapiResposta= restTemplate.exchange(
                urlBase,
                HttpMethod.GET,
                entity,
                BrapiResposta.class);
        return brapiResposta.getBody().getResults().getFirst().getRegularMarketPrice();
    }
}
