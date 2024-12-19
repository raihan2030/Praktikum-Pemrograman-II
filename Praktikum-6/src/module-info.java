module Praktikum_6 {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	
	opens praktikum6 to javafx.graphics, javafx.fxml, javafx.base;
}
