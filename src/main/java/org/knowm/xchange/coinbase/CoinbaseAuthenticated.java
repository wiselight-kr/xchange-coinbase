package org.knowm.xchange.coinbase;

import org.knowm.xchange.coinbase.dto.CoinbaseException;
import org.knowm.xchange.coinbase.dto.account.CoinbaseAccountsResponse;
import org.knowm.xchange.coinbase.dto.account.CoinbaseAddressesResponse;
import org.knowm.xchange.coinbase.dto.trade.CoinbaseCreateOrderRequest;
import org.knowm.xchange.coinbase.dto.trade.CoinbaseCreateOrderResponse;
import org.knowm.xchange.coinbase.dto.trade.CoinbaseGetOrderResponse;
import si.mazi.rescu.ParamsDigest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public interface CoinbaseAuthenticated extends Coinbase {

    String CB_ACCESS_KEY = "CB-ACCESS-KEY";
    String CB_ACCESS_SIGN = "CB-ACCESS-SIGN";
    String CB_ACCESS_TIMESTAMP = "CB-ACCESS-TIMESTAMP";

    @GET
    @Path("v3/brokerage/accounts")
    CoinbaseAccountsResponse getAccounts(
            @HeaderParam(CB_ACCESS_KEY) String apiKey,
            @HeaderParam(CB_ACCESS_SIGN) ParamsDigest signature,
            @HeaderParam(CB_ACCESS_TIMESTAMP) Long timestamp,
            @QueryParam("limit") Integer limit,
            @QueryParam("cursor") String cursor)
            throws CoinbaseException, IOException;

    @GET
    @Path("v2/accounts/{account_id}/addresses")
    CoinbaseAddressesResponse getAddresses(
            @HeaderParam(CB_ACCESS_KEY) String apiKey,
            @HeaderParam(CB_ACCESS_SIGN) ParamsDigest signature,
            @HeaderParam(CB_ACCESS_TIMESTAMP) Long timestamp,
            @PathParam("account_id") String accountId)
            throws CoinbaseException, IOException;

    @POST
    @Path("v3/brokerage/orders")
    @Consumes(MediaType.APPLICATION_JSON)
    CoinbaseCreateOrderResponse createOrder(
            @HeaderParam(CB_ACCESS_KEY) String apiKey,
            @HeaderParam(CB_ACCESS_SIGN) ParamsDigest signature,
            @HeaderParam(CB_ACCESS_TIMESTAMP) Long timestamp,
            CoinbaseCreateOrderRequest request)
            throws CoinbaseException, IOException;

    @GET
    @Path("v3/brokerage/orders/historical/{order_id}")
    CoinbaseGetOrderResponse getOrder(
            @HeaderParam(CB_ACCESS_KEY) String apiKey,
            @HeaderParam(CB_ACCESS_SIGN) ParamsDigest signature,
            @HeaderParam(CB_ACCESS_TIMESTAMP) Long timestamp,
            @PathParam("order_id") String orderId)
            throws CoinbaseException, IOException;

}
