package dev.marconymous.bookshelf.service;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.HashMap;
import java.util.Map;

@ApplicationPath("/resource")
public class Config extends Application {
  @Override
  public Map<String, Object> getProperties() {
    var props = new HashMap<String, Object>();
    return props;
  }
}
