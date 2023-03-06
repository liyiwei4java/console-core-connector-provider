package com.pccw.platform.provider.service;

import com.pccw.platform.provider.modal.Entity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILocationService {
    public List<Entity> list();

    public Entity get(String id);
}