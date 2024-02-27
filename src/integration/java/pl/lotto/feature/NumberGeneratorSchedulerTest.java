package pl.lotto.feature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.lotto.infrastructure.numbergenerator.db.scheduler.GeneratorNumbers;
import pl.lotto.numbergenerator.NumberGeneratorFacade;
import pl.lotto.numbergenerator.dto.NumberGeneratorResultDto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

@Component
public class NumberGeneratorSchedulerTest implements GeneratorNumbers {
    @Autowired
    NumberGeneratorFacade numberGeneratorFacade;


    @Scheduled(cron = "0 0 12 * * SAT")
    public boolean generateNumbers() {
        NumberGeneratorResultDto numberGeneratorResultDto = numberGeneratorFacade.generateNumbersForDate(
                LocalDateTime.of(calcNextSunday(LocalDate.now()), LocalTime.of(12, 0))
        );
        System.out.println(numberGeneratorResultDto.winningNumbers());
        System.out.println("numberGeneratorResultDtoInTest");
        return true;
    }

    private static LocalDate calcNextSunday(LocalDate currentDay) {
        return currentDay.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
    }

}