package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Practice1 extends Application {
    // displaying the next 50 days from today in the ListView and showing the selected date in the label
    private Label lb;
    private ListView<String> lv;

    public static void main(String[] args) {
        launch(args);
    }

    public void start (Stage stage) throws Exception {
        lb = new Label("いらっしゃいませ。");
        lv = new ListView<String>();

        ObservableList<String> ol = FXCollections.observableArrayList();

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime t = LocalDateTime.now();

        for(int i = 0; i < 50; i++) {
            ol.add(df.format(t.plusDays(i)));
        }

        lv.setItems(ol);

        BorderPane bp = new BorderPane();

        bp.setTop(lb);
        bp.setCenter(lv);

        lv.getSelectionModel().selectedItemProperty().addListener(new SampleChangeListener());

        Scene sc = new Scene(bp, 300, 200);

        stage.setScene(sc);

        stage.setTitle("サンプル");
        stage.show();
    }

    class SampleChangeListener implements ChangeListener<String> {
        public void changed(ObservableValue ob, String bs, String as) {
            lb.setText(as + "ですね。");
        }
    }




}
