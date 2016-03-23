package com.google.koenv.androidgtm;

import com.google.android.gms.tagmanager.ContainerHolder;

/**
 * Created by koenv on 8/24/15.
 */
public class ContainerHolderSingleton {
    private static ContainerHolder containerHolder;

    /**
     * Utility class; don't instantiate.
     */
    private ContainerHolderSingleton() {
    }

    public static ContainerHolder getContainerHolder() {
        return containerHolder;
    }

    public static void setContainerHolder(ContainerHolder c) {
        containerHolder = c;
    }
}
