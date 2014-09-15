package io.evanwong.hipchat.v2

import io.evanwong.hipchat.v2.commons.NoContent
import io.evanwong.hipchat.v2.rooms.MessageColor
import io.evanwong.hipchat.v2.rooms.Room
import spock.lang.Specification


class HipChatClientSpec extends Specification {

    def client = new HipChatClient()

    def setupSpec() {
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "debug")
    }

    def "return all rooms for the valid access token"() {
        setup:
        def token = "0Yv6Ur7XUDWbsmd1VGU2Ew9FvrDEyOeJdMYdY4GW"
        def request = client.prepareGetAllRoomsRequestBuilder(token).build()
        Room room = request.execute().get()

        expect:
        room.items.each {
            assert it.id != null
            assert it.name != null
            assert it.links != null
            assert it.links.self != null
        }
    }

    def "same access token should have the same behaviours"() {
        setup:
        def token = "0Yv6Ur7XUDWbsmd1VGU2Ew9FvrDEyOeJdMYdY4GW"
        def request1 = client.prepareGetAllRoomsRequestBuilder(token).build()
        def client2 = new HipChatClient()
        client2.setDefaultAccessToken(token)
        def request2 = client2.prepareGetAllRoomsRequestBuilder().build()
        Room room1 = request1.execute().get()
        Room room2 = request2.execute().get()

        expect:
        room1.items.eachWithIndex { item, index ->
            assert room2.items[index].id == item.id
            assert room2.items[index].links.self == item.links.self
        }
    }

    def "send notification return nothing"() {
        setup:
        def token = "0Yv6Ur7XUDWbsmd1VGU2Ew9FvrDEyOeJdMYdY4GW"
        def request = client.prepareSendRoomNotificationRequestBuilder(idOrName, message, token).setNotify(notify).setColor(color).build()

        when:
        NoContent noContent = request.execute().get()

        then:
        noContent != null

        where:
        idOrName | message    | notify | color
        "12345"  | "hello"    | true   | MessageColor.GRAY
        "test1"  | "hello123" | false  | MessageColor.GREEN

    }


}
