package com.pccw.platform.provider.controller;

import com.pccw.platform.AbstractAdminControllerTest;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

class LocationControllerTest extends AbstractAdminControllerTest {
  @Autowired private MockMvc mockMvc;

  @Test
  @SneakyThrows
  void list() {
    mvcGet(mockMvc, "/location/eunetworks/locations");
    mvcGet(mockMvc, "/location/colt/locations");
  }

  @Test
  @SneakyThrows
  void get() {
    mvcGet(mockMvc, "/location/eunetworks/locations/a062500000E0fBUAAZ");
  }
}
