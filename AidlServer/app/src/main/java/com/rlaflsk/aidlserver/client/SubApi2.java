package com.rlaflsk.aidlserver.client;

import android.content.Context;
import android.os.RemoteException;

import com.rlaflsk.aidlserver.IBinderPool;
import com.rlaflsk.aidlserver.IBinder2;

public class SubApi2 extends BaseSubApi {

    private IBinder2 mBinder2;
    private static SubApi2 mInstance = new SubApi2();

    public static SubApi2 getInstance() {
        return mInstance;
    }

    @Override
    public void onConnect(IBinderPool binderPool, Context context) {
        try {
            mBinder2 = IBinder2.Stub.asInterface(
                    binderPool.queryBinder(Definition.BINDER2));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisconnect() {

    }

    public String getName() {
        try {
            return mBinder2.getName();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
}
