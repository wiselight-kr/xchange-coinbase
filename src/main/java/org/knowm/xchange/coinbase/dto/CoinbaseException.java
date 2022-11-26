package org.knowm.xchange.coinbase.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import si.mazi.rescu.HttpStatusExceptionSupport;

public class CoinbaseException extends HttpStatusExceptionSupport {
    public CoinbaseException(
            @JsonProperty("message") String message) {
        super(message);
    }
}