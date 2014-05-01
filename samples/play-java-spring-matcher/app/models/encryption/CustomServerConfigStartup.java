package models.encryption;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.event.ServerConfigStartup;


/**
 *  @see http://stackoverflow.com/questions/15800453/play-framework-2-1-java-ebean-encrypted-annotation-errors
 *add ebean.encryptKeyManager=models.BasicEncryptKeyManager to application.conf
 */


public class CustomServerConfigStartup implements ServerConfigStartup {

    @Override
    public void onStart(ServerConfig serverConfig) {
        serverConfig.setEncryptKeyManager(new BasicEncryptKeyManager());
    }
}

