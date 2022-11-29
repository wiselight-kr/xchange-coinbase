package org.knowm.xchange.coinbase.dto.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.as;
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

    @Test
    public void testDeserializeGetListAddresses() throws IOException {
        InputStream is =
                CoinbaseAccountJsonTest.class.getResourceAsStream(
                        "/org/knowm/xchange/coinbase/dto/account/example-get-list-addresses.json");

        ObjectMapper mapper = new ObjectMapper();
        CoinbaseAddressesResponse addresses = mapper.readValue(is, CoinbaseAddressesResponse.class);

        assertThat(addresses.getPagination()).isNotNull();
        CoinbasePagination pagination = addresses.getPagination();
        assertThat(pagination.getEndingBefore()).isNull();
        assertThat(pagination.getStartingAfter()).isNull();
        assertThat(pagination.getLimit()).isEqualTo(25);
        assertThat(pagination.getOrder()).isEqualTo("desc");
        assertThat(pagination.getPreviousUri()).isNull();
        assertThat(pagination.getNextUri()).isNull();

        assertThat(addresses.getData().size()).isEqualTo(2);

        CoinbaseAddress address1 = addresses.getData().get(0);
        assertThat(address1.getId()).isEqualTo("dd3183eb-af1d-5f5d-a90d-cbff946435ff");
        assertThat(address1.getAddress()).isEqualTo("mswUGcPHp1YnkLCgF1TtoryqSc5E9Q8xFa");
        assertThat(address1.getName()).isNull();
        assertThat(address1.getCreatedAt()).isEqualTo("2015-01-31T20:49:02Z");
        assertThat(address1.getUpdatedAt()).isEqualTo("2015-03-31T17:25:29-07:00");
        assertThat(address1.getNetwork()).isEqualTo("bitcoin");
        assertThat(address1.getResource()).isEqualTo("address");
        assertThat(address1.getResourcePath()).isEqualTo("/v2/accounts/2bbf394c-193b-5b2a-9155-3b4732659ede/addresses/dd3183eb-af1d-5f5d-a90d-cbff946435ff");

        CoinbaseAddress address2 = addresses.getData().get(1);
        assertThat(address2.getId()).isEqualTo("ac5c5f15-0b1d-54f5-8912-fecbf66c2a64");
        assertThat(address2.getAddress()).isEqualTo("mgSvu1z1amUFAPkB4cUg8ujaDxKAfZBt5Q");
        assertThat(address2.getName()).isNull();
        assertThat(address2.getCreatedAt()).isEqualTo("2015-03-31T17:23:52-07:00");
        assertThat(address2.getUpdatedAt()).isEqualTo("2015-01-31T20:49:02Z");
        assertThat(address2.getNetwork()).isEqualTo("bitcoin");
        assertThat(address2.getResource()).isEqualTo("address");
        assertThat(address2.getResourcePath()).isEqualTo("/v2/accounts/2bbf394c-193b-5b2a-9155-3b4732659ede/addresses/ac5c5f15-0b1d-54f5-8912-fecbf66c2a64");
    }

    @Test
    public void testDeserializePostSendMoney() throws IOException {
        InputStream is =
                CoinbaseAccountJsonTest.class.getResourceAsStream(
                        "/org/knowm/xchange/coinbase/dto/account/example-post-send-money.json");

        ObjectMapper mapper = new ObjectMapper();
        CoinbaseSendMoneyResponse sendMoneyResponse = mapper.readValue(is, CoinbaseSendMoneyResponse.class);

        assertThat(sendMoneyResponse.getData()).isNotNull();
        CoinbaseTransactionData data = sendMoneyResponse.getData();
        assertThat(data.getId()).isEqualTo("3c04e35e-8e5a-5ff1-9155-00675db4ac02");
        assertThat(data.getType()).isEqualTo("send");
        assertThat(data.getStatus()).isEqualTo("pending");
        CoinbaseAmount amount = new CoinbaseAmount(new BigDecimal("-0.10000000"), "BTC");
        assertThat(data.getAmount()).usingRecursiveComparison().isEqualTo(amount);
        CoinbaseAmount nativeAmount = new CoinbaseAmount(new BigDecimal("-1.00"), "USD");
        assertThat(data.getNativeAmount()).usingRecursiveComparison().isEqualTo(nativeAmount);
        assertThat(data.getDescription()).isNull();
        assertThat(data.getCreatedAt()).isEqualTo("2015-01-31T20:49:02Z");
        assertThat(data.getUpdatedAt()).isEqualTo("2015-03-31T17:25:29-07:00");
        assertThat(data.getResource()).isEqualTo("transaction");
        assertThat(data.getResourcePath()).isEqualTo("/v2/accounts/2bbf394c-193b-5b2a-9155-3b4732659ede/transactions/3c04e35e-8e5a-5ff1-9155-00675db4ac02");
        CoinbaseNetwork network = new CoinbaseNetwork("unconfirmed", "463397c87beddd9a61ade61359a13adc9efea26062191fe07147037bce7f33ed", "bitcoin");
        assertThat(data.getNetwork()).usingRecursiveComparison().isEqualTo(network);
        CoinbaseTo to = new CoinbaseTo("bitcoin_address", "1AUJ8z5RuHRTqD1eikyfUUetzGmdWLGkpT");
        assertThat(data.getTo()).usingRecursiveComparison().isEqualTo(to);
        CoinbaseDetails details = new CoinbaseDetails("Send bitcoin", "to User 2");
        assertThat(data.getDetails()).usingRecursiveComparison().isEqualTo(details);
    }
}
