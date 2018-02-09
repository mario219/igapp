package com.mario219.restconsumer.applicationmodules;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by mario on 24/01/18.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface RestConsumerScope {
}
