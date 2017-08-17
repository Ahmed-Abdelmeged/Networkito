package com.abdelmeged.ahmed.networkitotest.java;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.abdelmeged.ahmed.networkito.ConnectionType;
import com.abdelmeged.ahmed.networkito.ConnectivityChangeListener;
import com.abdelmeged.ahmed.networkito.Networkito;
import com.abdelmeged.ahmed.networkitotest.R;


public class ArchActivity2 extends AppCompatActivity implements LifecycleRegistryOwner, ConnectivityChangeListener {
    LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Networkito(this, this, this);
    }

    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
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
