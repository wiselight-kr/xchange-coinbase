package org.knowm.xchange.coinbase.dto.account;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CoinbaseWallet {
    private Boolean availableOnConsumer;
    private BigDecimal holdBalance;
    private String id;
    private String holdCurrency;
    private BigDecimal balance;
    private String currency;
    private Boolean primary;
    private String name;
    private String type;
    private Boolean active;
}
