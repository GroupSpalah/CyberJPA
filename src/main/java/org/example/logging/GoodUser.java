package org.example.logging;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class GoodUser {

    private static final Logger LOGGER = LogManager.getLogger(GoodUser.class);
    String name;
    int age;

    public void print() {
        LOGGER.debug("Inside print method");
    }
    public void action(String name) {
        LOGGER.info("Inside action method = {}", name);
    }

}

class TestUser {
    public static void main(String[] args) {
//        new GoodUser().print();
        new GoodUser().action("Problem");
    }
}
