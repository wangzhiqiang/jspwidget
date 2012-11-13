package org.test;

import java.lang.reflect.Method;

import java.util.List;
import java.util.Map;

public abstract class Basebean {
	public String toString() {

		Class<?> c = null;
		Object obj = null;
		Method[] methods = null;
		try {
			// 加载class
			c = this.getClass();
			// 得到实例化对象
			obj = this;
			// 获取对象的所有方法
			methods = c.getDeclaredMethods();
//System.out.println(c.getDeclaredClasses());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 遍历方法
		for (int i = 0; i < methods.length; i++) {

			try {
				if (methods[i].getName().substring(0, 3).equals("get")) {

					if (List.class == methods[i].getReturnType()) {
						System.out.println("list");
					} else if (Map.class == methods[i].getReturnType()) {
						System.out.println("map");
					} else {
						System.out.println(methods[i].invoke(obj, null));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "toString";

	}
}
