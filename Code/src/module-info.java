module Praktikum_7 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	
	opens main to javafx.graphics, javafx.fxml;
	opens controller to javafx.fxml;
	opens model to javafx.base;
}
