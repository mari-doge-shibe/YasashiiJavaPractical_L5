package sample;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sample4 extends Application {
    // TableView showing Sunday as "休業日"

    private Label lb;
    private TableView<RowData> tv; // implement RowData class later

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        lb = new Label("いらっしゃいませ。");
        tv = new TableView<RowData>();

        TableColumn<RowData, String> tc1 = new TableColumn<RowData, String>("日付");
        TableColumn<RowData, String> tc2 = new TableColumn<RowData, String>("営業");

        tc1.setCellValueFactory(new PropertyValueFactory<RowData, String>("date"));
        tc2.setCellValueFactory(new PropertyValueFactory<RowData, String>("business"));

        ObservableList<RowData> ol = FXCollections.observableArrayList();
        for(int i = 0; i < 50; i++) {
            ol.add(new RowData(i));
        }

        tv.getColumns().add(tc1);
        tv.getColumns().add(tc2);

        tv.setItems(ol);

        BorderPane bp = new BorderPane();

        bp.setTop(lb);
        bp.setCenter(tv);

        Scene sc = new Scene(bp, 300, 200);

        stage.setScene(sc);

        stage.setTitle("サンプル");
        stage.show();

    }

    public class RowData {
        private final SimpleStringProperty date;
        private final SimpleStringProperty business;

        public RowData(int row) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime t = LocalDateTime.now();
            LocalDateTime d = t.plusDays(row);

            this.date = new SimpleStringProperty(df.format(d));

            if (d.getDayOfWeek() == DayOfWeek.SUNDAY) {
                this.business = new SimpleStringProperty("休業日です。");
            } else {
                this.business = new SimpleStringProperty("営業日です。");
            }
        }

            public StringProperty dateProperty() {
                return date;
            }
            public StringProperty businessProperty() {
                return business;
            }


        }

    }



