package org.knowm.xchange.coinbase;

import org.knowm.xchange.coinbase.dto.account.CoinbaseAccountsResponse;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.dto.account.AccountInfo;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.account.Wallet;
import org.knowm.xchange.instrument.Instrument;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CoinbaseAdapters {

    public static AccountInfo adaptAccountInfo(CoinbaseAccountsResponse accounts) {
        List<Wallet> wallets = new ArrayList<>();

        Wallet wallet = Wallet.Builder.from(accounts.getAccounts().stream()
                        .map(i -> new Balance(
                                Currency.getInstance(i.getCurrency()),
                                i.getHold().getValue().add(i.getAvailableBalance().getValue()),
                                i.getAvailableBalance().getValue()))
                        .collect(Collectors.toList()))
                .id("default")
                .build();
        wallets.add(wallet);

        return new AccountInfo(wallets);
    }

    public static String adaptInstrumentToCoinbaseInstrumentId(Instrument instrument) {
        return instrument.toString().replace('/', '-');
    }
}
