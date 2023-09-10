package com.risorlet.FXculator;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

//a vertical box to contain everything which is technically the root of the scene tree
public class view extends VBox {
    //custom font
    Font font;

    //stuff for the text field
    Rectangle rect;
    StackPane pane;
    Text field;

    //all the rows to contain the numbers and operators
    HBox row1;
    HBox row2;
    HBox row3;
    HBox row4;
    
    //buttons for numbers

    Button num1 = new Button("1");
    Button num2 = new Button("2");
    Button num3 = new Button("3");
    Button num4 = new Button("4");
    Button num5 = new Button("5");
    Button num6 = new Button("6");
    Button num7 = new Button("7");
    Button num8 = new Button("8");
    Button num9 = new Button("9");
    Button num0 = new Button("0");

    //buttons for operators
    Button opAdd = new Button("?");
    Button opSubtract = new Button("-");
    Button opMultiply = new Button("x");
    Button opDivision = new Button("/");

    //calculation button
    Button equalTo = new Button("=") ;

    //constructor
    public view(Font font){

        //font for the whole app
        this.font = font;

        //intitializing the main VBox component that'll hold everything
        this.setHeight(600);
        this.setWidth(700);
        this.setAlignment(Pos.CENTER);
        
        //setting up the rectangular field where out text will go;
        rect = new Rectangle(230,50);
        rect.setFill(Color.TRANSPARENT);
        rect.setStroke(Color.LIGHTGRAY);
        rect.setStrokeWidth(2);
        field = new Text("Fxculator");
        field.setFont(font);
        field.setTextAlignment(TextAlignment.RIGHT);

        //creating an controller instance
        Controller control = new Controller();
        control.setOutput(field);

        //adding our rect and text field to a stackpane to stack them up on top of eachother
        pane = new StackPane(rect,field);
        pane.setAlignment(Pos.CENTER);
        
        //setting up the size of every button
        num1.setPrefWidth(50);
        num1.setFont(font);
        num1.setOnAction(control::processNumpad);
        num2.setPrefWidth(50);
        num2.setFont(font);
        num2.setOnAction(control::processNumpad);
        num3.setPrefWidth(50);
        num3.setFont(font);
        num3.setOnAction(control::processNumpad);
        num4.setPrefWidth(50);
        num4.setFont(font);
        num4.setOnAction(control::processNumpad);
        num5.setPrefWidth(50);
        num5.setFont(font);
        num5.setOnAction(control::processNumpad);
        num6.setPrefWidth(50);
        num6.setFont(font);
        num6.setOnAction(control::processNumpad);
        num7.setPrefWidth(50);
        num7.setFont(font);
        num7.setOnAction(control::processNumpad);
        num8.setPrefWidth(50);
        num8.setFont(font);
        num8.setOnAction(control::processNumpad);
        num9.setPrefWidth(50);
        num9.setFont(font);
        num9.setOnAction(control::processNumpad);
        num0.setPrefWidth(110);
        num0.setFont(font);
        num0.setOnAction(control::processNumpad);

        opAdd.setPrefWidth(50);
        opAdd.setFont(font);
        opAdd.setOnAction(control::processOperator);
        opSubtract.setPrefWidth(50);
        opSubtract.setFont(font);
        opSubtract.setOnAction(control::processOperator);
        opDivision.setPrefWidth(50);
        opDivision.setFont(font);
        opDivision.setOnAction(control::processOperator);
        opMultiply.setPrefWidth(50);
        opMultiply.setFont(font);
        opMultiply.setOnAction(control::processOperator);
        equalTo.setPrefWidth(50);
        equalTo.setFont(font);
        equalTo.setOnAction(control::processOperator);

        //setting up every row and adding the buttons to them

        row1 = new HBox(10);
        row1.getChildren().addAll(num7,num8,num9,opDivision);
        row1.setAlignment(Pos.CENTER);

        row2 = new HBox(10, num4,num5,num6,opMultiply);
        row2.setAlignment(Pos.CENTER);

        row3 = new HBox(10, num1,num2,num3,opSubtract);
        row3.setAlignment(Pos.CENTER);

        row4 = new HBox(10, num0,equalTo,opAdd);
        row4.setAlignment(Pos.CENTER);

        //adding everything to the main VBox component
        this.getChildren().addAll(pane,row1,row2,row3,row4);
    }
}
