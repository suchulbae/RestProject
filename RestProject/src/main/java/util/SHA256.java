package util;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Date;

// 단방향 암호화(SHA-256)로 암호화하면 복호화가 불가능 -> 8 자리 임시비밀번호를 새로 생성해줌(메일로 보내줌)

public class SHA256 {

	
	
	/*-- [암호화 전 비밀번호 찾기]를 할때 리턴값으로 돌려주기위해 추가해 봄(시작)-- */
	private static String prePassword;
	public static String getPassword() { // 비밀번호찾기 시 암호화안된 비밀번호를 반환해줌
		return prePassword;
	}
	/*-- [암호화 전 비밀번호 찾기]를 할때 리턴값으로 돌려주기위해 추가해 봄(끝)-- */
	

	
	/*
	 * 임시 비밀번호 생성
	 * getRamdomPassword(8)를 호출하면 8 글자의 임시비밀번호가 생성됩니다.
	 * (1.'영어대소문자+숫자+특수문자'가 결합된 8 글자의 임시비밀번호 생성됨)
	 * (2.'영어대소문자+숫자'가 결합된 8 글자의 임시비밀번호 생성됨)
	 */
	public static String getRandomPassword(int size){
		//1.'영어대소문자+숫자+특수문자'가 결합된 8 글자의 임시비밀번호
		/*
		char[] charSet = new char[] { 
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 
				'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 
				'!', '@', '#', '$', '%', '^', '&' }; 
		*/
		
		//2.'영어대소문자+숫자'가 결합된 8 글자의 임시비밀번호
		char[] charSet = new char[] { 
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 
				'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 
		         };//특수문자 제외
		
		StringBuffer sb = new StringBuffer(); 
		SecureRandom sr = new SecureRandom(); 
		sr.setSeed(new Date().getTime()); 
		
		int idx = 0; 
		int len = charSet.length; 
		for (int i=0; i<size; i++) { 
			// idx = (int) (len * Math.random()); 
			idx = sr.nextInt(len); // 강력한 난수를 발생시키기 위해 SecureRandom을 사용한다.  (sr.nextInt : 난수 발생)
			sb.append(charSet[idx]); 
			} 
		return sb.toString(); 
	}
}

/*
 * <Random과 SecureRandom 클래스의 차이점>
 * java.util.Random 클래스는 난수를 생성할 때 seed값으로 시간을 이용해서 난수를 발생시킴.
 * 그래서 동일한 시간에 동일한 seed값으로 Random 클래스를 사용하여 난수를 생성하면 동일한 값이 린턴됨.
 * 예측가능한 난수를 사용하는 경우 공격자가 SW에서 생성되는 다음 숫자를 예상하여 시스템을 공격할 수 있다.
 * 
 * 반면에 java.security.SecureRandom 클래스는 예측할 수 없는 seed를 이용하여 강력한 난수를 생성하기 때문에 예측 불가능함
 * 
 */


