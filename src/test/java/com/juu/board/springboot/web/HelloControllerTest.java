package com.juu.board.springboot.web;

//import static net.bytebuddy.matcher.ElementMatchers.*;
import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.Matcher.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class)
class HelloControllerTest {

	@Autowired
	private MockMvc mvc;

	@DisplayName("Hello가 리턴된다")
	@Test
	void returnHello() throws Exception {
		String hello = "hello";

		mvc.perform(get("/hello"))
			.andExpect(status().isOk())
			.andExpect(content().string(hello));
	}

	@DisplayName("helloDto가 리턴된다")
	@Test
	void returnHelloDto() throws Exception {
		//given
		String name = "hello";
		int amount = 1000;

		//when
		mvc.perform(get("/hello/dto")
				.param("name", name)
				.param("amount", String.valueOf(amount))
			)
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name").value(equalTo(name)))
			.andExpect(jsonPath("$.amount").value(equalTo(amount)))
			;
		//then
	}
}