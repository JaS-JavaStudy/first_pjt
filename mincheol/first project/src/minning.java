// -1�� ����, ���ڴ� �ֺ��� ���� ������ ������� �ż����� ����� ���Դϴ�.

import java.util.*;

public class minning {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("����, ���� ����� �Է����ּ���!");
		int[][] mined= sizing(sc.nextInt(), sc.nextInt());
		if (mined[0][0]==-1) {
			main(args);
			//���ϴ� ���� �ȳ��� ��� �ٽ� ó������ ���ư� �Է��� �޵����Ѵ�.
		}
		mining(mined);
		number(mined);
		int[][] ground = sizing(mined.length, mined[0].length);
		
		printers(mined);
	
	}
	
	static int[][] sizing(int N,int M) {
		//4�� �̻��� ĭ�� ���� ��쿡�� ������ �ǵ��� �Ѵ�.
		if(N<=0 || M<=0) {
			System.out.println("0���� ū ���� �Է����ּ���.");
			return new int[][]{{-1}};
		}else if (N*M<4) {
			System.out.println("4ĭ �̻��� �����Ǿ��մϴ�.");
			return new int[][]{{-1}};
		}
		int[][] temp1 = new int[N][M];
		return temp1;
	}

	static void mining(int[][] arrays) {
		// �迭�� ũ�⿡ �°� itemStrings�� ����, 4������ -1(����)�� ���� �� �ֵ��� �Ѵ�.
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
		// Random Ŭ������ �̿��� ������ ���� �־��� �� �ֵ����Ѵ�.
		for (int i = 0; i < arrays.length; i++) {
			for (int j = 0; j < arrays[i].length; j++) {
				arrays[i][j]=itemStrings.remove(random.nextInt(itemStrings.size()));
			}
		}
	}
	static void printers(int[][] arrays) {
		// ���ڸ� �̻� ������� ����� �� �ֵ��� ���ش�.
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
		// 8���� ������ ���� ���ڰ� ������ 1�� �߰��� �־��ش�.
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

