package org.knowm.xchange.coinbase.dto.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoinbaseTo {

    private String resource;
    private String address;
}
