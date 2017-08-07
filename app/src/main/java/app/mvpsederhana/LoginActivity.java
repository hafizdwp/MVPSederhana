package app.mvpsederhana;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import app.mvpsederhana.constant.Constant;
import app.mvpsederhana.interfaces.LoginInterface;
import app.mvpsederhana.presenter.LoginPresenter;
import app.mvpsederhana.support.Bikin;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Asus on 8/4/2017.
 */

public class LoginActivity extends AppCompatActivity implements LoginInterface {

    @BindView(R.id.login_btn_gpl)
    Button btnGpl;
    @BindView(R.id.login_btn_login)
    Button btnLogin;
    @BindView(R.id.login_et_username)
    EditText etUsername;
    @BindView(R.id.login_et_password)
    EditText etPassword;

    private LoginPresenter presenter;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        this.mContext = LoginActivity.this;

        presenter = new LoginPresenter(this);

        btnGpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etUsername.setText("username");
                etPassword.setText("password");
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username, password;
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();
                presenter.eksekusiLogin(username, password);
            }
        });
    }


    @Override
    public void loginSuccess() {
        MainActivity.startActivity(mContext);
    }

    @Override
    public void loginFailed() {
        Bikin.alert(mContext, Constant.ERROR_TITLE, "Username atau Password salah.");

        etUsername.setText("");
        etUsername.requestFocus();
        etPassword.setText("");
    }
}
