package quote.desktop.stage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import quote.application.quotes.QuoteDAO;
import quote.application.quotes.Quotes;
import quote.desktop.controller.MainStageController;

/**
 * @author hjep
 */
public class MainStage extends Application {
    public static final Logger log = LoggerFactory.getLogger(MainStage.class);

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainStage.fxml"));
        Parent root = loader.load();

        MainStageController controller = loader.getController();

        Scene scene = new Scene(root, 800, 600);
        String styleSheet = MainStage.class.getResource("/css/quotes.css").toExternalForm();
        scene.getStylesheets().clear();
        scene.getStylesheets().add(styleSheet);

        primaryStage.setTitle("Quotes");
        primaryStage.setScene(scene);
        primaryStage.show();

        Quotes quotes = new Quotes();
        QuoteDAO quote = quotes.getRandomQuote();

        controller.setLabelQuote(quote.getQuote());
        controller.setLabelAuthor(quote.getAuthor());
        controller.setLabelCategory(quote.getCategory());

    }
}
