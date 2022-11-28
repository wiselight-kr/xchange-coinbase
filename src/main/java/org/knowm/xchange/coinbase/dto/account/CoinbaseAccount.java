package org.knowm.xchange.coinbase.dto.account;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CoinbaseAccount {

    private String uuid;
    private String name;
    private String currency;
    private CoinbaseBalance availableBalance;
    private Boolean _default;
    private Boolean active;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
    private String type;
    private Boolean ready;
    private CoinbaseBalance hold;

}
