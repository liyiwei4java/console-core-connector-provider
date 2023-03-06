package com.pccw.platform.eunetworks.service;

import com.pccw.platform.eunetworks.client.EunetworksWebClient;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EunetworksInitService {
  @Autowired private EunetworksWebClient client;

  @PostConstruct
  public void init() {
    client.refeshToken();
  }
}
