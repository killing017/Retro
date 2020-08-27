package com.example.retro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText name , email , phone, password;
    String strname, stremail, strphone, strpassword;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        password=findViewById(R.id.password);
        signup=findViewById(R.id.signup);
      signup.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              registerUser();
          }
      });

    }
    private void registerUser(){

        strname = name.getText().toString();
        stremail = email.getText().toString();
        strphone = phone.getText().toString();
        strpassword = password.getText().toString();
        Call<DefaultResponse> call=RetrofitClient.getInstance().getApi().registerUser("registerUser",strname,stremail,strphone,strpassword);
        call.enqueue(new Callback<DefaultResponse>() {


            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if(response.code()==200){
                    DefaultResponse dr=response.body();
                    Toast.makeText(MainActivity.this, dr.getMsg(), Toast.LENGTH_SHORT).show();
                //    String otp=dr.getMsg();
                }else{
                    DefaultResponse dr=response.body();
                    Toast.makeText(MainActivity.this, dr.getMsg(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {

            }
        });
    }


}
