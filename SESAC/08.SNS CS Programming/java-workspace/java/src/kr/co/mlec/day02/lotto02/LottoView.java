package kr.co.mlec.day02.lotto02;

import java.util.Arrays;
import java.util.Random;

public class LottoView {
	public void start()
	{
		/* 로또 번호 1~45 중 중복없이  6자리 */
		
		int[] lottoNums = new int[6];
		
		for (int game = 1; game <= 10; game++)
		{
			lottoNums = getLotto(); // 중복 없는 6개 숫자
			System.out.println(game +"게임 : "+Arrays.toString(lottoNums));
		}
	}
	
	public int[] getLotto()
	{
		// 중복 없이 출력하는 방법 4가지 이상
		Random rd = new Random();
		int[] result = new int[6];
		int num = 0;
		
		/* 강사님 Version 2 */
		
		int[] nums = new int[45];
		for (int i = 0; i < nums.length; i++)
		{
			nums[i] = i+1;
		}
		
		for (int i = 0; i < 6; i++)
		{
			int idx = rd.nextInt(45-i);
			result[i] = nums[idx];
			
			int temp = nums[idx];
			nums[idx] = nums[44-i];
			nums[44-i] = temp;
			
		}
		
		
		/* 1. 이중 for문으로 존재 여부 체크하면서 넣기
		select : for (int i = 0; i < 6; i++)
		{
			// 난수 생성
			num = rd.nextInt(45)+1;
			// 중복 검사
			for(int j = 0; j < i; j++)
			{
				if (result[j] == num)
				{
					i--;
					break select;
				}
			}
			// 배열에 입력
			result[i] = num;
		}
		*/
		
		/* 2. List 사용  - 순서 o, 중복 o
		//import java.util.ArrayList;
		//import java.util.List;
		
		List<Integer> nums = new ArrayList<>();
		while(nums.size() != 6)
		{
			// 난수 생성
			num = rd.nextInt(45)+1;
			// 중복 없으면 리스트에 추가
			if (!nums.contains(num))
				nums.add(num);
		}
		// 배열로 변환
		for (int i = 0; i < nums.size(); i++)
			result[i] = nums.get(i);
		*/

		
		/* 3. Set 사용 - 순서 x, 중복 x
		import java.util.HashSet;
		import java.util.Set;
		
		Set<Integer> nums = new HashSet<>();
		// 난수 Set에 추가
		while (nums.size() != 6)
			nums.add(rd.nextInt(45)+1);
		// 배열로 변환
		int idx = 0;
		for (Integer n : nums)
		{
			result[idx] = n;
			idx++;
		}
		*/
		
		/* 4. Map 사용 - 순서 x, key 중복 x(값은 o)
		import java.util.HashMap;
		import java.util.Map;
		
		Map<Integer, Integer> nums = new HashMap<>();
		int key = 0;
		
		// key 6개 될 때까지 반복
		while (key < 6)
		{
			// 난수 생성
			num = rd.nextInt(45)+1;
			// 난수 중복 시 재생성
			for (int i = 0; i < key; i++)
			{
				if (nums.get(i) == num)
				{
					num = rd.nextInt(45)+1;
					i = 0;
				}
			}
			// 중복 없을 경우 Map에 추가
			nums.put(key++, num);
		}
		// 배열로 변환
		for (int i = 0; i < nums.size(); i++)
			result[i] = nums.get(i);
		*/
		
		/* 5. 배열 인덱스
		// 0 ~ 44까지의 칸 생성, 숫자가 뽑히면 1, 아직 안 뽑히면 0값으로 체크할 예정
		int[] nums = new int[45];
		
		for (int tries = 0; tries < 6; tries++)
		{
			num = rd.nextInt(45);
			if (nums[num] != 0) // 해당되는 인덱스의 칸 값이 0이 아닐 경우 이미 있는 수
			{
				tries--;
				continue;
			}
			else // 해당되는 인덱스의 칸 값이 0일 경우 존재하지 않는 수, ++해줌
				nums[num]++;
		}
		
		int cnt = 0;
		for (int i = 0; i < 45; i++)
		{
			// 인덱스가 1인 숫자를 추려서 6칸짜리 배열에 넣어줌
			if (nums[i] != 0)
				result[cnt++] = i+1;
			// 6개 다 차면 for문 멈춤
			if (cnt >= 6)
				break;
		}
		*/
		
		return result;
	}
	
}
