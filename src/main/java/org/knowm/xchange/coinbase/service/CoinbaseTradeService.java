package org.knowm.xchange.coinbase.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.coinbase.CoinbaseAdapters;
import org.knowm.xchange.coinbase.dto.CoinbaseException;
import org.knowm.xchange.coinbase.dto.trade.CoinbaseCreateOrderRequest;
import org.knowm.xchange.coinbase.dto.trade.CoinbaseCreateOrderResponse;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.service.trade.TradeService;
import org.knowm.xchange.service.trade.params.orders.OrderQueryParams;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CoinbaseTradeService extends CoinbaseTradeServiceRaw implements TradeService {

    public CoinbaseTradeService(Exchange exchange) {
        super(exchange);
    }

    public String placeLimitOrder(LimitOrder limitOrder) throws IOException {
        String clientOrderId = UUID.randomUUID().toString();

        CoinbaseCreateOrderRequest request = new CoinbaseCreateOrderRequest();
        request.setClientOrderId(clientOrderId);
        request.setProductId(CoinbaseAdapters.adaptInstrumentToCoinbaseInstrumentId(limitOrder.getInstrument()));
        request.setSide(limitOrder.getType().equals(Order.OrderType.BID) ? "BUY" : "SELL");
        Map<String, Object> orderConfiguration = new HashMap<>();
        Map<String, Object> limitLimitGtc = new HashMap<>();
        limitLimitGtc.put("base_size", limitOrder.getOriginalAmount().toPlainString());
        limitLimitGtc.put("limit_price", limitOrder.getLimitPrice().toPlainString());
        orderConfiguration.put("limit_limit_gtc", limitLimitGtc);
        request.setOrderConfiguration(orderConfiguration);

        CoinbaseCreateOrderResponse response = createOrder(request);
        if (response.getSuccess())
            return response.getOrderId();
        else {
            throw new CoinbaseException(response.getErrorResponse().get("message"));
        }
    }

}
