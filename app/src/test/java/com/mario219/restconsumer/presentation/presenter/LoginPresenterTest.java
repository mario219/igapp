package com.mario219.restconsumer.presentation.presenter;

import com.mario219.restconsumer.presentation.view.contract.LoginView;
import com.mario219.restconsumer.session.Rest;
import com.mario219.restconsumer.session.RestLoginCallback;
import com.mario219.restconsumer.utils.Connectivity;
import com.mario219.restconsumer.utils.Preferences;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by marioalejndro on 20/07/17.
 */
public class LoginPresenterTest {

    @Test
    public void startLoginRequestSuccessful() {
        //given
        LoginView view = new MockLoginView();
        Preferences prefs = new MockPrefManager();
        Connectivity connectivity = new MockConnectivity();
        Rest rest = new MockRest(true);

        //when
        LoginPresenter presenter = new LoginPresenter(view, prefs, connectivity, rest);
        presenter.startLoginRequest("","");

        //then
        Assert.assertEquals(true, ((MockLoginView) view).logged);
    }

    @Test
    public void startLoginRequestFailure() {
        //given
        LoginView view = new MockLoginView();
        Preferences prefs = new MockPrefManager();
        Connectivity connectivity = new MockConnectivity();
        Rest rest = new MockRest(false);

        //when
        LoginPresenter presenter = new LoginPresenter(view, prefs, connectivity, rest);
        presenter.startLoginRequest("","");

        //then
        Assert.assertEquals(true, ((MockLoginView) view).failure);
    }

    private class MockLoginView implements LoginView {
        boolean logged;
        boolean failure;

        @Override
        public void login(String token) {
            logged = true;
        }

        @Override
        public void loginFailure(String word) {
            failure = true;
        }

        @Override
        public void loadCurrentSession() {}
    }

    private class MockPrefManager implements Preferences {
        @Override
        public String getCurrentSession() {
            return null;
        }

        @Override
        public void SetCurrentSession(String token) {

        }

        @Override
        public Boolean databaseExits() {
            return null;
        }

        @Override
        public void notifyDatabaseExits(Boolean flag) {

        }
    }

    private class MockConnectivity implements Connectivity {
        @Override
        public Boolean isOnline() {
            return true;
        }
    }

    private class MockRest implements Rest {
        private RestLoginCallback callback;
        private boolean success;

        public MockRest(boolean success) {
            this.success = success;
        }

        @Override
        public void setCallback(RestLoginCallback callback) {
            this.callback = callback;
        }

        @Override
        public void restLogin(String email, String password) {
            if(success) {
                callback.onFinishedRequest("token");
            }else{
                callback.onFinishedRequestFailure("failure");
            }
        }
    }
}