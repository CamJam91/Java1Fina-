package com.example.java1final;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ListView;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CharacterCreatorWindow extends Application{
    @Override
    public void start(Stage primaryStage){
        //lists
        ArrayList<String> characters = new ArrayList<>();
        ObservableList<String> charactersOL = FXCollections.observableArrayList(characters);
        ListView<String> charactersLV = new ListView<>(charactersOL);
        //pane
        //main window
        BorderPane CharacterCreationBox = new BorderPane();
        //HBox
        HBox createCharacterHB = new HBox();
        HBox statFieldHB = new HBox();
        //individual statBoxes
        //VBox
        VBox characterClassVB = new VBox();
        VBox listVB = new VBox();
        VBox statRadioVBox = new VBox();
        VBox statFieldVB = new VBox();
        VBox statRadioVB = new VBox();

        //buttons
        Button createCharacter = new Button("Create");
        Button deleteCharacter = new Button("Delete");
        //character class radios
        ToggleGroup characterClassRadios = new ToggleGroup();
        RadioButton fighterRB = new RadioButton("Fighter"); RadioButton rogueRB = new RadioButton("Rogue"); RadioButton wizardRB = new RadioButton("Wizard"); RadioButton bardRB = new RadioButton("Bard");
        fighterRB.setToggleGroup(characterClassRadios); rogueRB.setToggleGroup(characterClassRadios); wizardRB.setToggleGroup(characterClassRadios); bardRB.setToggleGroup(characterClassRadios);
        //stats radios
        ToggleGroup statsTG = new ToggleGroup();
        RadioButton customRB = new RadioButton("Custom"); customRB.setToggleGroup(statsTG);
        RadioButton defaultRB = new RadioButton("Default"); defaultRB.setToggleGroup(statsTG);

        //labels
        Label namePrompt = new Label("Character name:");
        Label listPrompt = new Label("Characters");
        //stat labels
        Label strengthLB = new Label("Strength"); Label dexLB = new Label("Dexterity"); Label constLB = new Label("Constitution");
        Label intelLB = new Label("Intelligence"); Label wisLB = new Label("Wisdom"); Label charLB = new Label("Charisma");

        //textFields
        TextField characterName = new TextField();
        //stat Text Fields
        TextField strengthTF = new TextField(); TextField dexTF = new TextField(); TextField constTF = new TextField();
        TextField intelTF = new TextField(); TextField wisTF = new TextField(); TextField charTF = new TextField();




        /**********************************************************************************************
         * *********************add children*********************************************************
         * *****************************************************************************************/
        //buttons
        characterClassVB.getChildren().addAll(fighterRB, rogueRB, wizardRB, bardRB);
        //boxes
        createCharacterHB.getChildren().addAll(deleteCharacter,namePrompt,characterName,createCharacter);
        listVB.getChildren().addAll(listPrompt,charactersLV);
        statRadioVB.getChildren().addAll(customRB, defaultRB);
        //statfield box adds anaonmymouse children
        statFieldVB.getChildren().addAll(new HBox(new Label("Strength"), new TextField()), new HBox(new Label("Dexterity"), new TextField()),
                new HBox(new Label("Constitution"), new TextField()), new HBox(new Label("Intelligence"), new TextField()),
                new HBox(new Label ("Wisdom"), new TextField()), new HBox(new Label("Charisma"), new TextField()));
        statFieldHB.getChildren().addAll(statFieldVB, statRadioVB);
        //borderPanes
        CharacterCreationBox.setBottom(createCharacterHB);
        CharacterCreationBox.setRight(characterClassVB);
        CharacterCreationBox.setLeft(listVB);
        CharacterCreationBox.setCenter(statFieldHB);


        Scene CharacterCreation = new Scene(CharacterCreationBox, 400, 500);
        primaryStage.setTitle("Character Creator");
        //add our scene to the primary stage
        primaryStage.setScene(CharacterCreation);
        primaryStage.show();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}