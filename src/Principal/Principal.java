package Principal;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.pdfbox.exceptions.COSVisitorException;

import Controlador.CRUD;
import Modelo.Usuario;
import Vista.Vista_Menu;

/**
 * 
 */

/**
 * @author Alumno
 *
 */
public class Principal {

	/**
	 * @param args
	 * @throws COSVisitorException 
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	public static void main(String[] args) throws COSVisitorException, SQLException, IOException, AddressException, MessagingException {
		
		Usuario usuario = new Usuario();
		CRUD crud = new CRUD();
		Vista_Menu  menu = new Vista_Menu();
		menu.MenuOpciones(usuario, crud);
	
}
}
