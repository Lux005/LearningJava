package test;



import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class MainApp {


public static void main(String[] args) {
	   @SuppressWarnings("resource")
	  ApplicationContext context = 
             new ClassPathXmlApplicationContext("bean.xml");
  //   BeanFactory factory=
   // 		 new ClassPathXmlApplicationContext("Bean.xml");

      HelloWorld obj1 = (HelloWorld) context.getBean("helloWorld");
      
      obj1.getMessage();
      Fruit apple=(Fruit) context.getBean("apple");
      Fruit pear=(Fruit)context.getBean("pear");
      Button btn=(Button)context.getBean("button");
      Button btn2=(Button)context.getBean("button");
      Size size=(Size)context.getBean("mySize");
      size.setHeight(100);
      size.setWidth(100);
      btn2.setSize(size);
      btn2.disp();
      btn.disp();
   }
}

