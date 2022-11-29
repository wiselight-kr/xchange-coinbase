package org.knowm.xchange.coinbase.dto.trade;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CoinbaseTradeJsonTest {

    @Test
    public void testDeserializePostCreateOrder() throws IOException {
        InputStream is =
                CoinbaseTradeJsonTest.class.getResourceAsStream(
                        "/org/knowm/xchange/coinbase/dto/trade/example-post-create-order.json");

        ObjectMapper mapper = new ObjectMapper();
        CoinbaseCreateOrderResponse orderResponse = mapper.readValue(is, CoinbaseCreateOrderResponse.class);
        assertThat(orderResponse.getSuccess()).isTrue();
        assertThat(orderResponse.getFailureReason()).isEqualTo("UNKNOWN_FAILURE_REASON");
        assertThat(orderResponse.getOrderId()).isEqualTo("string");

        assertThat(orderResponse.getSuccessResponse()).isNotNull();
        assertThat(orderResponse.getSuccessResponse().get("order_id")).isEqualTo("11111-00000-000000");
        assertThat(orderResponse.getSuccessResponse().get("product_id")).isEqualTo("BTC-USD");
        assertThat(orderResponse.getSuccessResponse().get("side")).isEqualTo("UNKNOWN_ORDER_SIDE");
        assertThat(orderResponse.getSuccessResponse().get("client_order_id")).isEqualTo("0000-00000-000000");

        assertThat(orderResponse.getErrorResponse()).isNotNull();
        assertThat(orderResponse.getErrorResponse().get("error")).isEqualTo("UNKNOWN_FAILURE_REASON");
        assertThat(orderResponse.getErrorResponse().get("message")).isEqualTo("The order configuration was invalid");
        assertThat(orderResponse.getErrorResponse().get("error_details")).isEqualTo("Market orders cannot be placed with empty order sizes");
        assertThat(orderResponse.getErrorResponse().get("preview_failure_reason")).isEqualTo("UNKNOWN_PREVIEW_FAILURE_REASON");
        assertThat(orderResponse.getErrorResponse().get("new_order_failure_reason")).isEqualTo("UNKNOWN_FAILURE_REASON");

        assertThat(orderResponse.getOrderConfiguration()).isNotNull();
        Map<String, Object> marketMarketIoc = new HashMap<>();
        marketMarketIoc.put("quote_size", "10.00");
        marketMarketIoc.put("base_size", "0.001");
        assertThat(orderResponse.getOrderConfiguration().get("market_market_ioc")).usingRecursiveComparison().isEqualTo(marketMarketIoc);

        Map<String, Object> limitLimitGtc = new HashMap<>();
        limitLimitGtc.put("quote_size", "10.00");
        limitLimitGtc.put("base_size", "0.001");
        limitLimitGtc.put("limit_price", "10000.00");
        limitLimitGtc.put("post_only", false);
        assertThat(orderResponse.getOrderConfiguration().get("limit_limit_gtc")).usingRecursiveComparison().isEqualTo(limitLimitGtc);

        Map<String, Object> limitLimitGtd = new HashMap<>();
        limitLimitGtd.put("quote_size", "10.00");
        limitLimitGtd.put("base_size", "0.001");
        limitLimitGtd.put("limit_price", "10000.00");
        limitLimitGtd.put("end_time", "2021-05-31T09:59:59Z");
        limitLimitGtd.put("post_only", false);
        assertThat(orderResponse.getOrderConfiguration().get("limit_limit_gtd")).usingRecursiveComparison().isEqualTo(limitLimitGtd);

        Map<String, Object> stopLimitStopLimitGtc = new HashMap<>();
        stopLimitStopLimitGtc.put("quote_size", "10.00");
        stopLimitStopLimitGtc.put("base_size", "0.001");
        stopLimitStopLimitGtc.put("limit_price", "10000.00");
        stopLimitStopLimitGtc.put("stop_price", "20000.00");
        stopLimitStopLimitGtc.put("stop_direction", "UNKNOWN_STOP_DIRECTION");
        assertThat(orderResponse.getOrderConfiguration().get("stop_limit_stop_limit_gtc")).usingRecursiveComparison().isEqualTo(stopLimitStopLimitGtc);

        Map<String, Object> stopLimitStopLimitGtd = new HashMap<>();
        stopLimitStopLimitGtd.put("quote_size", 10);
        stopLimitStopLimitGtd.put("base_size", 0.001);
        stopLimitStopLimitGtd.put("limit_price", "10000.00");
        stopLimitStopLimitGtd.put("stop_price", "20000.00");
        stopLimitStopLimitGtd.put("end_time", "2021-05-31T09:59:59Z");
        stopLimitStopLimitGtd.put("stop_direction", "UNKNOWN_STOP_DIRECTION");
        assertThat(orderResponse.getOrderConfiguration().get("stop_limit_stop_limit_gtd")).usingRecursiveComparison().isEqualTo(stopLimitStopLimitGtd);
    }

    @Test
    public void testDeserializeGetOrder() throws IOException {
        InputStream is =
                CoinbaseTradeJsonTest.class.getResourceAsStream(
                        "/org/knowm/xchange/coinbase/dto/trade/example-get-order.json");

        ObjectMapper mapper = new ObjectMapper();
        CoinbaseGetOrderResponse orderResponse = mapper.readValue(is, CoinbaseGetOrderResponse.class);
        assertThat(orderResponse.getOrder()).isNotNull();

        CoinbaseOrder order = orderResponse.getOrder();
        assertThat(order.getOrderId()).isEqualTo("0000-000000-000000");
        assertThat(order.getProductId()).isEqualTo("BTC-USD");
        assertThat(order.getUserId()).isEqualTo("2222-000000-000000");

        assertThat(order.getOrderConfiguration()).isNotNull();
        Map<String, Object> marketMarketIoc = new HashMap<>();
        marketMarketIoc.put("quote_size", "10.00");
        marketMarketIoc.put("base_size", "0.001");
        assertThat(order.getOrderConfiguration().get("market_market_ioc")).usingRecursiveComparison().isEqualTo(marketMarketIoc);

        Map<String, Object> limitLimitGtc = new HashMap<>();
        limitLimitGtc.put("quote_size", "10.00");
        limitLimitGtc.put("base_size", "0.001");
        limitLimitGtc.put("limit_price", "10000.00");
        limitLimitGtc.put("post_only", false);
        assertThat(order.getOrderConfiguration().get("limit_limit_gtc")).usingRecursiveComparison().isEqualTo(limitLimitGtc);

        Map<String, Object> limitLimitGtd = new HashMap<>();
        limitLimitGtd.put("quote_size", "10.00");
        limitLimitGtd.put("base_size", "0.001");
        limitLimitGtd.put("limit_price", "10000.00");
        limitLimitGtd.put("end_time", "2021-05-31T09:59:59Z");
        limitLimitGtd.put("post_only", false);
        assertThat(order.getOrderConfiguration().get("limit_limit_gtd")).usingRecursiveComparison().isEqualTo(limitLimitGtd);

        Map<String, Object> stopLimitStopLimitGtc = new HashMap<>();
        stopLimitStopLimitGtc.put("quote_size", "10.00");
        stopLimitStopLimitGtc.put("base_size", "0.001");
        stopLimitStopLimitGtc.put("limit_price", "10000.00");
        stopLimitStopLimitGtc.put("stop_price", "20000.00");
        stopLimitStopLimitGtc.put("stop_direction", "UNKNOWN_STOP_DIRECTION");
        assertThat(order.getOrderConfiguration().get("stop_limit_stop_limit_gtc")).usingRecursiveComparison().isEqualTo(stopLimitStopLimitGtc);

        Map<String, Object> stopLimitStopLimitGtd = new HashMap<>();
        stopLimitStopLimitGtd.put("quote_size", 10);
        stopLimitStopLimitGtd.put("base_size", 0.001);
        stopLimitStopLimitGtd.put("limit_price", "10000.00");
        stopLimitStopLimitGtd.put("stop_price", "20000.00");
        stopLimitStopLimitGtd.put("end_time", "2021-05-31T09:59:59Z");
        stopLimitStopLimitGtd.put("stop_direction", "UNKNOWN_STOP_DIRECTION");
        assertThat(order.getOrderConfiguration().get("stop_limit_stop_limit_gtd")).usingRecursiveComparison().isEqualTo(stopLimitStopLimitGtd);

        assertThat(order.getSide()).isEqualTo("UNKNOWN_ORDER_SIDE");
        assertThat(order.getClientOrderId()).isEqualTo("11111-000000-000000");
        assertThat(order.getStatus()).isEqualTo("PENDING");
        assertThat(order.getTimeInForce()).isEqualTo("UNKNOWN_TIME_IN_FORCE");
        assertThat(order.getCreatedTime()).isEqualTo("2021-05-31T09:59:59Z");
        assertThat(order.getCompletionPercentage()).isEqualTo("50");
        assertThat(order.getFilledSize()).isEqualTo(new BigDecimal("0.001"));
        assertThat(order.getAverageFilledPrice()).isEqualTo(new BigDecimal("50"));
        assertThat(order.getFee()).isEqualTo("string");
        assertThat(order.getNumberOfFills()).isEqualTo("2");
        assertThat(order.getFilledValue()).isEqualTo(new BigDecimal("10000"));
        assertThat(order.getPendingCancel()).isTrue();
        assertThat(order.getSizeInQuote()).isFalse();
        assertThat(order.getTotalFees()).isEqualTo(new BigDecimal("5.00"));
        assertThat(order.getSizeInclusiveOfFees()).isFalse();
        assertThat(order.getTotalValueAfterFees()).isEqualTo("string");
        assertThat(order.getTriggerStatus()).isEqualTo("UNKNOWN_TRIGGER_STATUS");
        assertThat(order.getOrderType()).isEqualTo("UNKNOWN_ORDER_TYPE");
        assertThat(order.getRejectReason()).isEqualTo("REJECT_REASON_UNSPECIFIED");
        assertThat(order.getSettled()).isTrue();
        assertThat(order.getProductType()).isEqualTo("UNKNOWN_PRODUCT_TYPE");
    }
}
