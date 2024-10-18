// -1은 지뢰, 숫자는 주변의 지뢰 갯수로 만들어진 매설지를 만드는 것입니다.

import java.util.*;

public class minning {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("세로, 가로 사이즈를 입력해주세요!");
		int[][] mined= sizing(sc.nextInt(), sc.nextInt());
		if (mined[0][0]==-1) {
			main(args);
			//원하는 값이 안나올 경우 다시 처음으로 돌아가 입력을 받도록한다.
		}
		mining(mined);
		number(mined);
		int[][] ground = sizing(mined.length, mined[0].length);
		
		printers(mined);
	
	}
	
	static int[][] sizing(int N,int M) {
		//4개 이상의 칸이 있을 경우에만 생성이 되도록 한다.
		if(N<=0 || M<=0) {
			System.out.println("0보다 큰 값을 입력해주세요.");
			return new int[][]{{-1}};
		}else if (N*M<4) {
			System.out.println("4칸 이상이 생성되야합니다.");
			return new int[][]{{-1}};
		}
		int[][] temp1 = new int[N][M];
		return temp1;
	}

	static void mining(int[][] arrays) {
		// 배열의 크기에 맞게 itemStrings를 생성, 4개마다 -1(지뢰)를 넣을 수 있도록 한다.
		int cnt=1;
		ArrayList<Integer> itemStrings = new ArrayList<>();
		for (int i = 0; i < arrays.length; i++) {
			for (int j = 0; j < arrays[i].length; j++) {
				cnt+=1;
				if (cnt%4==0) {
					itemStrings.add(-1);
				}else {
					itemStrings.add(0);
				}
			}
		}
		Random random = new Random();
		// Random 클래스를 이용해 랜덤한 값을 넣어줄 수 있도록한다.
		for (int i = 0; i < arrays.length; i++) {
			for (int j = 0; j < arrays[i].length; j++) {
				arrays[i][j]=itemStrings.remove(random.nextInt(itemStrings.size()));
			}
		}
	}
	static void printers(int[][] arrays) {
		// 지뢰를 이쁜 모양으로 출력할 수 있도록 해준다.
		for (int i = 0; i < arrays.length; i++) {
			for (int j = 0; j < arrays[i].length; j++) {
				System.out.print("|");
				if (arrays[i][j]==-1) {
					System.out.print(arrays[i][j]);
					System.out.print(" ");
					
				}else {
					System.out.print(" ");
					System.out.print(arrays[i][j]);
					System.out.print(" ");
				}
			}
			System.out.println('|');
			
		}
	}
	static void number(int[][] arrays) {
		// 8가지 방향을 보고 지뢰가 있으면 1을 추가해 넣어준다.
		int[] dir_i= {-1,-1,-1,0,0,0,1,1,1};
		int[] dir_j= {-1,0,1,-1,0,1,-1,0,1};
		for (int i = 0; i < arrays.length; i++) {
			for (int j = 0; j < arrays[i].length; j++) {
				int cnt=0;
				if(arrays[i][j]==0) {
					for(int d=0;d<8;d++) {
						if (0<=dir_i[d]+i && 0<=dir_j[d]+j && dir_i[d]+i<arrays.length && dir_j[d]+j< arrays[i].length && arrays[dir_i[d]+i][dir_j[d]+j]==-1) {
							cnt+=1;
						}
					}
				arrays[i][j]= cnt ;
				}

			}
		}
	}
	
}

