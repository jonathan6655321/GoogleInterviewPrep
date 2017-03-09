public class GitSetupTest {
	public static interface GraphInterface{
		void insert(int[] arr);
		boolean connected(int a, int b);
	}
	
	public static boolean test1(GraphInterface g){
		g.insert(new int[0]);		//0
		g.insert(new int[]{0});		//1
		g.insert(new int[]{0});		//2
		g.insert(new int[]);		//3
		g.insert(new int[]{1,3});	//4
		g.insert(new int[]{2});		//5
		g.insert(new int[]{3,5});	//6
		g.insert(new int[]{0,6});	//7
		g.insert(new int[]);		//8
		g.insert(new int[]{8});		//9
		g.insert(new int[]{7});		//10
		g.insert(new int[]);		//11
		g.insert(new int[]{10});	//12
		g.insert(new int[]{4,8});	//13
		g.insert(new int[]{11,12});	//14
		g.insert(new int[]{11,13});	//15
		g.insert(new int[]{8});		//16
		
		boolean failed = false;
		int i = 1;
//		Set 1: 1, 11
		if(g.connected(1,11)){
			failed = true;
			System.out.println(i);
		}i++;
//		Set 2: 0, 15
		if(!g.connected(0,15)){
			failed = true;
			System.out.println(i);
		}i++;
//		Set 3: 2, 7
		if(!g.connected(2,7)){
			failed = true;
			System.out.println(i);
		}i++;
//		Set 4: 5, 9
		if(g.connected(5,9)){
			failed = true;
			System.out.println(i);
		}i++;
//		Set 5: 6, 15
		if(g.connected(6,15)){
			failed = true;
			System.out.println(i);
		}i++;
//		Set 6: 7, 11
		if(g.connected(7,11)){
			failed = true;
			System.out.println(i);
		}i++;
//		Set 7: 3, 8
		if(g.connected(3,8)){
			failed = true;
			System.out.println(i);
		}i++;
//		Set 8: 10, 11
		if(g.connected(10,11)){
			failed = true;
			System.out.println(i);
		}i++;
//		Set 9: 1, 9
		if(g.connected(1,9)){
			failed = true;
			System.out.println(i);
		}i++;
//		Set 10: 3, 12
		if(!g.connected(3,12)){
			failed = true;
			System.out.println(i);
		}i++;
//		Set 11: 10, 16
		if(g.connected(10,16)){
			failed = true;
			System.out.println(i);
		}i++;
//		Set 12: 1, 6
		if(g.connected(1,6)){
			failed = true;
			System.out.println(i);
		}i++;
//		Set 13: 10, 13
		if(g.connected(10,13)){
			failed = true;
			System.out.println(i);
		}i++;
//		Set 14: 4, 9
		if(g.connected(4,9)){
			failed = true;
			System.out.println(i);
		}i++;
//		Set 15: 3, 15
		if(!g.connected(3,15)){
			failed = true;
			System.out.println(i);
		}i++;
//		Set 16: 10, 11
		if(g.connected(10,11)){
			failed = true;
			System.out.println(i);
		}i++;
//		Set 17: 0, 6
		if(!g.connected(0,6)){
			failed = true;
			System.out.println(i);
		}i++;
//		Set 18: 2, 10
		if(!g.connected(2,10)){
			failed = true;
			System.out.println(i);
		}i++;
//		Set 19: 1, 6
		if(g.connected(1,6)){
			failed = true;
			System.out.println(i);
		}i++;
//		Set 20: 0, 8
		if(g.connected(0,8)){
			failed = true;
			System.out.println(i);
		}i++;
		return !failed;
	}
}
