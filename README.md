[![Build Status](https://snap-ci.com/evanwong/hipchat-java/branch/develop/build_image)](https://snap-ci.com/evanwong/hipchat-java/branch/develop)

hipchat-java
============
Java client for the HipChat V2 API. And the implementation is base on [this doc](https://www.hipchat.com/docs/apiv2).


###  Requirements:
Java 8

### Quick Start:
To add this client into your project:

* maven
```xml
<dependency>
    <groupId>io.evanwong.oss</groupId>
    <artifactId>hipchat-java</artifactId>
    <version>xxx</version>
</dependency>
```
* gradle
```gradle
compile 'io.evanwong.oss:hipchat-java:xxx'
```

To send a notification
```java
String defaultAccessToken = "abcd1234";
HipChatClient client = new HipChatClient(defaultAccessToken);
SendRoomNotificationRequestBuilder builder = client.prepareSendRoomNotificationRequestBuilder("myRoom", "hello world!");
Future<NoContent> future = builder.setColor(Color.YELLOW).setNotify(true).build().execute();
//optional... if you want/need to inspect the result:
NoContent noContent = future.get();
```