package com.jiwon.bmi;

import java.io.*;

public class Main {
	// main에서는 사용자에게 입력받고 결과를 출력
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 사용자에게 입력 받기
		System.out.print("키를 입력해주세요: ");
		double clientHeight = Double.parseDouble(br.readLine());
		System.out.print("몸무게를 입력해주세요: ");
		double clientWeight = Double.parseDouble(br.readLine());
		// 사용자 bmi 계산 및 출력
		double clientBmi = getBmi(clientWeight, clientHeight);
		System.out.println("현재 BMI 수치는 " + clientBmi + " 입니다.");
		// 사용자의 상태 가져오기 및 출력
		String clientStatus = getStatus(clientBmi);
		System.out.println("현재 " + clientStatus + " 입니다.");
	}
	// 사용자의 입력 값에 따라 bmi 계산
	static double getBmi(double kg, double cm) {
		double m = cm / 100;
		return kg / (m * m);
	}
	// 사용자의 bmi에 따른 상태
	static String getStatus(double bmi) {
		String status;
		if (bmi < 18.5) status = "저체중";
		else if (bmi < 23.0) status = "정상";
		else if (bmi < 25.0) status = "비만 전 단계";
		else if (bmi < 30.0) status = "1단계 비만";
		else if (bmi < 35.0) status = "2단계 비만";
		else status = "3단계 비만";
		
		return status;
	}
}