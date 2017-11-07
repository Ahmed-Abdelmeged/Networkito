package com.abdelmeged.ahmed.networkitotest.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.abdelmeged.ahmed.networkitotest.R
import com.ahmedabdelmeged.networkito.ConnectionType
import com.ahmedabdelmeged.networkito.RxNetworkito
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.toast

class RxActivity : AppCompatActivity() {

    lateinit var disposable: Disposable
    lateinit var rxNetworkito: RxNetworkito

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rxNetworkito = RxNetworkito(this)
        disposable = rxNetworkito.networkitoObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ connectionType ->
                    if (connectionType == ConnectionType.MOBILE || connectionType == ConnectionType.WIFI) {
                        toast("connected: " + connectionType.name)
                    } else {
                        toast("disconnected")
                    }
                })
    }

    override fun onStop() {
        super.onStop()
        rxNetworkito.unRegisterNetworkitoReceiver()
        disposable.dispose()
    }
}
