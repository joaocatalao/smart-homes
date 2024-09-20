package com.example.events;

public class DeviceEvent {
    public String deviceName;
    public String eventType;
    public String eventData;

    public DeviceEvent(String deviceName, String eventType, String eventData) {
        this.deviceName = deviceName;
        this.eventType = eventType;
        this.eventData = eventData;
    }
}
