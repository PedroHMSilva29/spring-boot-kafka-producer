package com.examplo.kafka.springbootkafkaproducerexample.resource;

import com.examplo.kafka.springbootkafkaproducerexample.resource.model.User;
import com.examplo.kafka.springbootkafkaproducerexample.resource.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka")
public class UserResource {

    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

    private static String TOPIC = "kafka_topic";

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name){
        kafkaTemplate.send(TOPIC, new User(name,"TI", 4000L));
        return "Published successfully "+ name;
    }

    @RequestMapping(value = "/publish/user", method = RequestMethod.POST)
    public ResponseEntity<String> post(@RequestBody User user)  {

        ObjectMapper mapper;

        try{
            mapper = new ObjectMapper();

            if(UserService.isValid(user)) {
                kafkaTemplate.send(TOPIC, user);
                LOGGER.info("Informações enviadas para o Kafka");
                return new ResponseEntity<>(mapper.writeValueAsString(user), HttpStatus.CREATED);
            }

        }catch(Exception e){
            LOGGER.error(e.getMessage());
        }

        return new ResponseEntity<>("Java é top", HttpStatus.EXPECTATION_FAILED);
    }
}
