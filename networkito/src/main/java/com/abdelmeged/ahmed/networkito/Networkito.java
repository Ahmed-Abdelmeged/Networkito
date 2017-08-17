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


package com.abdelmeged.ahmed.networkito;

import android.arch.lifecycle.LifecycleOwner;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class Networkito {

    private ConnectivityChangeListener connectivityChangeListener;
    private Context context;
    private boolean isRegistered = false;

    public Networkito(Context context, LifecycleOwner lifecycleOwner, ConnectivityChangeListener connectivityChangeListener) {
        this.connectivityChangeListener = connectivityChangeListener;
        this.context = context;
        new NetworkitoLifeCycleObserver(context, lifecycleOwner, ConnectivityChangesBroadcast);
    }

    public Networkito(Context context, LifecycleOwner lifecycleOwner) {
        this.context = context;
        new NetworkitoLifeCycleObserver(context, lifecycleOwner, ConnectivityChangesBroadcast);
    }

    public Networkito(Context context, ConnectivityChangeListener connectivityChangeListener) {
        this.connectivityChangeListener = connectivityChangeListener;
        this.context = context;
        registerNetworkitoReceiver();
    }

    public Networkito(Context context) {
        this.context = context;
        registerNetworkitoReceiver();
    }

    private void registerNetworkitoReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);

        if (!isRegistered) {
            context.registerReceiver(ConnectivityChangesBroadcast, intentFilter);
            isRegistered = true;
        }
    }

    public void unRegisterNetworkitoReceiver() {
        if (isRegistered) {
            context.unregisterReceiver(ConnectivityChangesBroadcast);
        }
    }

    /**
     * Helper method to check the internet state
     *
     * @return true is the internet connected . false if not
     */
    public Boolean isAvailableInternetConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    private BroadcastReceiver ConnectivityChangesBroadcast = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (NetworkitoUtil.isAvailableInternetConnection(context)) {
                ConnectionType currentConnectionType = NetworkitoUtil.getConnectivityStatus(context);
                connectivityChangeListener.onInternetConnected(currentConnectionType);
            } else {
                connectivityChangeListener.onInternetDisconnected();
            }
        }
    };

    public void setConnectivityChangeListener(ConnectivityChangeListener connectivityChangeListener) {
        this.connectivityChangeListener = connectivityChangeListener;
    }

}
