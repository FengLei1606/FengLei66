package fl.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
   public static void main(String[] args) throws Exception{
	   //(1)根据一个类的全名字符串来获得一个类的对象
	   Class<?> clazz=Class.forName("fl.reflect.Student");
	 //获得构造器
	      Constructor<?> c=clazz.getConstructor(new Class[]{});
	     // Constructor<?> c1=clazz.getConstructor(new Class[]{String.class, int.class, String.class, String.class });
	      //System.out.println(c);
	      //System.out.println(c1);
	     // System.out.println("----------------------------------------------------------");
	      //根据类默认的构造器获得对象
	       Object instance=c.newInstance(new Object[]{});
	       //Object instance1=c1.newInstance(new Object[]{"fenglei",1,"nan","IOT"});
	       System.out.println(instance);
	       //System.out.println(instance1);
	       //System.out.println("----------------------------------------------------------");
	  
	   //获得一个类对象的属性
	   /*Field field=clazz.getDeclaredField("name");
	   System.out.println(field);
	   System.out.println("----------------------------------------------------------");

	      //获得一个具体的方法
	      Method method=clazz.getDeclaredMethod("getName",new Class[]{});
	      Method method1=clazz.getDeclaredMethod("setName",new Class[]{String.class});
	      System.out.println(method);
	      System.out.println(method1);
	      System.out.println("----------------------------------------------------------"); */
	      //获得所有方法
	      Method[] declaredMethods = clazz.getDeclaredMethods();
	      //遍历所有的方法
	      for(Method m:declaredMethods){
	    	  //获得方法的名字
	    	  String name=m.getName();
	    	  boolean startsWith = name.startsWith("set");
	    	  if(startsWith){
	    		  //获得到了set字符串后面的值
	    		  String fieldName=name.substring(3);
	    		  //获得属性的名字
	    		  fieldName=fieldName.substring(0,1).toLowerCase()+fieldName.substring(1);
	    		 Field field = clazz.getDeclaredField(fieldName);
	    		 //获得方法的具体类型
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