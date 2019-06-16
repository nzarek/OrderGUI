package application;



import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class hw6GUIController {
	
	//model object
	private hw6GUIModel guiModel;
	
	//variables to hold current selection status
	private String currentMain;
	private String currentDrink;
	
	//control declarations
	@FXML
	private ToggleGroup tgMain;
	
	@FXML
	private ToggleGroup tgDrink;
	
	@FXML
	private RadioButton rbMainNoSelection;
	
	@FXML
	private RadioButton rbMain1;

	@FXML
	private RadioButton rbMain2;
	
	@FXML
	private RadioButton rbDrinkNoSelection;
	
	@FXML
	private RadioButton rbDrink1;
	
	@FXML
	private RadioButton rbDrink2;
	
	@FXML
	private Label lblFeedback;
	
	@FXML
	private Button btnOrder;
	
	//initialize method
	@FXML
	private void initialize() {
		rbMainNoSelection.setSelected(true);
		rbDrinkNoSelection.setSelected(true);
		lblFeedback.setText("Please Select Your Order:");
		radioSelect(null); // Priming the listener event
		guiModel = new hw6GUIModel(); // Initialize model data
	}
	
	//action event for radio button clicks
	public void radioSelect(ActionEvent event) {

		//listener for determining which radio button is currently selected in group
		tgMain.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
		      public void changed(ObservableValue<? extends Toggle> changed,
		          Toggle oldVal, Toggle newVal) {
		        
		    	  RadioButton rb1 = (RadioButton) newVal;
		          currentMain = rb1.getText();

		      }
		    }); 
		
		//listener for determining which radio button is currently selected in group
		tgDrink.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
		      public void changed(ObservableValue<? extends Toggle> changed,
		          Toggle oldVal, Toggle newVal) {
		        
		    	  RadioButton rb2 = (RadioButton) newVal;
		    	  currentDrink = rb2.getText();
 
		      }
		    });
	}
	
	//order button if/elseif/else to ensure order is complete
	public void btnOrderClicked() {
		
		if (rbMainNoSelection.isSelected()) {
			lblFeedback.setText("Please select a Main Dish to complete your order");
		} else if (rbDrinkNoSelection.isSelected()) {
			lblFeedback.setText("Please select a Drink to complete your order");
		} else {
			lblFeedback.setText("Order Details: \n" + currentMain + " and " + currentDrink); 
			guiModel.setMainSelection(currentMain);
			guiModel.setDrinkSelection(currentDrink);
		}
	}
}
