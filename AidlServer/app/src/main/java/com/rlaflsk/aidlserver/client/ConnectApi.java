package com.rlaflsk.aidlserver.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.rlaflsk.aidlserver.IBinderPool;

import java.util.ArrayList;

public class ConnectApi {

    public ArrayList<BaseSubApi> mSubApiList = new ArrayList<>();
    private static ConnectApi mInstance = new ConnectApi();
    private Context mContext;
    private ConnectListener mListener;

    public static ConnectApi getInstance() {
        return mInstance;
    }

    private ConnectApi() {
        mSubApiList.add(SubApi1.getInstance());
        mSubApiList.add(SubApi2.getInstance());
    }

    public void connect(Context context, ConnectListener listener) {
        ComponentName component = new ComponentName("com.rlaflsk.aidlserver",
                "com.rlaflsk.aidlserver.server.ServerService");
        Intent intent = new Intent(IBinder.class.getName());
        intent.setComponent(component);
        mContext = context;
        mListener = listener;
        context.bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    public void disconnect() {
        mContext.unbindService(mServiceConnection);
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IBinderPool binderPool = IBinderPool.Stub.asInterface(iBinder);
            for (BaseSubApi subApi: mSubApiList) {
                subApi.onConnect(binderPool, mContext);
            }
            mListener.handleApiConnected();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mListener.handleApiDisconnected();
        }
    };
}
