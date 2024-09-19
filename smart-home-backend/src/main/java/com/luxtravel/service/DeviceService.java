package com.example.service;

import com.example.entity.Device;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class DeviceService {

    public List<Device> listAllDevices() {
        return Device.listAll();
    }

    @Transactional
    public Device addDevice(Device device) {
        System.out.println("Persisting device: " + device); // Log the device before persisting
        device.persist();
        System.out.println("Device persisted: " + device);
        return device;
    }

    @Transactional
    public void removeDevice(Long id) {
        Device.deleteById(id);
    }
}
