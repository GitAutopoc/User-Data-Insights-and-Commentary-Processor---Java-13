package com.user.assessment;

import java.util.List;

public class UserProcessor {

	public static String generateReport(List<User> users) {
		int totalCount = users.size();
		int validEmailCount = 0;
		int totalUsernameLength = 0;
		int validUsernameCount = 0;

		for (User user : users) {
			try {
				checkForNull(user);
				if (user.getEmail() != null) {
					validEmailCount++;
				}
				if (user.getUsername() != null) {
					totalUsernameLength += user.getUsername().length();
					validUsernameCount++;
				}
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
			}
		}

		double averageUsernameLength = validUsernameCount > 0 ? (double) totalUsernameLength / validUsernameCount : 0.0;

		return String.format("Total users: %d%n" + "Users with valid email: %d%n" + "Average username length: %.2f",
				totalCount, validEmailCount, averageUsernameLength);
	}

	private static void checkForNull(User user) throws NullPointerException {
		if (user.getUsername() == null)
			throw new NullPointerException("Username is null for user.");
		if (user.getEmail() == null)
			throw new NullPointerException("Email is null for user.");
		if (user.getAddress() == null)
			throw new NullPointerException("Address is null for user.");
	}

	public static void main(String[] args) {
		List<User> users = List.of(new User("john_doe", "john@example.com", "123 Maple St"),
				new User("jane_doe", null, "456 Elm St"), new User(null, "jane@example.com", "789 Pine St"));

		String report = generateReport(users);
		System.out.println(report);
	}
}
