package kr.co.mlec.day02;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * Map : key, value 쌍으로 구성된 데이터의 집합
 *   순서(x), key에 대한 중복(x)
 *   
 *   -HashMap
 *   -TreeMap
 * 
 */
public class MapMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		map.put("1","one");
		map.put("2","two");
		map.put("3","three");
		map.put("4","four");
		
		System.out.println("원소의 갯수 : "+map.size());
		System.out.println("key : 1 ====> value : "+map.get("1"));
		
		System.out.println("이전 값 : "+map.put("1", "하나")+", 바뀐 값 : "+map.get("1"));
		
		// key 5인 데이터가 없으면 key : 5, value : "FIVE" 삽입
		if(!map.containsKey("5"))
			map.put("5", "FIVE");
		System.out.println("key : 5 ====> value : "+map.get("5"));
		
		Set<Entry<String,String>> entry = map.entrySet();
		System.out.println(map.entrySet());
		
		System.out.println("<< Map 키와 value 전부 출력 1 >>");
		for (Entry etr : entry)
			System.out.println(etr);
		System.out.println("===========================");
		System.out.println();
		
		
		System.out.println("<< Map 키와 value 전부 출력 2 >>");
		for (Entry etr : entry)
			System.out.println("Key : " + etr.getKey() + ", value : "+ etr.getValue());
		System.out.println("===========================");
		System.out.println();
		
		System.out.println("<< Map 키와 value 전부 출력 3 >>");
		Set<String> keys = map.keySet();
		for(String key : keys)
			System.out.println("Key : "+key+", Value: "+map.get(key));
		System.out.println("===========================");
		System.out.println();
		
		
	}

}
/*
실제 사용자의 id,password 집합을 만들 때에는 List로 생성해서 만든다
* class Member {
*    private String id;
*    private String password;
*
*    public Member(String id, String password) {
*       this.id = id;
*       this.password = password
*        }
* }
*
* List<Member> members = new ArrayList<>
* members.add(new Member("aaa", "1111"));
* members.add(new Member("bbb", "2222"));
* members.add(new Member("ccc", "3333"));
* members.add(new Member("ddd", "4444"));

*/