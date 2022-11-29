package org.knowm.xchange.coinbase.dto.account;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CoinbaseTransactionData {

    private String id;
    private String type;
    private String status;
    private CoinbaseAmount amount;
    private CoinbaseAmount nativeAmount;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    private String resource;
    private String resourcePath;
    private CoinbaseNetwork network;
    private CoinbaseTo to;
    private CoinbaseDetails details;

}
