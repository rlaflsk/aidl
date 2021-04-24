package com.rlaflsk.aidlserver.client;

import android.content.Context;

import com.rlaflsk.aidlserver.IBinderPool;

public abstract class BaseSubApi {
    public abstract void onConnect(IBinderPool binderPool, Context context);
    public abstract void onDisconnect();
}
