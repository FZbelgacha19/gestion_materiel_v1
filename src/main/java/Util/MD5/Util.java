package Util.MD5;

import java.nio.charset.StandardCharsets;
import java.security.*;

public class Util {
	public static String getMD5(String m) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] hashInBytes = md.digest(m.getBytes(StandardCharsets.UTF_8));

			StringBuilder sb = new StringBuilder();
			for (byte b : hashInBytes) {
				sb.append(String.format("%02x", b));
			}
			return new String(sb);
		} catch (Exception ex) {
			return null;
		}
	}
}