package br.com.logistica.transporte.seguranca;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe utilit�ria para implementa��o da seguran�a do sistema.
 * @author Elias Monteiro
 */
public class Criptografia {

	private static final String UTF_8 	= "UTF-8";
	private static final String SHA_512 = "SHA-512";

	/**
	 * Gera um hash de acordo com a senha informada.
	 * @param senha
	 * @return
	 */
	public static String gerarHash( String senha ) {
		String senhaHex = null;

		try {
			MessageDigest algoritmo = MessageDigest.getInstance( SHA_512 );
			byte messagemDigest[] 	= algoritmo.digest( senha.getBytes( UTF_8 ) );
			
			StringBuilder hexStrBuilder = new StringBuilder();

			for ( byte b : messagemDigest ) { 					// percorre os bytes e converte os valores para String
				hexStrBuilder.append( String.format( "%02X", 0xFF & b ) );
			}
			senhaHex = hexStrBuilder.toString();
			
		} catch ( NoSuchAlgorithmException e ) {
			e.printStackTrace();

		} catch ( UnsupportedEncodingException e ) {
			e.printStackTrace();
		}
		return senhaHex.toLowerCase();
	}
	
	public static boolean hashesIguais( String hash1, String hash2 ) {
		return hash1.equals( hash2 );
	}
}
