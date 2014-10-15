package io.evanwong.hipchat.v2

import io.evanwong.hipchat.v2.commons.NoContent
import io.evanwong.hipchat.v2.rooms.MessageColor
import io.evanwong.hipchat.v2.rooms.MessageFormat
import io.evanwong.hipchat.v2.rooms.Room
import spock.lang.Specification


class HipChatClientSpec extends Specification {

    def client = new HipChatClient()
    //fake token
    def token = "fasdfasdfasdfas123123"

    def setupSpec() {
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "debug")
    }

    def "prepareGetAllRoomsRequestBuilder should create a GetAllRoomsRequest properly"() {
        setup:
        def builder = client.prepareGetAllRoomsRequestBuilder(token)
        builder = builder.setIncludeArchived(includeArchived)
        builder = builder.setMaxResults(maxResults)
        builder = builder.setStartIndex(startIndex)
        expansions.each {
            builder = builder.addExpansion(it)
        }

        when:
        def req = builder.build()

        then:
        req.startIndex == startIndex
        req.maxResults == maxResults
        req.includeArchived == includeArchived
        req.expansions.every { expansions.contains(it) }


        where:
        includeArchived | maxResults | startIndex | expansions
        true            | 123        | 456        | Arrays.asList("title1", "title2")
        false           | 321        | 654        | Arrays.asList("title1", "title2")
        null            | null       | null       | Arrays.asList("title1")
        true            | null       | 456        | null

    }

    def "prepareSendRoomNotificationRequestBuilder should create a SendRoomNotificationRequest properly"() {
        setup:
        def builder = client.prepareSendRoomNotificationRequestBuilder(room, message, token)
        builder.color = color
        builder.notify = notify
        builder.messageFormat = messageFormat

        when:
        def req = builder.build()        

        then:
        req.idOrName == room
        req.color == color
        req.message == message
        req.notify == notify
        req.messageFormat == messageFormat


        where:
        room      | message        | color               | notify | messageFormat
        "room1"   | "test message" | MessageColor.YELLOW | true   | MessageFormat.TEXT
        "room321" | "new message"  | MessageColor.GREEN  | false  | MessageFormat.HTML

    }

//    def "return all rooms for the valid access token"() {
//        setup:
//        def token = token
//        def request = client.prepareGetAllRoomsRequestBuilder(token).build()
//
//
//        when:
//        Room room = request.execute().get()
//
//        expect:
//        room.items.each {
//            assert it.id != null
//            assert it.name != null
//            assert it.links != null
//            assert it.links.self != null
//        }
//    }
//
//    def "same access token should have the same behaviours"() {
//        setup:
//        def token = token
//        def request1 = client.prepareGetAllRoomsRequestBuilder(token).build()
//        def client2 = new HipChatClient()
//        client2.setDefaultAccessToken(token)
//        def request2 = client2.prepareGetAllRoomsRequestBuilder().build()
//        Room room1 = request1.execute().get()
//        Room room2 = request2.execute().get()
//
//        expect:
//        room1.items.eachWithIndex { item, index ->
//            assert room2.items[index].id == item.id
//            assert room2.items[index].links.self == item.links.self
//        }
//    }
//
//    def "send notification return nothing"() {
//        setup:
//        def token = token
//        def request = client.prepareSendRoomNotificationRequestBuilder(idOrName, message, token).setNotify(notify).setColor(color).build()
//
//        when:
//        NoContent noContent = request.execute().get()
//
//        then:
//        noContent != null
//
//        where:
//        idOrName | message    | notify | color
//        "12345"  | "hello"    | true   | MessageColor.GRAY
//        "test1"  | "hello123" | false  | MessageColor.GREEN
//
//    }


}
