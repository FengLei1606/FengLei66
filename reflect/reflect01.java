package fl.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class reflect01 {
	public static void main(String[] args) throws Exception {
		// ����һ�����ȫ���ַ��������һ����Ķ���
		Class<?> clazz01 = Class.forName("fl.reflect.Student");
		// ���Ĭ�ϵĹ�����
		Constructor<?> constructor = clazz01.getDeclaredConstructor(new Class[] {});
		// �������Ĭ�Ϲ����������һ������
		Object newInstance = constructor.newInstance(new Object[] {});
		
		//�@��setname����������Ϊ������ֵ
		Method method01 = clazz01.getDeclaredMethod("setName", new Class[]{String.class});
		Object invoke01 = method01.invoke(newInstance, new Object[]{"����"});
		
		//���getname������
		Method method02 = clazz01.getDeclaredMethod("getName",new Class[]{});
		Object invoke02= method02.invoke(newInstance, new Class[]{});
		
	    //�o�B�����������{��
		Method method03 = clazz01.getDeclaredMethod("printInfo",null);
		Object invoke03 = method03.invoke(null, null);
	}
}
