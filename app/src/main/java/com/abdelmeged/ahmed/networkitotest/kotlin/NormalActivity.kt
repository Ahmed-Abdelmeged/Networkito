package com.abdelmeged.ahmed.networkitotest.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.abdelmeged.ahmed.networkitotest.R
import com.ahmedabdelmeged.networkito.ConnectionType
import com.ahmedabdelmeged.networkito.ConnectivityChangeListener
import com.ahmedabdelmeged.networkito.Networkito
import org.jetbrains.anko.toast

class NormalActivity : AppCompatActivity() {

    lateinit var networkito: Networkito

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        networkito = Networkito(this)

        if (networkito.isAvailableInternetConnection) {
            toast("Available Internet Connection")
        }

        networkito.setConnectivityChangeListener(object : ConnectivityChangeListener {
            override fun onInternetConnected(connectionType: ConnectionType?) {
                toast("connected: " + connectionType!!.name)
            }

            override fun onInternetDisconnected() {
                toast("disconnected")
            }

        })
    }


    override fun onStop() {
        super.onStop()
        networkito.unRegisterNetworkitoReceiver()
    }
}
