package org.knowm.xchange.coinbase.dto.marketdata;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CoinbaseProduct {

    private String productId;
    private BigDecimal price;
    private String pricePercentageChange_24h;
    private BigDecimal volume_24h;
    private String volumePercentageChange_24h;
    private BigDecimal baseIncrement;
    private BigDecimal quoteIncrement;
    private BigDecimal quoteMinSize;
    private BigDecimal quoteMaxSize;
    private BigDecimal baseMinSize;
    private BigDecimal baseMaxSize;
    private String baseName;
    private String quoteName;
    private Boolean watched;
    private Boolean isDisabled;
    private Boolean _new;
    private String status;
    private Boolean cancelOnly;
    private Boolean limitOnly;
    private Boolean postOnly;
    private Boolean tradingDisabled;
    private Boolean auctionMode;
    private String productType;
    private String quoteCurrencyId;
    private String baseCurrencyId;
    private BigDecimal midMarketPrice;

}
