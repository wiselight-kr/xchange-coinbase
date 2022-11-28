package org.knowm.xchange.coinbase.dto.account;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CoinbaseAddress {

    private String id;
    private String address;
    private String name;
    private Date createdAt;
    private Date updatedAt;
    private String network;
    private String resource;
    private String resourcePath;
}
