package fthylmz.currently;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreen extends AppCompatActivity {

    RestInterface restInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        restInterface=ApiClient.getClient().create(RestInterface.class);
        Call<List<ResponseREPO>> call=restInterface.getRepo();
        call.enqueue(new Callback<List<ResponseREPO>>() {
            @Override
            public void onResponse(Call<List<ResponseREPO>> call, Response<List<ResponseREPO>> response) {
                List<ResponseREPO> responseREPOList = new ArrayList<>();
                responseREPOList = response.body();
                for (int i = 0; i < responseREPOList.size(); i++) {

                    if (responseREPOList.get(i).getSuccess()){
                        Toast.makeText(getApplicationContext(), "Api bağlantısı başarılı", Toast.LENGTH_LONG);}
                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            Intent i = new Intent(SplashScreen.this, MainActivity.class);
                            startActivity(i);
                            finish();
                        }
                    }, 5000);
                }

        }

            @Override
            public void onFailure(Call<List<ResponseREPO>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Bağlantınızı kontrol ediniz",Toast.LENGTH_LONG);
            }
            });


    }
}
