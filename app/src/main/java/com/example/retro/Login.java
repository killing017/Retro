package com.example.retro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
EditText email,password;
TextView t1;
Button b1;
//private List<Result> resultList;

    String  stremail, strpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        t1=findViewById(R.id.t1);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        b1=findViewById(R.id.login);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
      LoginUser();
            }
        });

    }
    private void LoginUser(){
        stremail = email.getText().toString().trim();

        strpassword = password.getText().toString().trim();
       // JsonObject jsonObject=new JsonObject();

       // String jsonInputString="{\"method\":\"login\",\"customer_email\":\""+stremail+"\",\"customer_password\":\""+strpassword+"\"}";
        Call<LoginData> call=RetrofitClient.getInstance().getApi().LoginUser(stremail,strpassword);
        call.enqueue(new Callback<LoginData>() {
            @Override
            public void onResponse(Call<LoginData> call, Response<LoginData> response) {
              ArrayList<Result> loginData=response.body().getResult();
              for(int i=0;i<loginData.size();i++){
                  String id=loginData.get(i).getId();
                  String name=loginData.get(i).getName();
                  Toast.makeText(Login.this,name, Toast.LENGTH_SHORT).show();
              }
            // Toast.makeText(Login.this, loginData, Toast.LENGTH_SHORT).show();
                Toast.makeText(Login.this, "sucess", Toast.LENGTH_SHORT).show();
               /* if(data h){
                    Toast.makeText(Login.this, "success", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Login.this, "wrong", Toast.LENGTH_SHORT).show();
                }*/
              //  Toast.makeText(Login.this, response.message(), Toast.LENGTH_SHORT).show();
              //  String s=response.message();
             //   String s=null;

               //String s=null;

                 //   if (response.message() == s) {
                   //     Toast.makeText(Login.this, "sucess", Toast.LENGTH_SHORT).show();
                  //    //  s = response.body().string();
                 //   } else {
                   //     Toast.makeText(Login.this, "wrong", Toast.LENGTH_SHORT).show();
                       // s = response.errorBody().string();
                    }

            /*    if(s!=null){

                    try {
                        JSONObject jsonObject=new JSONObject();
                        Toast.makeText(Login.this,jsonObject.getString("msg"), Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }*/


            @Override
            public void onFailure(Call<LoginData> call, Throwable t) {
                Toast.makeText(Login.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }


        });
    }
}
