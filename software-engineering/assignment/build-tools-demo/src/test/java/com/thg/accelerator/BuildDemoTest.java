package com.thg.accelerator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuildDemoTest {

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void testDTOToJson() throws Exception {
        BuildDTO dto = new BuildDTO(1, "test");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        objectMapper.writeValue(baos, dto);

        assertEquals("{\"id\":1,\"msg\":\"test\"}", baos.toString());
    }

    @Test
    public void testJsonToDTO() throws Exception {
        String testJson = "{\"id\":1,\"msg\":\"test\"}";
        BuildDTO dto = objectMapper.readValue(testJson.getBytes(), BuildDTO.class);

        assertEquals("test", dto.getMsg());
    }
}
