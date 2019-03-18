package mypkg;

import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.springframework.batch.test.JsrTestUtils;

public class MyTest {
	
	@Test
	public void testSleepyB() throws TimeoutException{
		JsrTestUtils.runJob("sleepy-batchlet"
	}

}
