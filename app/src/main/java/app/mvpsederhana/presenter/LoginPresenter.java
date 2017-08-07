package app.mvpsederhana.presenter;

import app.mvpsederhana.LoginActivity;
import app.mvpsederhana.interactor.LoginPresenterInteractor;
import app.mvpsederhana.interfaces.LoginInterface;
import app.mvpsederhana.interfaces.LoginPresenterInterface;

/**
 * Created by Asus on 8/4/2017.
 */

public class LoginPresenter implements LoginPresenterInterface, LoginPresenterInteractor {

    LoginInterface view;

    public LoginPresenter(LoginActivity loginActivity) {
        this.view = loginActivity;
    }

    //method implementasi LoginPresenterInterface
    @Override
    public void eksekusiLogin(String username, String password) {
        boolean isSucess = validasiLogin(username, password);
        if (isSucess) view.loginSuccess();
        else view.loginFailed();
    }

    //method implementasi INTERACTOR LoginPresenterInteractor
    @Override
    public boolean validasiLogin(String username, String password) {
        boolean status;
        if (username.equals("username") && password.equals("password")) status = true;
        else status = false;
        return status;
    }


}
