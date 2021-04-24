package com.rlaflsk.aidlserver.client;

public interface ConnectListener {
    void handleApiConnected();
    void handleApiDisconnected();
}
