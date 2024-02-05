package practice.jpa.board.exceptionBundle.handler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import practice.jpa.board.controller.TestController;
import practice.jpa.board.exceptionBundle.enumtype.ErrorCode;

import java.net.SocketTimeoutException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GlobalExceptionHandlerTest {


    @Autowired
    MockMvc mockMvc;

    @Autowired
    TestController testController;


    @Test
    void testSocketTimeOutException() throws Exception {

        mockMvc = MockMvcBuilders.standaloneSetup(testController)
                .setControllerAdvice(new GlobalExceptionHandler()) // 예외 핸들러 주입
                .build();

        mockMvc.perform(MockMvcRequestBuilders.get("/your-endpoint")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errorCode").value(ErrorCode.SOCKET_TIMEOUT.getCode()));
    }

}