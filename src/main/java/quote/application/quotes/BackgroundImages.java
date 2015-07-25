package quote.application.quotes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author hjep
 */
public class BackgroundImages {
    public static final Logger log = LoggerFactory.getLogger(BackgroundImages.class);

    public static int getRandomInteger(int maximum, int minimum){ return ((int) (Math.random()*(maximum - minimum))) + minimum; }

    public String getRandomImage(){
        int imageNo = getRandomInteger(18, 1);

        return "quotes-"+imageNo+".jpg";
    }
}
