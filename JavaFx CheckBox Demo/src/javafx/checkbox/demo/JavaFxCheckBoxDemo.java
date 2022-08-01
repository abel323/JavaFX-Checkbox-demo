/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx.checkbox.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


/**
 *
 * @author Abel
 */
public class JavaFxCheckBoxDemo extends Application {
    protected Text text = new Text(20,20,"JavaFX Programming is fun!");
    Button btnLeft = new Button("Left");
    Button btnRight = new Button("Right");
    CheckBox chkItalic = new CheckBox("Italic");
    CheckBox chkBold = new CheckBox("Bold");
    protected BorderPane getBorderPane(){
        Font fontBoldItalic = Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 20);
        Font fontBold = Font.font("Times New Roman",FontWeight.BOLD, FontPosture.REGULAR, 20);
        Font fontItalic = Font.font("Times New Roman",FontWeight.NORMAL, FontPosture.ITALIC, 20);
        Font fontRegular = Font.font("Times New Roman",FontWeight.NORMAL, FontPosture.REGULAR,20);
        BorderPane root = new BorderPane();
        Pane pane = new Pane();
        pane.getChildren().addAll(text);
        HBox hbox = new HBox();
        hbox.getChildren().addAll(btnLeft,btnRight);
        hbox.setAlignment(Pos.CENTER);
        hbox.setStyle("-fx-border-color: green");
        VBox vbox = new VBox();
        vbox.getChildren().addAll(chkItalic, chkBold);
        vbox.setStyle("-fx-border-color:green");
        vbox.setPadding(new Insets(5,5,5,5));
        vbox.setAlignment(Pos.CENTER);
        
        EventHandler<ActionEvent> handler = e->{
            if(chkBold.isSelected() && chkItalic.isSelected()){
                text.setFont(fontBoldItalic);
            }
            else if(chkBold.isSelected()){
                text.setFont(fontBold);
            }
            else if(chkItalic.isSelected()){
                text.setFont(fontItalic);
            }
            else{
                text.setFont(fontRegular);
            }
        };
        
        btnLeft.setOnAction(e->{
            text.setX(text.getX()-10);
        });
        btnRight.setOnAction(e->{
            text.setX(text.getX()+10);
        });
        chkBold.setOnAction(handler);
        chkItalic.setOnAction(handler);
        root.setRight(vbox);
        root.setCenter(pane);
        root.setBottom(hbox);
        return root;
    }
    @Override
    public void start(Stage primaryStage) {
        
        Scene scene = new Scene(getBorderPane(),600,300);
        primaryStage.setTitle("Check Box Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
