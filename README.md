# This project is created as a test task for Solidgate

## Tech Stack

+ Java 22
+ Maven
+ Selenide
+ Retrofit
+ TestNG

## How to run locally:

Insert your credentials in **credentials.properties**

```
public.key=api_pk_xxx
secret.key=api_sk_xxx
```

or pass them as variables:

`mvn clean test -Dpublic.key=api_pk_xxx -Dsecret.key=api_sk_xxx`