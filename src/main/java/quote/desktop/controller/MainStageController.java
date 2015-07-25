package quote.desktop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import quote.application.quotes.QuoteDAO;
import quote.application.quotes.Quotes;

/**
 * @author hjep
 */
public class MainStageController {
    public static final Logger log = LoggerFactory.getLogger(MainStageController.class);

    @FXML
    private Label labelCategory;

    @FXML
    private Label labelQuote;

    @FXML
    private Label labelAuthor;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        log.debug("Alert button pressed");
        // Button was clicked, do something...
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText("I have a great message for you!");

        alert.showAndWait();
    }

    @FXML
    private void loadNewQuote(ActionEvent event){
        Quotes quotes = new Quotes();
        QuoteDAO quote = quotes.getRandomQuote();

        setLabelQuote(quote.getQuote());
        setLabelAuthor(quote.getAuthor());
        setLabelCategory(quote.getCategory());
    }

    public void setLabelCategory(String labelCategory){
        this.labelCategory.setText(labelCategory);
    }

    public void setLabelQuote(String labelQuote){
        this.labelQuote.setText(labelQuote);
    }

    public void setLabelAuthor(String labelAuthor){
        this.labelAuthor.setText("- " + labelAuthor);
    }
}
