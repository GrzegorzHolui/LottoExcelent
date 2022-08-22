package pl.lotto.numbergenerator;

import java.time.LocalDateTime;
import java.util.List;

public interface WinningNumberRepository {

    void save(List<Integer> numbers, LocalDateTime currentDate);

    List<Integer> getWinningNumbersForGivenDate(LocalDateTime dateToGet);

}
