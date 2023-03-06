package com.pccw.platform.provider.service;

import com.pccw.platform.provider.modal.Entity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class LocationService implements ILocationService {
    public List<Entity> list() {
        return new ArrayList<>();
    }

    public Entity get(String id) {
        return null;
    }
}