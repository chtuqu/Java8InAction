package com.chtuqu.ch10.optional_example;

import java.util.Optional;
import java.util.Properties;

public class PropsTest {

    private static Properties props;

    static {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");
    }

    public static void main(String[] args) {
        System.out.println(readDurationOptionally(props, "a"));
        System.out.println(readDurationOptionally(props, "b"));
        System.out.println(readDurationOptionally(props, "c"));
        System.out.println(readDurationOptionally(props, "d"));
    }

    // trivial solution
    private static int readDuration(Properties props, String name) {
        String value = props.getProperty(name);
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException nfe) { }
        }
        return 0;
    }

    // Optional-based solution
    private static int readDurationOptionally(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name)).flatMap(PropsTest::stringToInt).filter(i -> i > 0).orElse(0);
    }

    private static Optional<Integer> stringToInt(String str) {
        try {
            return Optional.of(Integer.parseInt(str));
        } catch (NumberFormatException nfe) {
            return Optional.empty();
        }
    }
}
