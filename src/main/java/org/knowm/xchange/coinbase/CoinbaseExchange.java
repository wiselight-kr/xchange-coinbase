package org.knowm.xchange.coinbase;

import org.knowm.xchange.BaseExchange;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeSpecification;

public class CoinbaseExchange extends BaseExchange implements Exchange {

    @Override
    protected void initServices() {

    }

    @Override
    public ExchangeSpecification getDefaultExchangeSpecification() {
        final ExchangeSpecification exchangeSpecification = new ExchangeSpecification(this.getClass());
        exchangeSpecification.setSslUri("https://api.exchange.coinbase.com");
        exchangeSpecification.setHost("api.exchange.coinbase.com");
        exchangeSpecification.setExchangeName("Coinbase");
        exchangeSpecification.setExchangeDescription("Coinbase is the easiest place to buy and sell cryptocurrency.");
        return exchangeSpecification;
    }
}
