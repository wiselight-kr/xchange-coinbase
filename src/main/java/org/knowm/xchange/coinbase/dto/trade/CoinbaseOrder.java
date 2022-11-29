package org.knowm.xchange.coinbase.dto.trade;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CoinbaseOrder {

    private String orderId;
    private String productId;
    private String userId;
    private Map<String, Object> orderConfiguration;
    private String side;
    private String clientOrderId;
    private String status;
    private String timeInForce;
    private Date createdTime;
    private BigDecimal completionPercentage;
    private BigDecimal filledSize;
    private BigDecimal averageFilledPrice;
    private String fee;
    private String numberOfFills;
    private BigDecimal filledValue;
    private Boolean pendingCancel;
    private Boolean sizeInQuote;
    private BigDecimal totalFees;
    private Boolean sizeInclusiveOfFees;
    private String totalValueAfterFees;
    private String triggerStatus;
    private String orderType;
    private String rejectReason;
    private Boolean settled;
    private String productType;
}
