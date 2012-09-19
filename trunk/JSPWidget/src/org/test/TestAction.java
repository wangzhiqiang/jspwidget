package org.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequestEvent;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import org.widget.Widget;

public class TestAction {
	public static void main(String str[]) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {

	 
//		Class c = Class.forName("org.test.ExtendsWidget");//加载class
//		Object obj =   c.newInstance();//得到对象
//		Method[] methods = c.getDeclaredMethods();//得到全体方法数组     
//		
//		for(int i=0 ;i<methods.length;i++){
//			Class[] types = methods[i].getParameterTypes();
//			Object[] values = new Object[types.length];
//			for(int j=0 ;j<types.length;j++){
//				
//				if(String.class == types[j])
//					values[j] = "String";
//				if(Integer.class == types[j])
//					values[j]= 888;
////				System.out.println(types[j].getParameterAnnotations());
//			}
////			System.out.println(methods[i].getName());
//			if(methods[i].getName().equals("run")){
//				methods[i].invoke(obj, values);
//			}
//		}
	}
}