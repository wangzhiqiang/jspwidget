package org.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequestEvent;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.ObjectUtils;
import org.widget.Widget;

public class TestAction {
	public static void main(String str[]) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			IllegalArgumentException, InvocationTargetException {
		Testbean tb = new Testbean();
		tb.setDd(789d);
		tb.setIi(123);
		tb.setSs("sfasdfasdf");
		System.out.println(tb.toString());
//System.out.println(ObjectUtils.identityToString(tb));
	}
}