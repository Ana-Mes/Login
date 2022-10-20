package dad.login;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
	
	private StringProperty nombre = new SimpleStringProperty();
	private StringProperty password = new SimpleStringProperty();
	private BooleanProperty useLdap = new SimpleBooleanProperty();
	
	public final StringProperty nombreProperty() {
		return this.nombre;
	}
	
	public final String getNombre() {
		return this.nombreProperty().get();
	}
	
	public final void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}
	
	public final StringProperty passwordProperty() {
		return this.password;
	}
	
	public final String getPassword() {
		return this.passwordProperty().get();
	}
	
	public final void setPassword(final String password) {
		this.passwordProperty().set(password);
	}

	public final BooleanProperty useLdapProperty() {
		return this.useLdap;
	}
	

	public final boolean UseLdap() {
		return this.useLdapProperty().get();
	}
	

	public final void setUseLdap(final boolean useLdap) {
		this.useLdapProperty().set(useLdap);
	}
	
	
	
	
}
