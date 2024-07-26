package com.example.java1final;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
        VBox centerVB = new VBox();

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
        listVB.getChildren().addAll(listPrompt,charactersLV);
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

        /******************************************************************************************************8
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
            //action button for when the create button is hit
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
            }
        });




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