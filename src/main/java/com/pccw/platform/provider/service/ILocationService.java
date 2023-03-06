package com.pccw.platform.provider.service;

import com.pccw.platform.provider.modal.Entity;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ILocationService {
  public List<Entity> list();

  public Entity get(String id);
}
