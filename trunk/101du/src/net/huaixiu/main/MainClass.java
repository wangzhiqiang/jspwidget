package net.huaixiu.main;

import net.huaixiu.utils.URLUtils;

public class MainClass {

	
	public static void main(String[] args) {

		String ss = "http://www.huaixiu.net/modules/article/articlelist.php";
		 System.out.println(URLUtils.content(ss, "GBK") );
//		URLUtils.content(ss, "GBK");
	}

}
