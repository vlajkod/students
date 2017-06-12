import gui.AlertBox;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import models.DosijeView;
import models.Predmet;
import services.IspitService;
import utils.PrintUtil;
import utils.ValidationUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vlajko on 5/30/17.
 */
public class App extends Application {

    private Map<String, Predmet> mapPredmeti = new HashMap<String, Predmet>();
    private int godinaRoka;
    private String oznakaRoka;

    public static void main(String args[]) {
        launch(args);
        System.out.println("Start App Here");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("T07");
        PrintUtil printUtil = new PrintUtil();



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


        Button searchButton = new Button("Pretrazi");
        GridPane.setConstraints(searchButton, 2,0);

        Button showButton = new Button("Prikazi");
        GridPane.setConstraints(showButton, 0,2);

        Button saveButton = new Button("Sacuvaj");
        GridPane.setConstraints(saveButton, 1,2);

        searchButton.setOnAction(e -> {
            listView.getItems().clear();
            if(ValidationUtils.isInt(unesiIndeksInput.getText())) {
                godinaRoka = Integer.parseInt(unesiIndeksInput.getText());
                List<Predmet> predmeti = IspitService.readPredmeti(godinaRoka);
                if(predmeti.isEmpty()) {
                    AlertBox.display("Prijavljeni ispiti", "Nema prijavljenih ispita za ovu godinu, pokusajte ponovo");
                    return;
                }

                for(Predmet predmet: predmeti) {

                    mapPredmeti.put(predmet.getNaziv(), predmet);
                    listView.getItems().add(predmet.getNaziv());

                }
            };
        });


        showButton.setOnAction(e -> {
            String smer = listView.getSelectionModel().getSelectedItems().toString();
            if(smer.equals("[]")) {
                AlertBox.display("Lista prazna", "Morate izabrati jedan predmet prvo");
                return;
            }
            Predmet p = mapPredmeti.get(smer.substring(1, smer.length() - 1));
            List<DosijeView> dosije = IspitService.readDosije(p.getIdPredmeta(), godinaRoka);
            printUtil.setDosije(dosije);
            printUtil.setPredmet(p);
            listView1.getItems().clear();
            for(DosijeView d: dosije) {
                listView1.getItems().add(d.getDosije().getIndeks() + " " + d.getDosije().getIme() + " " + d.getDosije().getPrezime() + " " + d.getBrPolaganja());
            }

        });

        saveButton.setOnAction(e -> {
            printUtil.saveFile(godinaRoka);
        });


        gridHeader.getChildren().addAll(unesiIndeks, unesiIndeksInput, searchButton);
        gridBody.getChildren().addAll(listView, showButton, listView1, saveButton);
        gridContainer.getChildren().addAll(gridHeader, gridBody);

        Scene scene = new Scene(gridContainer, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
