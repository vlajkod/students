import javafx.application.Application;
import javafx.beans.Observable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import models.Ispit;
import services.IspitService;
import utils.ValidationUtils;

import java.util.List;

/**
 * Created by vlajko on 5/30/17.
 */
public class App extends Application {

    private Button button;

    public static void main(String args[]) {
        launch(args);
        System.out.println("Start App Here");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("T07");

        //container grid
        GridPane gridContainer = new GridPane();
        gridContainer.setPadding(new Insets(10, 10, 10, 10));
        gridContainer.setVgap(8);
        gridContainer.setHgap(10);

        GridPane gridHeader = new GridPane();
        gridHeader.setPadding(new Insets(10, 10, 10, 10));
        gridHeader.setVgap(8);
        gridHeader.setHgap(10);
        GridPane.setConstraints(gridHeader, 0,0);

        GridPane gridBody = new GridPane();
        gridBody.setPadding(new Insets(10, 10, 10, 10));
        gridBody.setVgap(8);
        gridBody.setHgap(10);
        GridPane.setConstraints(gridBody, 0,1);



        Label unesiIndeks = new Label("Unesi godinu ispitnog roka:");
        GridPane.setConstraints(unesiIndeks, 0, 0);

        TextField unesiIndeksInput = new TextField();
        unesiIndeksInput.setPromptText("Unesite godinu roka");
        GridPane.setConstraints(unesiIndeksInput, 1, 0);

        ListView listView = new ListView();
        listView.setPrefSize(350, 400);
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        GridPane.setConstraints(listView,0,0);

        ListView listView1 = new ListView();
        listView.setPrefSize(350, 400);
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        GridPane.setConstraints(listView1,1,0);


        Button unesiButton = new Button("Pretrazi");
        GridPane.setConstraints(unesiButton, 2,0);

        Button prikaziButton = new Button("Prikazi");
        GridPane.setConstraints(prikaziButton, 0,2);

        Button saveButton = new Button("Sacuvaj");
        GridPane.setConstraints(saveButton, 1,2);

        unesiButton.setOnAction(e -> {
            if(ValidationUtils.isInt(unesiIndeksInput.getText())) {
                int godina = Integer.parseInt(unesiIndeksInput.getText());
                List<Ispit> ispiti = IspitService.readOne(godina);
                if(ispiti.isEmpty()) {
                    System.out.println("Nema prijavljenih ispita za ovu godinu, pokusajte ponovo");
                    return;
                }
                listView.getItems().removeAll();
                for(Ispit ispit: ispiti) {
                    listView.getItems().addAll(ispit.getOznaka_roka() + ispit.getGodina_roka());
                }
            };
        });


        prikaziButton.setOnAction(e -> {
            System.out.println("radi");
            Observable smer = listView.getSelectionModel().getSelectedItems();
            String smerString = smer.toString();
            System.out.println(smerString);
        });


        gridHeader.getChildren().addAll(unesiIndeks, unesiIndeksInput, unesiButton);
        gridBody.getChildren().addAll(listView, prikaziButton, listView1, saveButton);
        gridContainer.getChildren().addAll(gridHeader, gridBody);

        Scene scene = new Scene(gridContainer, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
