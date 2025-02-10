package lng.demo.rabbitmq.client.controller;

import lng.demo.rabbitmq.client.publisher.OrderApp;
import lng.demo.rabbitmq.client.subscriber.InventoryApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class InventoryAppController {
    // @Autowired
    private final InventoryApp subscriber;


    @Autowired
    public InventoryAppController(InventoryApp subscriber, OrderApp publisher) {
        this.subscriber = subscriber;

    }

    @PostMapping("/reset-cache-OrderQ")

    public @ResponseBody String resetCustomQCache() {

        try {
            subscriber.getMessages().clear();


        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return "Cache storing messages from CustomQ is reset to Empty";
    }

    @GetMapping("/startListener-subscribe-OrderQ")

    public @ResponseBody Map<Integer, List<String>> listenAllMessagesCustomQ() {
        List<String> l = null;
        Map<Integer, List<String>> m = new HashMap<Integer, List<String>>();
        try {
            subscriber.registerCustomQtoListner();
            l = subscriber.getMessages();
            m.put(l.size(), l);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return m;
    }

    @PostMapping("/stopListener-OrderQ")

    public @ResponseBody boolean stopListenerCustomQ() {

        try {
            subscriber.stopCustomQtoListner();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return true;
    }


}
