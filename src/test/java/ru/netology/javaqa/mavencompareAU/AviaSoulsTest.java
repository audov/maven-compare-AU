package ru.netology.javaqa.mavencompareAU;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    AviaSouls mng = new AviaSouls();
    Ticket ticket1 = new Ticket("Москва", "Самара", 100, 15, 16); // 1
    Ticket ticket2 = new Ticket("Москва", "Астрахань", 80, 7, 10); // 3
    Ticket ticket3 = new Ticket("Москва", "Самара", 130, 13, 14); // 1
    Ticket ticket4 = new Ticket("Хабаровск", "Москва", 300, 10, 18); // 6
    Ticket ticket5 = new Ticket("Краснодар", "Москва", 95, 4, 6); // 2


    @Test
    public void addTicket() { // ок
        mng.add(ticket1);
        mng.add(ticket2);
        mng.add(ticket3);
        mng.add(ticket4);
        mng.add(ticket5);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = mng.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void compareTo() { // ок
        mng.add(ticket1);
        mng.add(ticket2);

        System.out.println(ticket1.compareTo(ticket2)); // если 1-й больше 2-го
        System.out.println(ticket1.compareTo(ticket3)); // если 1-й меньше 3-го
        System.out.println(ticket1.compareTo(ticket4)); // если 1-й равен 4-му
    }

    @Test
    public void searchAndSortComparable() {
        mng.add(ticket1);
        mng.add(ticket2);
        mng.add(ticket3);
        mng.add(ticket4);
        mng.add(ticket5);

        Ticket[] expected = {ticket1, ticket3};
        Ticket[] actual = mng.searchAndSortComparable("Москва", "Самара");

        Assertions.assertArrayEquals(expected, actual);
        // System.out.print("цена" + ticket1.getPrice());
        // System.out.print("цена" + ticket3.getPrice());
    }

    @Test

    public void searchAndSortWithComp() {
        mng.add(ticket1);
        mng.add(ticket2);
        mng.add(ticket3);
        mng.add(ticket4);
        mng.add(ticket5);

        Comparator<Ticket> comp = new TicketTimeComparator();

        Ticket[] expected = {ticket3, ticket1};
        Ticket[] actual = mng.searchAndSortComparator("Москва", "Самара", comp);

        Assertions.assertArrayEquals(expected, actual);
    }
}
