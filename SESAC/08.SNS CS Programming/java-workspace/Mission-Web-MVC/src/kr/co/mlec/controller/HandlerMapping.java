package kr.co.mlec.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HandlerMapping {
	
	private Map<String, Controller> mappings = null;
	
	public HandlerMapping(String propLoc) {
		mappings = new HashMap<>();
		
		// 프로퍼티에서 키, 값 불러올 준비
		Properties prop = new Properties();
		
		try {
			
			// 프로퍼티 열기
			InputStream is = new FileInputStream(propLoc);
			prop.load(is);
			
			// prop.getProperty("/board/list.do"); 키에 따른 값 가져오기
			
			// 키값 가져오기
			Set<Object> keys = prop.keySet();
			for(Object key : keys) {
				
				// 클래스 이름을 알면 Class.forName("클래스명") 이용해서 동적 생성 가능
				String className = prop.getProperty(key.toString());
				Class<?> clz = Class.forName(className);
				mappings.put(key.toString(), (Controller)clz.newInstance());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// mappings.put("/board/list.do", new boardListController());
		// mappings.put("/board/writeForm.do", new boardWriteFormController());
	}
	
	public Controller getController(String uri) {
		return mappings.get(uri);
	}
	/*
	 * switch(uri) {
			case "/board/list.do" :
				control = new boardListController();
				break;
			case "/board/writeForm.do" :
				control = new boardWriteFormController();
				break;
		}
	 * 
	 */
	
	/*
	public static void main(String[] args) throws Exception {
		
		//java.util.Random r = new java.util.Random();
		//int random = r.nextInt(100);
		//System.out.println("추출된 난수 : " + random);
		
		
		Class<?> clz = Class.forName("java.util.Random");
		java.util.Random obj = (java.util.Random)clz.newInstance();
		int random = obj.nextInt(100);
		System.out.println("추출된 난수 : "+random);
	}
	*/

}



/*
 
 
 Spring 객체 만들 때 xml로 만들 수 있음
 
 <beans>
 	<bean class="kr.co.mlec.controller.BoardListController" id="list" />
 	<bean class="kr.co.mlec.controller.BoardWriteFormController" id="write" />
 </beans>
 
 
 or
 
 @Bean 어노테이션 사용
 
 	=> Controller list = new BoardListController();
 		Controller write = new BoardWriteFormController();
 
 */