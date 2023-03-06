package com.pccw.platform.colt.service;

import com.pccw.platform.colt.modal.Location;
import com.pccw.platform.provider.modal.Entity;
import com.pccw.platform.provider.service.ILocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ColtLocationService implements ILocationService {
    public List<Entity> list() {
        List<Entity> list = new ArrayList<>();
        list.add(Location.builder().code("code-colt").id("id-colt").name("name-colt").build());
        return list;
    }

    public Entity get(String id) {
        return Location.builder().code("code-colt").id("id-colt").name("name-colt").build();
    }
}