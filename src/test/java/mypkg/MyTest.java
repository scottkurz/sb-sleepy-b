package mypkg;

import java.util.Properties;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.springframework.batch.test.JsrTestUtils;

public class MyTest {
	
	@Test
	public void testSleepyB() throws TimeoutException{
    	Properties jobParms = new Properties();
    	jobParms.setProperty("sleepTimeSeconds","6");
		JsrTestUtils.runJob("sleepy-batchlet", jobParms, 100000);
	}

}
