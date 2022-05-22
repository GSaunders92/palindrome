package com.gsaunders.palindrome;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;



@SpringBootTest
@AutoConfigureMockMvc
class PalindromeApplicationTests {

	@Autowired
	private MockMvc mvc;
	@Test
	void test_palindrome_api() throws Exception {
		mvc.perform(get("/?username=kayak", 1)).andExpect(content().string("kayak is a Palindrome"));
		mvc.perform(get("/?username=chicken", 1)).andExpect(content().string("chicken is not a Palindrome"));
		mvc.perform(get("/?username=spa ce", 1)).andExpect(content().string("Please remove spaces from input"));
		mvc.perform(get("/?username=numb3rs", 1)).andExpect(content().string("Please remove numbers from input"));
	}
}
