package fl.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CopyObj {

	public static void main(String[] args) throws Exception {
		Student s=new Student();
		s.setId(1);
		s.setName("wangwu");
		s.setProfessional("���W");
		s.setSex("nan");
		
		//copyһ��s����
		Object object=CopyObj(s);
		System.out.print(object);

	}
	
	public static Object CopyObj(Object obj) throws Exception{
		//�@�Â��f�^��Č��Ժ͘�����
		Class<? extends Object> class1 = obj.getClass();
		Field[] declaredFields = class1.getDeclaredFields();
		Constructor<? extends Object> constructor = class1.getConstructor(new Class[]{});
		//����һ������
		Object newInstance = constructor.newInstance(new Object[]{});
		for(Field f:declaredFields){
			//�@�Ì�������
			String fname=f.getName();
			//�@�Ì��Ե�����ǂ�
			Class<?> type = f.getType();
			//�@�Ì�����set�ķ���
			String setMethodName="set"+fname.substring(0,1).toUpperCase()+fname.substring(1);
			String getMethodName="get"+fname.substring(0,1).toUpperCase()+fname.substring(1);
			
			//�@��get����
			Method declaredMethod = class1.getDeclaredMethod(getMethodName, null);
			//�{��get�����@�ñ���ؐ�����һ������ֵ
			Object invoke = declaredMethod.invoke(obj, null);
			//�@��set����
            Method declaredMethod2 = class1.getDeclaredMethod(setMethodName, new Class[]{declaredMethod.getReturnType()});
            declaredMethod2.invoke(newInstance, new Object[]{invoke});
		}
		return newInstance;
		
	}

}
