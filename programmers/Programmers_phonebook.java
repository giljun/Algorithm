
public class Programmers_phonebook {

	public static void main(String[] args) {
		String[] phone_book = { "119", "97674223", "1195524421" };

		boolean ans = solution(phone_book);

		System.out.println(ans);
	}

	public static boolean solution(String[] phone_book) {
		for (int i = 0; i < phone_book.length - 1; i++) {
			String phone_number = phone_book[i];
			for (int j = 0; j < phone_book.length; j++) {
				if (i != j && phone_book[j].startsWith(phone_number)) {
					return false;
				}
			}
		}
		return true;
	}
}
