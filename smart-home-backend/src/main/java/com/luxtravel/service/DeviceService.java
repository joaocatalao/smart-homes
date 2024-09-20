package com.example.service;

import com.example.entity.Device;
import com.example.events.DeviceEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class DeviceService {

    @Inject
    Event<DeviceEvent> deviceEvent;  // Inject Quarkus Event Bus

    // List all devices
    public List<Device> listAllDevices() {
        return Device.listAll();
    }

    // Add a new device and trigger an event
    @Transactional
    public Device addDevice(Device device) {
        device.persist();
        deviceEvent.fire(new DeviceEvent(device.name, "Device Added", "Device was successfully added."));
        return device;
    }

    // Find a device by its ID
    public Device findById(Long id) {
        return Device.findById(id);  // Assuming PanacheEntity or PanacheRepository
    }

    // Update a device and trigger an event
    @Transactional
    public void updateDevice(Long id, Device updatedDevice) {
        Device device = Device.findById(id);
        if (device != null) {
            device.name = updatedDevice.name;
            device.type = updatedDevice.type;
            device.status = updatedDevice.status;
            deviceEvent.fire(new DeviceEvent(device.name, "Device Updated", "Device status was updated."));
        }
    }

    // Remove a device and trigger an event
    @Transactional
    public boolean removeDevice(Long id) {
        boolean deleted = Device.deleteById(id);
        if (deleted) {
            deviceEvent.fire(new DeviceEvent(id.toString(), "Device Removed", "Device was successfully removed."));
        }
        return deleted;
    }
}
