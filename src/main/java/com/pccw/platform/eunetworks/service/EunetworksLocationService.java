package com.pccw.platform.eunetworks.service;

import com.pccw.platform.eunetworks.client.EunetworksWebClient;
import com.pccw.platform.eunetworks.config.EunetworksConfig;
import com.pccw.platform.eunetworks.modal.Location;
import com.pccw.platform.provider.modal.Entity;
import com.pccw.platform.provider.service.ILocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class EunetworksLocationService implements ILocationService {
    @Autowired
    private EunetworksWebClient client;
    @Autowired
    private EunetworksConfig config;

    public List<Entity> list() {
        List<Location> location = client.get(config.getUrl() + "locations", new ParameterizedTypeReference<List<Location>>() {
        });
        return List.copyOf(location);
    }

    public Entity get(String id) {
        Location location = client.get(config.getUrl() + "locations/" + id, Location.class);
        log.info("location:{}", location);
        return location;
    }
}