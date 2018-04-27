package javafxtestutilities;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Parent;
import javafx.scene.layout.Region;
import javafx.util.Duration;	

public class SideBarSliderAnimation {

	private Interpolator interpolator;
	private long time;
	private Region sideBar;
	private double minWidth;
	private double maxWidth;
	private static SideBarSliderAnimation sideBarSliderAnimation;
	private boolean isMinimized;
	
	public static SideBarSliderAnimation getInstance(){
		if(sideBarSliderAnimation==null)
			sideBarSliderAnimation = new SideBarSliderAnimation();
		return sideBarSliderAnimation;
	}
	
	private SideBarSliderAnimation() {
		this.interpolator = Interpolator.LINEAR;
		this.time = 350;
		this.minWidth = 40;
		
	}

	private void minimize() {
		Timeline animation = new Timeline(
				new KeyFrame(Duration.millis(time),
						new KeyValue(sideBar.prefWidthProperty(),minWidth ,interpolator)
						)
				);
		
		animation.setCycleCount(1);
		animation.play();
		
	}

	private void maximize() {
		Timeline animation = new Timeline(
				new KeyFrame(Duration.millis(time),
						new KeyValue(sideBar.prefWidthProperty(),maxWidth ,interpolator)
						)
				);
		
		animation.setCycleCount(1);
		animation.play();
	}
	
	public void run(Region sideBar){
		// if statement for switching two sideBar (left and right)
		if(this.sideBar==null || this.sideBar!=sideBar){
			if(this.sideBar!=null && this.sideBar!=sideBar && isMinimized){
				maximize();
				isMinimized=!isMinimized;
			}
			setSideBar(sideBar);
		}
		if(isMinimized)
			maximize();
		else minimize();
		isMinimized = !isMinimized;
	}

	public Interpolator getInterpolator() {
		return interpolator;
	}

	public void setInterpolator(Interpolator interpolator) {
		this.interpolator = interpolator;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public Parent getSideBar() {
		return sideBar;
	}

	public void setSideBar(Region sideBar) {
		this.sideBar = sideBar;
		if(isPreferedWidthComputed())
			this.sideBar.setPrefWidth(this.sideBar.getWidth());
		this.maxWidth = this.sideBar.getPrefWidth();
	}
	
	private boolean isPreferedWidthComputed(){
		return (this.sideBar.getPrefWidth()==-1);
	}
	
	

}
