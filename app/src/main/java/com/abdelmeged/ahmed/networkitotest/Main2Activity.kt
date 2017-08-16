package com.abdelmeged.ahmed.networkitotest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.abdelmeged.ahmed.networkito.ConnectionType
import com.abdelmeged.ahmed.networkito.ConnectivityChangeListener
import com.abdelmeged.ahmed.networkito.Networkito
import org.jetbrains.anko.toast

class Main2Activity : AppCompatActivity(), ConnectivityChangeListener {

    lateinit var networkito: Networkito

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        networkito = Networkito(this)
        networkito.setConnectivityChangeListener(object : ConnectivityChangeListener {
            override fun onInternetConnected(connectionType: ConnectionType?) {
                toast("connected: " + connectionType!!.name)
            }

            override fun onInternetDisconnected() {
                toast("disconnected")
            }

        })
    }

    override fun onInternetConnected(connectionType: ConnectionType?) {
    }

    override fun onInternetDisconnected() {
    }

    override fun onStop() {
        super.onStop()
        networkito.unRegisterNetworkitoReceiver()
    }
}
