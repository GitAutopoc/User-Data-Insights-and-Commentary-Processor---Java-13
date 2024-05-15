package com.user.assessment.functional;

import static com.task.assessment.testutils.TestUtils.businessTestFile;
import static com.task.assessment.testutils.TestUtils.currentTest;
import static com.task.assessment.testutils.TestUtils.yakshaAssert;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.user.assessment.User;
import com.user.assessment.UserProcessor;

public class FunctionalTests {

	@Test
	public void testAverageUsernameLength() throws IOException {
		List<User> users = List.of(new User("john_doe", "john@example.com", "123 Maple St"),
				new User("jane_doe", null, "456 Elm St"), new User("alice", "alice@example.com", "789 Pine St"));
		String report = normalizeString(UserProcessor.generateReport(users));
		String expectedOutput = normalizeString(
				"Total users: 3\n" + "Users with valid email: 2\n" + "Average username length: 6.50");
		yakshaAssert(currentTest(), expectedOutput.equals(report) ? "true" : "false", businessTestFile);
	}

	private String normalizeString(String input) {
		return input.replace("\r\n", "\n").trim();
	}
}
