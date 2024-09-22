package com.example.service;

import com.example.entity.Device;
import com.example.events.DeviceEvent;
import io.smallrye.reactive.messaging.annotations.Channel;
import io.smallrye.reactive.messaging.annotations.Emitter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class DeviceService {

    @Inject
    Event<DeviceEvent> deviceEvent;  // Inject Quarkus Event Bus

    // MQTT Emitter for device messages
    @Inject
    @Channel("device-status-out")
    Emitter<String> mqttEmitter;

    // List all devices
    public List<Device> listAllDevices() {
        return Device.listAll();
    }

    // Add a new device and trigger an event
    @Transactional
    public Device addDevice(Device device) {
        device.persist();
        deviceEvent.fire(new DeviceEvent(device.name, "Device Added", "Device was successfully added."));
        // Publish device addition to MQTT
        publishToMQTT(device.name, "Device Added");
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
            // Publish device update to MQTT
            publishToMQTT(device.name, "Device Updated");
        }
    }

    // Remove a device and trigger an event
    @Transactional
    public boolean removeDevice(Long id) {
        boolean deleted = Device.deleteById(id);
        if (deleted) {
            deviceEvent.fire(new DeviceEvent(id.toString(), "Device Removed", "Device was successfully removed."));
            // Publish device removal to MQTT
            publishToMQTT(id.toString(), "Device Removed");
        }
        return deleted;
    }

    // Helper method to publish to MQTT
    private void publishToMQTT(String deviceName, String status) {
        String message = "Device: " + deviceName + ", Status: " + status;
        mqttEmitter.send(message);  // Publish the status message to the MQTT broker
    }
}
