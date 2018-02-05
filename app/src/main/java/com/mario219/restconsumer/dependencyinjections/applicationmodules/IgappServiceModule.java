package com.mario219.restconsumer.dependencyinjections.applicationmodules;

import com.mario219.restconsumer.network.IgappService;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mario on 5/02/18.
 */

@Module(includes = NetworkModule.class)
public class IgappServiceModule {

    @Provides
    @RestConsumerScope
    public IgappService igappService(Retrofit retrofit){
        return retrofit.create(IgappService.class);
    }

    @Provides
    @RestConsumerScope
    public Retrofit retrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl("http://directotesting.igapps.co/")
                .build();
    }

}
