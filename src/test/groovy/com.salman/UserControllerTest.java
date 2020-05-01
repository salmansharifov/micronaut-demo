package com.salman;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import junit.framework.TestCase;
import org.junit.Test;

import javax.inject.Inject;

@MicronautTest
public class UserControllerTest extends TestCase {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void saveTest(){
        HttpRequest request = HttpRequest.POST("user/SALMAN,SHARIFOV,23,SAL.COM", User.class);
        HttpResponse response = client.toBlocking().exchange(request);
        assertEquals(response , true);
    }

}