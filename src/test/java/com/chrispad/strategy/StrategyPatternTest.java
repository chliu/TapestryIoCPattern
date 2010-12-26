package com.chrispad.strategy;

import com.chrispad.services.AppModule;
import junit.framework.TestCase;
import org.apache.tapestry5.ioc.Registry;
import org.apache.tapestry5.ioc.RegistryBuilder;
import org.junit.*;


public class StrategyPatternTest {

    private Registry registry;

    @Before
    public void setUp() {

        RegistryBuilder builder = new RegistryBuilder();

        builder.add(AppModule.class);

        registry = builder.build();

        registry.performRegistryStartup();

    }


    @Test
    public void testStrategyPattern() {

        DiscountSource discountSource = registry.getService(DiscountSource.class);

        Notebook nb = new Notebook(100);

        Item item = new Item(100);

        Assert.assertTrue(90 == nb.getPrice() * discountSource.discount(nb));

        Assert.assertTrue(100 == item.getPrice() * discountSource.discount(item));

    }

    @After
    public void tearDown() {
        // for operations done from this thread
        registry.cleanupThread();

        //call this to allow services clean shutdown
        registry.shutdown();
    }


}
