package com.pccw.platform.eunetworks.modal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthUser {
  private String username;
  private String password;
}
