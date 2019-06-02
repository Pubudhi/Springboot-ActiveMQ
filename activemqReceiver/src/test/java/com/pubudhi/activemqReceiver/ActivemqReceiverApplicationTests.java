package com.pubudhi.activemqReceiver;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pubudhi.activemqReceiver.receiver.Receiver;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ActivemqReceiverApplication.class)
public class ActivemqReceiverApplicationTests {

	@Autowired
	private Receiver receiver;

	@Test
	public void testReceive() throws Exception {

		receiver.getLatch().await(2, TimeUnit.MINUTES);
		assertThat(receiver.getLatch().getCount()).isEqualTo(0);
	}

}
