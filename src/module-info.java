module JavaFX {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires org.json;
	requires org.jsoup;
	requires java.net.http;
	
	opens main to javafx.graphics, javafx.fxml;
}
