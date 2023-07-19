package com.test1.test1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class movieTicketingSystem extends Application {

    TextField movieTextField = new TextField();
    //A text field to let user input movie name
    TextField seatsTextField = new TextField();
    //A text field to let user input seats
    ComboBox<String> expComboBox = new ComboBox<>();

    //Declare the variable to use
    String movieOutput = "";
    double expOutput = 0;
    String sessionOutput = "";
    String seatsOutput = "";
    double fnbOutput = 0;
    String fnbSelectedString = "";
    String exceptionString ="";
    int pax = 1;

    //radioButton
    RadioButton rb1100A = new RadioButton("11:00 AM");
    RadioButton rb0130P = new RadioButton("01:30 PM");
    RadioButton rb0400P = new RadioButton("04:00 PM");
    RadioButton rb0630P = new RadioButton("06:30 PM");
    RadioButton rb0900P = new RadioButton("09:00 PM");

    RadioButton rbPop1 = new RadioButton("RM 19.90");
    RadioButton rbPop2 = new RadioButton("RM 17.90");
    RadioButton rbPop3 = new RadioButton("RM 21.90");


    @Override
    public void start(Stage stage) throws IOException {
        BorderPane border = new BorderPane();
        Scene scene = new Scene(border);

        //Set the window cant be resize by user
        stage.setResizable(false);

        //Insert all the methods
        VBox mainBox  = new VBox(movieBox(),experienceHBox(),sessionHBox(),seatsBox(),fnbBox(),submitHBox());
        border.setTop(mainBox);

        //Title
        stage.setTitle("Movie Ticketing System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public HBox movieBox(){
        //Create a Label ("Movie"), set padding.
        Label movieLabel = new Label("Movie");
        movieLabel.setPadding(new Insets(5,52,5,0));

        //Styling
        movieTextField.setPrefSize(600,25);

        //Create a HBox to collect them and return to mainBox
        HBox movieHBox = new HBox(movieLabel,movieTextField);
        movieHBox.setSpacing(15);
        movieHBox.setPadding(new Insets(15,10,15,10));
        return movieHBox;
    }

    public HBox experienceHBox()
    {
        //Create a Label ("Experience"), set padding.
        Label expLabel = new Label("Experience");
        expLabel.setPadding(new Insets(5,43,5,0));

        //Customising ComboBox
        expComboBox.setValue("Choose Your Experience");
        expComboBox.getItems().addAll("Beanie","Classic","Deluxe","Family-Friendly",
                                        "Flexound","IMAX","Indulge","Infinity","Junior","Onyx");


        //Insert to HBox
        HBox experineceHBox = new HBox(expLabel,expComboBox);
        experineceHBox.setPadding(new Insets(15,10,15,10));
        return experineceHBox;
    }

    public HBox sessionHBox()
    {
        //Create a Label ("Session"), set padding.
        Label sessionLabel = new Label("Session");
        sessionLabel.setPadding(new Insets(55,40,0,0));

        //Set the toggle group
        ToggleGroup tgSession = new ToggleGroup();
        rb1100A.setToggleGroup(tgSession);
        rb0130P.setToggleGroup(tgSession);
        rb0400P.setToggleGroup(tgSession);
        rb0630P.setToggleGroup(tgSession);
        rb0900P.setToggleGroup(tgSession);

        //Create the gap between radiobutton
        VBox rb1 = new VBox(rb1100A);
        rb1.setPadding(new Insets(0,0,10,0));
        VBox rb2 = new VBox(rb0130P);
        rb2.setPadding(new Insets(0,0,10,0));
        VBox rb3 = new VBox(rb0400P);
        rb3.setPadding(new Insets(0,0,10,0));
        VBox rb4 = new VBox(rb0630P);
        rb4.setPadding(new Insets(0,0,10,0));
        VBox rb5 = new VBox(rb0900P);
        rb5.setPadding(new Insets(0,0,10,0));

        //Group the RadioButton into a VBox
        VBox rbBox = new VBox(rb1,rb2,rb3,rb4,rb5);
        rbBox.setPadding(new Insets(0,0,0,20));

        //Insert All into a HBox
        HBox sessionHBox = new HBox(sessionLabel,rbBox);
        sessionHBox.setPadding(new Insets(15,10,15,10));

        return sessionHBox;

    }

    public HBox seatsBox(){
        //Create a Label ("Seats"), set padding.
        Label seatsLabel = new Label("Seats");
        seatsLabel.setPadding(new Insets(5,58,5,0));

        //Styling
        seatsTextField.setPrefSize(600,25);

        //Create a HBox to collect them and return to mainBox
        HBox seatsHBox = new HBox(seatsLabel,seatsTextField);
        seatsHBox.setSpacing(15);
        seatsHBox.setPadding(new Insets(15,10,15,10));
        return seatsHBox;
    }

    public HBox fnbBox()
    {
        GridPane grid = new GridPane();
        //Create a Label ("Food & Beverage"), set padding.
        Label fnbLabel = new Label("Food & Beverage");
        fnbLabel.setPadding(new Insets(90,10,5,0));

        //Setting the image, imageview, size, label and radiobutton, collet into a Grid
        Image popcorn1Image = new Image(movieTicketingSystem.class.getResource("popcorn1.png").toString());
        ImageView popcorn1ImageView = new ImageView(popcorn1Image);
        popcorn1ImageView.setFitHeight(183);
        popcorn1ImageView.setFitWidth(261);
        Label popcorn1Label = new Label("Royal Popcorn Combo - Member Special");
        grid.add(popcorn1ImageView,0,0,1,1);
        grid.add(popcorn1Label,0,1,1,1);
        grid.add(rbPop1,0,2,1,1);


        //Setting the image, imageview, size, label and radiobutton, collet into a Grid
        Image popcorn2Image = new Image(movieTicketingSystem.class.getResource("popcorn2.png").toString());
        ImageView popcorn2ImageView = new ImageView(popcorn2Image);
        popcorn2ImageView.setFitHeight(183);
        popcorn2ImageView.setFitWidth(261);
        Label popcorn2Label = new Label("Royal Popcorn");
        grid.add(popcorn2ImageView,1,0,1,1);
        grid.add(popcorn2Label,1,1,1,1);
        grid.add(rbPop2,1,2,1,1);

        //Setting the image, imageview, size, label and radiobutton, collet into a Grid
        Image popcorn3Image = new Image(movieTicketingSystem.class.getResource("popcorn3.png").toString());
        ImageView popcorn3ImageView = new ImageView(popcorn3Image);
        popcorn3ImageView.setFitHeight(183);
        popcorn3ImageView.setFitWidth(261);
        Label popcorn3Label = new Label("Royal Popcorn Combo");
        grid.add(popcorn3ImageView,2,0,1,1);
        grid.add(popcorn3Label,2,1,1,1);
        grid.add(rbPop3,2,2,1,1);

        grid.setHgap(10);
        grid.setVgap(10);

        //Set the toggle group
        ToggleGroup tgPopcorn = new ToggleGroup();
        rbPop1.setToggleGroup(tgPopcorn);
        rbPop2.setToggleGroup(tgPopcorn);
        rbPop3.setToggleGroup(tgPopcorn);

        //Collect the items into a HBox
        HBox fnbHBox = new HBox(fnbLabel,grid);
        fnbHBox.setPadding(new Insets(15,10,15,15));
        return fnbHBox;
    }

    public HBox submitHBox()
    {
        //Create a button and put it into a HBox
        Button submitButton = new Button("Submit");
        submitButton.setTextAlignment(TextAlignment.CENTER);
        submitButton.setPrefWidth(100);
        HBox buttonHBox = new HBox(submitButton);
        buttonHBox.setAlignment(Pos.BOTTOM_RIGHT);
        buttonHBox.setPadding(new Insets(15,10,15,10));

        //Buttno Event, catch the exception will stop the button action. If no exception run until the end
        submitButton.setOnAction(event -> {
            try {
                exceptionMovieName();
                exceptionExp();
                exceptionSession();
                seatsException();
                exceptionPopcorn();

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Thank You!");
                String paxString="";
                if (pax==1)
                {
                   paxString = "1 seat(s)";
                }else paxString =pax+" seat(s)";

                //Content Text
                String contentText = "You selected "+movieTextField.getText()+" with "+expComboBox.getValue()+" experience at "+sessionOutput+" for "+paxString+" and a "+fnbSelectedString+". The total is RM "+totalPrice(pax,expOutput,fnbOutput);
                alert.setHeight(500);
                alert.setHeight(700);
                alert.setContentText(contentText);
                alert.showAndWait();
                pax=1;

            } catch (Exception exception) {
                //Print the exception message
                System.out.println(exceptionString);
            }

        });

        return buttonHBox;
    }

    public void exceptionMovieName() throws Exception
    {

            //trim remove all the whitespace and checking
            if(movieTextField.getText().trim().isEmpty())
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("Please insert a movie name.");
                alert.showAndWait();
                exceptionString = "Empty Movie Name \n";
                throw new Exception("Empty Movie Name");

            }else
            {
                //get the movie name
                movieOutput=movieTextField.getText();
            }

    }

    public void exceptionExp() throws Exception
    {
        //determine the value of the expereince
        switch(expComboBox.getValue()) {
            case "Beanie":
                expOutput = 19.90;
                break;
            case "Classic":
                expOutput = 15.90;
                break;
            case "Deluxe":
                expOutput = 23.90;
                break;
            case "Family-Friendly":
                expOutput = 23.90;
                break;
            case "Flexound":
                expOutput = 25.90;
                break;
            case "IMAX":
                expOutput = 25.90;
                break;
            case "Indulge":
                expOutput = 120.00;
                break;
            case "Infinity":
                expOutput = 120.00;
                break;
            case "Junior":
                expOutput = 15.90;
                break;
            case "Onyx":
                expOutput = 89.90;
                break;

                //if the user do not select, alert occur
            default:
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("Please select an experience");
                alert.showAndWait();
                exceptionString = "Empty Experience";
                throw new Exception("Empty Experience");
        }
    }

    public void exceptionSession() throws Exception
    {
        //determine the value of the session
        if (rb1100A.isSelected())
        {
            sessionOutput = "11:00 AM";
        }else if (rb0130P.isSelected())
        {
            sessionOutput = "01:30 PM";
        }else if (rb0400P.isSelected())
        {
            sessionOutput = "04:00 PM";
        }else if (rb0630P.isSelected())
        {
            sessionOutput = "06:30 PM";
        }else if (rb0900P.isSelected())
        {
            sessionOutput = "09:00 PM";
        }else
        {
            //if the user do not select, alert occur
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Please select a session");
            alert.showAndWait();
            exceptionString = "Empty Session";
            throw new Exception("Empty Session");
        }

    }

    public void seatsException() throws Exception
    {
        String check = seatsTextField.getText();
        Boolean validInput = false;
        //trim remove all the whitespace and checking
        if(movieTextField.getText().trim().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Please insert the seat(s).");
            alert.showAndWait();
            exceptionString = "Empty Seats \n";
            throw new Exception("Empty Seats");

        }

        //Check if the text is more than 3 letter. To make use 1 seat can be purchase e.g. A6 A13
        if (check.length()>3)
        {
            validInput =false;
                    for(int i=0;i<check.length();i++)
                    {
                        char tempChar = check.charAt(i);
                        if (tempChar == ',')
                        {
                            //found, break
                            validInput =true;
                            break;
                        }
                    }
        }else validInput = true;


        //if the user do not enter , alert occur
        if (validInput==false)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Please separate the seats with ,");
            alert.showAndWait();
            exceptionString = "Separate the seat with , \n";
            throw new Exception("Separate the seat with , ");


        }//else calculate the pax
        else calculatePax();

    }

    public void calculatePax()
    {
        //calculate the pax by the , in the string (default 1)
        String temp = seatsTextField.getText();

        for(int i=0;i<temp.length();i++)
        {
            char tempChar = temp.charAt(i);
            if (tempChar == ',')
            {
                pax++;
            }
        }
    }

    public void exceptionPopcorn() throws Exception
    {
        //determine the value of the popcorn
        if (rbPop1.isSelected())
        {
            fnbOutput = 19.90-1.99; //After discount
            fnbSelectedString="Royal Popcorn Combo – Member Special";
        }else if (rbPop2.isSelected())
        {
            fnbOutput = 17.90;
            fnbSelectedString="Royal Popcorn";
        }else if (rbPop3.isSelected())
        {
            fnbOutput = 21.90;
        fnbSelectedString="Royal Popcorn Combo";
        }
        else
        {
            //if the user do not select, alert occur
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Please select a Food & Beverage");
            alert.showAndWait();
            exceptionString = "Empty Food & Beverage";
            throw new Exception("Empty Food & Beverage");
        }

    }

    public double totalPrice(int pax,double expOutput,double fnbOutput)
    {
        //Calculate the total price and make it to 2 digit.
        double total = (pax*expOutput)+fnbOutput;
        String riggitMalaysia = String.format("%.2f", total);
        total = Double.parseDouble(riggitMalaysia);
        return total;
    }

    //    public HBox fnbBox()
