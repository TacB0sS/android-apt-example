package com.manolovn.android.apt_sample;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * MethodDebug
 *
 * @author manolovn
 */
public final class MethodDebug
		implements Consts {

	private MethodDebug() {
		throw new AssertionError("No instances");
	}

	public static void scan(Object target) {
		Class<?> targetClass = target.getClass();
		System.out.println("target class >>> " + targetClass.getName());
		try {
			Class<?> aClass = Class.forName(targetClass.getName() + SUFFIX);
			Object instance = aClass.newInstance();
			try {
				Method method = aClass.getMethod("execute");
				try {
					method.invoke(instance);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			//scan(targetClass.getSuperclass());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
