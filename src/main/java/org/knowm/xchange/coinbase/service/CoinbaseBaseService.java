package org.knowm.xchange.coinbase.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.client.ExchangeRestProxyBuilder;
import org.knowm.xchange.coinbase.CoinbaseAuthenticated;
import org.knowm.xchange.service.BaseExchangeService;
import org.knowm.xchange.service.BaseService;

public class CoinbaseBaseService extends BaseExchangeService implements BaseService {

    protected final CoinbaseAuthenticated coinbase;
    protected final CoinbaseDigest signatureCreator;

    protected CoinbaseBaseService(Exchange exchange) {
        super(exchange);
        coinbase = ExchangeRestProxyBuilder.forInterface(
                CoinbaseAuthenticated.class, exchange.getExchangeSpecification()
        ).build();
        signatureCreator = CoinbaseDigest.createInstance(exchange.getExchangeSpecification().getSecretKey());
    }
}
