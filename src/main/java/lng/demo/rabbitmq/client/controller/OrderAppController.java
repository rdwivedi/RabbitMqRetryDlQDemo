package lng.demo.rabbitmq.client.controller;

import lng.demo.rabbitmq.client.publisher.OrderApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderAppController {
    private final OrderApp publisher;

    @Autowired
    public OrderAppController(OrderApp publisher) {
        this.publisher = publisher;
    }


    @PostMapping("/pub-a-good-message")

    public @ResponseBody String pubGoodMessage(@RequestBody String message) {
        String str = null;
        try {
            str = publisher.sendAGoodMessagetoOrderQ(message);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return str;
    }

    @PostMapping("/pub-a-bad-message")

    public @ResponseBody String pubBadMessage(@RequestBody String message,
                                              @RequestParam(value = "retry-count", defaultValue = "1", required = false) int count) {
        String str = null;
        try {
            str = publisher.sendaBadMessagetoOrderQ(message, count);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return str;
    }


}
