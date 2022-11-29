package org.knowm.xchange.coinbase.dto.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoinbaseNetwork {

    private String status;
    private String hash;
    private String name;
}
