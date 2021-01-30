package com.emdiem.zomatoretrofit.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.emdiem.zomatoretrofit.Api.ApiClient;
import com.emdiem.zomatoretrofit.Api.ApiInterface;
import com.emdiem.zomatoretrofit.R;
import com.emdiem.zomatoretrofit.model.Establishments;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView txt = findViewById(R.id.txt);

        String authToken = "82fb014e5519cb0b7e7d90109956f50f"; // after (authentication)
        int idCity = 280;

        ApiInterface apiInterface = ApiClient.createService(ApiInterface.class, authToken);
        apiInterface.establishments(idCity).enqueue(new Callback<Establishments>() {
            String s = "";
            @Override
            public void onResponse(@NotNull Call<Establishments> call, @NotNull Response<Establishments> response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        List<Establishments.Establishment> list = response.body().getEstablishments();
                        for (Establishments.Establishment o : list){
                            s= s.concat( "id: " + o.getId() + " name: "+o.getName()+"\n");
                        }
                        txt.setText(s);
                    }
                }else {
                    //show dialog error
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NotNull Call<Establishments> call, @NotNull Throwable t) {
                //show dialog fail
                Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
            }
        });

    }
}