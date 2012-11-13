package net.huaixiu.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.huaixiu.bean.ArticleEntity;

public class URLUtils {
	/**
	 * 
	 * @param url
	 *            connecturl
	 * @param encode
	 *            charencoding
	 * @return
	 */
	public static String content(String url, String encode) {
		String str = null;
		try {
			if (!url.equals("") && url != null)
				url = url.trim();
			URL u = new URL(url);
			HttpURLConnection uc = (HttpURLConnection) u.openConnection();
			uc.setConnectTimeout(3000);
			InputStreamReader inreader = new InputStreamReader(
					uc.getInputStream(), encode);
			BufferedReader breader = new BufferedReader(inreader);
			StringBuffer sb = new StringBuffer();
			String line = null;
			while ((line = breader.readLine()) != null) {
				sb.append(line + "\n");
			}
			inreader.close();
			breader.close();
			str = sb.toString();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	public static List<ArticleEntity> list(String content) {
		String regex;
        List<ArticleEntity> list = new ArrayList<ArticleEntity>();
        regex = "<tr>(.*?)</tr>";
        Pattern pa = Pattern.compile(regex ,Pattern.DOTALL);
        Matcher ma = pa.matcher(content);
        ArticleEntity article = null;
        while (ma.find()) {
        	article = new ArticleEntity();
        	article.setAll(ma.group());
            list.add(article);
        }
        return list;
	}

	public static String decodeUnicode(String theString) {
		char aChar;
		int len = theString.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len;) {
			aChar = theString.charAt(x++);
			if (aChar == '\\') {
				aChar = theString.charAt(x++);
				if (aChar == 'u') {
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = theString.charAt(x++);
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException(
									"Malformed      encoding.");
						}
					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't') {
						aChar = '\t';
					} else if (aChar == 'r') {
						aChar = '\r';
					} else if (aChar == 'n') {
						aChar = '\n';
					} else if (aChar == 'f') {
						aChar = '\f';
					}
					outBuffer.append(aChar);
				}
			} else {
				outBuffer.append(aChar);
			}
		}
		return outBuffer.toString();
	}
}