//    {
//        //Create a Label ("Food & Beverage"), set padding.
//        Label fnbLabel = new Label("Food & Beverage");
//        fnbLabel.setPadding(new Insets(90,10,5,0));
//
//        //Setting the image, imageview, size, label and radiobutton, collet into a VBox
//        Image popcorn1Image = new Image(movieTicketingSystem.class.getResource("popcorn1.png").toString());
//        ImageView popcorn1ImageView = new ImageView(popcorn1Image);
//        popcorn1ImageView.setFitHeight(183);
//        popcorn1ImageView.setFitWidth(261);
//        Label popcorn1Label = new Label("Royal Popcorn Combo - Member Special");
//        VBox pop1 = new VBox(popcorn1ImageView,popcorn1Label,rbPop1);
//        pop1.setPadding(new Insets(0,10,0,0));
//
//        //Setting the image, imageview, size, label and radiobutton, collet into a VBox
//        Image popcorn2Image = new Image(movieTicketingSystem.class.getResource("popcorn2.png").toString());
//        ImageView popcorn2ImageView = new ImageView(popcorn2Image);
//        popcorn2ImageView.setFitHeight(183);
//        popcorn2ImageView.setFitWidth(261);
//        Label popcorn2Label = new Label("Royal Popcorn");
//        VBox pop2 = new VBox(popcorn2ImageView,popcorn2Label,rbPop2);
//        pop2.setPadding(new Insets(0,10,0,0));
//
//        //Setting the image, imageview, size, label and radiobutton, collet into a VBox
//        Image popcorn3Image = new Image(movieTicketingSystem.class.getResource("popcorn3.png").toString());
//        ImageView popcorn3ImageView = new ImageView(popcorn3Image);
//        popcorn3ImageView.setFitHeight(183);
//        popcorn3ImageView.setFitWidth(261);
//        Label popcorn3Label = new Label("Royal Popcorn Combo");
//        VBox pop3 = new VBox(popcorn3ImageView,popcorn3Label,rbPop3);
//        pop3.setPadding(new Insets(0,10,0,0));
//
//        //Set the toggle group
//        ToggleGroup tgPopcorn = new ToggleGroup();
//        rbPop1.setToggleGroup(tgPopcorn);
//        rbPop2.setToggleGroup(tgPopcorn);
//        rbPop3.setToggleGroup(tgPopcorn);
//
//        //Collect the items into a HBox
//        HBox fnbHBox = new HBox(fnbLabel,pop1,pop2,pop3);
//        fnbHBox.setPadding(new Insets(15,10,15,10));
//        return fnbHBox;
//    }

}



