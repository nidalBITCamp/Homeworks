package ba.bitcamp.weekend.homework.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MyMap {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the the key number: ");
		int key = input.nextInt();
		System.out.println("Enter the length of array: ");
		int size = input.nextInt();

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

		for (int i = 1; i < key; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = 1; j < size + i * i; j += i) {
				list.add(j);

			}
			map.put(i, list);

		}

		System.out.println(map);

	}

}
