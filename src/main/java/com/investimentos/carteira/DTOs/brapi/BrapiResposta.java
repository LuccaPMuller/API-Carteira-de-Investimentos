package com.investimentos.carteira.DTOs.brapi;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class BrapiResposta {
    private List<BrapiObjeto> results;

    @Data
    public static class BrapiObjeto {
        private String symbol;
        private String shortName;
        private String longName;
        private String currency;
        private BigDecimal regularMarketPrice;
        private BigDecimal regularMarketDayHigh;
        private BigDecimal regularMarketDayLow;
        private BigDecimal regularMarketChange;
        private BigDecimal regularMarketChangePercent;
        private LocalDateTime regularMarketTime;
        private String marketCap;
        private String regularMarketVolume;
        private String logourl;
    }
}
