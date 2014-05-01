package models;

import com.avaje.ebean.annotation.EnumValue;


/**
 * Created by Ben on 8/04/2014.
 */
public enum Gender {
    @EnumValue("X")
    UNSPECIFIED,
    @EnumValue("M")
    MALE,
    @EnumValue("F")
    FEMALE
}
