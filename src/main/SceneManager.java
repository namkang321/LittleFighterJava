package main;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import main.menu.MenuComponent;
import main.controls.ControlsComponent;
import main.charac.CharComponent;
import main.arena.Arena;
import entity.character.AllList;

public class SceneManager {
	private static Stage primaryStage;
	private static Scene menuScene;
	private static Scene controlScene;
	private static Scene charScene;
	private static Scene arenaScene;
	
	
	public static void setMenuScene() {
		if(menuScene==null)
			menuScene = new Scene(MenuComponent.getInstance().getBackgroundPane(), Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		MenuComponent.getInstance().startSound();
		primaryStage.setScene(menuScene);
		primaryStage.setOnCloseRequest(event -> {
			MenuComponent.getInstance().stopSound();
		});
	}
	
	public static void setArena() {
		if(arenaScene==null)
		{
			arenaScene = new Scene(Arena.getInstance().getBackgroundPane(), Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
			arenaScene.addEventFilter(KeyEvent.KEY_PRESSED, event -> 
			{
				Arena.getInstance().hh(event.getCode());
			});
			arenaScene.addEventFilter(KeyEvent.KEY_RELEASED, event -> 
			{
				Arena.getInstance().ho(event.getCode());
			});
		}
		AllList.kList.clear();
		AllList.initAC();
		Arena.getInstance().newArena();
		primaryStage.setScene(arenaScene);
		primaryStage.setOnCloseRequest(event -> {
			Arena.getInstance().stopSound();
		});
	}
	
	
	public static Scene getControlScene() {
		return controlScene;
	}
	
	public static Scene getCharScene() {
		return charScene;
	}
	
	public static void setControlScene() {
		if(controlScene==null)
			controlScene = new Scene(ControlsComponent.getInstance().getBackgroundPane(), Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		ControlsComponent.getInstance().startSound();
		primaryStage.setScene(controlScene);
		
		primaryStage.setOnCloseRequest(event -> {
			ControlsComponent.getInstance().stopSound();
		});
	}
	
	public static void setCharSelectScene() {
		if(charScene==null)
		{
			charScene = new Scene(CharComponent.getInstance().getBackgroundPane(), Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
			charScene.addEventFilter(KeyEvent.KEY_PRESSED, event -> 
			{
				CharComponent.getInstance().hh(event.getCode());
			}
		);
		}
		CharComponent.getInstance().startSound();
		AllList.initPlayCard();
		CharComponent.getInstance().newRound();
		primaryStage.setScene(charScene);
		
		primaryStage.setOnCloseRequest(event -> {
			CharComponent.getInstance().stopSound();
		});
	}
	
	public static void setStage(Stage primaryStage) {
		SceneManager.primaryStage = primaryStage;
	}
}
