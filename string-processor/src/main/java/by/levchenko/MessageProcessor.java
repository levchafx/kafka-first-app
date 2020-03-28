package by.levchenko;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(Processor.class)
public class MessageProcessor {
	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public ProcessedMessage processMessage(Message message) {
		ProcessedMessage processedMessage = new ProcessedMessage();
		processedMessage.setId(message.getId());
		processedMessage.setSplitStatement(Stream.of(message.getStatement().split(" ")).collect(Collectors.toList()));
		return processedMessage;
	}
}
