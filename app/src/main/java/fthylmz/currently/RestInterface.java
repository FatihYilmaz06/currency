package fthylmz.currently;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestInterface {

    @GET("latest?access_key=f650f930eb70134a616600d6fd7c78e0&base=EUR&symbols=USD,TRY,GBP")
    Call<List<ResponseREPO>> getRepo();
}
