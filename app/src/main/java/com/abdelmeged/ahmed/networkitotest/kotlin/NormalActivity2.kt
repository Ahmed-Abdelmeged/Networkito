package com.abdelmeged.ahmed.networkitotest.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.abdelmeged.ahmed.networkito.ConnectionType
import com.abdelmeged.ahmed.networkito.ConnectivityChangeListener
import com.abdelmeged.ahmed.networkito.Networkito
import com.abdelmeged.ahmed.networkitotest.R
import org.jetbrains.anko.toast

class NormalActivity2 : AppCompatActivity(), ConnectivityChangeListener {

    lateinit var networkito: Networkito

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        networkito = Networkito(this, this)
    }

    override fun onInternetConnected(connectionType: ConnectionType?) {
        toast("connected: " + connectionType!!.name)
    }

    override fun onInternetDisconnected() {
        toast("disconnected")
    }

    override fun onStop() {
        super.onStop()
        networkito.unRegisterNetworkitoReceiver()
    }
}
