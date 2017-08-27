package com.donriver.demo.controller;

import com.donriver.demo.DonRiverDemoApplication;
import com.donriver.demo.model.Product;
import com.donriver.demo.service.ProductService;
import com.jayway.jsonpath.DocumentContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static com.donriver.demo.utils.TestUtils.convertToJson;
import static com.jayway.jsonpath.JsonPath.parse;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DonRiverDemoApplication.class)
@Transactional
public class ProductControllerTests {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ProductService productService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void testFindAll() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/products/")
        ).andExpect(status().is2xxSuccessful())
                .andReturn();
        DocumentContext c = parse(result.getResponse().getContentAsString());
        assertThat(c.read("$"), hasSize(13));
    }

    @Test
    public void testCreate() throws Exception {
        Product p = buildProduct();
        MvcResult result = mockMvc.perform(
                post("/products/")
                        .contentType(APPLICATION_JSON)
                        .content(convertToJson(p))
        ).andExpect(status().is2xxSuccessful())
                .andReturn();
        DocumentContext c = parse(result.getResponse().getContentAsString());
        assertThat(c.read("$"), notNullValue());
        assertThat(c.read("$.id"), notNullValue());
    }

    @Test
    public void testUpdate() throws Exception {
        Product p = productService.findOne(1);
        assertThat(p.getName(), is("name"));
        p.setName("anotherName");
        MvcResult result = mockMvc.perform(
                put("/products/")
                        .contentType(APPLICATION_JSON)
                        .content(convertToJson(p))
        ).andExpect(status().is2xxSuccessful())
                .andReturn();
        DocumentContext c = parse(result.getResponse().getContentAsString());
        assertThat(c.read("$"), notNullValue());
        assertThat(c.read("$.id"), is(1));
        assertThat(c.read("$.name"), is("anotherName"));

        entityManager.clear();
        p = productService.findOne(1);
        assertThat(p.getName(), is("anotherName"));
    }

    @Test
    public void testRemove() throws Exception {
        assertThat(productService.findAll(), hasSize(13));
        mockMvc.perform(
                delete("/products/1")
        ).andExpect(status().is2xxSuccessful());
        assertThat(productService.findAll(), hasSize(12));
    }

    private Product buildProduct() {
        return Product.builder()
                .name("testName")
                .category("category")
                .guarantee(3)
                .manufacturer("manufacturer")
                .salesCount(10)
                .totalCount(20)
                .build();
    }
}
