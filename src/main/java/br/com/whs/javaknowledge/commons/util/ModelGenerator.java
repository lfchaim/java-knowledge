package br.com.whs.javaknowledge.commons.util;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class ModelGenerator {

	private ModelGenerator() {}
	
	private static class SingletonHelper{
		private static final ModelGenerator INSTANCE = new ModelGenerator();
	}
	
	public static ModelGenerator getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	public static Field[] getDeclaredField( Object obj ) {
		return obj.getClass().getDeclaredFields();
	}
	
	public static List<String> getDeclaredFieldName( Object obj ) {
		Field[] f = obj.getClass().getDeclaredFields();
		List<String> ret = new ArrayList<>();
		for( int i = 0; i < f.length; i++ ) {
			ret.add(f[i].getName());
		}
		return ret;
	}

	public static <T> T createAndFill(Class<T> klass) throws Exception {
        T instance = klass.newInstance();
        for(Field field: klass.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = getRandomValueForField(field);
            field.set(instance, value);
        }
        return instance;
    }
 
    private static Object getRandomValueForField(Field field) throws Exception {
        Class<?> type = field.getType();
        Random random = new Random();
        // Note that we must handle the different types here! This is just an 
        // example, so this list is not complete! Adapt this to your needs!
        if(type.isEnum()) {
            Object[] enumValues = type.getEnumConstants();
            return enumValues[random.nextInt(enumValues.length)];
        } else if(type.equals(Integer.TYPE) || type.equals(Integer.class)) {
            return random.nextInt();
        } else if(type.equals(Long.TYPE) || type.equals(Long.class)) {
            return random.nextLong();
        } else if(type.equals(Double.TYPE) || type.equals(Double.class)) {
            return random.nextDouble();
        } else if(type.equals(Float.TYPE) || type.equals(Float.class)) {
            return random.nextFloat();
        } else if(type.equals(String.class)) {
            return UUID.randomUUID().toString();
        } else if(type.equals(BigInteger.class)){
            return BigInteger.valueOf(random.nextInt());
        } else if(type.equals(Date.class)){
            return new Date();
        }
        return createAndFill(type);
    }
}
