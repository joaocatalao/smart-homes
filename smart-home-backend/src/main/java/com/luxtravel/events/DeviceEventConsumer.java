package com.example.events;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class DeviceEventConsumer {

    public void onDeviceEvent(@Observes DeviceEvent event) {
        // Here you can perform actions based on the event
        System.out.println("Received event: " + event.eventType + " for device " + event.deviceName);
        System.out.println("Event data: " + event.eventData);

        // Example: You can send this event data to another service or save it in a log
    }
}
