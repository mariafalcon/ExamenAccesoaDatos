package Vista;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.pdfbox.exceptions.COSVisitorException;

import Controlador.CRUD;
import Modelo.Usuario;


public class Vista_Menu {

	
	
	public Vista_Menu(){
		
	
	}
	
	public void MenuOpciones(Usuario usuario, CRUD crud) throws COSVisitorException, SQLException, IOException, AddressException, MessagingException{
		
		Scanner tec = new Scanner(System.in);
		
		int opcion;
		
		do{
		System.out.println("=========================================");
		System.out.println("                MENU                     ");
		System.out.println("=========================================");
		System.out.println("1.Insertar registro de una persona");
		System.out.println("2.Consultar el DNI de una persona");
		System.out.println("3.Mostrar el listado completo");
		System.out.println("4.Modificar un registro");
		System.out.println("5.Eliminar un registro de forma física.");
		System.out.println("6.Borrado lógico.");
		System.out.println("7.Listar usuarios borrados.");
		System.out.println("8.Recuperar usuarios borrados.");
		System.out.println("9.Crear fichero XML");
		System.out.println("10.Leer fichero XML");
		System.out.println("11.Crear fichero CSV");
		System.out.println("12.Leer fichero CSV");
		System.out.println("13.Crear Código QR");
		System.out.println("14.Generar PDF");
		System.out.println("15.Enviar Email. Desde una cuenta GMAIL.");
		System.out.println("16.Enviar email. Desde una cuenta HOTMAIL");
		System.out.println("17.Realizar gráficos");
		System.out.println("18.Salir");
		System.out.println("================================================");
		System.out.println("Introduzca una de las anteriores opciones: ");
		opcion=tec.nextInt();
		
			
		switch(opcion){
		
		case 1: crud.InsertUsuario(usuario);
		break;
		
		case 2: crud.BuscarDni(usuario);
		break;
		
		case 3: crud.VerUsuarios(usuario);
		break;
		
		case 4: crud.modificarRegistro(usuario);
		break;
		
		case 5: crud.EliminarFormFisica(usuario);
		break;
		
		case 6: crud.BorradoLogico(usuario);
		break;
		
		case 7: crud.ListarUsuariosBorrados(usuario,2);
		break;
		
		case 8: crud.RecuperarUsuarioBorrado(usuario);
		break;
		
		case 9: crud.crearXML(usuario);
		break;
		
		case 10: crud.verXml();
		break;
		
		case 11: crud.crearCSV(usuario);
		break;
		
		case 12: crud.LeerCSV(usuario);
		break;
		
		case 13: crud.Codigo_QR(usuario);
		break;	
			
		case 14: crud.Generar_PDF(usuario);
		break;		
		
		case 15: crud.Enviar_Email(usuario);
		break;
		
		case 16: crud.Enviar_mail_hotmail(usuario);
		break;
		
		case 17: crud.Graficos();
		break;
		
		case 18: System.out.println("Ha salido del programa");
		}
		
		}while(opcion!=18);
	}
	
	
	
	
}
