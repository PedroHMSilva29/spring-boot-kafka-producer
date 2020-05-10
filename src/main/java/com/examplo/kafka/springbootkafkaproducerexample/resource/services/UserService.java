package com.examplo.kafka.springbootkafkaproducerexample.resource.services;
import com.examplo.kafka.springbootkafkaproducerexample.resource.model.User;
import org.springframework.util.StringUtils;

public class UserService {

    public static Boolean isValid(User user){
        if(!StringUtils.isEmpty(user)
                && !StringUtils.isEmpty(user.getName())
                && !StringUtils.isEmpty(user.getDept())
                && !StringUtils.isEmpty(user.getSalary())
                && !StringUtils.isEmpty(user.getName())) {
            return Boolean.TRUE;
        }
        else return Boolean.FALSE;
    }
}
