package com.abdelmeged.ahmed.networkitotest.java;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.abdelmeged.ahmed.networkitotest.R;
import com.ahmedabdelmeged.networkito.ConnectionType;
import com.ahmedabdelmeged.networkito.ConnectivityChangeListener;
import com.ahmedabdelmeged.networkito.Networkito;


public class NormalActivity2 extends AppCompatActivity implements ConnectivityChangeListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Networkito networkito = new Networkito(this, this, this);
    }

    @Override
    public void onInternetConnected(ConnectionType connectionType) {
        Toast.makeText(this, "connected: " + connectionType.name(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInternetDisconnected() {
        Toast.makeText(this, "disconnected", Toast.LENGTH_SHORT).show();
    }

}
