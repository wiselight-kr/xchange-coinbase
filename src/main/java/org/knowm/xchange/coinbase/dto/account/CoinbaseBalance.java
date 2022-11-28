package org.knowm.xchange.coinbase.dto.account;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CoinbaseBalance {

    private BigDecimal value;
    private String currency;
}
