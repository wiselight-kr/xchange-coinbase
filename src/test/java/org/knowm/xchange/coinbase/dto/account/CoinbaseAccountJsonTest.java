package org.knowm.xchange.coinbase.dto.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CoinbaseAccountJsonTest {

    @Test
    public void testDeserializeGetListAccounts() throws IOException {
        InputStream is =
                CoinbaseAccountJsonTest.class.getResourceAsStream(
                        "/org/knowm/xchange/coinbase/dto/account/example-get-list-accounts.json");

        ObjectMapper mapper = new ObjectMapper();
        CoinbaseAccountsResponse accounts = mapper.readValue(is, CoinbaseAccountsResponse.class);

        assertThat(accounts.getAccounts().size()).isEqualTo(1);

        CoinbaseAccount account = accounts.getAccounts().get(0);
        assertThat(account.getUuid()).isEqualTo("8bfc20d7-f7c6-4422-bf07-8243ca4169fe");
        assertThat(account.getName()).isEqualTo("BTC Wallet");
        assertThat(account.getCurrency()).isEqualTo("BTC");
        assertThat(account.getAvailableBalance()).isNotNull();

        CoinbaseBalance availableBalance = account.getAvailableBalance();
        assertThat(availableBalance.getValue()).isEqualTo(new BigDecimal("1.23"));
        assertThat(availableBalance.getCurrency()).isEqualTo("BTC");

        assertThat(account.get_default()).isEqualTo(false);
        assertThat(account.getActive()).isEqualTo(true);
        assertThat(account.getCreatedAt()).isEqualTo("2021-05-31T09:59:59Z");
        assertThat(account.getUpdatedAt()).isEqualTo("2021-05-31T09:59:59Z");
        assertThat(account.getDeletedAt()).isEqualTo("2021-05-31T09:59:59Z");
        assertThat(account.getType()).isEqualTo("ACCOUNT_TYPE_UNSPECIFIED");
        assertThat(account.getReady()).isEqualTo(true);

        CoinbaseBalance hold = account.getHold();
        assertThat(hold.getValue()).isEqualTo(new BigDecimal("1.23"));
        assertThat(hold.getCurrency()).isEqualTo("BTC");
    }
}
