package com.yedam.condition;

import java.util.Scanner;

public class WhileLoopExe2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		//어떤 조건일 동안 반복. =while
		int random = (int) (Math.random() * 100) +1;// 1~10 정수.
		while(true) {
			System.out.println("값 입력>>");
			int input = scn.nextInt();
			if(random > input) {
				System.out.println("입의값 보다 작습니다.");
				
			}
			else if(random < input) {
				System.out.println("입의값 보다 큽니다.");
				
			}
			else if(random == input) {
				System.out.printf("입의값 %d\n", random);
				break;
			}
//			System.out.println("틀린값입니다.");
		}
		
		System.out.printf("end of prog.");
	}
}

/*Scanner scn = new Scanner(System.in);
//어떤 조건일 동안 반복. =while
int random = (int) (Math.random() * 10) +1;// 1~10 정수.
while(true) {
	System.out.println("값 입력>>");
	if(random == scn.nextInt()) {
		System.out.printf("입의값 %d\n", random);
		break;
	}
	System.out.println("틀린값입니다.");
}

System.out.printf("end of prog.");
}*/


/*Scanner scn = new Scanner(System.in)   ;
int random = (int) (Math.random() * 10) +1 ; // 0 ~ 1까지의 임의의 실
while(true) {
System.out.println("값입력 >>");
   int a = scn.nextInt();
   if(random == a) {
      System.out.printf("임의값 %d \n" , random);
      break;
   }if (random < a) {
    System.out.printf("임의 값은 %d 보다 큽니다" , a);
    System.out.println(random);
    continue;}
//   }else {
      System.out.printf("임의 값은 %d 보다 작니다", a);
//   }
      
   
}
  System.out.println("end of prog");

  
}
}*/