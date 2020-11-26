package com.developer.smmmousavi.balefilm.network.factory;


import android.content.Context;
import android.util.Log;

import com.developer.smmmousavi.balefilm.application.BaseApplication;
import com.developer.smmmousavi.balefilm.constants.Constants;
import com.developer.smmmousavi.balefilm.network.api.MovieRestApi;
import com.developer.smmmousavi.balefilm.network.util.LiveDataCallAdapterFactory;
import com.developer.smmmousavi.balefilm.util.NetworkUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieRestApiFactory {
    private static final String TAG = "MovieRestApiFactory";

    private MovieRestApiFactory() {
    }

    public static MovieRestApi create() {
        OkHttpClient client = provideOkHttpClientInstance();
        Retrofit retrofit = provideRetrofitInstance(client);
        return retrofit.create(MovieRestApi.class);
    }

    static OkHttpClient provideOkHttpClientInstance() {
        Context context = BaseApplication.getAppContext();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        Cache cacheObj = new Cache(context.getCacheDir(), Constants.CACHE_SIZE);
        Interceptor interceptor = chain -> {
            Request request = chain.request();
            if (NetworkUtils.hasNetwork()) {
                Log.d(TAG, "RETROFIT_ENQUEUE: Internet available" );
                /*
                 *  If there is Internet, get the cache that was stored 5 seconds ago.
                 *  If the cache is older than 5 seconds, then discard it,
                 *  and indicate an error in fetching the response.
                 *  The 'max-age' attribute is responsible for this behavior.
                 */
                request.newBuilder()
                    .header("Cache-Control", "public, max-age=" + 5)
                    .build();
            } else {
                /*
                 *  If there is no Internet, get the cache that was stored 7 days ago.
                 *  If the cache is older than 7 days, then discard it,
                 *  and indicate an error in fetching the response.
                 *  The 'max-stale' attribute is responsible for this behavior.
                 *  The 'only-if-cached' attribute indicates to not retrieve new data; fetch the cache only instead.
                 */
                request.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7)
                    .build();
            }
            return chain.proceed(request);
        };
        return new OkHttpClient.Builder()
            // connection timeout: establish connection to server
            // read timeout between each byte read from server
            // write timeout between each byte sent to server
            .connectTimeout(Constants.CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
            .readTimeout(Constants.READ_TIMEOUT, TimeUnit.MILLISECONDS)
            .writeTimeout(Constants.WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
            .retryOnConnectionFailure(false)
            .cache(cacheObj)
            .addInterceptor(interceptor)
            .build();
    }

    static Retrofit provideRetrofitInstance(OkHttpClient httpClient) {
        return new Retrofit.Builder()
            .baseUrl(Constants.TMDB_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(new LiveDataCallAdapterFactory())
            .client(httpClient)
            .build();
    }
}
