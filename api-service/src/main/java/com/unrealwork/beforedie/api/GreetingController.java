package com.unrealwork.beforedie.api;

import com.unrealwork.beforedie.models.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
public class GreetingController {
  private Logger logger = LoggerFactory.getLogger(GreetingController.class);
  private final AtomicLong counter = new AtomicLong();

  @Autowired
  private MessageSource messageSource;

  @GetMapping("greeting")
  public Greeting greeting(Locale locale, @RequestParam(value = "name", defaultValue = "World") String name) {
    logger.debug("The language is {}", locale.getDisplayLanguage());
    final String greetingMessage = messageSource.getMessage("greeting", new String[] {name}, locale);
    return new Greeting(counter.incrementAndGet(),
        greetingMessage);
  }
}
