package com.pccw.platform.eunetworks.client;

import com.pccw.platform.provider.client.CommonWebClient;
import com.pccw.platform.eunetworks.config.EunetworksConfig;
import com.pccw.platform.eunetworks.modal.AuthUser;
import com.pccw.platform.eunetworks.modal.AuthToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Slf4j
@Service
public class EunetworksWebClient extends CommonWebClient {
    @Autowired
    private EunetworksConfig config;

    @Override
    public void refeshToken() {
        AuthUser authUser = AuthUser.builder().username(config.getUsername()).password(config.getPassword()).build();
        AuthToken euToken = post(config.getUrl() + "session", authUser, AuthToken.class);
        String token = euToken.getToken();
        log.info("token:{}", token);
        Header header = new BasicHeader("authorization", "Bearer " + token);
        this.setAuthHeader(header);
    }

    @Override
    public boolean shouldRefeshToken(WebClientResponseException ex) {
        return ex.getStatusCode().equals(HttpStatus.CONFLICT)
                || ex.getStatusCode().equals(HttpStatus.UNAUTHORIZED);
    }
}