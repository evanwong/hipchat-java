package io.evanwong.oss.hipchat.v2;

import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.*;
import com.openpojo.validation.rule.impl.*;
import com.openpojo.validation.test.impl.*;
import io.evanwong.oss.hipchat.v2.emoticons.EmoticonItem;
import io.evanwong.oss.hipchat.v2.emoticons.Emoticons;
import io.evanwong.oss.hipchat.v2.rooms.Owner;
import io.evanwong.oss.hipchat.v2.rooms.Room;
import io.evanwong.oss.hipchat.v2.rooms.RoomItem;
import io.evanwong.oss.hipchat.v2.rooms.Rooms;
import io.evanwong.oss.hipchat.v2.users.*;
import org.junit.Test;


public class PojoTest {
    @Test
    public void testPojoStructureAndBehavior() {
        Validator validator = ValidatorBuilder.create()
                .with(new GetterMustExistRule())
                .with(new SetterMustExistRule())
                .with(new SetterTester())
                .with(new GetterTester())
                .build();

        validator.validate(PojoClassFactory.getPojoClass(UserItem.class));
        validator.validate(PojoClassFactory.getPojoClass(Users.class));
        validator.validate(PojoClassFactory.getPojoClass(Owner.class));
        validator.validate(PojoClassFactory.getPojoClass(Room.class));
        validator.validate(PojoClassFactory.getPojoClass(Rooms.class));
        validator.validate(PojoClassFactory.getPojoClass(RoomItem.class));
        validator.validate(PojoClassFactory.getPojoClass(Emoticons.class));
        validator.validate(PojoClassFactory.getPojoClass(EmoticonItem.class));
    }
}