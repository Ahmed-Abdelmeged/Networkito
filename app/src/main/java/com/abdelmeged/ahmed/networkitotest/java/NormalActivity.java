package com.abdelmeged.ahmed.networkitotest.java;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.abdelmeged.ahmed.networkitotest.R;
import com.ahmedabdelmeged.networkito.ConnectionType;
import com.ahmedabdelmeged.networkito.ConnectivityChangeListener;
import com.ahmedabdelmeged.networkito.Networkito;


public class NormalActivity extends AppCompatActivity {

    private Networkito networkito;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        networkito = new Networkito(this);

        if (networkito.isAvailableInternetConnection()) {
            Toast.makeText(this, "Available Internet Connection", Toast.LENGTH_SHORT).show();
        }

        networkito.setConnectivityChangeListener(new ConnectivityChangeListener() {
            @Override
            public void onInternetConnected(ConnectionType connectionType) {
                Toast.makeText(NormalActivity.this, "connected: " + connectionType.name(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInternetDisconnected() {
                Toast.makeText(NormalActivity.this, "disconnected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        networkito.unRegisterNetworkitoReceiver();
    }
}
