package ch.ti.bfh.physio_app.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Jonas on 05.05.2017.
 */
public class Test {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {

        Class<MyAnnotatedClass> clazz = MyAnnotatedClass.class;

        MyAnnotatedClass instance = clazz.newInstance();

        for (Method method : clazz.getMethods()) {
            if(method.isAnnotationPresent(MyAnnotation.class)) {
                method.invoke(instance, null);
            }
        }

    }

}
