package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.InputStream;


public class Main extends  Application  {


    @Override
    public  void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();
        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setPadding(new Insets(25,25,25,25));

        TextField productName = new TextField();
        TextField quantity = new TextField();
        TextField oldPrice = new TextField();
        TextField newPrice = new TextField();
        TextField descriptionTextField = new TextField();

        ObservableList<Product> productObservableList = FXCollections.observableArrayList();
        productObservableList.add(new Product("Schafmichlkäse", "200 Gramm Packung", 2.59, 1.99, "Hier gibt es keine Beschreibung, weil unsere Handelskette kennst sich nur bedingt damit aus, wie man eine Werbebeschreibung schreibt."));
        productObservableList.add(new Product("Pfeffer", "1 Stück", 3.49, 2.79, "Schwarzer Pfeffer verleiht Ihren Speisen eine pikante Schärfe, besonders wenn er länger mitgekocht wird."));
        productObservableList.add(new Product("Vöslauer", "1.5 Liter Flasche", 0.75, 0.49, "Spritziges Vöslauer Mineralwasser"));
        productObservableList.add(new Product("Zucker", "500 Gramm Paket", 1.39, 0.89, "Natürliches Gelieren wird durch Apfelpektin unterstützt, welches im richtigen Verhältnis mit Zitronensäure und Kristallzucker abgemischt wurde."));

        ListView<Product> productListView = new ListView<Product>(productObservableList);
        productListView.setCellFactory(param -> new ListCell<Product>() {
            @Override
            protected void updateItem(Product item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getProductName() == null) {
                    setText(null);
                } else {
                    setText("{" + item.getProductName() + ", old=" + item.getProductOldPrice() + ", new=" + item.getProductNewPrice() + "}");
                }
            }
        });

        productListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                productName.setText(productListView.getSelectionModel().getSelectedItem().getProductName());
                quantity.setText(productListView.getSelectionModel().getSelectedItem().getProductQuantity());
                oldPrice.setText(Double.toString(productListView.getSelectionModel().getSelectedItem().getProductOldPrice()));
                newPrice.setText(Double.toString(productListView.getSelectionModel().getSelectedItem().getProductNewPrice()));
                descriptionTextField.setText(productListView.getSelectionModel().getSelectedItem().getProductDescription());
            }
        });

        HBox productList = new HBox(productListView);

        Label euroLabel = new Label("EUR");
        Label productNameLabel = new Label("Prod. Name");
        Label quantityLabel = new Label("Quantity");
        Label oldPriceLabel = new Label("Old price");
        Label newPriceLabel = new Label("new price");
        Label euroLabel2 = new Label("EUR");
        Label descriptionLabel = new Label("Description:");

        descriptionLabel.setStyle("-fx-font-size: 2em;");
        descriptionTextField.setStyle("-fx-background-color: transparent");


        /*InputStream input1 = this.getClass().getResourceAsStream("/images/cheese_salakis_600x600.jpg");
        Image salakisCheeseImage = new Image(input1);
        ImageView cheeseImageView = new ImageView(salakisCheeseImage);
        VBox imageVBox = new VBox(cheeseImageView);*/

        pane.add(productNameLabel, 0, 1);
        pane.add(productName, 1, 1);
        //pane.add(productList,3, 1);
        pane.add(quantityLabel, 0,2);
        pane.add(quantity, 1, 2);
        pane.add(oldPriceLabel, 0, 3);
        pane.add(oldPrice, 1, 3);
        pane.add(euroLabel, 2, 3);
        pane.add(newPriceLabel, 0, 4);
        pane.add(newPrice, 1, 4);
        pane.add(euroLabel2, 2, 4);
        pane.add(descriptionLabel,0,5);
        //pane.add(descriptionTextField,0,6);

        borderPane.setLeft(pane);
        borderPane.setRight(productList);
        borderPane.setBottom(descriptionTextField);

        Scene scene = new Scene(borderPane, 500, 500);
        primaryStage.setTitle("Set action price");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
