package com.luxtravel;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api")
public class SmartHomeController {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Smart Home Backend is Running!";
    }
}
