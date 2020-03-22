package com.example;

import com.example.repo.QueueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class StoreController {

    final private QueueRepository repository;

    public static Logger logger = LoggerFactory.getLogger(StoreController.class);

    public StoreController(QueueRepository repository) {
      this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/stores/{storeId}", consumes = "application/json")
    public void update(@PathVariable("storeId") String id, @RequestParam("message") String message) {
        logger.info(String.format("%s, %s", id, message));

        String response = message + " Ok";
        repository.setActiveState(response, Long.valueOf(id));
    }

}
