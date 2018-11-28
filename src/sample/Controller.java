package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller {

    boolean stateFreehand = false;
    @FXML
    private Canvas canvas;
    @FXML
    private Button drawButton;
    @FXML
    private Button freeButton;

    @FXML
    private void handleDraw(ActionEvent event) {

        drawSquare();
    }

    @FXML
    private void handleFree(ActionEvent event) {
        stateFreehand = true;
    }

    @FXML
    private void handleMouseDrag(MouseEvent event) {
        //System.out.println("(dragging), x = " + event.getX() + ", y = " + event.getY());
        if (stateFreehand) {
            GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
            graphicsContext.setFill(Color.BLUE);
            graphicsContext.fillOval(event.getX(), event.getY(), 10, 10);
        }

        /*canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        graphicsContext.beginPath();
                        graphicsContext.moveTo(event.getX(), event.getY());
                        graphicsContext.stroke();

                    }
                });

        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        graphicsContext.lineTo(event.getX(), event.getY());
                        graphicsContext.stroke();
                        graphicsContext.closePath();
                        graphicsContext.beginPath();
                        graphicsContext.moveTo(event.getX(), event.getY());
                    }
                });

        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        graphicsContext.lineTo(event.getX(), event.getY());
                        graphicsContext.stroke();
                        graphicsContext.closePath();
                    }
                });*/
    }

    @FXML
    private void handleMouseEnter(MouseEvent event) {
        System.out.println("(enter) the mouse entered the canvas");
    }

    @FXML
    private void handleMouseRelease(MouseEvent event) {
        System.out.println("(release) the mouse was released ");
        stateFreehand = false;
    }


    private void drawSquare() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(2);
        gc.setFill(Color.BLUE);
        gc.fillRect(10, 20, 30, 40);

        gc.setStroke(Color.RED);
        gc.strokeLine(170, 230, 40, 80);

        gc.setStroke(Color.GREEN);
        gc.setLineWidth(5);
        gc.strokeOval(200, 200, 50, 40);
    }
}
