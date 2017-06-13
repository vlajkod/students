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
    private static ListView listView1;
    private static ListView listView;

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

        GridPane gridFooter = new GridPane();
        gridFooter.setPadding(new Insets(10, 10, 10, 10));
        gridFooter.setVgap(8);
        gridFooter.setHgap(10);
        GridPane.setConstraints(gridFooter, 0,3);


        Label unesiIndeks = new Label("Unesi godinu ispitnog roka:");
        GridPane.setConstraints(unesiIndeks, 0, 0);

        TextField unesiIndeksInput = new TextField();
        unesiIndeksInput.setPromptText("Unesite godinu roka");
        GridPane.setConstraints(unesiIndeksInput, 1, 0);

        listView = new ListView();
        listView.setPrefSize(350, 400);
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        GridPane.setConstraints(listView,0,0);

        listView1 = new ListView();
//        listView.setPrefSize(550, 400);
        listView1.setMinSize(500, 400);
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        GridPane.setConstraints(listView1,1,0);


        Button searchButton = new Button("Pretrazi");
        GridPane.setConstraints(searchButton, 2,0);

        Button showButton = new Button("Prikazi");
        GridPane.setConstraints(showButton, 0,2);

        Button saveButton = new Button("Sacuvaj");
        GridPane.setConstraints(saveButton, 1,2);

        Button startButton = new Button("Pocetak");
        GridPane.setConstraints(startButton, 0,0);

        Button stopButton = new Button("Kraj");
        GridPane.setConstraints(stopButton, 1,0);

        searchButton.setOnAction(e -> {
            clearAll();
            if(ValidationUtils.isInt(unesiIndeksInput.getText())) {
                godinaRoka = Integer.parseInt(unesiIndeksInput.getText());
                List<Predmet> predmeti = IspitService.readPredmeti(godinaRoka);

                if(ValidationUtils.isSearchButtonValid(predmeti)){
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

            if(ValidationUtils.isShowButtonValid(smer)) {
                return;
            }
            Predmet p = mapPredmeti.get(smer.substring(1, smer.length() - 1));
            List<DosijeView> dosije = IspitService.readDosije(p.getIdPredmeta(), godinaRoka);
            printUtil.setDosijeAndPredmet(dosije, p);
            listView1.getItems().clear();
            for(DosijeView d: dosije) {
                listView1.getItems().add(d.getDosije().getIndeks() + " " + d.getDosije().getIme() + " " + d.getDosije().getPrezime() + " " + d.getBrPolaganja());
            }

        });

        saveButton.setOnAction(e -> {
            printUtil.saveFile(godinaRoka);
        });

        startButton.setOnAction(e -> clearAll());
        stopButton.setOnAction(e -> primaryStage.close());


        gridHeader.getChildren().addAll(unesiIndeks, unesiIndeksInput, searchButton);
        gridBody.getChildren().addAll(listView, showButton, listView1, saveButton);
        gridFooter.getChildren().addAll(startButton, stopButton);
        gridContainer.getChildren().addAll(gridHeader, gridBody, gridFooter);

        Scene scene = new Scene(gridContainer, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void clearAll() {
        listView.getItems().clear();
        listView1.getItems().clear();
    }
}
