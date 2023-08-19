package com.mastercoding.retrofit_app

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

   companion object{
       val BASE_URL="https://jsonplaceholder.typicode.com/"

       fun getRetrofitInstance(): Retrofit{
           return Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
               .build()

           //Add converter factory and I'm just thinking the JSON with JSON and start building this retrofit instance.


       }
   }




}
//And here this class is a retrofit instance, it will include a companion object because it's a singleton
//So.This is the companion object.
//I want to create a singleton instance of a retrofit.
//I want this application to use only one retrofit instance without creating more and more retrofit instances
//every time I need to fetch the data in order to prevent memory leaks, save time, save network calls