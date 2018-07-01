package com.eprogrammerz.examples.gateway.config;

import com.eprogrammerz.examples.gateway.domain.RegistryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yogen on 10/11/2017.
 */
@Component
@Primary
@EnableAutoConfiguration
public class DocumentationController implements SwaggerResourcesProvider {
    @Autowired
    private RegistryInfo registryInfo;

    @Override
    public List<SwaggerResource> get() {
        final List<SwaggerResource> resources = new ArrayList<>();

        this.registryInfo.getServices().forEach(entry -> resources.add(swaggerResource(entry.getName(), entry.getApiDoc(), entry.getVersion())));

        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }

}