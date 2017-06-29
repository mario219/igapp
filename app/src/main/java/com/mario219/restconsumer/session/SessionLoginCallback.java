package com.mario219.restconsumer.session;

import com.mario219.restconsumer.models.SessionModel;

/**
 * Created by marioalejndro on 28/06/17.
 */

public interface SessionLoginCallback {

    void onFinishedRequest(String response);

}
