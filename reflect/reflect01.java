package fl.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class reflect01 {
	public static void main(String[] args) throws Exception {
		// 根据一个类的全名字符串来获得一个类的对象
		Class<?> clazz01 = Class.forName("fl.reflect.Student");
		// 获得默认的构造器
		Constructor<?> constructor = clazz01.getDeclaredConstructor(new Class[] {});
		// 根据类的默认构造器来获得一个对象
		Object newInstance = constructor.newInstance(new Object[] {});
		
		//獲得setname方法，并且为其设置值
		Method method01 = clazz01.getDeclaredMethod("setName", new Class[]{String.class});
		Object invoke01 = method01.invoke(newInstance, new Object[]{"張三"});
		
		//获得getname方法，
		Method method02 = clazz01.getDeclaredMethod("getName",new Class[]{});
		Object invoke02= method02.invoke(newInstance, new Class[]{});
		
	    //靜態方法被反射調用
		Method method03 = clazz01.getDeclaredMethod("printInfo",null);
		Object invoke03 = method03.invoke(null, null);
	}
}
