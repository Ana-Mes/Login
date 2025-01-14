package dad.login;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import dad.login.auth.AuthService;
import dad.login.auth.FileAuthService;
import dad.login.auth.LdapAuthService;

public class Controller {
	
	private View view = new View();
	private Model model = new Model();
	
	public Controller() {
		
		//bindings
		
		model.nombreProperty().bind(view.getNombreText().textProperty());
		model.passwordProperty().bindBidirectional(view.getPasswordField().textProperty());
		model.useLdapProperty().bind(view.getLdapBox().selectedProperty());

		//listeners
		
		view.getAccederButton().setOnAction(this::onAccederAction);
		view.getCancelarButton().setOnAction(this::onCancelarAction);
		
	}

	public View getView() {
		return view;
	}
	
	public Model getModel() {
		return model;
	}
	
	private void onAccederAction(ActionEvent e) {
		AuthService auth = model.UseLdap() ? new LdapAuthService() : new FileAuthService();
		try {
			if(model.getPassword() != null && model.getNombre() != null && auth.login(model.getNombre(), model.getPassword())) {
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Iniciar sesión");
				alert.setHeaderText("Acceso permitido");
				alert.setContentText("Las credenciales de acceso son válidas");
				alert.showAndWait();
				LoginApp.primaryStage.close();
				
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Iniciar sesión");
				alert.setHeaderText("Acceso denegado");
				alert.setContentText("El usuario y/o la contraseña no son válidos");
				alert.showAndWait();
				model.setPassword(null);
			}
		} catch (Exception e1) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error");
			alert.setContentText(e1.getMessage());
			alert.showAndWait();
			e1.printStackTrace();
		}
		
	}
	
	private void onCancelarAction(ActionEvent e) {
		LoginApp.primaryStage.close();
	}
	
}
