package com.jiwon.bmi;

import java.io.*;

public class Main {
	// main������ ����ڿ��� �Է¹ް� ����� ���
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ����ڿ��� �Է� �ޱ�
		System.out.print("Ű�� �Է����ּ���: ");
		double clientHeight = Double.parseDouble(br.readLine());
		System.out.print("�����Ը� �Է����ּ���: ");
		double clientWeight = Double.parseDouble(br.readLine());
		// ����� bmi ��� �� ���
		double clientBmi = getBmi(clientWeight, clientHeight);
		System.out.println("���� BMI ��ġ�� " + clientBmi + " �Դϴ�.");
		// ������� ���� �������� �� ���
		String clientStatus = getStatus(clientBmi);
		System.out.println("���� " + clientStatus + " �Դϴ�.");
	}
	// ������� �Է� ���� ���� bmi ���
	static double getBmi(double kg, double cm) {
		double m = cm / 100;
		return kg / (m * m);
	}
	// ������� bmi�� ���� ����
	static String getStatus(double bmi) {
		String status;
		if (bmi < 18.5) status = "��ü��";
		else if (bmi < 23.0) status = "����";
		else if (bmi < 25.0) status = "�� �� �ܰ�";
		else if (bmi < 30.0) status = "1�ܰ� ��";
		else if (bmi < 35.0) status = "2�ܰ� ��";
		else status = "3�ܰ� ��";
		
		return status;
	}
}