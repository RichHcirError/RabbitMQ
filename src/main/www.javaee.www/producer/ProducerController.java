package main.www.javaee.www.producer;

import lombok.extern.slf4j.Slf4j;
import main.www.javaee.www.producer.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class ProducerController {

    @Autowired
    private SendService sendService;


    @RequestMapping("/start")
    @ResponseBody
    String startSend() {
        log.info("Start send to queue");
        sendService.startSendThread();
        return "START";
    }

    @RequestMapping("/stop")
    @ResponseBody
    String stopSend() {
        log.info("Stop send to queue");
        sendService.stopThread();
        return "STOP";
    }
}