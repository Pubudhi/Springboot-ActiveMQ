package com.pubudhi.activemqSender.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;

public class Sender {
	
	@Value("${spring.activemq.queue.name}")	
	private String QUEUE;

	
	private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

	@Autowired
	private JmsTemplate jmsTemplate;

	public void send(String message) {
		LOGGER.info("sending message='{}' to '{}' queue", message, QUEUE);
		LOGGER.info(QUEUE);
		jmsTemplate.convertAndSend(QUEUE, message);
	}

}
