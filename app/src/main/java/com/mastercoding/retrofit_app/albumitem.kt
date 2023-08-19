package com.mastercoding.retrofit_app

import com.google.gson.annotations.SerializedName


// 1- Data Classes (POJO)

data class `albumitem`(
    //Now I want to add an annotation here that it's called serialize.

   @SerializedName("id")
    val id:Int,
   @SerializedName("userid")
    val userid:Int,
   @SerializedName("title")
    val title:String,


   //That at serialized name annotation can be used to serialize a field with a different name instead of
    //the actual field name.
    //We can provide the expected serialized name as an annotation attribute.
//Also, if I'm going to use the user ID similar to user ID so I can also remove the serialized name.
//But if I want to display the title as name, so I should mention the serialized name and notation here.

//this class is for the object



)

