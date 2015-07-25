package quote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import quote.desktop.stage.MainStage;

/**
 * @author hjep
 */
public class Main {
    public static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.debug("Application started");
        MainStage.launch(MainStage.class, args);
    }
}
