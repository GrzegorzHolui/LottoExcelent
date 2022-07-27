package pl.lotto.numberreceiver;

import java.util.Optional;
import java.util.Set;

class TicketRepositoryImpl implements TicketRepository {
    Set<Ticket> tickets;

    public TicketRepositoryImpl(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void saveTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public Optional<Ticket> findTicketByHash(String currentTicketHash) {
        return tickets
                .stream()
                .filter(ticket -> currentTicketHash.equals(ticket.getHash()))
                .findFirst();
    }


}