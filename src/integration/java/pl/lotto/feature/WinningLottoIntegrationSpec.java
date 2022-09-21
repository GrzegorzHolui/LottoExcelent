package pl.lotto.feature;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.lotto.BaseSpecIntegration;
import pl.lotto.infrastructure.numberreceiver.controller.NumberReceiverRequestDto;
import pl.lotto.numbergenerator.NumberGeneratorFacade;
import pl.lotto.numbergenerator.dto.NumberGeneratorResultDto;
import pl.lotto.numberreceiver.dto.NumberReceiverResultDto;
import pl.lotto.resultannoucer.ResultAnnouncerFacade;
import pl.lotto.resultannoucer.dto.ResultAnnouncerMessageDto;
import pl.lotto.resultchecker.ResultCheckerFacade;
import pl.lotto.resultchecker.dto.ResultCheckerDto;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@ActiveProfiles("test")
@AutoConfigureMockMvc
public class WinningLottoIntegrationSpec extends BaseSpecIntegration {


    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    NumberGeneratorFacade numberGeneratorFacade;
    //
    @Autowired
    ResultCheckerFacade resultCheckerFacade;

//    @Autowired
//    ResultAnnouncerFacade resultAnnouncerFacade;

//    # HAPPY PATH 1
//
//    when user input 6 numbers (1, 2, 3, 4, 5, 6) to POST /inputNumbers on date on 05-07-2022
//    system returns that numbers were correct in range (1-99), unique random ID (userLotteryId) and draw date 06-07-2022
//    system generates random winning number (1, 2, 3, 4, 5, 6) using “lotto” logic for day 06-07-2022
//    user wants to know if won using GET /winners/{userLotteryId}
//    system returns ‘won result’ to user

    @Test
    public void should_user_play_and_win() throws Exception {


//        ResultCheckerFacade resultCheckerFacade = new ResultCheckerFacade();
//        ResultAnnouncerFacade resultAnnouncerFacade = new ResultAnnouncerFacade(resultCheckerFacade);


        // given
        NumberReceiverRequestDto userNumbers = NumberReceiverRequestDto.builder()
                .clientNumbers(List.of(1, 2, 3, 4, 5, 6))
                .build();
        MvcResult mvcResultOfPostInputNumbers = mockMvc.perform(MockMvcRequestBuilders.post("/inputNumbers")
                        .content(new ObjectMapper().writeValueAsString(userNumbers))
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
//                .andExpect(status().is(200))
//                .andExpect(jsonPath("$"))
        NumberReceiverResultDto numberReceiverResultDto =
                objectMapper.readValue(mvcResultOfPostInputNumbers.getResponse().getContentAsString(), NumberReceiverResultDto.class);

        assertThat(mvcResultOfPostInputNumbers.getResponse().getStatus()).isEqualTo(200);
        assertThat(numberReceiverResultDto.message()).isEqualTo(List.of("correct message"));
        assertThat(numberReceiverResultDto.ticket().userNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));

        String userHashCode = numberReceiverResultDto.ticket().hash();
        LocalDateTime currentDate = numberReceiverResultDto.ticket().dateAndTimeNextDraw();


        MvcResult mvcResultOfGetGenerateNumbers = mockMvc.perform(MockMvcRequestBuilders.get("/generateNumbersForDate/" + currentDate.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();


        NumberGeneratorResultDto numberGeneratorResultDto =
                objectMapper.readValue(mvcResultOfGetGenerateNumbers.getResponse().getContentAsString(), NumberGeneratorResultDto.class);


        assertThat(mvcResultOfGetGenerateNumbers.getResponse().getStatus()).isEqualTo(200);
        assertThat(numberGeneratorResultDto.winningNumbers().size()).isEqualTo(6);


//        numberGeneratorFacade.generateNumbersForDate(currentDate);


        ResultCheckerDto winners = resultCheckerFacade.winners(currentDate);


        MvcResult mvcResultOfGetWinners = mockMvc.perform(MockMvcRequestBuilders.get("/winners/" + userHashCode)
//                        .content(new ObjectMapper().writeValueAsString(userNumbers))
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        ResultAnnouncerMessageDto resultAnnouncerDto =
                objectMapper.readValue(mvcResultOfGetWinners.getResponse().getContentAsString(), ResultAnnouncerMessageDto.class);

        assertThat(mvcResultOfGetWinners.getResponse().getStatus()).isEqualTo(200);
        assertThat(resultAnnouncerDto.userWonInformation()).isEqualTo(true);
    }

    @Test
    public void shouldReturnTicketNotFound() throws Exception {
        String ticketHash = "hash";
        MvcResult mvcResultOfGetTicket = mockMvc.perform
                        (MockMvcRequestBuilders.get("/winners/" + ticketHash)
                                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertThat(mvcResultOfGetTicket.getResponse().getStatus()).isEqualTo(404);
        assertThat(mvcResultOfGetTicket.getResponse().getContentAsString())
                .isEqualTo("Could not find Ticket: hash");
    }

    @Test
    public void shouldReturnThatNumberWereWrong() throws Exception {
        NumberReceiverRequestDto userNumbers = NumberReceiverRequestDto.builder()
                .clientNumbers(List.of(1, 2, 3, 4, 5, 6, 6))
                .build();
        MvcResult mvcResultOfGetTicket = mockMvc.perform
                        (MockMvcRequestBuilders.post("/inputNumbers")
                                .content(new ObjectMapper().writeValueAsString(userNumbers))
                                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertThat(mvcResultOfGetTicket.getResponse().getStatus()).isEqualTo(404);
        assertThat(mvcResultOfGetTicket.getResponse().getContentAsString())
                .isEqualTo("you must give exactly six numbers ," +
                        " you must give exactly six not repeatable numbers");
    }
}