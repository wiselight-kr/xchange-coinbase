package org.knowm.xchange.coinbase.dto.account;

import lombok.Data;

import java.util.List;

@Data
public class CoinbaseAddressesResponse {

    private CoinbasePagination pagination;
    private List<CoinbaseAddress> data;
}
