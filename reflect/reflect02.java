package fl.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class reflect02 {

	public static void main(String[] args) throws Exception {
		// ����һ�����ȫ���ַ��������һ����Ķ���
				Class<?> clazz02 = Class.forName("fl.reflect.Student");
				// ���Ĭ�ϵĹ�����
				Constructor<?> constructor = clazz02.getDeclaredConstructor(new Class[] {});
				// �������Ĭ�Ϲ����������һ������
				Object newInstance02 = constructor.newInstance(new Object[] {});
				//�����������֫@�Ì��Ԍ���
				Field field = clazz02.getDeclaredField("name");
				//�������䣬�Ɖĵ�name��˽�Ќ���
				field.setAccessible(true);
				field.set(newInstance02,"����");//��name��˽�еČ��ԣ�����ֱ�ӵ��O��ֵ
				//�@�Ì��Ե����
			Class<?> type = field.getType();
			System.out.print(type);
			
				

	}

}
