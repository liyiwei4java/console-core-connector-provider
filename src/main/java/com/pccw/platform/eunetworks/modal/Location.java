package com.pccw.platform.eunetworks.modal;

import com.pccw.platform.provider.modal.Entity;
import lombok.Data;

@Data
public class Location extends Entity {
  private String id;
  private String code;
  private String name;
  private String streetNumber;
  private String streetName;
  private String city;
  private String postcode;
  private String country;
  private Double latitude;
  private Double longitude;
}
