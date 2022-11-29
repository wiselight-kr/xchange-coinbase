package org.knowm.xchange.coinbase.dto.trade;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Map;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CoinbaseCreateOrderRequest {

    private String clientOrderId;
    private String productId;
    private String side;
    private Map<String, Object> orderConfiguration;

}
