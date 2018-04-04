package ib.facmed.unam.mx.simexfacmed.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by samo92 on 04/04/2018.
 */

public class ApiService {

    public static PostApiService createApiService(){

        Retrofit retrofitBuilder = new Retrofit.Builder()
                .baseUrl("http://ib.facmed.unam.mx/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofitBuilder.create(PostApiService.class);

    }
}
