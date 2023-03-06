package com.pccw.platform.provider.service;

import com.pccw.platform.colt.service.ColtLocationService;
import com.pccw.platform.eunetworks.service.EunetworksLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFactory {
  @Autowired EunetworksLocationService eunetworksLocationService;
  @Autowired ColtLocationService coltLocationService;
  @Autowired LocationService locationService;

  public ILocationService getLocationService(String provider) {
    if (provider.equals("eunetworks")) {
      return eunetworksLocationService;
    } else if (provider.equals("colt")) {
      return coltLocationService;
    }
    return locationService;
  }
}
