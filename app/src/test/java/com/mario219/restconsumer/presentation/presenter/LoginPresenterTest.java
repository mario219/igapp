package com.mario219.restconsumer.presentation.presenter;

import com.mario219.restconsumer.presentation.view.contract.LoginView;
import com.mario219.restconsumer.session.Rest;
import com.mario219.restconsumer.session.RestLoginCallback;
import com.mario219.restconsumer.utils.Connectivity;
import com.mario219.restconsumer.utils.Preferences;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;


/**
 * Created by marioalejndro on 20/07/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock Rest rest;
    @Mock Preferences prefs;
    @Mock Connectivity connectivity;
    @Mock LoginView view;

    @Test
    public void startLoginRequestSuccessful() {
        //given
        Mockito.when(connectivity.isOnline()).thenReturn(true);
        Mockito.doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                RestLoginCallback callback = (RestLoginCallback) invocation.getArgument(0);
                callback.onFinishedRequest("token");
                return null;
            }
        }).when(rest).restLogin((any(RestLoginCallback.class)),anyString(),anyString());

        //when
        LoginPresenter presenter = new LoginPresenter(view, prefs, connectivity, rest);
        presenter.startLoginRequest("","");

        //then
        Mockito.verify(view).login(anyString());
    }

    @Test
    public void startLoginRequestFailure() {
        //given
        Mockito.when(connectivity.isOnline()).thenReturn(true);
        Mockito.doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                RestLoginCallback callback = invocation.getArgument(0);
                callback.onFinishedRequestFailure("fail");
                return null;
            }
        }).when(rest).restLogin((any(RestLoginCallback.class)),anyString(),anyString());

        //when
        LoginPresenter presenter = new LoginPresenter(view, prefs, connectivity, rest);
        presenter.startLoginRequest("","");

        //then
        Mockito.verify(view).loginFailure(anyString());
    }

    @Test
    public void handleNoInternetConnection(){
        //given
        Mockito.when(connectivity.isOnline()).thenReturn(false);

        //when
        LoginPresenter presenter = new LoginPresenter(view, prefs, connectivity, rest);
        presenter.startLoginRequest("","");

        //then
        Mockito.verify(view).loginFailure(anyString());
    }

}