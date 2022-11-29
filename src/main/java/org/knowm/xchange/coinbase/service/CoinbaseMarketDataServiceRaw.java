package org.knowm.xchange.coinbase.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.coinbase.dto.marketdata.CoinbaseListProductResponse;

import java.io.IOException;
import java.util.Date;

public class CoinbaseMarketDataServiceRaw extends CoinbaseBaseService {

    public CoinbaseMarketDataServiceRaw(Exchange exchange) {
        super(exchange);
    }

    public CoinbaseListProductResponse getListProducts(Integer limit, Integer offset, String productType) throws IOException {
        final String apiKey = exchange.getExchangeSpecification().getApiKey();

        return coinbase.getListProducts(apiKey, signatureCreator, new Date().getTime() / 1000L, limit, offset, productType);
    }

}
