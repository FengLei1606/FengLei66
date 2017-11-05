package fl.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class reflect02 {

	public static void main(String[] args) throws Exception {
		// 根据一个类的全名字符串来获得一个类的对象
				Class<?> clazz02 = Class.forName("fl.reflect.Student");
				// 获得默认的构造器
				Constructor<?> constructor = clazz02.getDeclaredConstructor(new Class[] {});
				// 根据类的默认构造器来获得一个对象
				Object newInstance02 = constructor.newInstance(new Object[] {});
				//根據方法名字獲得屬性對象
				Field field = clazz02.getDeclaredField("name");
				//暴力反射，破壞掉name的私有屬性
				field.setAccessible(true);
				field.set(newInstance02,"張三");//因爲name是私有的屬性，不能直接的設置值
				//獲得屬性的類型
			Class<?> type = field.getType();
			System.out.print(type);
			
				

	}

}
