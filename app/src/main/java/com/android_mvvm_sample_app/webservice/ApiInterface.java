package com.android_mvvm_sample_app.webservice;

import com.android_mvvm_sample_app.model.BookResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by kaushik on 21-Aug-18.
 */


public interface ApiInterface {


    @GET("books/v1/volumes")
    Call<BookResponseModel> getBooksInfo(@Query("q") String queue);
}
