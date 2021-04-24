package com.rlaflsk.aidlserver.client;

import android.content.Context;
import android.os.RemoteException;

import com.rlaflsk.aidlserver.IBinderPool;
import com.rlaflsk.aidlserver.IBinder1;
import com.rlaflsk.aidlserver.IListener;

public class SubApi1 extends BaseSubApi {

    private IBinder1 mBinder1;
    private static SubApi1 mInstance = new SubApi1();

    public static SubApi1 getInstance() {
        return mInstance;
    }

    @Override
    public void onConnect(IBinderPool binderPool, Context context) {
        try {
            mBinder1 = IBinder1.Stub.asInterface(
                    binderPool.queryBinder(Definition.BINDER1));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisconnect() {

    }

    public String getName() {
        try {
            return mBinder1.getName();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setData(Data data, IListener listener) {
        try {
            mBinder1.setData(data, listener);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public Data getData() {
        try {
            return mBinder1.getData();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
}
