package br.com.logistica.transporte.seguranca;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

/**
 * Classe de teste para a classe Criptografia.
 * @author Elias Monteiro
 */
public class CriptografiaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String hash = "c7ad44cbad762a5da0a452f9e854fdc1e0e7a52a38015f23f3eab1d80b931dd472634dfac71cd34ebc35d16ab7fb8a90c81f975113d6c7538dc69dd8de9077ec";
		String hashRetorno = Criptografia.gerarHash( "admin" );
		Assert.assertEquals( hash, hashRetorno );
	}
}
