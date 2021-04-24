// IBinder1.aidl
package com.rlaflsk.aidlserver;
import com.rlaflsk.aidlserver.client.Data;
import com.rlaflsk.aidlserver.IListener;

interface IBinder1 {
    String getName();
    void setData(in Data data, IListener listener);
    Data getData();
}