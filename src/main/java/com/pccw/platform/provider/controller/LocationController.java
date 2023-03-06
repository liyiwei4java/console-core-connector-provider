package com.pccw.platform.provider.controller;

import com.pccw.platform.common.web.ResultData;
import com.pccw.platform.provider.modal.Entity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
@Tag(name = "eunetworks", description = "eunetworks api")
public class LocationController {
  @Autowired com.pccw.platform.provider.service.ServiceFactory serviceFactory;

  @Operation(summary = "get location list")
  @GetMapping("/{provider}/locations")
  public ResultData<List<Entity>> list(@PathVariable("provider") String provider) {
    return ResultData.success(serviceFactory.getLocationService(provider).list());
  }

  @Operation(summary = "get a location")
  @GetMapping("/{provider}/locations/{id}")
  public ResultData<Entity> get(
      @PathVariable("provider") String provider, @PathVariable("id") String id) {
    return ResultData.success(serviceFactory.getLocationService(provider).get(id));
  }
}
