package me.helioalbano.messagingredis;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Receiver {
	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
	
	private AtomicInteger counter = new AtomicInteger();
	
	public void receiveMessage(String message) {
		LOGGER.info(String.format("Received <%s>", message));
		counter.incrementAndGet();
	}
	
	public boolean receivedNothing() {
		return counter.get() == 0;
	}
}
