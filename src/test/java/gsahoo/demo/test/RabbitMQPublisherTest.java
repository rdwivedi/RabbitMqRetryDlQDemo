package gsahoo.demo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lng.demo.rabbitmq.client.RabbitConfig;
import lng.demo.rabbitmq.client.RabbitConfig.ConfirmCallbackBasicImplementation;
import lng.demo.rabbitmq.client.dto.Order;
import lng.demo.rabbitmq.client.publisher.OrderApp;

@RunWith(SpringRunner.class)
@PropertySource("classpath:application.properties")
@ContextConfiguration(classes = RabbitConfig.class)
//@ContextConfiguration(initializers = ConfigFileApplicationContextInitializer.class)
@Configuration
@Import({OrderApp.class, RabbitConfig.class})
//@WebAppConfiguration
@ActiveProfiles("test")

public class RabbitMQPublisherTest {

	
		//@Autowired
	
		OrderApp publisher;
		
		@Mock
		Order order;
		/*
		@Mock
		RabbitTemplate rabbitTemplate;
		
		@Mock
		RabbitTemplate rabbitTemplate;
		
		@Mock
		ConfirmCallbackBasicImplementation confirmCallback;
		@Before
		public void setup() {
			publisher = new SWATPublisher();
			ReflectionTestUtils.setField(rabbitTemplate, rmq.port, 8071);
		}
		*/
		/*
		@Test
		public void testGetConfirmationCount() {
			
			Order s1 = mock(Order.class);
			s1.setOrderNumber("111");
			int count =0;
			
			
		//	when(publisher.getConfirmationCount()).thenReturn(count);

			// test
		//	publisher.resetConfirmationMap();
			try {
				publisher.sendOrder(order, 1, 4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count= publisher.getConfirmationCount();
			System.out.println("************************"+publisher.getConfirmationMap());
			assertNotNull(count);
					
		}
		*/
		@Test
		public void testsendOrder() {
		}

			
		
		@Test
		public void testsendOrderRejctPub() {
			
			
			
		//	when(publisher.getConfirmationCount()).thenReturn(count);
		}
			
}
