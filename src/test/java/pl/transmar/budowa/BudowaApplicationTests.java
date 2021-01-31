package pl.transmar.budowa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import pl.transmar.budowa.controllers.MachineController;
import pl.transmar.budowa.controllers.PersonController;
import pl.transmar.budowa.controllers.TaskController;
import pl.transmar.budowa.controllers.WorkDayController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BudowaApplicationTests {

	@Autowired
	private MachineController mc;
	@Autowired
	private PersonController pc;
	@Autowired
	private TaskController tc;
	@Autowired
	private WorkDayController wdc;
	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
		assertThat(mc).isNotNull();
		assertThat(pc).isNotNull();
		assertThat(tc).isNotNull();
		assertThat(wdc).isNotNull();
	}

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Persons")));
		mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("credentials")));
	}

}
