package org.knowm.xchange.coinbase.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.coinbase.CoinbaseAdapters;
import org.knowm.xchange.dto.account.AccountInfo;
import org.knowm.xchange.service.account.AccountService;

import java.io.IOException;

public class CoinbaseAccountService extends CoinbaseAccountServiceRaw implements AccountService {
    public CoinbaseAccountService(Exchange exchange) {
        super(exchange);
    }

    @Override
    public AccountInfo getAccountInfo() throws IOException {
        return CoinbaseAdapters.adaptAccountInfo(getAccounts(null, null));
    }
}
