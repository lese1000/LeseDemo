package tech.lese.demo.other.test;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SomeTest {

	public static void main(String[] args) {
		
		System.out.println();
		SomeTest s = new SomeTest();
		s.getPath();
	}
	
	public void getPath(){
		System.out.println(this.getClass().getResource("/").getPath());
	}
	
	public static <T> void testFanxing(T t){
		System.out.println(t.getClass());
	}
	
	public static <K,V> Map<K,V>  newHashMap(){
		return new HashMap<K, V>();
	}
	
	public static <K,V> List<K> newArrayList(){
		return new ArrayList<K>();
	}
	
	public static Map<String,? > newHashMap2(){
		return new HashMap<String, String>();
	}
	
	@SuppressWarnings("unchecked")
	public <T> Class<T> getEntityClass(){
		ParameterizedType p =(ParameterizedType) this.getClass().getGenericSuperclass();
		return (Class<T>) p.getActualTypeArguments()[0];
	}
	
	public static <K> List<K> getList(){
		return  new  ArrayList<>();
	}

}
