package com.dubbo.demo;


import org.apache.dubbo.common.extension.LoadingStrategy;

import static java.util.ServiceLoader.load;
import static java.util.stream.StreamSupport.stream;


public class tTsfd {
    private static volatile LoadingStrategy[] strategies = loadLoadingStrategies();

    private static LoadingStrategy[] loadLoadingStrategies() {


        return stream(load(LoadingStrategy.class).spliterator(), false)
                .sorted()
                .toArray(LoadingStrategy[]::new);
    }

}
