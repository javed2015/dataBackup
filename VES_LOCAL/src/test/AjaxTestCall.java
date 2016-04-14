package test;


public class AjaxTestCall {
	public String add(){
		String ans = "";
		int result = 0;
		int a=2;
		int b=3;
		try {
			Thread.sleep(5000);
			result = a+b;
			ans =String.valueOf(result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(ans);
		return ans;
	}
	public String sub(){
		String ans = "";
		int result = 0;
		int a=2;
		int b=3;
		try {
			Thread.sleep(5000);
			result = a-b;
			ans =String.valueOf(result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(ans);
		return ans;
	}
	public String multiply(){
		String ans = "";
		int result = 0;
		int a=2;
		int b=3;
		try {
			Thread.sleep(5000);
			result = a*b;
			ans =String.valueOf(result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(ans);
		return ans;
	}

}
