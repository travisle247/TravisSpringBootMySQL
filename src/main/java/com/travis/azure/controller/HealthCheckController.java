package com.travis.azure.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(value = "Healthcheck")
public class HealthCheckController {

    @Autowired
    private Environment environment;

    @GetMapping(path = "/healthcheck")
    @ResponseBody
    public ResponseEntity healthCheck() {
        String[] activeProfiles = this.environment.getActiveProfiles();
        String activeEnvironment = "";
        if (activeProfiles.length > 0) {
            activeEnvironment = activeProfiles[0];
        }
        if (StringUtils.hasText(activeEnvironment))
            return ResponseEntity.ok("HealthCheck is successful. Active environment is " + activeEnvironment);
        else
            return ResponseEntity.ok("HealthCheck is successful. Active environment is unknown.");
    }
}
