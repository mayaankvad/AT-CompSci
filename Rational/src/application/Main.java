//WARNING: PLEASE INCLUDE JFOENIX.JAR IN THE BUILD PATH
//OR ELSE THIS WILL NOT COMPILE
//
//YOU ALSO NEED THE E(FX)CLIPSE PLUGIN
//AND THIS PROJECT HAS TO INCLUDE THE JavaFX SDK in the build path
//(with the e(fx)clipse plugin, this should be a New JavaFX Project)

// Mayaank Vadlamani, Bharath Hegde 

package application;

import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

/*
 * Controller for view.fxml and main user-interface/action logic
 */
public class Main extends Application {
	
	
	//Instance variables for all the
	//fields, buttons, and labels in the
	//FXML user interface
	@FXML
	private JFXTextField denominator1;

	@FXML
	private JFXTextField denominator2;

	@FXML
	private JFXTextField numerator1;

	@FXML
	private JFXTextField numerator2;

	@FXML
	private Label error;
	
	@FXML
	private Label outputNumerator;
	
	@FXML
	private Label outputDenominator;
	
	@FXML
	private Label multiRationalHeading;
	
	@FXML
	private JFXButton prevRational;
	
	@FXML
	private JFXButton nextRational;
	
	@FXML
	private JFXButton deleteRational;

	
	public static int numRationals = 2; //used for adding and removing rationals in multi-rational calculations, but not for knowing the size of the rationals arraylist.
	public static int currentRationalID = -1; // array list holds only extra rationals
	
	
	public static ArrayList<Rational> rationals = new ArrayList<Rational>();
	
	private Rational rational2Backup;
	
	// called inside operation functions 
	// this makes sure the current rational being entered (if it is a "extra" rational (after #2))
	// is inside the rationals ArrayList 
	@FXML void verifyCurrentFracInList() {
		if(currentRationalID != -1)
		{
			
			try {
				
				int num = Integer.valueOf(numerator2.getText());
				int den = Integer.valueOf(denominator2.getText());
				
				if(num == 0 || den == 0) {
					error.setText("Can't divide by zero. Denominators of zero have been set to 1.");
				}
				if(rationals.size() >= currentRationalID + 1) {
					rationals.set(currentRationalID, new Rational(num, den));
				} else {
					rationals.add(new Rational(num, den));
				}
				
			} catch (NumberFormatException e){
				error.setText("Type in actual numbers");
				setOutput(null);
				return;
			}
		
		}
	}
	
	
	//This deletes the current "extra" (past #2) rational
	//being entered from the arraylist
	@FXML
	void deleteRationalButton(ActionEvent event) {
		error.setText("");
		
		if(rationals.size() >= currentRationalID + 1) { 
			rationals.remove(currentRationalID);
		}
		
		if(currentRationalID == 0) {
			numerator2.setText("" + rational2Backup.getNumerator());
			denominator2.setText("" + rational2Backup.getDenominator());
			
			
			prevRational.setDisable(true);
			deleteRational.setDisable(true);
			
		} else {
			Rational prevFraction = rationals.get(currentRationalID - 1);
			numerator2.setText("" + prevFraction.getNumerator());
			denominator2.setText("" + prevFraction.getDenominator());
		}
		
		currentRationalID--;
		
		
		
		multiRationalHeading.setText("Rational " + (currentRationalID + 3));
	}
	
	
	//This scrolls back to the previous rational
	//in the multi-rational editor
	@FXML
	void prevRationalButton(ActionEvent event) {
		
		error.setText("");
		 
		try {

			int num = Integer.valueOf(numerator2.getText());
			int den = Integer.valueOf(denominator2.getText());
				
			if(num == 0 || den == 0) {
				error.setText("Can't divide by zero. Denominators of zero have been set to 1.");
			}
			
			if(rationals.size() >= currentRationalID + 1) {
				rationals.set(currentRationalID, new Rational(num, den));
			} else {
				rationals.add(new Rational(num, den));
			}
		} catch (NumberFormatException e){
			error.setText("Type in actual numbers");
			setOutput(null);
			return;
		}
		
		if(currentRationalID == 0) {
			numerator2.setText("" + rational2Backup.getNumerator());
			denominator2.setText("" + rational2Backup.getDenominator());
			
			
			prevRational.setDisable(true);
			deleteRational.setDisable(true);
			
		} else {
			Rational prevFraction = rationals.get(currentRationalID - 1);
			numerator2.setText("" + prevFraction.getNumerator());
			denominator2.setText("" + prevFraction.getDenominator());
		}
		
		currentRationalID--;
		
		
		
		multiRationalHeading.setText("Rational " + (currentRationalID + 3));
	}
	
