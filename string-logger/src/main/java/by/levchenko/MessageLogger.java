package by.levchenko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class MessageLogger {
	private static final Logger logger = LoggerFactory.getLogger(StringLoggerApplication.class);

	@StreamListener(Sink.INPUT)
	public void process(ProcessedMessage processedMessage) {
		logger.info(processedMessage.toString());
	}

}
