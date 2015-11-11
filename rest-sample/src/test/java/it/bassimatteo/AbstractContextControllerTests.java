package it.bassimatteo;

import hello.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
// @SuiteClasses({ GreetingControllerTest.class })
@WebAppConfiguration
public class AbstractContextControllerTests {

  @Autowired
  protected WebApplicationContext wac;

}