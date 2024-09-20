package com.example.resource;

import com.example.entity.Device;
import com.example.service.DeviceService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/devices")  // Base path for device-related API endpoints
@Produces(MediaType.APPLICATION_JSON)  // Endpoints will return JSON
@Consumes(MediaType.APPLICATION_JSON)  // Endpoints will accept JSON input
public class DeviceResource {

    @Inject
    DeviceService deviceService;  // Injecting the service class

    // 1. GET: List all devices
    @GET
    public List<Device> getDevices() {
        return deviceService.listAllDevices();  // Service to get all devices
    }

    // 2. POST: Add a new device
    @POST
    public Response addDevice(Device device) {
        deviceService.addDevice(device);  // Service to add a device
        return Response.status(Response.Status.CREATED).build();  // Return HTTP 201 Created
    }

    // 3. GET: Get device by ID
    @GET
    @Path("/{id}")  // The {id} is a path parameter
    public Response getDeviceById(@PathParam("id") Long id) {
        Device device = deviceService.findById(id);
        if (device == null) {
            return Response.status(Response.Status.NOT_FOUND).build();  // Return 404 if device not found
        }
        return Response.ok(device).build();  // Return 200 OK with the device details
    }

    // 4. PUT: Update a device
    @PUT
    @Path("/{id}")  // Update device using its ID
    public Response updateDevice(@PathParam("id") Long id, Device updatedDevice) {
        deviceService.updateDevice(id, updatedDevice);
        return Response.ok(updatedDevice).build();  // Return the updated device with 200 OK
    }

    // 5. DELETE: Remove a device by ID
    @DELETE
    @Path("/{id}")
    public Response deleteDevice(@PathParam("id") Long id) {
        boolean removed = deviceService.removeDevice(id);  // Service to delete device
        if (!removed) {
            return Response.status(Response.Status.NOT_FOUND).build();  // Return 404 if not found
        }
        return Response.noContent().build();  // Return 204 No Content on successful deletion
    }
}
