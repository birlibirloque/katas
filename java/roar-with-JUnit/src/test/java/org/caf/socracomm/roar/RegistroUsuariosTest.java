package org.caf.socracomm.roar;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class RegistroUsuariosTest 
    extends TestCase
{
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public RegistroUsuariosTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( RegistroUsuariosTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testCrearRegistroUsuarios()
    {
    	RegistroUsuarios registroUsuarios = new RegistroUsuarios();
        assertTrue(registroUsuarios.estaVacio());
    }
    /**
     * Rigourous Test :-)
     */
    public void testRegistraUsuario()
    {
    	RegistroUsuarios registroUsuarios = new RegistroUsuarios();
        assertTrue(registroUsuarios.registrarUsuario("@pepe"));
    }

    /**
     * Rigourous Test :-)
     */
    public void testRegistraUsuarioRepetido()
    {
    	RegistroUsuarios registroUsuarios = new RegistroUsuarios();
    	registroUsuarios.registrarUsuario("@pepe");
    	
        assertFalse(registroUsuarios.registrarUsuario("@pepe"));
    }


}
