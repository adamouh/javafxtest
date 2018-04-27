package javafxtest;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafxtestutilities.SideBarSliderAnimation;

public class TestController implements Initializable{
	
	@FXML
	private Label sideBarButton;
	
	@FXML
	private JFXButton sideBarBtn;
	
	@FXML
	private VBox sideBar;
	
	@FXML
	private VBox sideBarRight;
	
	@FXML
	private Button swithcSlideEffectButton;
	
	@FXML
	private BorderPane container;
	
	private SideBarSliderAnimation sideBarAnimation;
	private Pane sideBarMenu;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sideBarAnimation = SideBarSliderAnimation.getInstance();
		sideBarMenu = sideBar;
		sideBarButton.setOnMouseClicked(e->{
			runSlideAnimation();
		});
		
		swithcSlideEffectButton.setOnAction(e->{
			switchSlideAnimation();
		});
	}
	
	private void runSlideAnimation(){
		sideBarAnimation.run(sideBarMenu);
	}
	
	private void switchSlideAnimation(){
		if(sideBarMenu == sideBarRight)
			sideBarMenu = sideBar;
		else if(sideBarMenu == sideBar)
			sideBarMenu  = sideBarRight;
	}
	
	

}
