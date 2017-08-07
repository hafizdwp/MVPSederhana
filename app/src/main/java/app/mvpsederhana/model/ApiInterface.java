package app.mvpsederhana.model;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Asus on 8/7/2017.
 */

public interface ApiInterface {

    //nama user saya di github
    @GET("hafizdwp")
    Call<ResponseBody> getResponse();
}
