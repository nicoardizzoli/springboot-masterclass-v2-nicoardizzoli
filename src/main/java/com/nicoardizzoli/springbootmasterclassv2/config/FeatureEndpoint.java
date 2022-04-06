package com.nicoardizzoli.springbootmasterclassv2.config;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//ESTO ES PARA AGREGARLE ENDPOINTS AL ACTUATOR.
@Component
@Endpoint(id = "features")
public class FeatureEndpoint {

    private final Map<String, Feature> featureMap = new ConcurrentHashMap<>();

    public FeatureEndpoint(){
        featureMap.put("Department", new Feature(true));
        featureMap.put("User", new Feature(false));
        featureMap.put("Authentication", new Feature(false));
    }

    @ReadOperation
    public Map<String, Feature> getFeatureMap() {
        return featureMap;
    }

    @ReadOperation
    public Feature getFeature(@Selector String featureName) {
        return featureMap.get(featureName);
    }
}
