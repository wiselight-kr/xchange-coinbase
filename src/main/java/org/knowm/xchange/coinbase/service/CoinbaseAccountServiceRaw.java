package org.knowm.xchange.coinbase.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.coinbase.dto.account.CoinbaseAccountsResponse;
import org.knowm.xchange.coinbase.dto.account.CoinbaseAddressesResponse;
import org.knowm.xchange.coinbase.dto.account.CoinbaseSendMoneyRequest;
import org.knowm.xchange.coinbase.dto.account.CoinbaseSendMoneyResponse;

import java.io.IOException;
import java.util.Date;

public class CoinbaseAccountServiceRaw extends CoinbaseBaseService {

    public CoinbaseAccountServiceRaw(Exchange exchange) {
        super(exchange);
    }

    public CoinbaseAccountsResponse getAccounts(Integer limit, String cursor) throws IOException {
        final String apiKey = exchange.getExchangeSpecification().getApiKey();

        return coinbase.getAccounts(
                apiKey, signatureCreator, new Date().getTime() / 1000L, limit, cursor);
    }

    public CoinbaseAddressesResponse getAddresses(String accountId) throws IOException {
        final String apiKey = exchange.getExchangeSpecification().getApiKey();

        return coinbase.getAddresses(apiKey, signatureCreator, new Date().getTime() / 1000L, accountId);
    }

    public CoinbaseSendMoneyResponse sendMoney(String accountId, CoinbaseSendMoneyRequest sendMoneyRequest) throws IOException {
        final String apiKey = exchange.getExchangeSpecification().getApiKey();

        return coinbase.sendMoney(apiKey, signatureCreator, new Date().getTime() / 1000L, accountId, sendMoneyRequest);
    }
}
