package spring.util;

import java.security.MessageDigest;
import java.util.Random;

public class SaltUtil {

	// 암호화
	public static String getEncrypt(String source, String salt){	
		return getEncrypt(source.getBytes(), salt.getBytes());
	}

	// (오버로딩)
	private static String getEncrypt(byte[] source, byte[] salt) {
		
		String result="";
		
		byte[] bytes = new byte[source.length + salt.length];
		
		System.arraycopy(source, 0, bytes, 0, source.length);
		System.arraycopy(salt, 0, bytes, source.length, salt.length);
		
		try {
			
			MessageDigest md = MessageDigest.getInstance("SHA-256"); // SHA 암호화 알고리즘
			md.update(bytes);
			
			byte[] byteData = md.digest();
			
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<byteData.length; i++){
				sb.append( Integer.toString( (byteData[i] & 0xFF) + 256, 16).substring(1) ); 	
				// & : 비트 And 연산
				// SHA-256 암호화의 경우, 256을 더함
				// 그 후 16진수 숫자를 문자열로 Integer.toString(int i, radix r)로 변환
				// toString(1) : 부호비트 제외  
			}
			
			result = sb.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	// Salt 생성
	public static String generateSalt(){
		
		Random random = new Random();
		
		byte[] salt = new byte[8];
		random.nextBytes(salt);
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<salt.length; i++){
		
			// byte -> hexa(16진수)로 바꿈
			sb.append(String.format("%02x", salt[i]));
		}
		
		return sb.toString();
	}
}
