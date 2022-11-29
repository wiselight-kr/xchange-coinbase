package org.knowm.xchange.coinbase.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.service.marketdata.MarketDataService;

public class CoinbaseMarketDataService extends CoinbaseMarketDataServiceRaw implements MarketDataService {

    public CoinbaseMarketDataService(Exchange exchange) {
        super(exchange);
    }

}
