package org.knowm.xchange.coinbase.dto.marketdata;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CoinbaseListProductResponse {

    private List<CoinbaseProduct> products;
    private Integer numProducts;
}
