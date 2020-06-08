package com.example.retrofitkotlin1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.*
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

 val retrofit = Retrofit.Builder()
     .addConverterFactory(ScalarsConverterFactory.create())
     .baseUrl("http://jsonplaceholder.typicode.com/")
     .build()

        val api = retrofit.create(MyInterface::class.java)

        val call: Call<String> = api.getString()

          call.enqueue(object :Callback<String>{
              override fun onFailure(call: Call<String>, t: Throwable) {
                  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                  Log.e("ERROR",t.message.toString())
              }

              override fun onResponse(call: Call<String>, response: Response<String>) {


                  val Jsonresponse:String = response.body()!!

                  val stringBuilder = StringBuilder()

                  val JA  = JSONArray(Jsonresponse)

                 for(data in 0 until JA.length())
                  {

                      val c = JA.getJSONObject(data)
                      val address =  c.getJSONObject("address")



                    //  val modelListView = ModelListView(c.getString("name"),c.getString("email"),address.getString("city"))
                      stringBuilder.append(c.getString("name"))
                      stringBuilder.append("\n")
                      stringBuilder.append(c.getString("email"))
                      stringBuilder.append("\n")
                      stringBuilder.append(address.getString("city"))
                      stringBuilder.append("\n\n")



                  }

                  data.text = stringBuilder


              }


          })

    }
}
