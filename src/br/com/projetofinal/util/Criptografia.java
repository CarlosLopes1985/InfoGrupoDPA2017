package br.com.projetofinal.util;

import org.jcommon.encryption.SimpleMD5;

import br.com.projetofinal.modelo.Login;

public class Criptografia {

	public void criptografia(Login l){

		SimpleMD5 md5=new SimpleMD5(l.getSenha(), "cotiinformatica@123456");

		l.setSenha(md5.toHexString());

		}
	
}
