package com.mastercoding.retrofit_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textview : TextView = findViewById(R.id.textview)

        val retrofitService = RetrofitInstance
                //variable i initialize as RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumServices::class.java)
        //So here I'm combining the album service with the With the Retrofit instance.

//create a live data object
        //Since we need to pass and get a response from the Internet from the server.
        //And this live data will update the UI directly.
        val reponseLiveData : LiveData<Response<albums>> =
            //I need to get a response Of type albums Albums.ALBUM is It's an array list of our JSON file equal to live data.
            liveData {
                //This would be requesting and and representing the live data scope of response albums.
                  val response = retrofitService.getAlbums()
                //Am calling this getAlbums() method in order to store it inside a response variable.

                //val response2 = retrofitService.getSpecificAlbums(6)
                //And I need to call the function Emit in order to emit the response.
                emit(response)
            }

        reponseLiveData.observe(this, Observer {
            val albumsList = it.body()?.listIterator()
//Now I need to check if the albums list is not equal to null.
            //Then I need to loop through all the elements of this album's list, which is mutable list DOT has next.
            if (albumsList !=null){
                while (albumsList.hasNext()){
                    val albumItem = albumsList.next()
                    //  Log.i("TAGY",albumItem.title)

                    val result = " Album Title: ${albumItem.title} \n"

                    textview.append(result)


                }
            }
        })
    }



    }
