package com.example.resource;

import com.example.entity.Device;
import com.example.service.DeviceService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/devices")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DeviceResource {

    @Inject
    DeviceService deviceService;

    @GET
    public List<Device> getDevices() {
        return deviceService.listAllDevices();
    }

    @POST
    public Response addDevice(Device device) {
        System.out.println("Received device: " + device);
        deviceService.addDevice(device);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDevice(@PathParam("id") Long id) {
        deviceService.removeDevice(id);
        return Response.noContent().build();
    }
}
