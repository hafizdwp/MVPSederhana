package app.mvpsederhana;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import app.mvpsederhana.constant.Constant;
import app.mvpsederhana.interfaces.MainInterface;
import app.mvpsederhana.model.ApiClient;
import app.mvpsederhana.model.ApiInterface;
import app.mvpsederhana.presenter.MainPresenter;
import app.mvpsederhana.support.Bikin;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MainInterface {

    @BindView(R.id.main_tv_response)
    TextView tvResponse;
    @BindView(R.id.main_tv_title)
    TextView tvTitle;
    @BindView(R.id.main_tv_url)
    TextView tvUrl;
    @BindView(R.id.main_btn_exec)
    Button btnExec;

    private MainPresenter presenter;
    private Context mContext;

    //intent startActivity
    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = MainActivity.this;

        presenter = new MainPresenter(this);

        tvUrl.setText("URL " + Constant.BASE_URL);
        btnExec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.eksekusiApi();
            }
        });
    }

    @Override
    public void apiSuccess(String body) {
        Bikin.toast(mContext, "Api Berhasil");
        tvResponse.setText(body);
    }

    @Override
    public void apiFailed() {
        Bikin.toast(mContext, "Api Gagal");
    }
}
