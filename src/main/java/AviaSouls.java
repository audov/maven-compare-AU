import java.util.Arrays;
import java.util.Comparator;

public class AviaSouls {
    private Ticket[] tickets = new Ticket[0];

    private Ticket[] addToArray(Ticket[] current, Ticket ticket) {
        Ticket[] tmp = new Ticket[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = ticket;
        return tmp;
    }

    public void add(Ticket ticket) {

        tickets = addToArray(tickets, ticket);
    }

    public Ticket[] findAll() {

        return tickets;
    }

    public Ticket[] search(String from, String to) {
        System.out.print(Arrays.toString(tickets));
        Ticket[] result = new Ticket[0]; // массив для ответа
        for (Ticket ticket : tickets) { // перебираем все билеты
            if (ticket.getFrom().equals(from)) { // совпадает аэропорт вылета
                if (ticket.getTo().equals(to)) { // совпадает аэропорт прилёта
                    result = addToArray(result, ticket); // добавляем его в массив ответа
                }
            }
            System.out.print(Arrays.toString(result));
        }
        Arrays.sort(result);
        return result;
    }

    public Ticket[] searchAndSortBy(String from, String to, Comparator<Ticket> comp) {
        Ticket[] result = new Ticket[0]; // массив для ответа
        for (Ticket ticket : tickets) { // перебираем все билеты
            if (ticket.getFrom().equals(from)) { // совпадает аэропорт вылета
                if (ticket.getTo().equals(to)) { // совпадает аэропорт прилёта
                    result = addToArray(result, ticket); // добавляем его в массив ответа
                }
            }
        }
        Arrays.sort(result, comp);
        return result;
    }
}