package Controlador;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import Modelo.Usuario;
import Transversal.Conexion;
import Vista.Ventana;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Panel;




/**
 * 
 */

/**
 * @author Alumno
 *
 */
public class CRUD {
	
	String cadenaSQL = " ";
	Conexion bd = new Conexion();
	ResultSet resultado = null;
	Statement sentencia = null;
	PreparedStatement sentenciaP = null;
	Scanner tec = new Scanner(System.in);
	String nombre, apellido1, apellido2, dni,correo;
	int idUsuario;
	
	public void VerUsuarios(Usuario usuario) {
	try{
		String borrado;
		cadenaSQL = "SELECT * FROM Usuarios where borrado='n'";
		Connection conexion = bd.conectar();
		if(conexion !=null){
			sentencia = conexion.createStatement();
			resultado = sentencia.executeQuery(cadenaSQL);
			System.out.println("ID - NOMBRE - APELLIDO1 - APELLIDO2 - DNI - BORRADO - CORREO");
		
		
		while (resultado.next()){
			idUsuario = resultado.getInt("idusuario");
			nombre= resultado.getString("nombre");
			apellido1 = resultado.getString("apellido");
			apellido2 = resultado.getString("apellido2");
			dni = resultado.getString("dni");
			borrado = resultado.getString("borrado");
			correo=resultado.getString("correo");
			
			usuario.setIdusuario(idUsuario);
			usuario.setNombre(nombre);
			usuario.setApellido1(apellido1);
			usuario.setApellido2(apellido2);
			usuario.setDni(dni);
			usuario.setBorrado(borrado);
			usuario.setCorreo(correo);
			System.out.println(usuario.toString());
		}
	} else {
		System.out.println("Ha habido un problema al conectar con la base de datos");
		
	}
	}
		catch(SQLException e){
			System.out.println(e.getMessage());
			
		}finally {
			if(sentencia!=null){
				try {
					sentencia.close();
					resultado.close();
					bd.conexion.close();
				} catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public int RetornarDNISelect(String DNI, Usuario usuario) {
		
		int id=0;
		
		try{
			
			cadenaSQL = "Select * from Usuarios where dni='"+DNI+"'";
			System.out.println(cadenaSQL);
			Connection conexion = bd.conectar();
			if(conexion !=null){
				sentencia = conexion.createStatement();
				resultado = sentencia.executeQuery(cadenaSQL);
				
				while(resultado.next()){
					
					idUsuario=resultado.getInt("idusuario");
					nombre=resultado.getString("nombre");
					apellido1=resultado.getString("apellido");
					apellido2=resultado.getString("apellido2");
					dni = resultado.getString("dni");
					correo=resultado.getString("correo");
					
					
					if(dni.equals(DNI)){
						usuario.setIdusuario(idUsuario);
						usuario.setNombre(nombre);
						usuario.setApellido1(apellido1);
						usuario.setApellido2(apellido2);
						usuario.setDni(dni);
						usuario.setCorreo(correo);
						id = 1;
					}
						
					}
			}
				
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			
		}finally {
			if(sentencia!=null){
				try {
					sentencia.close();
					resultado.close();
					bd.conexion.close();
				} catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return id;
	
		}
	
	public void InsertUsuario(Usuario usuario){

		String DNI;
		int resultado1;
		String borrado;
		
		System.out.println("Introduzca nombre de usuario: ");
		nombre=tec.nextLine();
		
		System.out.println("Introduzca apellido1: ");
		apellido1=tec.nextLine();
		
		System.out.println("Introduzca apellido2: ");
		apellido2=tec.nextLine();
		
		System.out.println("Introduzca DNI: ");
		DNI=tec.next();
		
		System.out.println("Introduzca el borrado: ");
		borrado = tec.next();
		
		System.out.println("Introduzca correo: ");
		correo=tec.next();
		
		
		int id = RetornarDNISelect(DNI, usuario);
		
		try {
		
		if(id==1){
			
			System.out.println("EL USUARIO INTRODUCIDO YA EXISTE");
			System.out.println(usuario.toString());
		}
			
		else{
			usuario.setIdusuario(idUsuario);
			usuario.setNombre(nombre);
			usuario.setApellido1(apellido1);
			usuario.setApellido2(apellido2);
			usuario.setCorreo(correo);
			usuario.setBorrado(borrado);
			usuario.setDni(DNI);
			
			System.out.println("El usuario introducido no existe. Procemos a insertar el nuevo registro: ");
			Connection conexion = bd.conectar();
			cadenaSQL = "INSERT INTO Usuarios(nombre, apellido, apellido2, dni, borrado, correo) values ('"+usuario.getNombre()+"','"+usuario.getApellido1()+"','"+usuario.getApellido2()+"','"+usuario.getDni()+"','"+usuario.getBorrado()+"','"+usuario.getCorreo()+"')";
			
				sentencia = conexion.createStatement();
				resultado1 = sentencia.executeUpdate(cadenaSQL);
				System.out.println(usuario.toString());
				
				if(resultado1>0){
					System.out.println("Se ha introducido correctamente.");
				}
				else{
					System.out.println("Ha habido un problema con la conexión");
				}
		}
		}
			catch(SQLException e){
				System.out.println(e.getMessage());
				
			}finally {
				if(sentencia!=null){
					try {
						sentencia.close();
						resultado.close();
						bd.conexion.close();
					} catch(SQLException e){
						e.printStackTrace();
					}
				}
			}
		
		
		
		
				
			}
	
	
	public void BuscarDni(Usuario usuario){	
		
		
		String DNI;
		
		System.out.println("Introduzca número de DNI: ");
		DNI=tec.next();
		
		int id=RetornarDNISelect(DNI, usuario);
		
		if(id==1){
		System.out.println("Lo ha encontrado.");
		System.out.println(usuario.toString());
			}
		else{
			System.out.println("No ha encontrado el DNI.");
			}		
				}
	
	
	public void modificarRegistro(Usuario usuario){
		
		String DNI;
		String otronombre="";
		String otroap1="";
		String otroap2="";
		String resp="";
		String otrocorreo="";
		Connection conexion = bd.conectar();

		System.out.println("Introduzca número de DNI: ");
		DNI=tec.next();
		int id = RetornarDNISelect(DNI, usuario);
				
		try {
				if(id==1){
					System.out.println("Lo ha encontrado.");
					System.out.println(usuario.toString());
	
					System.out.println("Procedemos a modificar el registro con DNI " + DNI);
					int opcion;
					
					do{
					System.out.println("1.Cambiar nombre:");
					System.out.println("2.Cambiar apellido1:");
					System.out.println("3.Cambiar apellido2:");
					System.out.println("4.Cambiar correo:");
					System.out.println("5.Más cambios.");
					System.out.println("6.Salir");
					opcion=tec.nextInt();
					
					switch(opcion){
					
					case 1: 
					resp=tec.nextLine();
					System.out.println("Introduzca el nuevo nombre: ");
					otronombre=tec.nextLine();
					usuario.setNombre(otronombre);
					cadenaSQL= "Update Usuarios set nombre='"+usuario.getNombre()+"' where dni ='"+DNI+"'";
					sentencia = conexion.createStatement();
					sentencia.executeUpdate(cadenaSQL);
					break;
					
					case 2: 
					tec.nextLine();
					System.out.println("Introduzca el nuevo primer apellido:");
					otroap1=tec.nextLine();
					System.out.println(otroap1);
					usuario.setApellido1(otroap1);
					cadenaSQL="Update Usuarios set apellido='"+usuario.getApellido1()+"' where dni='"+DNI+"'";
					sentencia = conexion.createStatement();
					sentencia.executeUpdate(cadenaSQL);
					break;
					
					case 3:
					resp=tec.nextLine();
					System.out.println("Introduzca el nuevo segundo apellido: ");
					otroap2=tec.nextLine();
					usuario.setApellido2(otroap2);
					cadenaSQL= "Update Usuarios set apellido2='"+usuario.getApellido2()+"' where dni='"+DNI+"'";
					sentencia = conexion.createStatement();
					sentencia.executeUpdate(cadenaSQL);
					break;
					
					case 4:
					resp=tec.nextLine();
					System.out.println("Introduzca el nuevo correo: ");
					otrocorreo=tec.nextLine();
					usuario.setCorreo(otrocorreo);
					cadenaSQL= "Update Usuarios set correo='"+usuario.getCorreo()+"' where dni='"+DNI+"'";
					sentencia = conexion.createStatement();
					sentencia.executeUpdate(cadenaSQL);
					break;
						
					case 5:
					resp=tec.nextLine();
					System.out.println("Quieres hacer más cambios?");
					resp=tec.nextLine();
										
					while(!resp.equalsIgnoreCase("si") || !resp.equalsIgnoreCase("no")){
						System.out.println("Responda si o no: ");
						resp=tec.nextLine();
						
					}
					break;
					
					case 6: System.out.println("Has salido de los cambios.");
					}
					
					}while(opcion!=6 || resp.equalsIgnoreCase("no"));
					
				}
				else{
					System.out.println("No ha encontrado el DNI.");
				}
					
		}
					catch(SQLException e){
						System.out.println(e.getMessage());
						
					}finally {
						if(sentencia!=null){
							try {
								sentencia.close();
								resultado.close();
								bd.conexion.close();
							} catch(SQLException e){
								e.printStackTrace();
							}
						}
					}
					
		
	}
	
	public void EliminarFormFisica(Usuario usuario){
		
		
		
		String DNI;
		int resultado1;
		Connection conexion = bd.conectar();
		
		System.out.println("Vamos a eliminar el usuario, por favor: ");
		System.out.println("Introduzca número de DNI: ");
		DNI=tec.next();
		
		int id=RetornarDNISelect(DNI, usuario);
		
		
		try{
			
						
				if(id==1){
					System.out.println("Lo ha encontrado.");
					System.out.println(usuario.toString());
					
					cadenaSQL = "Delete from Usuarios where dni='"+DNI+"'";
					sentencia = conexion.createStatement();
					resultado1=sentencia.executeUpdate(cadenaSQL);
					
					if(resultado1>0){
						System.out.println("Se ha eliminado exitosamente.");
					}
					else{
						System.out.println("No se ha eliminado el registro.");
					}
				}
				else{
					System.out.println("No ha encontrado el DNI.");
				}
		}
					catch(SQLException e){
						System.out.println(e.getMessage());
						
					}finally {
						if(sentencia!=null){
							try {
								sentencia.close();
								resultado.close();
								bd.conexion.close();
							} catch(SQLException e){
								e.printStackTrace();
							}
						}
					}
		
	}
	
	
	
	public void BorradoLogico(Usuario usuario){
		
		
		String DNI;
		int resultado1;
		String borrado="";
		Connection conexion = bd.conectar();
		
		System.out.println("Vamos a eliminar el usuario de forma lógica, por favor: ");
		System.out.println("Introduzca número de DNI: ");
		DNI=tec.next();
	
		int id=RetornarDNISelect(DNI, usuario);
		try {
				if(id==1){
					System.out.println("Lo ha encontrado.");
					System.out.println(usuario.toString());
					
					if(borrado.equalsIgnoreCase("s")){
						System.out.println("Este usuario ya tiene borrado lógico.");
					}
				
					else {
						cadenaSQL = "Update Usuarios set Borrado='s' where dni='"+DNI+"'";
						sentencia = conexion.createStatement();
						resultado1=sentencia.executeUpdate(cadenaSQL);
						
						if(resultado1>0){
							System.out.println("Se ha eliminado exitosamente.");
							System.out.println(usuario.toString());
						}
						else{
							System.out.println("No se ha eliminado el registro.");
						}
					}
						
					}
					else{
						System.out.println("No ha encontrado el DNI.");
					}
			}
						catch(SQLException e){
							System.out.println(e.getMessage());
							
						}finally {
							if(sentencia!=null){
								try {
									sentencia.close();
									resultado.close();
									bd.conexion.close();
								} catch(SQLException e){
									e.printStackTrace();
								}
							}
						}
						
						
						
			
					
		
	
	}
	
	public String ListarUsuariosBorrados(Usuario usuario, int id){
		
		try{
			String borrado;
			cadenaSQL = "SELECT * FROM Usuarios where borrado='s'";
			Connection conexion = bd.conectar();
			if(conexion !=null){
				sentencia = conexion.createStatement();
				resultado = sentencia.executeQuery(cadenaSQL);
				System.out.println("ID - NOMBRE - APELLIDO1 - APELLIDO2 - DNI");
			
			
			while (resultado.next()){
				int idusuario = resultado.getInt("idusuario");
				nombre= resultado.getString("nombre");
				apellido1 = resultado.getString("apellido");
				apellido2 = resultado.getString("apellido2");
				dni = resultado.getString("dni");
				borrado = resultado.getString("borrado");
				correo = resultado.getString("correo");
				
				usuario.setIdusuario(idusuario);
				usuario.setNombre(nombre);
				usuario.setApellido1(apellido1);
				usuario.setApellido2(apellido2);
				usuario.setDni(dni);
				usuario.setBorrado(borrado);
				usuario.setCorreo(correo);
				if(id!=1) {
				System.out.println(usuario.toString());
				}
			}
		} else {
			System.out.println("Ha habido un problema al conectar con la base de datos");
			
		}
		}
			catch(SQLException e){
				System.out.println(e.getMessage());
				
			}finally {
				if(sentencia!=null){
					try {
						sentencia.close();
						resultado.close();
						bd.conexion.close();
					} catch(SQLException e){
						e.printStackTrace();
					}
				}
		
		
	}
		return correo;
			
	}

	
	public void RecuperarUsuarioBorrado(Usuario usuario){
		Connection conexion = bd.conectar();
		String DNI;
		String borrado;
		System.out.println("Introduzca número de DNI: ");
		DNI=tec.next();
		tec.nextLine();
		int id= RetornarDNISelect(DNI,usuario);
		
		try{
			
				if(id==1){
					System.out.println("Lo ha encontrado.");
					System.out.println(usuario.toString());
	
					System.out.println("Procedemos a recuperar el registro con DNI " + DNI);
				
					
					System.out.println("¿Estás seguro de querer recuperar el registro?");
					String resp = tec.nextLine();
					
					
					while(!resp.equalsIgnoreCase("s") && !resp.equalsIgnoreCase("n")){
						System.out.println("Responda s o n:");
						resp=tec.nextLine();
						
					}
					
					if(resp.equalsIgnoreCase("no")){
						System.out.println("No se ha modificado el registro.");
						
					}
					
					else{
						cadenaSQL= "Update Usuarios set borrado='n' where dni ='"+DNI+"'";
						sentencia = conexion.createStatement();
						sentencia.executeUpdate(cadenaSQL);
					}
					}
				
				else{
					System.out.println("No se ha encontrado el registro");
				}
		}
				
				
				catch(SQLException e){
					System.out.println(e.getMessage());
					
				}finally {
					if(sentencia!=null){
						try {
							sentencia.close();
							resultado.close();
							bd.conexion.close();
						} catch(SQLException e){
							e.printStackTrace();
						}
					}
	
}
	}
	
	public void crearXML(Usuario usuario){
		String borrado;
		String fichero="usuarios.xml";
		
		boolean existe = new File(fichero).exists();
		
		if(!existe){
			System.out.println("Es la primera vez que generamos el fichero " + fichero);
		} else{
			System.out.println("Añadiendo usuarios al archivo XML");
		}
		
		FileWriter fp = null;
		PrintWriter pw = null;
		try {
			fp = new FileWriter(fichero);
			pw = new PrintWriter(fichero);
			
			
			pw.println("<?xml version=\"1.0\"?>");
			pw.println("<usuarios>");
			
			cadenaSQL = "Select * from Usuarios where Borrado='n'";
			Connection conexion = bd.conectar();
			
			try{
				
			sentencia = conexion.createStatement();
			resultado = sentencia.executeQuery(cadenaSQL);
			
			while(resultado.next()){
				
				int id = resultado.getInt("idusuario");
				nombre = resultado.getString("nombre");
				apellido1 = resultado.getString("apellido");
				apellido2=resultado.getString("apellido2");
				dni = resultado.getString("dni");
				borrado = resultado.getString("borrado");
				correo = resultado.getString("correo");
				
				usuario.setIdusuario(id);
				usuario.setNombre(nombre);
				usuario.setApellido1(apellido1);
				usuario.setApellido2(apellido2);
				usuario.setDni(dni);
				usuario.setBorrado(borrado);
				usuario.setCorreo(correo);
				
				pw.println("<usuario>");
				pw.println("<id>" + usuario.getIdusuario()+"</id>");
				pw.println("<nombre>" +usuario.getNombre()+"</nombre>");
				pw.println("<apellido1>" + usuario.getApellido1()+"</apellido1>");
				pw.println("<apellido2>" + usuario.getApellido2()+"</apellido2>");
				pw.println("<dni>" + usuario.getDni()+"</dni>");
				pw.println("<borrado>" + usuario.getBorrado()+"</borrado>");
				pw.println("<correo>" + usuario.getCorreo()+"</correo>");
				pw.println("</usuario>");
			}
			
			}
			catch(SQLException e){
				System.out.println(e.getMessage());
				
			}finally {
				if(sentencia!=null){
					try {
						sentencia.close();
						resultado.close();
						bd.conexion.close();
					} catch(SQLException e){
						e.printStackTrace();
					}
				}

				pw.println("</usuarios>");
				pw.close();
				fp.close();
			
	}
		} catch (IOException e) {
			e.printStackTrace();
		}
}
	
	
	
	public void verXml(){
		
		SAXBuilder builder = new SAXBuilder();
		
		File xmlFile = new File("usuarios.xml");
		
		try{
			Document documento;
			
				documento = (Document) builder.build(xmlFile);
			 
			
			Element rootNode = documento.getRootElement();
			
			List list = rootNode.getChildren("usuario");
			
			System.out.println("ID - NOMBRE - APELLIDO1 - APELLIDO2 - DNI - BORRADO - CORREO");
			
			for (int i = 0; i < list.size(); i++) {
				
				Element tabla = (Element) list.get(i);
				
				List lista_campos = tabla.getChildren();
				String id = tabla.getChildText("id");
				String nombre = tabla.getChildText("nombre");
				String ap1 = tabla.getChildText("apellido1");
				String ap2=tabla.getChildText("apellido2");
				String dni=tabla.getChildText("dni");
				String borrado=tabla.getChildText("borrado");
				String correo=tabla.getChildText("correo");
				
				System.out.println(id + "   " + nombre + "   " + ap1 + "   " + ap2 + "   " + dni + "   " + borrado + "  " + correo);
			}
		}
		catch(IOException io){
			System.out.println(io.getMessage());
		}
		catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	public void crearCSV(Usuario usuario){
		String fichero="usuarios.csv";
		boolean existe = new File(fichero).exists();
		
		try{
			CsvWriter t2 = new CsvWriter(new FileWriter(fichero, true),',');
			cadenaSQL= "SELECT * FROM usuarios;";
			Connection conexion = bd.conectar();
			if(conexion != null){
				sentencia = conexion.createStatement();
				resultado = sentencia.executeQuery(cadenaSQL);
				try{
					if(!existe){
						t2.write("ID");
						t2.write("Nombre");
						t2.write("Apellido1");
						t2.write("Apellido2");
						t2.write("DNI");
						t2.write("Borrado");
						t2.write("Correo");
						t2.endRecord();
					}
				}
				catch(IOException e){
					e.printStackTrace();
				}
				
				while(resultado.next()){
					try{
					t2.write("" + resultado.getInt("idusuario"));
					t2.write("" + resultado.getString("nombre"));
					t2.write("" + resultado.getString("apellido"));
					t2.write("" + resultado.getString("apellido2"));
					t2.write("" + resultado.getString("dni"));
					t2.write("" + resultado.getString("borrado"));
					t2.write("" + resultado.getString("correo"));
					t2.endRecord();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
				if(t2!=null) {
					System.out.println("Se ha creado el archivo csv");
				}
				t2.close();
		}else{
			System.out.println("Ha habido un problema con la base de datos");
		}
		}catch(SQLException e){
				System.out.println(e.getMessage());
			}catch(IOException el){
				el.printStackTrace();
			}finally{
				if(sentencia!=null){
					try{
						sentencia.close();
						resultado.close();
						bd.conexion.close();
					}catch(SQLException e){
						e.printStackTrace();
					}
				}
			}
		
	
	}
	
	
	
	public void LeerCSV(Usuario usuario) throws COSVisitorException{
		
		String fichero="usuarios.csv";
		
		try{
			boolean existe = new File(fichero).exists();
			if(!existe){
				System.out.println("El archivo no existe");
			}
			
		CsvReader t1 = new CsvReader(fichero);
		t1.readHeaders();
		while(t1.readRecord()){
			String id =t1.get("ID");
			nombre=t1.get("Nombre");
			apellido1=t1.get("Apellido1");
			apellido2=t1.get("Apellido2");
			dni=t1.get("DNI");
			String borrado=t1.get("Borrado");
			correo = t1.get("Correo");
			System.out.println("ID " + id + " Nombre: " + nombre + " Apellido1: " + apellido1 + " Apellido2: " + apellido2 + " DNI: " + dni + " Borrado: " + borrado + " Correo: " + correo);
			
		}
		t1.close();
	}catch(FileNotFoundException e){
	e.printStackTrace();
	}
	catch(IOException el){
	el.printStackTrace();
		}
	}
	
	
	
	public void Codigo_QR(Usuario usuario)throws SQLException{
		String pathname="C:\\temp\\usuario1.png";
		String query="";
		String nombre="",apellido1="",apellido2="",dni="",borrado="", correo="";
		int id=0;
		System.out.println("Introduzca número de DNI: ");
		dni=tec.next();
		
		
		try {
			query = "Select * from Usuarios where dni='"+dni+"'";
			Connection conexion = bd.conectar();
			sentencia = conexion.createStatement();
			resultado = sentencia.executeQuery(query);
			while(resultado.next()){
				
				nombre=resultado.getString("nombre");
				apellido1 = resultado.getString("apellido");
				apellido2=resultado.getString("apellido2");
				dni=resultado.getString("dni");
				borrado=resultado.getString("borrado");
				correo=resultado.getString("correo");
				
			
				usuario.setNombre(nombre);
				usuario.setApellido1(apellido1);
				usuario.setApellido2(apellido2);
				usuario.setDni(dni);
				usuario.setBorrado(borrado);
				usuario.setCorreo(correo);
				
				
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
		String textToQR = " " + nombre + " "
	 + apellido1 + " " + apellido2 + " " + dni + " " +correo;	
		System.out.println(textToQR);
		
		try{
			Ventana.writeQR(textToQR, pathname);
			System.out.println("El código QR se ha generado con éxito");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void Generar_PDF(Usuario usuario) throws SQLException, COSVisitorException, IOException {
		int pdfs = 600;
		PDDocument doc = null;
		
		
		try {
			
			doc = new PDDocument();
			PDPage page = new PDPage();
			doc.addPage(page);
			PDFont font = PDType1Font.COURIER_BOLD_OBLIQUE;
			Color color = Color.BLUE;
			PDPageContentStream contentStream = null;
			
			try {
				contentStream = new PDPageContentStream(doc, page);
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			try {
				
				contentStream.beginText();
				contentStream.setFont( font, 16);
				contentStream.setNonStrokingColor(color);
				contentStream.moveTextPositionByAmount(160, 700);
				contentStream.drawString("------LISTADO DE USUARIOS----");
				contentStream.endText();
				
				contentStream.beginText();
				contentStream.setFont(font, 12);
				contentStream.setNonStrokingColor(Color.GREEN);
				contentStream.moveTextPositionByAmount(75, 650);
				contentStream.drawString("ID -  NOMBRE -  APELLIDO1 -  APELLIDO2 - DNI - CORREO");
				contentStream.endText();
				
				String query="";
				String nombre="",apellido1="",apellido2="",dni="",correo="";
				int id=0;
				List<String> usuarios = new ArrayList<String>();
				
				query = "Select * from Usuarios";
				Connection conexion = bd.conectar();
				sentencia = conexion.createStatement();
				resultado = sentencia.executeQuery(query);
				while(resultado.next()){
					id=resultado.getInt("idUsuario");
					nombre=resultado.getString("nombre");
					apellido1 = resultado.getString("apellido");
					apellido2=resultado.getString("apellido2");
					dni=resultado.getString("dni");
					correo=resultado.getString("correo");
					
					usuario.setIdusuario(id);
					usuario.setNombre(nombre);
					usuario.setApellido1(apellido1); 
					usuario.setApellido2(apellido2); 
					usuario.setDni(dni);
					usuario.setCorreo(correo);
				
					String idusuario= Integer.toString(id);
		
					String text = idusuario + "     " +nombre + "     " + apellido1 + "     " + apellido2 + "     " + dni + "     " + correo;
					usuarios.add(text);
					
				}
				
				for (int i = 0; i <usuarios.size(); i++) {
					contentStream.beginText();
					contentStream.setFont(font, 12);
					contentStream.setNonStrokingColor(color);
					contentStream.moveTextPositionByAmount(75, pdfs);
					contentStream.drawString(usuarios.get(i));
					pdfs=pdfs-30;
					contentStream.endText();
				}
				
				contentStream.close();
				doc.save("c:\\temp\\prueba.pdf");
				System.out.println("El pdf se ha generado correctamente");
				
				
		}
		catch(IOException e) {
			e.printStackTrace();
		}}
			
			finally {
			if(doc !=null) {
				try {
					doc.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	
	
}
	
	
	public void Enviar_Email(Usuario usuario) throws SQLException {
		
		String correo = null;
		String email="";
		System.out.println("Seleccione una de las siguientes formas para enviar el email");
		System.out.println("1.Enviar a un usuario especifico");
		System.out.println("2.Enviar a todos los usuarios");
		int op=tec.nextInt();
		
		
		cadenaSQL= "SELECT * FROM usuarios;";
		Connection conexion = bd.conectar();
		if(conexion !=null){
			
			sentencia = conexion.createStatement();
			resultado = sentencia.executeQuery(cadenaSQL);
			
				
				
				while(resultado.next()){
				
					if(op==2) {
					correo =resultado.getString("correo");
					usuario.setCorreo(correo);
					email=correo;
					System.out.println("Enviado a: " + correo);
					}

					if(op==1) {
						correo = ListarUsuariosBorrados(usuario, 1);
						email=correo;
					}
				final String correoEnvia="grupoinfoclub@gmail.com";
				final String contrasena="Adivinala1.";
				String receptor=email;
				String asunto="Le remitimos la invitación a nuestro evento IT";
				String mensaje="Buenos días, le remitimos el código de qr, el cual será la invitación a nuestro próximo evento IT del año. Saludos";
				
				System.out.println("Preparando configuración");
				Properties propiedad = new Properties();
				propiedad.setProperty("mail.smtp.host","smtp.gmail.com");
				propiedad.setProperty("mail.smtp.starttls.enable", "true");
				propiedad.setProperty("mail.smtp.port","465");
				propiedad.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
				propiedad.setProperty("mail.smtp.user", correoEnvia);
				propiedad.setProperty("mail.smtp.password", contrasena);
				propiedad.setProperty("mail.transport.protocol", "smtp");
				propiedad.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		
		
		Session sesion = Session.getInstance(propiedad, new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(correoEnvia, contrasena);
			}
		});
		
		System.out.println("Configuración okay");
		System.out.println("Sesión okay");
		
		MimeMessage mail = new MimeMessage(sesion);
		try {
			mail.setFrom(new InternetAddress(correoEnvia));
			mail.addRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
			mail.setSubject(asunto);
			mail.setText(mensaje);
			
			System.out.println("Adjuntando.......");
			Multipart multipart = new MimeMultipart();
			MimeBodyPart attachpart = new MimeBodyPart();
			String attachfile="c:\\temp\\usuario1.png";
			
			
			try {
				attachpart.attachFile(attachfile);
				
			}
			catch(IOException e) {
				e.printStackTrace();
				System.out.println("Error");
				return;
			}
			
			multipart.addBodyPart(attachpart);
			mail.setContent(multipart);
			System.out.println("Archivo adjunto preparado.....");
			
			System.out.println("Enviando");
			Transport transportar = sesion.getTransport("smtp");
			transportar.connect(correoEnvia, contrasena);
			transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
			transportar.close();
			
			JOptionPane.showMessageDialog(null, "Listo, revise su correo");
			
		}catch(AddressException ex) {
			Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
			
		}
		catch(MessagingException ex) {
			Logger.getLogger(Panel.class.getName()).log(Level.SEVERE,null, ex);
		}
			}
		
		
	}
	}

	
	
	public void Enviar_mail_hotmail(Usuario usuario) throws AddressException, MessagingException {
		
		
		
					String email="mafq2998@gmail.com";
					final String correoEnvia="tubi98@hotmail.com";
					String contrasena="8597447";
					String receptor=email;
					String asunto="Le remitimos la invitación a nuestro evento IT";
					String mensaje="Buenos días, le remitimos el código de qr, el cual será la invitación a nuestro próximo evento IT del año. Saludos";
		
					Properties props = null;
					if (props == null) {
						props = new Properties();
						props.put("mail.smtp.auth", true);
						props.put("mail.smtp.starttls.enable", true);
						props.put("mail.smtp.Host", "smtp.live.com");
						props.put("mail.smtp.port", "587");
						props.put("mail.smtp.ssl.protocols", "TLSv1.2");
						props.put("mail.smtp.user", correoEnvia);
						props.put("mail.smtp.password", contrasena);
					}
					Session session = Session.getInstance(props, null);
					session.setDebug(true);
					Message msg = new MimeMessage(session);
					msg.setFrom(new InternetAddress(correoEnvia));
					if (asunto != null) {
						msg.setSubject(asunto);

		    }
		    msg.setText(mensaje);
		    msg.setRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
		    Transport transport = session.getTransport("smtp");
		    transport.connect("smtp.live.com", 587, correoEnvia, contrasena);
		    transport.sendMessage(msg, msg.getAllRecipients());
		    System.out.println("Mail sent successfully at " + receptor);
		    transport.close();
		    
		    
		}
		
	
	
	
	public void Graficos() {
		
		Scanner tec = new Scanner(System.in);
		int mes1=0;
		int anio=0;
		int totalDias = 0;
		String fecha="";
		int numero=0;
		int [] importes = new int[31];
		
		XYSeries series = new XYSeries("Ventas");
		
		System.out.println("Introduzca mes: ");
		mes1=tec.nextInt();
		System.out.println("Introduzca año: ");
		anio=tec.nextInt();
		totalDias=31;

		
		for (int i = 0; i < totalDias; i++) {
			fecha=anio+"-"+mes1+"-"+i;
			numero=(int)(Math.random()*1000)+1;
			importes[i]=numero;
		}
		
		for (int i = 0; i < totalDias; i++) {
			fecha=anio+"-"+mes1+"-"+i;
			series.add(i,importes[i]);
		}
		
		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] months = dfs.getMonths();
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		
		JFreeChart chart = ChartFactory.createXYLineChart(
				"Ventas "+months[mes1-1]+" "+anio,
				"Dia",
				"Cantidad",
				dataset,
				PlotOrientation.VERTICAL,
				true,
				false,
				false
				);
		
		ChartFrame frame = new ChartFrame("Ejemplo Gráfica de tipo lineal",chart);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	
	
	

	
}
	

	
	
	

		



	

	
	

