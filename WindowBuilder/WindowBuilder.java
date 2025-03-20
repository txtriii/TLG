import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class WindowBuilder extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My Awesome Window");

        Pane pane = new Pane();
        pane.setPrefSize(1053, 534);
        pane.setStyle("-fx-background-color: #1e1e1e;");

        TextField inputWortlänge = new TextField("");
        inputWortlänge.setLayoutX(56.00);
        inputWortlänge.setLayoutY(85.00);
        inputWortlänge.setPrefWidth(106.00);
        inputWortlänge.setPrefHeight(22.00);
        inputWortlänge.setPromptText("");
        inputWortlänge.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lato.ttf"), 15.00));
        inputWortlänge.setStyle("-fx-background-color: #B2B2B2; -fx-text-fill: #353535; -fx-border-color: #979797; -fx-border-width: 0px; -fx-border-radius: 2px; -fx-prompt-text-fill: #656565;");
        pane.getChildren().add(inputWortlänge);

        TextField inputWortMenge = new TextField("");
        inputWortMenge.setLayoutX(50.38);
        inputWortMenge.setLayoutY(148.70);
        inputWortMenge.setPrefWidth(105.81);
        inputWortMenge.setPrefHeight(21.00);
        inputWortMenge.setPromptText("");
        inputWortMenge.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lato.ttf"), 15.00));
        inputWortMenge.setStyle("-fx-background-color: #B2B2B2; -fx-text-fill: #353535; -fx-border-color: #979797; -fx-border-width: 0px; -fx-border-radius: 2px; -fx-prompt-text-fill: #656565;");
        pane.getChildren().add(inputWortMenge);

        Button buttonVerb = new Button("Verben");
        buttonVerb.setLayoutX(55.00);
        buttonVerb.setLayoutY(218.00);
        buttonVerb.setPrefWidth(105.81);
        buttonVerb.setPrefHeight(29.00);
        buttonVerb.setDisable(false);
        buttonVerb.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lato.ttf"), 14.00));
        buttonVerb.setStyle("-fx-background-color: #2e2e2e; -fx-text-fill: #D9D9D9; -fx-border-color: #979797; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        buttonVerb.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { buttonVerb.setBackground(new Background(new BackgroundFill(Color.web("#232323"), new CornerRadii(4.00), null))); });
        buttonVerb.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { buttonVerb.setBackground(new Background(new BackgroundFill(Color.web("#2e2e2e"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(buttonVerb);

        Button buttonAdj = new Button("Adjektive");
        buttonAdj.setLayoutX(55.00);
        buttonAdj.setLayoutY(274.00);
        buttonAdj.setPrefWidth(105.81);
        buttonAdj.setPrefHeight(29.00);
        buttonAdj.setDisable(false);
        buttonAdj.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lato.ttf"), 14.00));
        buttonAdj.setStyle("-fx-background-color: #2e2e2e; -fx-text-fill: #D9D9D9; -fx-border-color: #979797; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        buttonAdj.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { buttonAdj.setBackground(new Background(new BackgroundFill(Color.web("#232323"), new CornerRadii(4.00), null))); });
        buttonAdj.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { buttonAdj.setBackground(new Background(new BackgroundFill(Color.web("#2e2e2e"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(buttonAdj);

        Button buttonSubst = new Button("Substantive");
        buttonSubst.setLayoutX(55.00);
        buttonSubst.setLayoutY(333.00);
        buttonSubst.setPrefWidth(105.81);
        buttonSubst.setPrefHeight(29.00);
        buttonSubst.setDisable(false);
        buttonSubst.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lato.ttf"), 14.00));
        buttonSubst.setStyle("-fx-background-color: #2e2e2e; -fx-text-fill: #D9D9D9; -fx-border-color: #979797; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        buttonSubst.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { buttonSubst.setBackground(new Background(new BackgroundFill(Color.web("#232323"), new CornerRadii(4.00), null))); });
        buttonSubst.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { buttonSubst.setBackground(new Background(new BackgroundFill(Color.web("#2e2e2e"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(buttonSubst);

        Label text1 = new Label("AUSGEWÄHLTE WORTART:");
        text1.setLayoutX(51);
        text1.setLayoutY(396);
        text1.setPrefWidth(107);
        text1.setPrefHeight(12);
        text1.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lato.ttf"), 8.00));
        text1.setStyle("-fx-text-fill: #D9D9D9;");
        pane.getChildren().add(text1);

        Label textWortart = new Label("Wortart");
        textWortart.setLayoutX(56);
        textWortart.setLayoutY(408);
        textWortart.setPrefWidth(119);
        textWortart.setPrefHeight(28);
        textWortart.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lato.ttf"), 22.00));
        textWortart.setStyle("-fx-text-fill: #D9D9D9;");
        pane.getChildren().add(textWortart);

        TextArea textFeldAusgabe = new TextArea("");
        textFeldAusgabe.setLayoutX(191.00);
        textFeldAusgabe.setLayoutY(88.00);
        textFeldAusgabe.setPrefWidth(795.00);
        textFeldAusgabe.setPrefHeight(387.00);
        textFeldAusgabe.setPromptText("Erzeugte Wörter");
        textFeldAusgabe.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lato.ttf"), 15.00));
        textFeldAusgabe.setStyle("-fx-control-inner-background: #B2B2B2; -fx-background-color: #B2B2B2; -fx-text-fill: #353535; -fx-border-color: #979797; -fx-border-width: 0px; -fx-border-radius: 2px; -fx-prompt-text-fill: #656565;");
        pane.getChildren().add(textFeldAusgabe);

        Button buttonRun = new Button("Wörter Generieren");
        buttonRun.setLayoutX(191.38);
        buttonRun.setLayoutY(33.70);
        buttonRun.setPrefWidth(163.00);
        buttonRun.setPrefHeight(31.00);
        buttonRun.setDisable(false);
        buttonRun.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lato.ttf"), 14.00));
        buttonRun.setStyle("-fx-background-color: #2e2e2e; -fx-text-fill: #D9D9D9; -fx-border-color: #979797; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        buttonRun.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { buttonRun.setBackground(new Background(new BackgroundFill(Color.web("#232323"), new CornerRadii(4.00), null))); });
        buttonRun.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { buttonRun.setBackground(new Background(new BackgroundFill(Color.web("#2e2e2e"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(buttonRun);

        Label textLen = new Label("Silbenanzahl");
        textLen.setLayoutX(52);
        textLen.setLayoutY(110);
        textLen.setPrefWidth(105.8125);
        textLen.setPrefHeight(17);
        textLen.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lato.ttf"), 14.00));
        textLen.setStyle("-fx-text-fill: #D9D9D9;");
        pane.getChildren().add(textLen);

        Label textMenge = new Label("Wortanzahl");
        textMenge.setLayoutX(52.375);
        textMenge.setLayoutY(164.953125);
        textMenge.setPrefWidth(105.8125);
        textMenge.setPrefHeight(17);
        textMenge.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lato.ttf"), 14.00));
        textMenge.setStyle("-fx-text-fill: #D9D9D9;");
        pane.getChildren().add(textMenge);

        Scene scene = new Scene(pane, 1053, 534);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}