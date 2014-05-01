package models;

import com.avaje.ebean.annotation.EnumValue;

/**
 * Created by Ben on 8/04/2014.
 */
public enum AuditEvent {

    @EnumValue("LO")
    LOGON,
    @EnumValue("PA")
    PAYMENT,
    @EnumValue("MS")
    MESSAGE

}
