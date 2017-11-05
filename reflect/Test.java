package fl.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
   public static void main(String[] args) throws Exception{
	   //(1)����һ�����ȫ���ַ��������һ����Ķ���
	   Class<?> clazz=Class.forName("fl.reflect.Student");
	 //��ù�����
	      Constructor<?> c=clazz.getConstructor(new Class[]{});
	     // Constructor<?> c1=clazz.getConstructor(new Class[]{String.class, int.class, String.class, String.class });
	      //System.out.println(c);
	      //System.out.println(c1);
	     // System.out.println("----------------------------------------------------------");
	      //������Ĭ�ϵĹ�������ö���
	       Object instance=c.newInstance(new Object[]{});
	       //Object instance1=c1.newInstance(new Object[]{"fenglei",1,"nan","IOT"});
	       System.out.println(instance);
	       //System.out.println(instance1);
	       //System.out.println("----------------------------------------------------------");
	  
	   //���һ������������
	   /*Field field=clazz.getDeclaredField("name");
	   System.out.println(field);
	   System.out.println("----------------------------------------------------------");

	      //���һ������ķ���
	      Method method=clazz.getDeclaredMethod("getName",new Class[]{});
	      Method method1=clazz.getDeclaredMethod("setName",new Class[]{String.class});
	      System.out.println(method);
	      System.out.println(method1);
	      System.out.println("----------------------------------------------------------"); */
	      //������з���
	      Method[] declaredMethods = clazz.getDeclaredMethods();
	      //�������еķ���
	      for(Method m:declaredMethods){
	    	  //��÷���������
	    	  String name=m.getName();
	    	  boolean startsWith = name.startsWith("set");
	    	  if(startsWith){
	    		  //��õ���set�ַ��������ֵ
	    		  String fieldName=name.substring(3);
	    		  //������Ե�����
	    		  fieldName=fieldName.substring(0,1).toLowerCase()+fieldName.substring(1);
	    		 Field field = clazz.getDeclaredField(fieldName);
	    		 //��÷����ľ�������
	    		  Class<?> type = field.getType();
	    		  
	    		  if(type==String.class&&"name".equals(fieldName)){
	    			  m.invoke(instance, new Object[]{"fenglei"});
	    		  }
	    		  if(type==String.class&&"sex".equals(fieldName)){
	    			  m.invoke(instance, new Object[]{"nan"});
	    		  }
	    		  if(type==String.class&&"professional".equals(fieldName)){
	    			  m.invoke(instance, new Object[]{"IOT"});
	    		  }
	    		  if(type==int.class){
	    			  m.invoke(instance, new Object[]{1});
	    		  }
	    	  }
	      }
	      System.out.println(instance); 

	      
	       
	   }

     }