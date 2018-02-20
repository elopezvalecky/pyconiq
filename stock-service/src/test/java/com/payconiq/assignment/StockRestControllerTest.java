package com.payconiq.assignment;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class StockRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

	@Autowired
	private StockRepository stockRepository;

	@Before
	public void setUpContent() {
		stockRepository.save(new Stock("Test 1", 0.9f));
		stockRepository.save(new Stock("Test 2", 1.95f));
		stockRepository.save(new Stock("Test 3", 99.999999f));
		stockRepository.save(new Stock("Test 4", 1.999999f));
		stockRepository.save(new Stock("Test 5", 0.0001f));
	}

    @Test
    public void listStocks() throws Exception {
        this.mockMvc.perform(get("/?size=2"))
        	.andExpect(status().isOk())
            .andExpect(content().json("{\"data\":[{},{}],\"count\":5}", false));
    }

    @Test
    public void newStock() throws Exception {
        this.mockMvc.perform(post("/").contentType(MediaType.APPLICATION_JSON).content("{\"name\":\"Test X\",\"currentPrice\":5.5}"))
        	.andExpect(status().isCreated())
        	.andExpect(redirectedUrl("http://localhost/6"));
        this.mockMvc.perform(get("/6"))
	    	.andExpect(status().isOk())
	        .andExpect(content().json("{\"id\":6,\"name\":\"Test X\",\"currentPrice\":5.5}", false));
    }

    @Test
    public void retrieveStock() throws Exception {
        this.mockMvc.perform(get("/1"))
        	.andExpect(status().isOk())
            .andExpect(content().json("{\"id\":1,\"name\":\"Test 1\",\"currentPrice\":0.9}", false));
    }

    @Test
    public void modifyStock() throws Exception {
        this.mockMvc.perform(put("/1").contentType(MediaType.APPLICATION_JSON).content("{\"currentPrice\":1.1}"))
        	.andExpect(status().isNoContent());
        this.mockMvc.perform(get("/1"))
	    	.andDo(print())
	    	.andExpect(status().isOk())
	        .andExpect(content().json("{\"id\":1,\"name\":\"Test 1\",\"currentPrice\":1.1}", false));
    }

    @Test
    public void removeStock() throws Exception {
        this.mockMvc.perform(delete("/2"))
        	.andExpect(status().isNoContent());
        this.mockMvc.perform(get("/"))
	    	.andExpect(status().isOk())
	        .andExpect(content().json("{\"data\":[{},{},{},{}],\"count\":4}", false));
    }
}
