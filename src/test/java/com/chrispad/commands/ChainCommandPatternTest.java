package com.chrispad.commands;

import com.chrispad.services.AppModule;
import com.chrispad.strategy.DiscountSource;
import com.chrispad.strategy.Item;
import com.chrispad.strategy.Notebook;
import org.apache.tapestry5.ioc.Registry;
import org.apache.tapestry5.ioc.RegistryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;


public class ChainCommandPatternTest {

    private Registry registry;

    @Before
    public void setUp() {

        RegistryBuilder builder = new RegistryBuilder();

        builder.add(AppModule.class);

        registry = builder.build();

        registry.performRegistryStartup();

    }


    @Test
    public void testStrategyPattern() throws ParseException {

        Command commands = registry.getService(Command.class);

        System.out.println(commands);

        Map<String, Object> context = new HashMap<String, Object>();

        context.put(AbstractCommand.DATE_STRING, "2010/07/01");

        commands.execute(context);

        Assert.assertNotNull(context.get(AbstractCommand.PARSED_DATE));

    }


    @After
    public void tearDown() {
        // for operations done from this thread
        registry.cleanupThread();

        //call this to allow services clean shutdown
        registry.shutdown();
    }


}
