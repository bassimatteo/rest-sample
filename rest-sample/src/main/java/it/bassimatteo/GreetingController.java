package it.bassimatteo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  /**
   * Test.
   * 
   * @return a string
   */
  @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/plain")
  public String test() {

    return "testOK";

  }

  @RequestMapping(value = "/greeting", method = RequestMethod.GET, produces = "application/json")
  public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }

}
