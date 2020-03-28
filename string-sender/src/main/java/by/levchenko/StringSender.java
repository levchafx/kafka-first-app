package by.levchenko;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@EnableBinding(Source.class)
public class StringSender {
	@Autowired
	private Source source;
	private String[] keys = { "java", "kafka" };

	private String[] values = { "i love java very much", "i love kafka a little less than java" };

	@Scheduled(fixedDelay = 1000)
	public void sendEvents() {
		Message message = new Message();
		int i = new Random().nextInt(2);
		message.setId(this.keys[i]);
		message.setStatement(this.values[i]);
		this.source.output().send(MessageBuilder.withPayload(message).build());
	}

}
