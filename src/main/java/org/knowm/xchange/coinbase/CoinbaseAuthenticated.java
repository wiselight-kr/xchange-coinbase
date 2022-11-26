package org.knowm.xchange.coinbase;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
public interface CoinbaseAuthenticated extends Coinbase {

    String CB_ACCESS_KEY = "CB-ACCESS-KEY";
    String CB_ACCESS_SIGN = "CB-ACCESS-SIGN";
    String CB_ACCESS_TIMESTAMP = "CB-ACCESS-TIMESTAMP";
    String CB_ACCESS_PASSPHRASE = "CB-ACCESS-PASSPHRASE";

}
