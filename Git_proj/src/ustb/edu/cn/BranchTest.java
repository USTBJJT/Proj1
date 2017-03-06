package ustb.edu.cn;

public class BranchTest {
	
	private String user_name = null;
	private String pass_word = null;
	
	public String getName() {
		return user_name;
	}
	
	public String getPW() {
		return pass_word;
	}
	
	public void setName(String user_name) {
		this.user_name = user_name;
	}
	
	public void setPW(String pass_word) {
		this.pass_word = pass_word;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BranchTest bt = new BranchTest();
		bt.setName("USTB");
		bt.setPW("USTB");
		System.out.println(bt.getName());
		System.out.println(bt.getPW());
		
	}

}
