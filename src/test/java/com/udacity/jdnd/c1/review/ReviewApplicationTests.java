package com.udacity.jdnd.c1.review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReviewApplicationTests {
	public static WebDriver driver;


	@LocalServerPort
	public int port;


	public String baseURL;

	@BeforeAll
	public static void setUpDriver(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterAll
	public static void tearDown(){
		driver.quit();
	}

	@BeforeEach
	public void enterURL(){
		baseURL = "http://localhost:" + port + "/";
	}

	@Test
	void contextLoads() {
		String firstName = "test";
		String lastName = "user5";
		String username = firstName + lastName;
		String password = "d0e0v09999";
		String message = "hello";

		driver.get(baseURL + "signup");
		new SignupPage(driver).signUp(firstName, lastName, username, password);

		driver.get(baseURL + "login");
		new LoginPage(driver).login(username, password);

		driver.get(baseURL + "chat");
		ChatPage chat = new ChatPage(driver);
		chat.enterMessage(message);

		assertEquals(username, chat.getFirstMessage().getUsername());
		assertEquals(message, chat.getFirstMessage().getMessage());

	}



}
