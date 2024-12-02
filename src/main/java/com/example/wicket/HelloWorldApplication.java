package com.example.wicket;

import org.apache.wicket.protocol.http.WebApplication;

public class HelloWorldApplication extends WebApplication {
    @Override
    public Class<HomePage> getHomePage() {
        return HomePage.class; // Set the home page
    }

    @Override
    public void init() {
        super.init();
        // Additional initialization if required
    }
}
