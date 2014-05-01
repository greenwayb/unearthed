package models.encryption;

import com.avaje.ebean.config.EncryptKey;
import com.avaje.ebean.config.EncryptKeyManager;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.event.ServerConfigStartup;


/**
 *  @see http://stackoverflow.com/questions/15800453/play-framework-2-1-java-ebean-encrypted-annotation-errors
 *add ebean.encryptKeyManager=models.BasicEncryptKeyManager to application.conf
 */


public class BasicEncryptKeyManager implements EncryptKeyManager {

    @Override
    public EncryptKey getEncryptKey(String tableName, String columnName) {
        return new CustomEncryptKey(tableName, columnName);
    }

    @Override
    public void initialise() {
        //Do nothing (yet)
    }

}
