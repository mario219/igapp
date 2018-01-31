package com.mario219.restconsumer.presentation.presenter;

import com.mario219.restconsumer.presentation.view.contract.LoginView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


/**
 * Created by marioalejndro on 20/07/17.
 */

public class LoginPresenterTest {

    private final String ANY_STRING = "";

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock Rest rest;
    @Mock Preferences prefs;
    @Mock Connectivity connectivity;
    @Mock LoginView view;
    private LoginPresenter presenter;

    @Before
    public void setUp() { presenter = new LoginPresenter(view, prefs, connectivity, rest); }

    @Test
    public void startLoginRequestSuccessful() {

        when(connectivity.isOnline()).thenReturn(true);
        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                RestLoginCallback callback = invocation.getArgument(0);
                callback.onFinishedRequest(ANY_STRING);
                return null;
            }
        }).when(rest).restLogin((any(RestLoginCallback.class)),anyString(),anyString());

        presenter.startLoginRequest(ANY_STRING, ANY_STRING);

        verify(view).login(anyString());

    }

    @Test
    public void startLoginRequestFailure() {

        when(connectivity.isOnline()).thenReturn(true);
        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                RestLoginCallback callback = invocation.getArgument(0);
                callback.onFinishedRequestFailure(anyString());
                return null;
            }
        }).when(rest).restLogin((any(RestLoginCallback.class)),anyString(),anyString());

        presenter.startLoginRequest(ANY_STRING, ANY_STRING);

        verify(view).loginFailure(anyString());

    }

    @Test
    public void handleNoInternetConnection(){

        when(connectivity.isOnline()).thenReturn(false);

        presenter.startLoginRequest(ANY_STRING, ANY_STRING);

        verify(view).loginFailure(anyString());

    }

}