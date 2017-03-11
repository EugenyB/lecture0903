package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logic.Logic;
import logic.MyBean;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML TextField startField;
    @FXML TextField finishField;
    @FXML
    Canvas canvas;
    @FXML
    Pane centerPane;

    MyBean myBean;

    Logic logic;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        canvas.widthProperty().bind(centerPane.widthProperty());
        canvas.heightProperty().bind(centerPane.heightProperty());
        canvas.widthProperty().addListener(e->draw());
        canvas.heightProperty().addListener(e->draw());

        logic = new Logic();
    }

    public void draw(){
        double width = centerPane.getWidth();
        double height = centerPane.getHeight();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.AQUA);
        gc.fillRect(0,0, width, height);
        gc.strokeRect(0, 0, width, height);
//        gc.strokeLine(0,0, width, height);
//        gc.strokeLine(0, height, width, 0);
        drawGraphic();
    }

    private void drawGraphic() {
        if (myBean == null) return;
        double[] x = logic.calcX(myBean.getStart(), myBean.getFinish(), calcStep());
        double[] y = logic.calcY(x);
        System.out.println("---- start ----");
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i] + " " + y[i]);
        }
        System.out.println("---- finish ----");
    }

    private double calcStep() {
        return (myBean.getFinish() - myBean.getStart()) / centerPane.getWidth();
    }

    public void processGraphic(ActionEvent actionEvent) {
        double start = Double.parseDouble(startField.getText());
        double finish = Double.parseDouble(finishField.getText());
        myBean = new MyBean(start, finish);
        draw();
    }
}
