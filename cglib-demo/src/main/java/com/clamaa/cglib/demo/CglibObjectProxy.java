package com.clamaa.cglib.demo;

import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * User: mazhqa
 * Date: 14-3-6
 */
public class CglibObjectProxy {

    @SuppressWarnings("rawtypes")
    public static Object ceateProxtObject(final Object object, Class clazz) {
        // 声明增加类实例
        Enhancer en = new Enhancer();
        // 设置被代理类字节码，CGLIB根据字节码生成被代理类的子类
        en.setSuperclass(clazz);
        // 设置回调函数，即一个方法拦截
        en.setCallback(new MethodInterceptor() {

            @Override
            public Object intercept(Object arg0, Method method, Object[] args,
                                    MethodProxy arg3) throws Throwable {
                // 注意参数object,仍然为外部声明的源对象，且Method为JDK的Method反射
                System.out.println("delegate start...");
                Object o = method.invoke(object, args);
                System.out.println("delegate stop...");
                return o;
            }
        });
        en.setCallbackFilter(new CallbackFilter() {
            @Override
            public int accept(Method method) {
                return 0;  //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        return en.create();
    }

    public static void main(String[] args) {
        // 未实现接口的类的代理
        Person proxyPerson = (Person) CglibObjectProxy.ceateProxtObject(new Person(), Person.class);
        proxyPerson.active("Talk with sb.");
        // 实现接口的类的代理
        IAnimal proxyDog = (IAnimal) CglibObjectProxy.ceateProxtObject(new Dog(), Dog.class);
        proxyDog.active("Dog lying ...........");
    }

}
