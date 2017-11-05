package fl.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CopyObj {

	public static void main(String[] args) throws Exception {
		Student s=new Student();
		s.setId(1);
		s.setName("wangwu");
		s.setProfessional("物聯網");
		s.setSex("nan");
		
		//copy一個s對象
		Object object=CopyObj(s);
		System.out.print(object);

	}
	
	public static Object CopyObj(Object obj) throws Exception{
		//獲得傳遞過來的屬性和構造器
		Class<? extends Object> class1 = obj.getClass();
		Field[] declaredFields = class1.getDeclaredFields();
		Constructor<? extends Object> constructor = class1.getConstructor(new Class[]{});
		//創建一個對象
		Object newInstance = constructor.newInstance(new Object[]{});
		for(Field f:declaredFields){
			//獲得屬性名字
			String fname=f.getName();
			//獲得屬性的類型那個
			Class<?> type = f.getType();
			//獲得對應的set的方法
			String setMethodName="set"+fname.substring(0,1).toUpperCase()+fname.substring(1);
			String getMethodName="get"+fname.substring(0,1).toUpperCase()+fname.substring(1);
			
			//獲得get方法
			Method declaredMethod = class1.getDeclaredMethod(getMethodName, null);
			//調用get方法獲得被拷貝對象的一個屬性值
			Object invoke = declaredMethod.invoke(obj, null);
			//獲得set方法
            Method declaredMethod2 = class1.getDeclaredMethod(setMethodName, new Class[]{declaredMethod.getReturnType()});
            declaredMethod2.invoke(newInstance, new Object[]{invoke});
		}
		return newInstance;
		
	}

}
