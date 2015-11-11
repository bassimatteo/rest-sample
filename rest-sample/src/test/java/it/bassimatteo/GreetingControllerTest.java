package it.bassimatteo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class GreetingControllerTest extends AbstractContextControllerTests {

	private MockMvc mockMvc;

	@Before
	public void setup() {

		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
				.build();
	}

	@Test
	public void test() throws Exception {

		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(
						content().contentType(MediaType.TEXT_PLAIN));

	}

	@Test
	public void greeting() throws Exception {

		mockMvc.perform(get("/greeting"))
				.andExpect(status().isOk())
				.andExpect(
						content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.content").value("Hello, World!"));

	}

}