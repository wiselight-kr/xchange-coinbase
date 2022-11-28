package org.knowm.xchange.coinbase.dto.account;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CoinbasePagination {

    private Object endingBefore;
    private Object startingAfter;
    private Integer limit;
    private String order;
    private String previousUri;
    private String nextUri;
}
