package cn.edu.ustb.cbwstc.tsg;

import java.util.ArrayList;


public class TestSequenceModel {
	
	private ArrayList<TeatSequence> TeatSequenceList = new ArrayList<TeatSequence>();

	public ArrayList<TeatSequence> getTeatSequenceList() {
		return TeatSequenceList;
	}

	public void setTeatSequenceList(ArrayList<TeatSequence> teatSequenceList) {
		TeatSequenceList = teatSequenceList;
	}
	
	/**
	 * ÒÀ¾ÝTeatSequence¸ÃTeatSequenceµÄÐòºÅ
	 * @param str
	 * @return
	 */
	public int getTeatSequence(String str) {
		for (int i=0;i<TeatSequenceList.size();i++) {
			if(TeatSequenceList.get(i).getTs().equals(str)) {
				return TeatSequenceList.get(i).getTcId();
			}
		}
		return 0;
	}
	
}
