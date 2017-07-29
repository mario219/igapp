package com.mario219.restconsumer.presentation.presenter;

import com.mario219.restconsumer.models.ProspectModel;
import com.mario219.restconsumer.models.ProspectSqlModel;
import com.mario219.restconsumer.presentation.view.contract.ListProspectsView;
import com.mario219.restconsumer.prospects.DataProspect;
import com.mario219.restconsumer.prospects.DataProspectManagerCallback;
import com.mario219.restconsumer.prospects.RequestProspects;
import com.mario219.restconsumer.prospects.RequestProspectsUrlCallback;
import com.mario219.restconsumer.utils.Connectivity;
import com.mario219.restconsumer.utils.Preferences;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

/**
 * Created by mario219 on 28/07/17.
 */
public class ListProspectsPresenterTest {

    private final String ANY_STRING = "";
    private final List<ProspectSqlModel> prospectSqlList = Arrays.asList(new ProspectSqlModel(), new ProspectSqlModel());
    private final List<ProspectModel> prospectRestList = Arrays.asList(new ProspectModel(), new ProspectModel());

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock ListProspectsView view;
    @Mock Connectivity connectivity;
    @Mock Preferences preferences;
    @Mock RequestProspects requestProspects;
    @Mock DataProspect dataProspect;
    private ListProspectsPresenter presenter;

    @Before
    public void setUp() {
        presenter = new ListProspectsPresenter(view,connectivity,preferences,requestProspects,dataProspect);
    }

    @Test
    public void loadProspectListFromDatabase() {

        when(preferences.databaseExits()).thenReturn(true);
        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                DataProspectManagerCallback callback = invocation.getArgument(0);
                callback.onDatabaseCreated(prospectSqlList);
                return null;
            }
        }).when(dataProspect).loadCursorData((any(DataProspectManagerCallback.class)));

        presenter.loadProspectsList(ANY_STRING);

        verify(view).loadRecycler(prospectSqlList);
        verify(preferences).notifyDatabaseExits(true);

    }

    @Test
    public void loadProspectListFromInternet() {

        when(preferences.databaseExits()).thenReturn(false);
        when(connectivity.isOnline()).thenReturn(true);
        doAnswer(new Answer <Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                RequestProspectsUrlCallback callback = invocation.getArgument(0);
                callback.onRequestCompleted(prospectRestList);
                return null;
            }
        }).when(requestProspects).requestProspects(any(RequestProspectsUrlCallback.class), anyString());
        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                DataProspectManagerCallback callback = invocation.getArgument(0);
                callback.onSaveCompleted();
                return null;
            }
        }).when(dataProspect).save((any(DataProspectManagerCallback.class)), eq(prospectRestList));
        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                DataProspectManagerCallback callback = invocation.getArgument(0);
                callback.onDatabaseCreated(prospectSqlList);
                return null;
            }
        }).when(dataProspect).loadCursorData((any(DataProspectManagerCallback.class)));

        presenter.loadProspectsList(ANY_STRING);

        verify(view).loadRecycler(prospectSqlList);

    }

    @Test
    public void handleErrorOnRequest() {

        when(preferences.databaseExits()).thenReturn(false);
        when(connectivity.isOnline()).thenReturn(true);
        doAnswer(new Answer <Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                RequestProspectsUrlCallback callback = invocation.getArgument(0);
                callback.onRequestFail(anyString());
                return null;
            }
        }).when(requestProspects).requestProspects(any(RequestProspectsUrlCallback.class), anyString());

        presenter.loadProspectsList(ANY_STRING);

        verify(view).displayErrorMessage(anyString());

    }

    @Test
    public void handleNoInternetConnection () {

        when(preferences.databaseExits()).thenReturn(false);
        when(connectivity.isOnline()).thenReturn(false);

        presenter.loadProspectsList(ANY_STRING);

        verify(view).onFailureConnection();

    }
}