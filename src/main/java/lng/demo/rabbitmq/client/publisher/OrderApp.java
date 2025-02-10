package lng.demo.rabbitmq.client.publisher;

import lng.demo.rabbitmq.client.RabbitConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@Service
public class OrderApp {

    @Autowired
    private final RabbitTemplate rabbitTemplate;
    @Autowired
    private RabbitConfig rabbitConfig;


    @Autowired
    public OrderApp(RabbitTemplate rabbitTemplate) {
        super();
        this.rabbitTemplate = rabbitTemplate;

    }


    public String sendAGoodMessagetoOrderQ(String message)
            throws InterruptedException, ExecutionException, TimeoutException {


        MessageProperties messageProperties = new MessageProperties();
        Map<String, Object> header = messageProperties.getHeaders();
        header.put("order-type", "mouse");
        MessageConverter messageConverter = new SimpleMessageConverter();
        Message rmqmessage = messageConverter.toMessage(message, messageProperties);
        //rabbitTemplate.send("", rabbitConfig.getRmqcustomQ(), rmqmessage, correlationData);
        rabbitTemplate.send(RabbitConfig.MAIN_EXCHANGE, RabbitConfig.RTK_TOPIC, rmqmessage);

        return (" message sent");


    }


    public String sendaBadMessagetoOrderQ(String message, int msgcountperpub)
            throws InterruptedException, ExecutionException, TimeoutException {

        MessageProperties messageProperties = new MessageProperties();
        Map<String, Object> header = messageProperties.getHeaders();
        header.put("order-type", "keyboard");
        MessageConverter messageConverter = new SimpleMessageConverter();
        Message rmqmessage = messageConverter.toMessage(message, messageProperties);

        rabbitTemplate.send(RabbitConfig.MAIN_EXCHANGE, RabbitConfig.RTK_TOPIC, rmqmessage);

        return (" message sent");
    }

}
