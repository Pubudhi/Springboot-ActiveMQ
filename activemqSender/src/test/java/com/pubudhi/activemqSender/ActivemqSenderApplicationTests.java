package com.pubudhi.activemqSender;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pubudhi.activemqSender.sender.Sender;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ActivemqSenderApplication.class)
public class ActivemqSenderApplicationTests {

	@Autowired
	private Sender sender;

	@Test
	public void testReceive() throws Exception {
		sender.send("******* Hello ActiveMQ!********8");

	}

}
