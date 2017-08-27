package com.donriver.demo.controller;

import com.donriver.demo.DonRiverDemoApplication;
import com.donriver.demo.model.SalePoint;
import com.donriver.demo.service.SalePointService;
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
public class SalePointControllerTests {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private SalePointService salePointService;
    @Autowired
    private EntityManager entityManager;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void testFindAll() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/sale_points/")
        ).andExpect(status().is2xxSuccessful())
                .andReturn();
        DocumentContext c = parse(result.getResponse().getContentAsString());
        assertThat(c.read("$"), hasSize(14));
    }

    @Test
    public void testCreate() throws Exception {
        SalePoint p = buildSalePoint();
        MvcResult result = mockMvc.perform(
                post("/sale_points/")
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
        SalePoint sp = salePointService.findOne(1);
        assertThat(sp.getName(), is("name"));
        sp.setName("anotherSalePoint");
        MvcResult result = mockMvc.perform(
                put("/sale_points/")
                        .contentType(APPLICATION_JSON)
                        .content(convertToJson(sp))
        ).andExpect(status().is2xxSuccessful())
                .andReturn();
        DocumentContext c = parse(result.getResponse().getContentAsString());
        assertThat(c.read("$"), notNullValue());
        assertThat(c.read("$.id"), is(1));
        assertThat(c.read("$.name"), is("anotherSalePoint"));

        entityManager.clear();
        sp = salePointService.findOne(1);
        assertThat(sp.getName(), is("anotherSalePoint"));
    }

    @Test
    public void testRemove() throws Exception {
        assertThat(salePointService.findAll(), hasSize(14));
        mockMvc.perform(
                delete("/sale_points/1")
        ).andExpect(status().is2xxSuccessful());
        assertThat(salePointService.findAll(), hasSize(13));
    }

    private SalePoint buildSalePoint() {
        return SalePoint.builder()
                .name("salePoint")
                .address("address")
                .retailChain("M-MARKET")
                .consultantCount(10)
                .build();
    }
}
