package com.example.config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

@LoadPolicy(LoadType.MERGE)
@Sources({
        "system:properties",
        "classpath:credentials.properties"
})
public interface Configuration extends Config {

    @Key("public.key")
    String publicKey();

    @Key("secret.key")
    String secretKey();
}
