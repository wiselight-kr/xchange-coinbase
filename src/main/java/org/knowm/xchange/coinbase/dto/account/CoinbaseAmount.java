package org.knowm.xchange.coinbase.dto.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoinbaseAmount {

    private BigDecimal amount;
    private String currency;
}
