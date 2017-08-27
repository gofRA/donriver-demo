package com.donriver.demo.utils;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;

import static org.springframework.http.MediaType.APPLICATION_JSON;

public class TestUtils {
    public static String convertToJson(Object object) throws Exception {
        MockHttpOutputMessage output = new MockHttpOutputMessage();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        converter.write(object, APPLICATION_JSON, output);

        return output.getBodyAsString();
    }
}
