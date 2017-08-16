package com.abdelmeged.ahmed.networkito;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

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

class NetworkitoUtil {

    /**
     * Helper method to get the current connection state
     *
     * @param context the application context
     * @return the connection type
     */
    static ConnectionType getConnectivityStatus(Context context) {
        ConnectionType connectionType = ConnectionType.NOT_CONNECTED;

        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                connectionType = ConnectionType.MOBILE;
            } else if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                connectionType = ConnectionType.WIFI;
            }
        }
        return connectionType;
    }

    /**
     * Helper method to check the internet state
     *
     * @return true is the internet connected . false if not
     */
    static Boolean isAvailableInternetConnection(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
