package org.knowm.xchange.coinbase.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.coinbase.CoinbaseAdapters;
import org.knowm.xchange.coinbase.dto.account.*;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.dto.account.AccountInfo;
import org.knowm.xchange.service.account.AccountService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;

public class CoinbaseAccountService extends CoinbaseAccountServiceRaw implements AccountService {
    public CoinbaseAccountService(Exchange exchange) {
        super(exchange);
    }

    @Override
    public AccountInfo getAccountInfo() throws IOException {
        return CoinbaseAdapters.adaptAccountInfo(getAccounts(null, null));
    }

    @Override
    public String requestDepositAddress(Currency currency, String... args) throws IOException {
        CoinbaseAccountsResponse accountsResponse = getAccounts(null, null);

        Optional<CoinbaseAccount> account = accountsResponse.getAccounts().stream()
                .filter(i -> i.getCurrency().equals(currency.getCurrencyCode()))
                .findFirst();

        if(account.isPresent()) {
            String accountId = account.get().getUuid();
            CoinbaseAddressesResponse coinbaseAddressesResponse = getAddresses(accountId);

            if(!coinbaseAddressesResponse.getData().isEmpty())
                return coinbaseAddressesResponse.getData().get(0).getAddress();
        }

        return null;
    }

    public String withdrawFunds(Currency currency, BigDecimal amount, String address) throws IOException {
        CoinbaseAccountsResponse accountsResponse = getAccounts(null, null);

        Optional<CoinbaseAccount> account = accountsResponse.getAccounts().stream()
                .filter(i -> i.getCurrency().equals(currency.getCurrencyCode()))
                .findFirst();

        if(account.isPresent()) {
            String accountId = account.get().getUuid();
            CoinbaseSendMoneyRequest sendMoneyRequest = new CoinbaseSendMoneyRequest();
            sendMoneyRequest.setType("send");
            sendMoneyRequest.setTo(address);
            sendMoneyRequest.setAmount(amount);
            sendMoneyRequest.setCurrency(currency.getCurrencyCode());
            CoinbaseSendMoneyResponse sendMoneyResponse = sendMoney(accountId, sendMoneyRequest);
            return sendMoneyResponse.getData().getId();
        }

        return null;
    }

}
