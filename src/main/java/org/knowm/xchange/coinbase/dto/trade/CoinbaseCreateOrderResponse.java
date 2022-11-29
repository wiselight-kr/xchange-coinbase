package org.knowm.xchange.coinbase.dto.trade;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Map;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CoinbaseCreateOrderResponse {

    private Boolean success;
    private String failureReason;
    private String orderId;
    private Map<String, String> successResponse;
    private Map<String, String> errorResponse;
    private Map<String, Object> orderConfiguration;
}
