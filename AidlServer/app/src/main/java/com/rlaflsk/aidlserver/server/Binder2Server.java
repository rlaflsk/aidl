package com.rlaflsk.aidlserver.server;

import android.os.RemoteException;

import com.rlaflsk.aidlserver.IBinder2;

public class Binder2Server extends IBinder2.Stub {
    @Override
    public String getName() throws RemoteException {
        return "ClientServer2";
    }
}
