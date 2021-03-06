/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.sharma.jitin.builditbigger.backend;

import com.example.Joke;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.builditbigger.jitin.sharma.com",
    ownerName = "backend.builditbigger.jitin.sharma.com",
    packagePath=""
  )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        Joke joke = new Joke();
        response.setData(joke.getJoke());
        return response;
    }

    @ApiMethod(name = "getJoke")
    public MyBean getJoke(){
        MyBean response = new MyBean();
        Joke joke = new Joke();
        response.setData(joke.getJoke());
        return response;
    }

}
