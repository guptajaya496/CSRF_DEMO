package com.csrf.action.model;

import java.security.SecureRandom;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;


public final class GenerateCSRFToken
{
	public final static String SESSION_ATTR_KEY = "CSRF_Token";
	private final static String NO_SESSION_ERROR = "No valid session found";
		
	private static String getSecurePassword(String passwordToHash, String salt)
	{
		String generatedPassword = null;
		try 
		{
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			//Add password bytes to digest
			md.update(salt.getBytes());
			//Get the hash's bytes 
			byte[] bytes = md.digest(passwordToHash.getBytes());
			//This bytes[] has bytes in decimal format;
			//Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< bytes.length ;i++)
			{
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
			//Get complete hashed password in hex format
			generatedPassword = sb.toString();
	    } 
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
	    }
        return generatedPassword;
    }
	     
	    //Add salt
	private static String getSalt() throws NoSuchAlgorithmException, NoSuchProviderException
	{
		//Always use a SecureRandom generator
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
		//Create array for salt
		byte[] salt = new byte[16];
		//Get a random salt
		sr.nextBytes(salt);
		//return salt
		return salt.toString();
	}
	
	public static void setToken(HttpSession session) throws ServletException, NoSuchAlgorithmException, NoSuchProviderException
	{
		String passwordToHash = "password";
	    String salt = getSalt();
		
		if (session != null)
		{
			String token_val = (String)session.getAttribute(SESSION_ATTR_KEY);
			if(token_val == null)
			{			
				System.out.println("session is not null!!!! Now getting a token");
				String CSRFToken = getSecurePassword(passwordToHash, salt);
				System.out.println(CSRFToken);
				session.setAttribute(SESSION_ATTR_KEY, CSRFToken);
			}
		}
		else
		{
			throw new ServletException(NO_SESSION_ERROR);			
		}				
	}
}
