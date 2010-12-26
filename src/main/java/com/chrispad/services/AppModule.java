package com.chrispad.services;

import com.chrispad.strategy.*;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.services.StrategyBuilder;
import org.apache.tapestry5.ioc.util.StrategyRegistry;

import java.util.Map;

public class AppModule {


    public static void contributeDiscountSource(MappedConfiguration<Class, DiscountSource> config) {

        config.addInstance(Item.class, DefaultDiscountSource.class);

        config.addInstance(Book.class, ReducedDiscountSource.class);

        config.addInstance(Notebook.class, ReducedDiscountSource.class);

    }

    public static DiscountSource buildDiscountSource(Map<Class, DiscountSource> configuration, StrategyBuilder strategyBuilder) {

        StrategyRegistry<DiscountSource> registry = StrategyRegistry.newInstance(DiscountSource.class, configuration);

        return strategyBuilder.build(registry);

    }


    public static void bind(ServiceBinder binder) {

    }

}

