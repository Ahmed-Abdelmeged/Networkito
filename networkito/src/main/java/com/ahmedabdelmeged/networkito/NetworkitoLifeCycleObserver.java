/*
 * Copyright (c) 2017 Ahmed-Abdelmeged
 *
 * github: https://github.com/Ahmed-Abdelmeged
 * email: ahmed.abdelmeged.vm@gamil.com
 * Facebook: https://www.facebook.com/ven.rto
 * Twitter: https://twitter.com/A_K_Abd_Elmeged
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.ahmedabdelmeged.networkito;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;


class NetworkitoLifeCycleObserver implements LifecycleObserver {
    private boolean isRegistered = false;
    private Context context;
    private BroadcastReceiver internetConnectivityChangeBroadcastReceiver;

    NetworkitoLifeCycleObserver(Context context, LifecycleOwner lifecycleOwner,
                                BroadcastReceiver internetConnectivityChangeBroadcastReceiver) {
        this.context = context;
        lifecycleOwner.getLifecycle().addObserver(this);
        this.internetConnectivityChangeBroadcastReceiver = internetConnectivityChangeBroadcastReceiver;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void start() {
        if (!isRegistered) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
            context.registerReceiver(internetConnectivityChangeBroadcastReceiver, intentFilter);
            isRegistered = true;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void stop() {
        if (isRegistered) {
            context.unregisterReceiver(internetConnectivityChangeBroadcastReceiver);
            isRegistered = false;
        }
    }

}