	//this scrolls forward to the 
	//next rational in the multi-rational editor
	@FXML
	void nextRationalButton(ActionEvent event) {
		error.setText("");
		
		if(currentRationalID == -1) {
			Rational[] rationalOneAndTwo = getRationals();
			if(rationalOneAndTwo == null) {
				error.setText("Fill out two rationals before trying to add another");
				return;
			}
			
			rational2Backup = new Rational(rationalOneAndTwo[1].getNumerator(), rationalOneAndTwo[1].getDenominator());
			
		} else {
			try {
				
				int num = Integer.valueOf(numerator2.getText());
				int den = Integer.valueOf(denominator2.getText());
				
				if(num == 0 || den == 0) {
					error.setText("Can't divide by zero. Denominators of zero have been set to 1.");
				}
				if(rationals.size() >= currentRationalID + 1) {
					rationals.set(currentRationalID, new Rational(num, den));
				} else {
					rationals.add(new Rational(num, den));
				}
				
			} catch (NumberFormatException e){
				error.setText("Type in actual numbers");
				setOutput(null);
				return;
			}
			
		}
		
		numRationals++;
		currentRationalID++;
		
		if(prevRational.isDisabled()) {
			prevRational.setDisable(false);
		}
		if(deleteRational.isDisabled()) {
			deleteRational.setDisable(false);
		}
		
		if(rationals.size() >= currentRationalID + 1) {
			Rational nextFraction = rationals.get(currentRationalID);
			numerator2.setText("" + nextFraction.getNumerator());
			denominator2.setText("" + nextFraction.getDenominator());
		} else {
			numerator2.setText("");
			denominator2.setText("");
		}
		
		multiRationalHeading.setText("Rational " + (currentRationalID + 3));
		
	}
	
	/**
	 * addBtn
	 * 
	 * Controller function for the add button. It gets the two rationals
	 * and displays the result in the output fraction.
	 * @param event
	 */
	
	@FXML
	void addBtn(ActionEvent event) {
		error.setText("");
		
		verifyCurrentFracInList();
		
		Rational[] oneAndTwo = getRationals();
		if(oneAndTwo == null) {
			return;
		}
		
		
		Rational sum = oneAndTwo[0].add(oneAndTwo[1]);
		for(Rational extra : rationals) {
			
			sum = sum.add(extra);
		}
		
		setOutput(sum);
	}

	
	/**
	 * subtractBtn
	 * 
	 * Controller function for the subtract button. It gets the two rationals
	 * and displays the result in the output fraction.
	 * @param event
	 */
	@FXML
	void subtractBtn(ActionEvent event) {
		error.setText("");
		
		verifyCurrentFracInList();
	
		Rational[] oneAndTwo = getRationals();
		if(oneAndTwo == null) {
			return;
		}
		
		
		Rational sum = oneAndTwo[0].subtract(oneAndTwo[1]);
		for(Rational extra : rationals) {
			
			sum = sum.subtract(extra);
		}
		
		setOutput(sum);
	}

	
	/**
	 * multiplyBtn
	 * 
	 * Controller function for the multiply button. It gets the two rationals
	 * and displays the result in the output fraction.
	 * @param event
	 */
	@FXML
	void multiplyBtn(ActionEvent event) {
		error.setText("");
		
		verifyCurrentFracInList();
		
		Rational[] oneAndTwo = getRationals();
		if(oneAndTwo == null) {
			return;
		}
		
		
		Rational product = oneAndTwo[0].multiply(oneAndTwo[1]);
		for(Rational extra : rationals) {
		
			product = product.multiply(extra);
		}
		
		setOutput(product);
	}
	
	
	/**
	 * divideBtn
	 * 
	 * Controller function for the divide button. It gets the two rationals
	 * and displays the result in the output fraction.
	 * @param event
	 */
	@FXML
	void divideBtn(ActionEvent event) {
		error.setText("");
		
		verifyCurrentFracInList();
		
		Rational[] oneAndTwo = getRationals();
		if(oneAndTwo == null) {
			return;
		}
		
		
		Rational quotient = oneAndTwo[0].divide(oneAndTwo[1]);
		for(Rational extra : rationals) {
			
			quotient = quotient.divide(extra);
		}
		
		setOutput(quotient);
	}

	
	/**
	 * equalityBtn
	 * 
	 * only compares first two rationals
	 * Controller function for the equality button. It gets the first two rationals
	 * and displays whether they are equal in the text label. If not, it says
	 * which fraction is greater than the other (in reduced form)
	 * @param event
	 */
	@FXML
	void equalityBtn(ActionEvent event) {
		error.setText("");
		
		Rational[] r = getRationals();
		if(r == null) {
			return;
		}
		if(r[0].compareTo(r[1]) == 0) {
			error.setText("Rational 1 & 2 Equal");
		} 
		else if(r[0].compareTo(r[1]) == 1) {
			error.setText("Rational 1 is greater than Rational 2");
		}
		else if(r[0].compareTo(r[1]) == -1) {
			error.setText("Rational 2 is greater than Rational 1");
		}
	}

	
	
