package com.mario219.restconsumer.dependencyinjections.applicationmodules;

import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * Created by mario on 5/02/18.
 */

@Module(includes = ContextModule.class)
public class NetworkModule {

    @Provides
    @RestConsumerScope
    public HttpLoggingInterceptor loginInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return interceptor;
    }

    @Provides
    @RestConsumerScope
    public File cacheFile(@ApplicationContext Context context){
        return new File(context.getCacheDir(), "okhttp_cache");
    }

    @Provides
    @RestConsumerScope
    public Cache cache(File cacheFile){
        return new Cache(cacheFile, 10*10*1000); //10Mb
    }

    @Provides
    @RestConsumerScope
    public OkHttpClient client(HttpLoggingInterceptor loggingInterceptor, Cache cache){
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
    }

}
