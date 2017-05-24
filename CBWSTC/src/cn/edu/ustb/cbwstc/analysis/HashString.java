package cn.edu.ustb.cbwstc.analysis;

import java.util.*;

public class HashString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringToHash('g');
	}
	
	public static void StringToHash(Character s) {
		ArrayList<Character> list=new ArrayList<Character>();
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		list.add(s);
		if(map.containsKey(s)) {
			int count = map.get(s).intValue();
			count++;
			map.put(s,count);
		}else {
			map.put(s, 1);
		}
		for(Character key : list) {
			if(map.get(key) == 1) {
				System.out.println(key);
				break;
			}
		}
	}
	
	private Map<Character,Integer> map = new HashMap<Character,Integer>();
    private ArrayList<Character> list=new ArrayList<Character>();
    public void Insert(char ch)
    {
        list.add(ch);
        if(map.containsKey(ch)) {
				int count = map.get(ch).intValue();
				count++;
				map.put(ch,count);
			}else {
				map.put(ch, 1);
			}
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    	for(Character key : list) {
			if(map.get(key) == 1) {
				return key;
			}
		}
		return '#';
	
    }

}
