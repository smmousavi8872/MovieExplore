package com.developer.smmmousavi.balefilm.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.developer.smmmousavi.balefilm.application.BaseApplication;

public class NetworkUtils {

    public static boolean hasNetwork() {
        Context context = BaseApplication.getAppContext();
        ConnectivityManager connectivityManager
            = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
