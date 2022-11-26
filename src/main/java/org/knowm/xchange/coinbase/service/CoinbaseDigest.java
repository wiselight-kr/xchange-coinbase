package org.knowm.xchange.coinbase.service;

import org.knowm.xchange.service.BaseParamsDigest;
import org.knowm.xchange.utils.DigestUtils;
import si.mazi.rescu.RestInvocation;

import javax.ws.rs.HeaderParam;

import static org.knowm.xchange.coinbase.CoinbaseAuthenticated.CB_ACCESS_TIMESTAMP;

public class CoinbaseDigest extends BaseParamsDigest {

    private CoinbaseDigest(String secretKey) {
        super(secretKey, HMAC_SHA_256);
    }

    public static CoinbaseDigest createInstance(String secretKey) {
        return secretKey == null ? null : new CoinbaseDigest(secretKey);
    }

    @Override
    public String digestParams(RestInvocation restInvocation) {
        final String timestamp = restInvocation.getParamValue(HeaderParam.class, CB_ACCESS_TIMESTAMP).toString();
        final String method = restInvocation.getHttpMethod();
        final String requestPath = restInvocation.getPath();
        final String body = restInvocation.getRequestBody();

        final String message = timestamp + method + requestPath + body;
        return DigestUtils.bytesToHex(getMac().doFinal(message.getBytes()));
    }
}
