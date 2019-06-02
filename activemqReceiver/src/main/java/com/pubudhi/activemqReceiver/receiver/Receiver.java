package com.pubudhi.activemqReceiver.receiver;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;


public class Receiver {
	@Value("${spring.activemq.queue.name}")	
	private String LISTERNING_QUEUE;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}

	@JmsListener(destination = "${spring.activemq.queue.name}")
	public void receive(String message) {
		LOGGER.info("received message='{}' from '{}' queue", message, LISTERNING_QUEUE);
		latch.countDown();
	}

}
