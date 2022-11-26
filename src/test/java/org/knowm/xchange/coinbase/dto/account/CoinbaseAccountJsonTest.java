package org.knowm.xchange.coinbase.dto.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CoinbaseAccountJsonTest {

    @Test
    public void testDeserializeGetAllCoinbaseWallets() throws IOException {
        InputStream is =
                CoinbaseAccountJsonTest.class.getResourceAsStream(
                        "/org/knowm/xchange/coinbase/dto/account/example-get-all-coinbase-wallets.json");

        ObjectMapper mapper = new ObjectMapper();
        CoinbaseWallet[] coinbaseWallets = mapper.readValue(is, CoinbaseWallet[].class);

        assertThat(coinbaseWallets.length).isEqualTo(1);

        CoinbaseWallet coinbaseWallet = coinbaseWallets[0];
        assertThat(coinbaseWallet.getAvailableOnConsumer()).isEqualTo(true);
        assertThat(coinbaseWallet.getHoldBalance()).isEqualTo(new BigDecimal("0.00"));
        assertThat(coinbaseWallet.getId()).isEqualTo("OXT");
        assertThat(coinbaseWallet.getHoldCurrency()).isEqualTo("USD");
        assertThat(coinbaseWallet.getBalance()).isEqualTo(new BigDecimal("0.00000000"));
        assertThat(coinbaseWallet.getCurrency()).isEqualTo("OXT");
        assertThat(coinbaseWallet.getPrimary()).isEqualTo(false);
        assertThat(coinbaseWallet.getName()).isEqualTo("OXT Wallet");
        assertThat(coinbaseWallet.getType()).isEqualTo("wallet");
        assertThat(coinbaseWallet.getActive()).isEqualTo(true);
    }
}
