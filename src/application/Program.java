package application;

import entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter the room number");
        int roomNumber = sc.nextInt();
        System.out.println("Enter the Check-in Date (dd/mm/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.println("Enter the Check-out Date (dd/mm/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println("Enter data to update the reservation: ");
            System.out.println("Enter the Check-in Date (dd/mm/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.println("Enter the Check-out Date (dd/mm/yyyy): ");
            checkOut = sdf.parse(sc.next());

            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)){
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            } else if (!checkOut.after(checkIn)){
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            } else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation update:" + reservation);
            }
                reservation.updateDates(checkIn, checkOut);
        }
        sc.close();
    }
}
