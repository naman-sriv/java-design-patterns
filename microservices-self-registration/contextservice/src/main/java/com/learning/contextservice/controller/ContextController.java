package com.learning.contextservice.controller;

import com.learning.contextservice.client.GreetingServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContextController {

  private final GreetingServiceClient greetingServiceClient;
  private final String userRegion;

  @Autowired
  public ContextController(GreetingServiceClient greetingServiceClient, @Value("${user.region}") String userRegion) {
    this.greetingServiceClient = greetingServiceClient;
    this.userRegion = userRegion;
  }

  @GetMapping("/context")
  public String getContext() {
    String greeting = greetingServiceClient.getGreeting();
    return "The Greeting Service says: "+greeting+" from "+userRegion;
  }
}
