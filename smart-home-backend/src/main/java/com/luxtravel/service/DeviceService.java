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
        device.persist();
        return device;
    }

    @Transactional
    public void removeDevice(Long id) {
        Device.deleteById(id);
    }
}
