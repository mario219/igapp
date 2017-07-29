package com.mario219.restconsumer.presentation.presenter;

import com.mario219.restconsumer.presentation.view.contract.EditProspectView;
import com.mario219.restconsumer.prospects.DataProspect;
import com.mario219.restconsumer.prospects.DataProspectManagerCallback;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;

/**
 * Created by mario219 on 29/07/17.
 */
public class EditDataProspectPresenterTest {

    private final int ANY_INT = 1;
    private final String ANY_STRING = "";
    private final Long ANY_LONG = Long.MIN_VALUE;

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock EditProspectView view;
    @Mock DataProspect dataProspect;
    private EditDataProspectPresenter presenter;

    @Before
    public void setUp() {
        presenter = new EditDataProspectPresenter(view, dataProspect);
    }

    @Test
    public void updateProspect() {

        Mockito.doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                DataProspectManagerCallback callback = invocation.getArgument(0);
                callback.onProspectUpdated(anyString());
                return null;
            }
        }).when(dataProspect).updateProspect(
                (any(DataProspectManagerCallback.class)),anyInt(),anyString(),anyString(), anyLong(), anyLong());

        presenter.updateProspect(ANY_INT, ANY_STRING, ANY_STRING, ANY_LONG, ANY_LONG);

        Mockito.verify(view).onUserUpdated(anyString());

    }
}