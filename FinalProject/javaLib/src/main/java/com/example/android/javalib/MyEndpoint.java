package com.example.android.javalib;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * Created by SSubra27 on 11/7/17.
 */

/**
 * An endpoint class we are exposing
 */

@Api( name = "myApi",
      version= "v1",
      namespace = @ApiNamespace(
              ownerDomain = "javalib.android.example.com",
              ownerName="javalib.android.example.com",
              packagePath = ""
      ))


/**
 * A simple endpoint method that spouts a stupid joke
 */
public class MyEndpoint {
    @ApiMethod(name = "sayJoke")
    public JokeSayer sayJoke()
    {
        JokeSayer jokeSayer = new JokeSayer();
        jokeSayer.setJoke("This is a stupid joke");
         return jokeSayer;
    }
}
