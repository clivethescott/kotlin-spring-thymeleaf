package hello.service.impl;

import app.greeting.Greeting;
import app.greeting.GreetingService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import util.AbstractITest;

import java.util.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by scott on 18/10/2016.
 */
public class GreetingServiceImplTest extends AbstractITest {

    @Autowired
    private GreetingService greetingService;

    @Before
    public void setUp() throws Exception {

        final Greeting greeting1 = new Greeting("scott");
        final Greeting greeting2 = new Greeting("clive");
        final Greeting greeting3 = new Greeting("something else");

        assertNotNull("Greeting1 cannot be null", greetingService.save(greeting1));
        assertNotNull("Greeting2 cannot be null", greetingService.save(greeting2));
        assertNotNull("Greeting3 cannot be null", greetingService.save(greeting3));


    }

    @Test
    public void findGreetings() throws Exception {

        final List<Greeting> greetings = greetingService.findGreetings();

        assertNotNull("Greetings cannot be null", greetings);
        assertTrue("Greetings not size 3", greetings.size() == 3);

    }

}