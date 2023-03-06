/** */
package com.pccw.platform;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pccw.platform.service.sdk.rbac.model.RbacProperties;
import com.pccw.platform.service.sdk.rbac.utils.JwtBody;
import com.pccw.platform.service.sdk.rbac.utils.JwtToolkit;
import com.pccw.platform.service.utils.MessageService;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.validation.constraints.AssertTrue;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AbstractAdminControllerTest {
  protected String token;
  protected MockMvc mvc;
  protected ObjectMapper objectMapper;
  public static final String JWT_TOKEN_AMDIN =
      "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxYWViMjBhNC0zYThiLTQxMTQtOGI4ZS02Mzk1OWU5Njg3NmQiLCJhdWQiOm51bGwsImlzcyI6IkRldiBDb25zb2xlIENvcmUiLCJ0b2tlblR5cGUiOiJBUEkiLCJleHAiOjE2NjM5ODcxMzksImlhdCI6MTYzMjQ1MTEzOSwianRpIjoiNzQ2YzM1MWQtNzMwNy00NTc3LWJlNzEtMWYyZjdhM2I5ZTczIiwidGVuYW50IjoiQUdFTlQifQ.DnQMqmtn8KxY35BdxMf5N6SXtpBaw6dTjnlSgLMl6-k";
  @MockBean private MessageService utils;

  @Autowired
  public void init(MockMvc mvc, ObjectMapper objectMapper, RbacProperties rbacProperties)
      throws JsonProcessingException {
    this.mvc = mvc;
    this.objectMapper = objectMapper;
    JwtBody jwtBody = JwtToolkit.getJwtBody(JWT_TOKEN_AMDIN);
    token =
        "bearer "
            + JwtToolkit.sign(
                "123456",
                jwtBody.getSub(),
                jwtBody.getIss(),
                jwtBody.getAud(),
                jwtBody.getExp(),
                jwtBody.getJti(),
                "API");
    rbacProperties.getOpa().setEnabled(true);
  }

  public void mockMessage() {
    Mockito.when(utils.getMessage("message key")).thenReturn("error message");
  }

  public static String readFileToString(String path) throws IOException {
    ResourceLoader resourceLoader = new DefaultResourceLoader();
    Resource resource = resourceLoader.getResource(path);
    return IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);
  }

  public void mvcGet(MockMvc mockMvc, String url) throws Exception {
    mockMvc
            .perform(
                    MockMvcRequestBuilders.get(url)
                            .contentType(MediaType.APPLICATION_JSON)
                            .header("Authorization", token)
                            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn();
  }

  @Test
  @SneakyThrows
  void test() {
    String s ="";
    assertNotNull(s);
  }
}
