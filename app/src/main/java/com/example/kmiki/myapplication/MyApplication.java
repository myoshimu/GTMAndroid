package com.example.kmiki.myapplication;

import android.app.Application;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.tagmanager.ContainerHolder;
import com.google.android.gms.tagmanager.TagManager;

import java.util.concurrent.TimeUnit;


public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        String container_id = "GTM-KGNP65";

        TagManager tagManager = TagManager.getInstance(this);

        tagManager.setVerboseLoggingEnabled(true);

        PendingResult<ContainerHolder> pending =
                tagManager.loadContainerPreferNonDefault(container_id,
                        R.raw.my_default_container);

        pending.setResultCallback(new ResultCallback<ContainerHolder>() {
            @Override
            public void onResult(ContainerHolder containerHolder) {
                ContainerHolderSingleton.setContainerHolder(containerHolder);
                if (!containerHolder.getStatus().isSuccess()) {
                    return;
                }
                ContainerHolderSingleton.setContainerHolder(containerHolder);
                ContainerHolderSingleton.getContainerHolder().refresh(); // Refresh the container immediately after initializing
            }
        }, 2, TimeUnit.SECONDS);
    }
}
