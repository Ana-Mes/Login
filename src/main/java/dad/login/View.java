package dad.login;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class View extends VBox{

	private TextField nombreText;
	private PasswordField passwordField;
	private CheckBox ldapBox;
	private Button accederButton;
	private Button cancelarButton;
	
	public View() {
		super();
		
		nombreText = new TextField();
		nombreText.setPromptText("Nombre de usuario");
		
		passwordField = new PasswordField();
		passwordField.setPromptText("Contraseña del usuario");
		
		ldapBox = new CheckBox("Usar LDAP");
		
		accederButton = new Button("Acceder");
		cancelarButton = new Button("Cancelar");
		
		accederButton.setDefaultButton(true);
			
		GridPane accesoPane = new GridPane();
		accesoPane.setHgap(5);
		accesoPane.setVgap(5);
		accesoPane.addRow(0, new Label("Usuario: "), nombreText);
		accesoPane.addRow(1, new Label("Contraseña: "), passwordField);
		accesoPane.addRow(2, new Label(), ldapBox);
		
		ColumnConstraints [] cols = {
				new ColumnConstraints(),
				new ColumnConstraints(),
			};
		accesoPane.getColumnConstraints().setAll(cols);
		
		RowConstraints [] rows = {
				new RowConstraints(),
				new RowConstraints(),
				new RowConstraints(),
		};
		
		for (int row = 0; row < rows.length; row++) {
			rows[row].setPrefHeight(30);
		}
		
		this.setSpacing(15);
		this.setAlignment(Pos.CENTER);
		this.setFillWidth(false);
		this.getChildren().addAll(accesoPane, 
				new HBox(5, accederButton, cancelarButton)
				);
	}

	public TextField getNombreText() {
		return nombreText;
	}

	public PasswordField getPasswordField() {
		return passwordField;
	}

	public CheckBox getLdapBox() {
		return ldapBox;
	}

	public Button getAccederButton() {
		return accederButton;
	}

	public Button getCancelarButton() {
		return cancelarButton;
	}
	
}
