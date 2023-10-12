package dao;

import java.awt.AWTException;
import java.sql.Connection;

import controler.Conexao;

public class bd {
	private static Connection connection = null;
	
	public static void main(String[] args) {
		try {
		Conexao.getInstancia().abrirConexao();
		System.out.println("Base criada com sucesso!");
		Conexao.getInstancia().fecharConexao();;
		}catch(Exception e){
		System.out.println(e.getMessage());
		System.exit(0);
	}
	}
}
