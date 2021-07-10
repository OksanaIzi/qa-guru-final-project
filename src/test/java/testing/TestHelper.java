package testing;

import testing.TestConfig;
import org.aeonbits.owner.ConfigFactory;

public class TestHelper {
    static TestConfig testConfig = ConfigFactory.create(TestConfig.class, System.getProperties());

    public void Configure(){

    }
}
