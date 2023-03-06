package com.pccw.platform.eunetworks.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@Slf4j
public class EunetworksConfig {
  @Value("${eunetworks.url}")
  private String url;

  @Value("${eunetworks.username}")
  private String username;

  @Value("${eunetworks.password}")
  private String password;
}
