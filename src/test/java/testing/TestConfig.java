package testing;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({"system:properties",
        "classpath:testConfig/{driver}.properties",
        "classpath:testConfig/remote.properties"})
public interface TestConfig extends Config {

    @Key("test.value")
    String testValue();

    @Key("test.remote.driver.url")
    String testRemoteDriverUrl();
}
