[![Build Status](https://snap-ci.com/evanwong/hipchat-java/branch/develop/build_image)](https://snap-ci.com/evanwong/hipchat-java/branch/develop)

hipchat-java
============
Java client for the HipChat V2 API. The implementation is base on [this doc](https://www.hipchat.com/docs/apiv2).


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

### License
The MIT License (MIT)

Copyright (c) 2014 Evan Wong

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
