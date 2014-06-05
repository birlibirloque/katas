package org.caf.socracomm.roar;

import java.util.Set;

public class RegistroUsuarios {
	Set<String> usuariosRegistrados;
	
	public RegistroUsuarios() {
		this.usuariosRegistrados = new java.util.HashSet<String>();
	}
	public boolean estaVacio() {
		return true;
	}

	public boolean registrarUsuario(String string) {
		return this.usuariosRegistrados.add(string);
	}
		
}
