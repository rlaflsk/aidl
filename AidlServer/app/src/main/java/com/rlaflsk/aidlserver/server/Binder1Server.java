package com.rlaflsk.aidlserver.server;

import android.os.RemoteException;

import com.rlaflsk.aidlserver.IBinder1;
import com.rlaflsk.aidlserver.IListener;
import com.rlaflsk.aidlserver.client.Data;

public class Binder1Server extends IBinder1.Stub {

    private Data mData;

    @Override
    public String getName() {
        return "ClientServer1";
    }

    @Override
    public void setData(Data data, IListener listener) {
        mData = data;
        if (listener != null) {
            try {
                listener.onSucess();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Data getData() {
        return mData;
    }
}