	/**
	 * resetBtn
	 * 
	 * Controller function for the equality button. It clears the text
	 * fields for the rationals, and the results
	 * @param event
	 */
	@FXML
	void resetBtn(ActionEvent event) {
		setOutput(null);
		error.setText("");
		numerator1.setText("");
		denominator1.setText("");
		numerator2.setText("");
		denominator2.setText("");
		
		rationals.clear();
		currentRationalID = -1;
		rational2Backup = null;
		numRationals = 2;
		
		multiRationalHeading.setText("Rational 2");
		deleteRational.setDisable(true);
		prevRational.setDisable(true);
	}
	
	/**
	 * getRationals
	 * 
	 * Returns an array of two rationals which correspond to the 
	 * numerator and denominators the user entered.
	 * 
	 * @return Rational[]
	 */
	Rational[] getRationals() {
		try {
			int n1 = Integer.valueOf(numerator1.getText());
			int d1 = Integer.valueOf(denominator1.getText());
			int n2 = Integer.valueOf(numerator2.getText());
			int d2 = Integer.valueOf(denominator2.getText());
			
			if(n1 == 0 || d1 == 0 || n2 == 0 || d2 == 0) {
				error.setText("Cannot divide by 0. Set to 1");
			}
			
			if(currentRationalID == -1) {
				return new Rational[] {new Rational(n1, d1), new Rational(n2, d2)};
			} else {
				return new Rational[] {new Rational(n1, d1), rational2Backup};
			}
			
			
		} catch (NumberFormatException e){
			error.setText("");
			setOutput(null);
		}
		return null;
	}
	
	
	/**
	 * setOutput
	 * 
	 * This sets the output fraction bar to 'output'
	 * 
	 * @param output
	 */
	void setOutput(Rational output) {
		if (output == null) {
			outputNumerator.setText("");
			outputDenominator.setText("");
		}
		else {
			outputNumerator.setText(Integer.toString(output.getNumerator()));
			outputDenominator.setText(Integer.toString(output.getDenominator()));
		}
	}
	
	
	/**
	 * start
	 * 
	 * This creates the root view (loaded from a FXML layout), 
	 * creates the main scene, and initializes the javaFX application
	 * 
	 * @param primaryStage
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			//Load the FXML layout with our buttons, text fields, etc. into
			//a root scene node
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view.fxml"));
	        
			
			
			//Create a new JavaFX scene (view)
	        Scene scene = new Scene(root);
	        scene.getStylesheets().add(getClass().getClassLoader().getResource("view.css").toExternalForm());

	        primaryStage.setScene(scene); //set the stage to this scene
			primaryStage.setResizable(false); //prevent the user from resizing the window
			primaryStage.centerOnScreen(); //center the window on the user's screen
			primaryStage.setTitle("Rational by Mayaank & Bharath"); //set the window title
			primaryStage.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("icon.png"))); //set the icon of the window
			primaryStage.show(); //display the window
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		launch(args);
	}
}
