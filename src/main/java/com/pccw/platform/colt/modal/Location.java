package com.pccw.platform.colt.modal;

import com.pccw.platform.provider.modal.Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Location extends Entity {
  private String id;
  private String code;
  private String name;
}
