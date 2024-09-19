package com.example.resource;

import com.example.entity.Device;
import com.example.service.DeviceService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TestResource {

    @POST
    @Path("/echo")
    public Response echo(Device device) {
        return Response.ok(device).build();
    }
}
