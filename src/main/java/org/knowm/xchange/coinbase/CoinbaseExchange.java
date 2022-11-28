package org.knowm.xchange.coinbase;

import org.knowm.xchange.BaseExchange;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.coinbase.service.CoinbaseAccountService;

public class CoinbaseExchange extends BaseExchange implements Exchange {

    public static final String COINBASE_PASSPHRASE = "passphrase";

    @Override
    protected void initServices() {
        this.accountService = new CoinbaseAccountService(this);
    }

    @Override
    public ExchangeSpecification getDefaultExchangeSpecification() {
        final ExchangeSpecification exchangeSpecification = new ExchangeSpecification(this.getClass());
        exchangeSpecification.setSslUri("https://api.coinbase.com");
        exchangeSpecification.setHost("api.coinbase.com");
        exchangeSpecification.setExchangeName("Coinbase");
        exchangeSpecification.setExchangeDescription("Coinbase is the easiest place to buy and sell cryptocurrency.");
        return exchangeSpecification;
    }
}
