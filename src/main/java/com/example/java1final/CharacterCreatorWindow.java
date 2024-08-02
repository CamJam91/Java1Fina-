package com.example.java1final;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ListView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import javafx.stage.Popup;

public class CharacterCreatorWindow extends Application{
    @Override
    public void start(Stage primaryStage){
        //file for saving data
        File charFile = new File("CharacterData.txt");
        //error popUp for IOExceptions
        StackPane errorPage = new StackPane(new Label("Character file not found"));
        Stage errorStage = new Stage();
        errorStage.setTitle("Character Info");
        Scene errorScene = new Scene(errorPage, 200, 100);
        errorStage.setScene(errorScene);

        //lists
        ArrayList<String> characterNames = new ArrayList<>(); //holds character names for user viewing
        ArrayList<Character>characters = FileHandler.readCharacter(charFile); //holds character objects for exporting and importing data
        for (Character character : characters) {
            characterNames.add(character.getName()); //get names from character array
             }//import file data into char array


        //list view
        ObservableList<String> charactersOL = FXCollections.observableArrayList(characterNames);
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
        VBox centerVB = new VBox();


        //buttons
        Button createCharacter = new Button("Create");
        Button deleteCharacter = new Button("Delete");
        Button newCharacter = new Button("New Character");
        //character class radios
        ToggleGroup characterClassRadios = new ToggleGroup();
            //radio buttons that trigger image changes
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
        TextField nameTF = new TextField();
        //stat Text Fields
        TextField strengthTF = new TextField(); TextField dexTF = new TextField(); TextField constTF = new TextField();
        TextField intelTF = new TextField(); TextField wisTF = new TextField(); TextField charTF = new TextField();

        //images
        Image defaultImg = new Image(getClass().getResourceAsStream("/images/default.jpg"));
        Image fighterImg = new Image(getClass().getResourceAsStream("/images/fighter.jpg"));
        Image rogueImg = new Image(getClass().getResourceAsStream("/images/rogue.jpg"));
        Image wizardImg = new Image(getClass().getResourceAsStream("/images/wizard.jpg"));
        Image bardImg = new Image(getClass().getResourceAsStream("/images/bard.jpg"));
        ImageView characterIV = new ImageView(defaultImg);



        /**********************************************************************************************
         * *********************add children*********************************************************
         * *****************************************************************************************/
        //buttons
        characterClassVB.getChildren().addAll(fighterRB, rogueRB, wizardRB, bardRB);
        //boxes
        createCharacterHB.getChildren().addAll(deleteCharacter,namePrompt,nameTF,createCharacter);
        listVB.getChildren().addAll(listPrompt,newCharacter,charactersLV);
        statRadioVB.getChildren().addAll(customRB, defaultRB);
        //statfield box adds anonymous children
        statFieldVB.getChildren().addAll(strengthLB, strengthTF, dexLB, dexTF, constLB, constTF, intelLB, intelTF, wisLB, wisTF, charLB, charTF);
        centerVB.getChildren().addAll(statFieldHB, characterIV);
        statFieldHB.getChildren().addAll(statFieldVB, statRadioVB);
        //borderPanes
        CharacterCreationBox.setBottom(createCharacterHB);
        CharacterCreationBox.setRight(characterClassVB);
        CharacterCreationBox.setLeft(listVB);
        CharacterCreationBox.setCenter(centerVB);

        /******************************************************************************************
         * ******************     margins, sizes, alignments, etc.      ***************************
         * ****************************************************************************************
         */
        //images
        characterIV.setFitWidth(200);
        characterIV.setPreserveRatio(true);
        //buttons
        createCharacter.getStyleClass().add("buttons");
        deleteCharacter.getStyleClass().add("buttons");
        //boxes
        createCharacterHB.setSpacing(15);
        createCharacterHB.setPadding(new Insets(0,0,10,0));
        centerVB.getStyleClass().add("centerBox");
        statFieldVB.getStyleClass().add("statBox");
        statFieldHB.getStyleClass().add("statField");
        //Textfields
        nameTF.getStyleClass().add("characterName");
        //panes
            //dummy top pane
        Pane topPane = new Pane();
        topPane.setPrefSize(0,0);
        CharacterCreationBox.setTop(topPane);

        /******************************************************************************************************
         * ********************        Action Handling       *************************************************
         * *************************************************************************************************/
        //class type radios
        fighterRB.setOnAction(e -> {
            if (fighterRB.isSelected()){
                characterIV.setImage(fighterImg);
            }
        });
        rogueRB.setOnAction(e -> {
            if (rogueRB.isSelected()){
                characterIV.setImage(rogueImg);
            }
        });
        wizardRB.setOnAction(e -> {
            if (wizardRB.isSelected()){
                characterIV.setImage(wizardImg);
            }
        });
        bardRB.setOnAction(e -> {
            if (bardRB.isSelected()){
                characterIV.setImage(bardImg);
            }
        });
        //stat fields
        defaultRB.setOnAction(e ->{
            if (defaultRB.isSelected()){
                strengthTF.setText("5");
                dexTF.setText("5");
                constTF.setText("5");
                wisTF.setText("5");
                intelTF.setText("5");
                charTF .setText("5");
            }
        });

            //action button for when the create button is hit, Character.name is added to listview, Character object stats are added to characaters array then file
        createCharacter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Character newCharacter = new Character(nameTF.getText()); //create a new character
                    //create stats array to fill the character stats array
                int [] newStats = new int[6];
                newStats[0] = Integer.parseInt(strengthTF.getText()); newStats[1] = Integer.parseInt(dexTF.getText()); newStats[2] = Integer.parseInt(constTF.getText());
                newStats[3] = Integer.parseInt(wisTF.getText()); newStats[4] = Integer.parseInt(intelTF.getText()); newStats[5] = Integer.parseInt(charTF.getText());
                    //for each stat call the setStat method and fill
                for (int count = 0; count < newStats.length; count++) {
                    newCharacter.setStat(count, newStats[count]);
                }
                characters.add(newCharacter); //add object to file
                charactersOL.add(newCharacter.getName()); //add character name to list
                int charWrite = FileHandler.characterWriter(charFile,characters); //write to file, return nonzero on fail
                if (charWrite > 0)
                    errorStage.show();
            }
        });
            //listview event
            //listener for when a listview item is selected
        charactersLV.getSelectionModel().selectedItemProperty().addListener(charSelect ->{
            createCharacter.setDisable(true); //disable create button
                //popup action
            //popup
            Popup statsPopup = new Popup();
                for (Character character : characters) {
                    characterNames.add(character.getName()); //get names from character array
                }
                int position = charactersLV.getSelectionModel().getSelectedIndex();
                Character character = characters.get(position);
                //create labels to dynamically fill the popup with character info
                Label namePopLB = new Label(characters.get(position).getName());
                Label strengthPopLB = new Label(String.valueOf(characters.get(position).getStat(0))); Label dexPopLB = new Label(String.valueOf(characters.get(position).getStat(1))); Label constPopLB = new Label(String.valueOf(characters.get(position).getStat(2))); Label intelPopLB = new Label(String.valueOf(characters.get(position).getStat(3))); Label wisPopLB = new Label(String.valueOf(characters.get(position).getStat(4))); Label charPopLB = new Label(String.valueOf(characters.get(position).getStat(5)));
                VBox mainPane = new VBox();
                mainPane.getChildren().addAll(namePopLB,new HBox(new Label("Strength: "), strengthPopLB), new HBox(new Label("Dexterity: "), dexPopLB), new HBox(new Label("Constitution: "), constPopLB), new HBox(new Label("Intelligence: "), intelPopLB), new HBox(new Label("Wisdom: "), wisPopLB), new HBox(new Label("Charisma: "), charPopLB));

                    //show popUp
                Stage popUpStage = new Stage();
                popUpStage.setTitle("Character Info");
                Scene popUpScene = new Scene(mainPane, 250, 250);
                popUpStage.setScene(popUpScene);
                popUpStage.show();

        });
            //enable create character button
        newCharacter.setOnAction(e ->{
            createCharacter.setDisable(false);
        });

            //delete
        deleteCharacter.setOnAction(e ->{
           int position = charactersLV.getSelectionModel().getSelectedIndex(); //get positin of target object
            if(position>=0){ //ensure legal position
                //delete in GUI
                characters.remove(position); //delete in char array
                charactersOL.remove(position); //delete in observable list
                //delete in file
                int charWrite = FileHandler.characterWriter(charFile, characters); //update fiile
                if (charWrite > 0) //show error on nonzero value
                    errorStage.show();
            }

        });

        /**************************************************************
         * *********        Startup Code         **********************
         * ************************************************************
         */

        //create scene
        Scene CharacterCreation = new Scene(CharacterCreationBox, 700, 600);
        CharacterCreation.getStylesheets().add(getClass().getResource("/styles/CharacterCreator.css").toExternalForm());
        primaryStage.setTitle("Character Creator");
        //add our scene to the primary stage
        primaryStage.setScene(CharacterCreation);
        primaryStage.show();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}