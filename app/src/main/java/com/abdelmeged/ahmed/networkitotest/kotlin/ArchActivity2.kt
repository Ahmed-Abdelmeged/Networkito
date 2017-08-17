package com.abdelmeged.ahmed.networkitotest.kotlin

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.abdelmeged.ahmed.networkito.ConnectionType
import com.abdelmeged.ahmed.networkito.ConnectivityChangeListener
import com.abdelmeged.ahmed.networkito.Networkito
import com.abdelmeged.ahmed.networkitotest.R
import org.jetbrains.anko.toast

class ArchActivity2 : AppCompatActivity(), LifecycleRegistryOwner, ConnectivityChangeListener {

    var lifecycleRegistry = LifecycleRegistry(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Networkito(this, this, this)
    }

    override fun getLifecycle(): LifecycleRegistry {
        return lifecycleRegistry
    }

    override fun onInternetConnected(connectionType: ConnectionType?) {
        toast("connected: " + connectionType!!.name)
    }

    override fun onInternetDisconnected() {
        toast("disconnected")
    }

}
