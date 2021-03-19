package com.example.weatherapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherapi.API.APIService;
import com.example.weatherapi.MODEL.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText editText ;
    Button button;
    TextView textView;


    String url = "api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}";
    String apiKey ="192fa8bc7c1a029c4c80398e1901ab1b";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.tvC);
        button=findViewById(R.id.btnSearch);
        editText=findViewById(R.id.edtCityName);
    }

    public void getWeather (View view){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        APIService service = retrofit.create(APIService.class);


        Call<Example> exampleCall =service.getWeather(editText.getText().toString().trim(),apiKey);

        exampleCall.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.code() == 404){
                    Toast.makeText(MainActivity.this, "City not empty", Toast.LENGTH_SHORT).show();
                }
                else if( response.isSuccessful()){
                    Toast.makeText(MainActivity.this, ""+response.code(), Toast.LENGTH_SHORT).show();
                }

                Example example = response.body();
                Main main = example.getMain();

                Double temp = main.getTemp();

                Integer temperature = (int)(temp-273.15);

                textView.setText(temperature+"C");
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });

    }
}