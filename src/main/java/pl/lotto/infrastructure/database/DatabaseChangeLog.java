//package pl.lotto.infrastructure.database;
//
//import com.github.cloudyrock.mongock.ChangeLog;
//import com.github.cloudyrock.mongock.ChangeSet;
//import java.time.LocalDateTime;
//import java.util.List;
//import pl.lotto.numberreceiver.Ticket;
//import pl.lotto.numberreceiver.TicketRepository;
//
//@ChangeLog(order = "1")
//public class DatabaseChangeLog {
//
//    @ChangeSet(order = "001", id = "seedDatabase", author = "bartlomiej.kalka")
//    public void seedDatabase(TicketRepository ticketRepository) {
//        System.out.println("TESTUJEMY");
//        ticketRepository.save(new Ticket("asdasd", List.of(1, 2, 3, 4, 5, 6), LocalDateTime.now()));
//    }
//
//    @ChangeSet(order = "002", id = "seedDatabase2", author = "bartlomiej.kalka")
//    public void seedDatabase2(TicketRepository ticketRepository) {
//        System.out.println("TESTUJEMY");
//        ticketRepository.save(new Ticket("asdasd", List.of(1, 2, 3, 4, 5, 6), LocalDateTime.now()));
//    }
//}
