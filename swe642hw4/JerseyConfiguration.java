//AUTHOR: Srivedaa Chinthalapani
//cross origin configuration file

package com.example.swe642;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfiguration extends ResourceConfig {
    public JerseyConfiguration() {
        register(StudentResource.class);
    }
}
