package com.example.retrofitkotlin1

import retrofit2.Call
import retrofit2.http.GET
import java.util.stream.Stream

interface MyInterface {

    //"http://jsonplaceholder.typicode.com/"

    @GET("users")
    fun getString(): Call<String>




}