package com.abdelmeged.ahmed.networkitotest

import android.arch.lifecycle.LifecycleActivity
import android.os.Bundle
import com.abdelmeged.ahmed.networkito.ConnectionType
import com.abdelmeged.ahmed.networkito.ConnectivityChangeListener
import com.abdelmeged.ahmed.networkito.Networkito
import org.jetbrains.anko.toast

class MainActivity : LifecycleActivity(), ConnectivityChangeListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Networkito(this, this, this)
    }

    override fun onInternetConnected(connectionType: ConnectionType?) {
        toast("connected")
    }

    override fun onInternetDisconnected() {
        toast("disConnected")
    }

}
