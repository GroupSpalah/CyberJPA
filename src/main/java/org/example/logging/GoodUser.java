package org.example.logging;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.logging.Level;
import java.util.logging.Logger;


@FieldDefaults(level = AccessLevel.PRIVATE)
public class GoodUser {

    private final Logger logger = Logger.getLogger("GoodUser");
    String name;
    int age;

    public void print() {
//        logger.log(Level., "Hello");
    }

}

class TestUser {
    public static void main(String[] args) {
        new GoodUser().print();
    }
}
