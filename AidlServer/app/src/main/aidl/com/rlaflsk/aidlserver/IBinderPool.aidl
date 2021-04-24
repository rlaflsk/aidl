// IBinderPool.aidl
package com.rlaflsk.aidlserver;

interface IBinderPool {
    IBinder queryBinder(int binderCode);
}