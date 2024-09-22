package com.example.mqtt;

import org.eclipse.microprofile.reactive.messaging.Outgoing;
import io.smallrye.reactive.messaging.annotations.Broadcast;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DeviceCommandSender {

    private String command;

    // Method to accept input and set the command
    public void setCommand(String command) {
        this.command = command;
    }

    // @Outgoing method without parameters
    @Outgoing("device-command-out")
    @Broadcast
    public String sendDeviceCommand() {
        System.out.println("Sending command to device: " + command);
        return command;  // Publishes the command
    }
}
