package com.mario219.restconsumer.presentation.presenter;

import com.mario219.restconsumer.presentation.view.contract.LoginView;
import com.mario219.restconsumer.session.Rest;
import com.mario219.restconsumer.session.RestLoginCallback;
import com.mario219.restconsumer.utils.ConnectivityInterface;
import com.mario219.restconsumer.utils.Preferences;

import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by marioalejndro on 20/07/17.
 */
public class LoginPresenterTest {

    @Test
    public void startLoginRequestWhenInternet() throws Exception {
        //given
        LoginView view = new MockLoginView();
        Preferences prefs = new MockPrefManager();
        ConnectivityInterface connectivity = new MockConnectivity();
        Rest rest = new MockRest();

        //when
        LoginPresenter presenter = new LoginPresenter(view, prefs, connectivity, rest);
        //presenter.startLoginRequest();

        //then
        Assert.assertEquals(true, ((MockLoginView) view).passed);
    }

    private class MockLoginView implements LoginView {
        boolean passed;
        @Override
        public void login(String token) {
            passed = true;
        }

        @Override
        public void loginFailure(String word) {

        }

        @Override
        public void loadCurrentSession() {

        }
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

    private class MockConnectivity implements ConnectivityInterface {
        @Override
        public Boolean isOnline() {
            return null;
        }
    }

    private class MockRest implements Rest {
        @Override
        public void setCallback(RestLoginCallback callback) {

        }

        @Override
        public void restLogin(String email, String password) {

        }
    }
}