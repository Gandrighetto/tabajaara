package br.com.personalfinancetabajara.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppUtil {
	
	
	//GeneretaMD5-Criptografia
	public static String generateMD5(String text) throws NoSuchAlgorithmException {
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.reset();
		m.update(text.getBytes());
		byte[] digest = m.digest();
		BigInteger bigInt = new BigInteger(1, digest);
		String hashtext = bigInt.toString(16);
		// Now we need to zero pad it if you actually want the full 32 chars.
		while (hashtext.length() < 32) {
			hashtext = "0" + hashtext;
		}
		return hashtext;
	}

	
	//DataSQL
	
	public static java.sql.Date dateUtilToDateSql(Date data) 
	{
		return new java.sql.Date(data.getTime());
	}
	
	public static Date strDateToDate(String data) throws ParseException{
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dataretorno = df.parse(data);
		
		
		
		return dataretorno;
		
	}
	
	
	public static String dateToStr(Date data) {
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String dataretorno = df.format(data);
		
		return dataretorno;
		
		
	}
	
	
	
}
