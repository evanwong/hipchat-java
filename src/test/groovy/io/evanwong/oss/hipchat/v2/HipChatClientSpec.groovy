package io.evanwong.oss.hipchat.v2

import io.evanwong.oss.hipchat.v2.commons.Scope
import io.evanwong.oss.hipchat.v2.emoticons.EmoticonType
import io.evanwong.oss.hipchat.v2.oauth.GrantType
import io.evanwong.oss.hipchat.v2.rooms.MessageColor
import io.evanwong.oss.hipchat.v2.rooms.MessageFormat
import io.evanwong.oss.hipchat.v2.rooms.Privacy
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
        true            | 123        | 456        | ["title1", "title2"]
        false           | 321        | 654        | ["title1", "title2"]
        null            | null       | null       | ["title1"]
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

    def "prepareCreateRoomRequestBuilder should create a CreateRoomRequest properly"() {
        setup:
        def builder = client.prepareCreateRoomRequestBuilder(name, token)
        builder.guestAcccess = guestAccess
        builder.ownerUserId = ownerUserId
        builder.privacy = privacy
        builder.topic = topic

        when:
        def req = builder.build()

        then:
        req.name == name
        req.ownerUserId == ownerUserId
        req.privacy == privacy
        req.guestAcccess == guestAccess
        req.topic == topic


        where:
        name       | ownerUserId | privacy         | guestAccess | topic
        "room1"    | "@testuser" | Privacy.PRIVATE | true        | "topic1"
        "room321"  | "user"      | Privacy.PUBLIC  | false       | null
        "room456"  | "user"      | Privacy.PRIVATE | false       | null
        "adsfasdf" | "user123"   | null            | null        | "topic2"
    }

    def "prepareGetRoomRequestBuilder should create a GetRoomRequest properly"() {
        setup:
        def builder = client.prepareGetRoomRequestBuilder(name, token)

        when:
        def req = builder.build()

        then:
        req.roomIdOrName == name

        where:
        name    | _
        "test1" | _
        "1test" | _
    }

    def "prepareGetEmoticonRequestBuilder should create a GetEmoticonRequest properly"() {
        setup:
        def builder = client.prepareGetEmoticonRequestBuilder(name, token)

        when:
        def req = builder.build()

        then:
        req.idOrShortcut == name

        where:
        name    | _
        "test1" | _
        "1test" | _
    }

    def "prepareGetAllEmoticonsRequestBuilder should create a GetAllEmoticonsRequest properly"() {
        setup:
        def builder = client.prepareGetAllEmoticonsRequestBuilder(token)
        builder = builder.setType(type)
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
        req.type == type
        req.expansions.every { expansions.contains(it) }


        where:
        type                | maxResults | startIndex | expansions
        EmoticonType.ALL    | 123        | 456        | ["title1", "title2"]
        EmoticonType.GLOBAL | 321        | 654        | ["title1", "title2"]
        null                | null       | null       | ["title1"]
        EmoticonType.GROUP  | null       | 456        | null
    }

    def "prepareGenerateTokenRequestBuilder should create a GenerateTokenRequest properly"() {
        setup:
        def builder = client.prepareGenerateTokenRequestBuilder(grantType, token)
        builder = builder.setUsername(username).setCode(code).setRefreshToken(refreshToken)
        scopes.each {
            builder = builder.addScope(it)
        }

        when:
        def req = builder.build()

        then:
        req.grantType == grantType
        req.username == username
        req.code == code
        req.refreshToken == refreshToken
        req.scopes.size() == scopes.size()
        if (req.scopes && scopes) {
            req.scopes.each {
                assert scopes.contains(it)
            }
            scopes.each {
                assert req.scopes.contains(it)
            }
        }

        where:
        grantType                    | username   | code       | refreshToken | scopes
        GrantType.AUTHORIZATION_CODE | null       | "codecode" | null         | [Scope.ADMIN_GROUP, Scope.ADMIN_ROOM]
        GrantType.REFRESH_TOKEN      | null       | null       | "tokentoken" | []
        GrantType.CLIENT_CREDENTIALS | "evanwong" | null       | null         | [Scope.SEND_MESSAGE]

    }
}