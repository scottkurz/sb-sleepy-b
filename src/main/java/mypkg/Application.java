package mypkg;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.BatchStatus;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootConfiguration
@EnableAutoConfiguration
@EnableBatchProcessing
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	JobOperator jobOperator = BatchRuntime.getJobOperator();
	
    @Override
    public void run(String... args) throws Exception
    {
    	long execId = jobOperator.start("sleepy-batchlet", new Properties().setProperty("sleep.time.seconds","5"));
    	waitForCompletion(execId);
    }

	private void waitForCompletion(long execId) {

		System.out.println("SKSK: waiting for completion");
		while (true) {
			BatchStatus bs = jobOperator.getJobExecution(execId).getBatchStatus();
			if (bs.equals(BatchStatus.COMPLETED) || bs.equals(BatchStatus.FAILED)) {
				System.out.println("SKSK: Final status = " + bs);
				break;
			}
		}
	}
}
