package org.knowm.xchange.coinbase.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.coinbase.dto.trade.CoinbaseCreateOrderRequest;
import org.knowm.xchange.coinbase.dto.trade.CoinbaseCreateOrderResponse;
import org.knowm.xchange.coinbase.dto.trade.CoinbaseGetOrderResponse;

import java.io.IOException;
import java.util.Date;

public class CoinbaseTradeServiceRaw extends CoinbaseBaseService {

    public CoinbaseTradeServiceRaw(Exchange exchange) {
        super(exchange);
    }

    public CoinbaseCreateOrderResponse createOrder(CoinbaseCreateOrderRequest orderRequest) throws IOException {
        final String apiKey = exchange.getExchangeSpecification().getApiKey();

        return coinbase.createOrder(apiKey, signatureCreator, new Date().getTime() / 1000L, orderRequest);
    }

    public CoinbaseGetOrderResponse getOrder(String orderId) throws IOException {
        final String apiKey = exchange.getExchangeSpecification().getApiKey();

        return coinbase.getOrder(apiKey, signatureCreator, new Date().getTime() / 1000L, orderId);
    }

}
