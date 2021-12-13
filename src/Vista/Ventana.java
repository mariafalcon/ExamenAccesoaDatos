package Vista;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.swing.ImageIcon;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;

import javafx.scene.image.Image;

public class Ventana extends JFrame{
	
	public Ventana() throws WriterException {
		BufferedImage imagen = crearQR("prueba", 300, 300);
		ImageIcon icono = new ImageIcon(imagen);
		JLabel etiqueta = new JLabel("");
	}
	
	public BufferedImage crearQR(String datos, int ancho, int altura) throws WriterException{
		BitMatrix matrix;
		Writer escritor = new QRCodeWriter();
		matrix = escritor.encode(datos, BarcodeFormat.QR_CODE, ancho, altura);
		
		BufferedImage imagen = new BufferedImage(ancho, altura, BufferedImage.TYPE_INT_RGB);
		
		
			for (int y = 0; y < altura; y++) {
				for (int x = 0; x < ancho; x++) {
					int grayValue = (matrix.get(x,y) ? 0 : 1) & 0xff;
					imagen.setRGB(x, y, (grayValue == 0 ? 0 : 0xFFFFFF));
				}
			}
			
			return imagen;
		
	}
	
	
	public static void writeQR(String text, String pathname) throws WriterException, IOException {
		int width = 600;
		int height = 400;
		
		String imageFormat ="png";
		BitMatrix bitMatrix = new QRCodeWriter().encode(text,BarcodeFormat.QR_CODE, width, height);
		FileOutputStream outputStream = new FileOutputStream(new File(pathname));
		MatrixToImageWriter.writeToStream(bitMatrix, imageFormat,outputStream);
		
	}
	
	public static String readQR(String pathname) throws FormatException, ChecksumException, NotFoundException, ChecksumException, IOException{
		
		InputStream qrInputStream = new FileInputStream(pathname);
		BufferedImage qrBufferedImage = ImageIO.read(qrInputStream);
		LuminanceSource source = new BufferedImageLuminanceSource(qrBufferedImage);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		Reader reader = new MultiFormatReader();
		Result stringBarcode = reader.decode(bitmap);
		
		return stringBarcode.getText();
		
	}

}
