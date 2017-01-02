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
    <version>0.4.2</version>
</dependency>
```
* gradle
```gradle
compile 'io.evanwong.oss:hipchat-java:0.4.2'
```

If you are using Java 7, there is a temporary workaround using [retrolambda](https://github.com/orfjackal/retrolambda).

* maven
```xml
<dependency>
    <groupId>io.evanwong.oss</groupId>
    <artifactId>hipchat-java7</artifactId>
    <version>0.4.0</version>
</dependency>
```
* gradle
```gradle
compile 'io.evanwong.oss:hipchat-java7:0.4.0'
```

To send a notification
```java
String defaultAccessToken = "abcd1234";
HipChatClient client = new HipChatClient(defaultAccessToken);
SendRoomNotificationRequestBuilder builder = client.prepareSendRoomNotificationRequestBuilder("myRoom", "hello world!");
Future<NoContent> future = builder.setColor(MessageColor.YELLOW).setNotify(true).build().execute();
//optional... if you want/need to inspect the result:
NoContent noContent = future.get();
```

* **Javadoc**: [Link](http://evanwong.github.io/hipchat-java/javadoc)

### Methods

##### CAPABILITIES
- [ ] Get capabilities

##### EMOTICONS
- [x] Get emoticon
- [x] Get all emoticons

##### OAUTH SESSIONS
- [ ] Generate token
- [ ] Get session
- [ ] Delete session

##### ROOMS
- [x] Get all rooms
- [x] Create room
- [x] Get room
- [x] Update room
- [x] Delete room
- [ ] View room history
- [ ] Get room message
- [x] Send room message
- [ ] View recent room history
- [ ] Invite user
- [x] Add member
- [x] Remove member
- [ ] Get all members
- [ ] Send room notification redirect
- [x] Send room notification
- [ ] Get all participants
- [ ] Reply to message
- [ ] Share file with room
- [ ] Share link with room
- [ ] Get room statistics
- [x] Set topic
- [ ] Get all webhooks
- [ ] Create webhook
- [ ] Get webhook
- [ ] Delete webhook

##### USERS
- [x] Get all users
- [x] Create user
- [x] View user
- [ ] Update user
- [x] Delete user
- [ ] Get privatechat message
- [ ] View recent privatechat history
- [x] Private message user
- [ ] Update photo
- [ ] Delete photo
- [ ] Get auto join rooms
- [ ] Share file with user
- [ ] Share link with user

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
