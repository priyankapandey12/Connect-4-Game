package com.internshala.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
private Controller Controller;
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
	    GridPane rootGridPane = loader.load();
	    Controller = loader.getController();
	    Controller.createPlayground();
	    MenuBar menuBar = createMenu();
	    menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
	 Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
	 menuPane.getChildren().add(menuBar);
	    Scene scene = new Scene(rootGridPane);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("Connect Four");
	    primaryStage.setResizable(false);
	    primaryStage.show();
    }
    private MenuBar createMenu(){
	Menu fileMenu = new Menu("File");
	MenuItem newGame = new MenuItem("New game");
	newGame.setOnAction(event -> Controller.resetGame());
	MenuItem resetGame = new MenuItem("Reset game");
	resetGame.setOnAction(event -> Controller.resetGame());
	SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
	MenuItem exitGame = new MenuItem("Exit game");
	exitGame.setOnAction(event -> exitGame());
	fileMenu.getItems().addAll(newGame,resetGame,separatorMenuItem,exitGame);
	Menu helpMenu = new Menu("Help");
	MenuItem aboutGame = new MenuItem("About Connect4");
	aboutGame.setOnAction(event -> aboutConnect4());
	SeparatorMenuItem separator = new SeparatorMenuItem();
	MenuItem aboutMe = new MenuItem("About Me");
	aboutMe.setOnAction(event -> aboutMe());
	helpMenu.getItems().addAll(aboutGame,separator,aboutMe);
	MenuBar menuBar = new MenuBar();
	menuBar.getMenus().addAll(fileMenu,helpMenu);
	return menuBar;
}

	private void aboutMe() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About The Developer");
		alert.setHeaderText("Priyanka Pandey");
		alert.setContentText("I love to play around with the code and create Games." +
						  "Connect 4 is one of them.In free time " +
		                   "I like to spend time.");
		alert.show();

	}

	private void aboutConnect4() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About Connect Four");
		alert.setHeaderText("How To Play?");
		alert.setContentText("Connect Four is a two player game in which the " +
				"players first choose a color and then take turns dropping colored discs " +
				"from the top into a seven-column,six -row vertically suspended grid. " +
				"The pieces fall straight down, Occupying the next available space with in column. " +
				"The objective of the game is to be the first to form a horizontal,vertical," +
				"or diagonal line of four of one's own discs.Connect Four is a solved game." +
				"The first player can always win by playing thr right moves.");
		alert.show();
	}

	private void exitGame() {
		Platform.exit();
		System.exit(0);
	}

	private void resetGame() {
    	//To do
	}

	public static void main(String[] args) {
        launch(args);
    }
}
