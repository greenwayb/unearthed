package models.encryption;

/**
 * Created by Ben on 2/04/2014.
 */


import com.avaje.ebean.config.EncryptKey;


class CustomEncryptKey implements EncryptKey {

    private String tableName;

    private String columnName;

    public CustomEncryptKey(String tableName, String columnName) {
        this.tableName = tableName;
        this.columnName = columnName;
    }

    @Override
    public String getStringValue() {
        return play.Configuration.root().getString("application.secret") + "::" + this.tableName + "::" + this.columnName;
    }
}