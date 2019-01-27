package com.github.templateapp.rest;

import com.github.templateapp.model.Result;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {

    @GET("planets/")
    Single<Result> getResult();
}
