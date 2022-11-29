package org.knowm.xchange.coinbase.dto.marketdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CoinbaseMarketDataJsonTest {

    @Test
    public void testDeserializeGetListProducts() throws IOException {
        InputStream is =
                CoinbaseMarketDataJsonTest.class.getResourceAsStream(
                        "/org/knowm/xchange/coinbase/dto/marketdata/example-get-list-products.json");

        ObjectMapper mapper = new ObjectMapper();
        CoinbaseListProductResponse productResponse = mapper.readValue(is, CoinbaseListProductResponse.class);
        assertThat(productResponse.getProducts()).hasSize(1);
        assertThat(productResponse.getNumProducts()).isEqualTo(100);

        CoinbaseProduct product = productResponse.getProducts().get(0);
        assertThat(product.getProductId()).isEqualTo("BTC-USD");
        assertThat(product.getPrice()).isEqualTo(new BigDecimal("140.21"));
        assertThat(product.getPricePercentageChange_24h()).isEqualTo("9.43%");
        assertThat(product.getVolume_24h()).isEqualTo(new BigDecimal("1908432"));
        assertThat(product.getVolumePercentageChange_24h()).isEqualTo("9.43%");
        assertThat(product.getBaseIncrement()).isEqualTo(new BigDecimal("0.00000001"));
        assertThat(product.getQuoteIncrement()).isEqualTo(new BigDecimal("0.00000001"));
        assertThat(product.getQuoteMinSize()).isEqualTo(new BigDecimal("0.00000001"));
        assertThat(product.getQuoteMaxSize()).isEqualTo(new BigDecimal("1000"));
        assertThat(product.getBaseMinSize()).isEqualTo(new BigDecimal("0.00000001"));
        assertThat(product.getBaseMaxSize()).isEqualTo(new BigDecimal("1000"));
        assertThat(product.getBaseName()).isEqualTo("Bitcoin");
        assertThat(product.getQuoteName()).isEqualTo("US Dollar");
        assertThat(product.getWatched()).isTrue();
        assertThat(product.getIsDisabled()).isFalse();
        assertThat(product.get_new()).isTrue();
        assertThat(product.getStatus()).isEqualTo("string");
        assertThat(product.getCancelOnly()).isTrue();
        assertThat(product.getLimitOnly()).isTrue();
        assertThat(product.getPostOnly()).isTrue();
        assertThat(product.getTradingDisabled()).isFalse();
        assertThat(product.getAuctionMode()).isTrue();
        assertThat(product.getProductType()).isEqualTo("UNKNOWN_PRODUCT_TYPE");
        assertThat(product.getQuoteCurrencyId()).isEqualTo("USD");
        assertThat(product.getBaseCurrencyId()).isEqualTo("BTC");
        assertThat(product.getMidMarketPrice()).isEqualTo(new BigDecimal("140.22"));
    }
}
