package main.charac;

import entity.character.players;
import entity.control.Control;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import main.SceneManager;

public class playCardBot extends playCard {
	
	private Button Cplus;
	private Button Cminus;
	
	private Button Teamplus;
	private Button Teamminus;
	
	private Button Activate;
	
	public playCardBot(players p,double posx,double posy,double width,double height) {
		super(p,posx,posy,width,height);
		Cplus = new Button(">");
		Cplus.setStyle("-fx-focus-color: transparent;-fx-background-radius: 0;-fx-background-insets: 0;");
		Cplus.setLayoutX(76);
		Cplus.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> this.player.changeChar(1));
		Cplus.addEventFilter(MouseEvent.MOUSE_ENTERED, event -> SceneManager.getCharScene().setCursor(Cursor.HAND));
		Cplus.addEventFilter(MouseEvent.MOUSE_EXITED, event -> SceneManager.getCharScene().setCursor(Cursor.DEFAULT));
		
		Cminus = new Button("<");
		Cminus.setStyle("-fx-focus-color: transparent;-fx-background-radius: 0;-fx-background-insets: 0;");
		Cminus.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> this.player.changeChar(-1));
		Cminus.addEventFilter(MouseEvent.MOUSE_ENTERED, event -> SceneManager.getCharScene().setCursor(Cursor.HAND));
		Cminus.addEventFilter(MouseEvent.MOUSE_EXITED, event -> SceneManager.getCharScene().setCursor(Cursor.DEFAULT));
		
		Teamplus = new Button(">");
		Teamplus.setStyle("-fx-focus-color: transparent;-fx-background-radius: 0;-fx-background-insets: 0;");
		Teamplus.setLayoutX(76);
		Teamplus.setLayoutY(this.getPrefHeight()-25);
		Teamplus.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> this.player.changeTeam(1));
		Teamplus.addEventFilter(MouseEvent.MOUSE_ENTERED, event -> SceneManager.getCharScene().setCursor(Cursor.HAND));
		Teamplus.addEventFilter(MouseEvent.MOUSE_EXITED, event -> SceneManager.getCharScene().setCursor(Cursor.DEFAULT));
		
		Teamminus = new Button("<");
		Teamminus.setStyle("-fx-focus-color: transparent;-fx-background-radius: 0;-fx-background-insets: 0;");
		Teamminus.setLayoutY(this.getPrefHeight()-25);
		Teamminus.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> this.player.changeTeam(-1));
		Teamminus.addEventFilter(MouseEvent.MOUSE_ENTERED, event -> SceneManager.getCharScene().setCursor(Cursor.HAND));
		Teamminus.addEventFilter(MouseEvent.MOUSE_EXITED, event -> SceneManager.getCharScene().setCursor(Cursor.DEFAULT));
		
		Activate = new Button("AC/DC");
		Activate.setStyle("-fx-focus-color: transparent;-fx-background-radius: 0;-fx-background-insets: 0;");
		Activate.setLayoutY(this.getPrefHeight()-50);
		Activate.setPrefWidth(100);
		Activate.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> this.player.toggleActive());
		Activate.addEventFilter(MouseEvent.MOUSE_ENTERED, event -> SceneManager.getCharScene().setCursor(Cursor.HAND));
		Activate.addEventFilter(MouseEvent.MOUSE_EXITED, event -> SceneManager.getCharScene().setCursor(Cursor.DEFAULT));
		
		this.getChildren().addAll(Cplus,Cminus,Teamplus,Teamminus,Activate);
	}
}