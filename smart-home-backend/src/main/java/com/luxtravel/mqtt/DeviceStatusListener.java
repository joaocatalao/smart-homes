package com.example.mqtt;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DeviceStatusListener {

    @Incoming("device-status-in") // This matches the "device/status" topic configured in application.properties
    public void receiveDeviceStatus(String status) {
        System.out.println("Received device status: " + status);
        // Here you can process the device status (e.g., update the database, trigger alerts, etc.)
    }
}
