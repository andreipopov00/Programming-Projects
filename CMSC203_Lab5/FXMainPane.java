package Lab5;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button button1,
		   button2,
		   button3,
		   button4,
		   button5,
		   button6;
	Label label;
	TextField text;
	//  declare two HBoxes
	HBox box1, 
		 box2;
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager manager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and text field
		 button1 = new Button("Hello");
		 button2 = new Button("Howdy");
		 button3 = new Button("Chinese");
		 // The "sixth" additional button added just for fun
		 button4 = new Button("Romanian");
		 button5 = new Button("Clear");
		 button6 = new Button("Exit");
		 
		 label = new Label("Feedback");
		 text = new TextField();
		//  instantiate the HBoxes
		 box1 = new HBox();
		 box2 = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
		 manager = new DataManager();
		//  set margins and set alignment of the components
		Insets inset = new Insets(15);
		HBox.setMargin(button1, inset);
		HBox.setMargin(button2, inset);
		HBox.setMargin(button3, inset);
		HBox.setMargin(button4, inset);
		HBox.setMargin(button5, inset);
		HBox.setMargin(button6, inset);
		HBox.setMargin(label, inset);
		HBox.setMargin(text, inset);
		box1.setAlignment(Pos.CENTER);
		box2.setAlignment(Pos.CENTER);
		
		 
		//student Task #3:
		//  add the label and text field to one of the HBoxes
		//  add the buttons to the other HBox
		 box1.getChildren().addAll(button1, button2, button3, button4, button5, button6);
		 box2.getChildren().addAll(label, text);
		//  add the HBoxes to this FXMainPanel (a VBox)
		 getChildren().addAll(box1, box2);
		
		 button1.setOnAction(new ButtonHandler());
		 button2.setOnAction(new ButtonHandler());
		 button3.setOnAction(new ButtonHandler());
		 button4.setOnAction(new ButtonHandler());
		 button5.setOnAction(new ButtonHandler());
		 button6.setOnAction(new ButtonHandler());
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler  implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent event)
		{
			if (event.getTarget() == button1)
				text.setText(manager.getHello());
			else if (event.getTarget() == button2)
				text.setText(manager.getHowdy());
			else if (event.getTarget() == button3)
				text.setText(manager.getChinese());
			else if (event.getTarget() == button4)
				text.setText(manager.getRomanian());
			else if (event.getTarget() == button5)
				text.setText("");
			else if (event.getTarget() == button6)
			{
				Platform.exit();
				System.exit(0);
			}
		}
	}
}