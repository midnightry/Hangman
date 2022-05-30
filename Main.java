import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Random;

public class Main {
	private List<String> words = new ArrayList<>();
	private Scanner scan = new Scanner(System.in);
	private Random rad = new Random();

	public void Menu() {
		int pilih = 0;
		do {
			System.out.println("Menu: ");
			System.out.println("1. Add Data\n" + "2. Look Data\n" + "3. Game\n" + "4. Exit");
			System.out.println("Pilih menu: ");
			try {
				pilih = scan.nextInt();
			} catch (Exception e) {
				pilih = 0;
			}
			scan.nextLine();
			switch (pilih) {
			case 1:
				addWord();
				break;
			case 2:
				if (words.isEmpty()) {
					System.out.println("There is no data!");
				} else {
					Show();
				}
				break;
			case 3:
				if (words.isEmpty()) {
					System.out.println("There is no data!");
				} else {
					game();
				}
				break;
			case 4:
				return;
			}
		} while (pilih != 4);
	}

	public void addWord() {
		String newword;
		do {
			System.out.println("Masukkan kata:");
			newword = scan.nextLine();
		} while (newword.length() < 5 || newword.length() > 50);

		if (words.contains(newword)) {
			System.out.println("Kata sudah dimasukkan");
			addWord();
		} else {
			words.add(newword);
			System.out.println("Kata berhasil dimasukkan");
		}

	}

	public void Show() {
		System.out.println("List Kata:");
		for (int i = 0; i < words.size(); i++) {
			System.out.printf("- %s\n", words.get(i));
		}
		return;
	}

	public void game() {
		char ch;
		int index = rad.nextInt(words.size());
		String word = words.get(index);
		char[] key = word.toCharArray();
		String answer;
		int pos;
		int st = 0;
		int len = word.length();
		int count = 0;
		for (int i = 0; i < key.length; i++)
			key[i] = '-';
		do {
			print(key);
			System.out.print("Tekan huruf:");
			answer = scan.nextLine();
			ch = answer.charAt(0);
			do {
				
				boolean res = check(word, ch, st, len);
				if (res == true)
					count++;
				pos = getPosition(word, ch, st, len);
				if (pos == -1)
					break;
				key[pos] = ch;
				st = pos + 1;
			} while (st < len);
			st = 0;
			pos = 0;
			
		} while (count != len);
		System.out.println("Selamat! Anda berhasil!");
	}

	public boolean check(String word, char ch, int st, int len) {
		for (int i = st; i < len; i++) {
			if (word.charAt(i) == ch) {
				return true;
			}
		}
		return false;
	}

	public int getPosition(String word, char ch, int st, int len) {
		for (int i = st; i < len; i++)
			if (word.charAt(i) == ch) {
				return i;
			}
		return -1;
	}

	public void print(char[] key) {
		System.out.print(key);
		System.out.println();
	}

	public Main() {
		Menu();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
