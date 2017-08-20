package com.abdelmeged.ahmed.networkitotest.java;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.abdelmeged.ahmed.networkito.ConnectionType;
import com.abdelmeged.ahmed.networkito.RxNetworkito;
import com.abdelmeged.ahmed.networkitotest.R;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ahmed on 8/20/2017.
 */

public class RxActivity extends AppCompatActivity {

    Disposable disposable;
    RxNetworkito rxNetworkito;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rxNetworkito = new RxNetworkito(this);
        disposable =
                rxNetworkito.getNetworkitoObservable()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(connectionType -> {
                            if (connectionType == ConnectionType.MOBILE || connectionType == ConnectionType.WIFI) {
                                Toast.makeText(this, "connected: " + connectionType.name(), Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(this, "disconnected", Toast.LENGTH_SHORT).show();
                            }
                        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        rxNetworkito.unRegisterNetworkitoReceiver();
        disposable.dispose();
    }
}
