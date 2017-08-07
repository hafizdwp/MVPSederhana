package app.mvpsederhana.presenter;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import app.mvpsederhana.MainActivity;
import app.mvpsederhana.interactor.MainPresenterInteractor;
import app.mvpsederhana.interfaces.MainInterface;
import app.mvpsederhana.interfaces.MainPresenterInterface;
import app.mvpsederhana.model.ApiCallback;
import app.mvpsederhana.model.ApiClient;
import app.mvpsederhana.model.ApiInterface;
import app.mvpsederhana.support.Bikin;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Asus on 8/4/2017.
 */

public class MainPresenter implements MainPresenterInterface, MainPresenterInteractor {

    MainInterface view;

    public MainPresenter(MainActivity mainActivity) {
        this.view = mainActivity;
    }

    //method implementasi MainPresenterInterface
    @Override
    public void eksekusiApi() {
        talkToApi(new ApiCallback() {
            @Override
            public void onBerhasil(String body) {
                view.apiSuccess(body);
            }

            @Override
            public void onGagal(Throwable t) {
                view.apiFailed();
            }
        });
    }

    //method implementasi INTERACTOR MainPresenterInteractor
    @Override
    public void talkToApi(final ApiCallback apiCallback) {

        ApiInterface apiInterface;
        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<ResponseBody> call = apiInterface.getResponse();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    //berhasil
                    apiCallback.onBerhasil(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                //gagal
                apiCallback.onGagal(t);
            }
        });
    }
}
