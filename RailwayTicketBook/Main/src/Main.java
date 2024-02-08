import java.util.*;

public class Main{

        public static void bookTicket(Passenger p){
            TicketBooker booker = new TicketBooker();

            if(TicketBooker.availableWaitingList==0){
                System.out.println("No Avaliable Ticket");
                return;
            }
            if((p.berthPreference.equals("L")&& TicketBooker.availableLowerBerths>0)||
                (p.berthPreference.equals("M")&& TicketBooker.availableMiddleBerths>0)||
                (p.berthPreference.equals("U")&& TicketBooker.availableUpperBerths>0))
                {
                    System.out.println("Prefered Berth Avaliable");
                    if(p.berthPreference.equals("L"))// Lower Berth Booking
                    {
                        System.out.println("Lower Berth Given");
                        booker.bookTicket(p,(TicketBooker.lowerBerthsPositions.get(0)),"L");

                        TicketBooker.lowerBerthsPositions.remove(0);
                        TicketBooker.availableLowerBerths--;
                    }

                    else if(p.berthPreference.equals("M"))// Middle Berth Booking
                    {
                        System.out.println("Middle Berth Given");
                        booker.bookTicket(p,(TicketBooker.middleBerthsPositions.get(0)),"M");

                        TicketBooker.middleBerthsPositions.remove(0);
                        TicketBooker.availableMiddleBerths--;
                    }

                    else if(p.berthPreference.equals("U"))// Upper Berth Booking
                    {
                        System.out.println("Upper Berth Given");
                        booker.bookTicket(p,(TicketBooker.upperBerthsPositions.get(0)),"U");

                        TicketBooker.upperBerthsPositions.remove(0);
                        TicketBooker.availableUpperBerths--;
                    }
                }
                    //Perference is not Avaliable -> book the Avsliable Berth compartment
            else if(TicketBooker.availableLowerBerths>0){
                System.out.println("Lower Berth Given");
                booker.bookTicket(p,TicketBooker.lowerBerthsPositions.get(0),"L");
                TicketBooker.lowerBerthsPositions.remove(0);
                TicketBooker.availableLowerBerths--;
            }

            else if(TicketBooker.availableMiddleBerths>0){
                System.out.println("Middle Berth Given");
                booker.bookTicket(p,TicketBooker.middleBerthsPositions.get(0),"M");
                TicketBooker.middleBerthsPositions.remove(0);
                TicketBooker.availableMiddleBerths--;
            }

            else if(TicketBooker.availableUpperBerths>0){
                System.out.println("Upper Berth Given");
                booker.bookTicket(p,TicketBooker.upperBerthsPositions.get(0),"U");
                TicketBooker.upperBerthsPositions.remove(0);
                TicketBooker.availableUpperBerths--;
            }

            else if(TicketBooker.availableRacTickets > 0)
            {
                System.out.println("RAC avaliable");
                booker.addToRAC(p,(TicketBooker.racPositions.get(0)),"RAC");
            }

            else if(TicketBooker.availableWaitingList > 0)
            {
                System.out.println("Add to WaitingList avaliable");
                booker.addToWaitingList(p,(TicketBooker.waitingListPositions.get(0)),"WL");
            } 
        }

    public static void cancelTicket(int id){
        TicketBooker booker = new TicketBooker();
        if(!booker.passengers.containsKey(id))
        {
            System.out.println("passenger detail Unknow");
        }
        else{
            booker.cancelTicket(id);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("1. Book Ticket\n 2. Cancel Ticket\n 3. Avaliable Tickets\n 4. Booked Ticket \n 5. Exit");
            int choice = sc.nextInt();
            switch(choice){

                //book ticket
                case 1:
                {
                    System.out.println("Enter the Passenger name,age,berth Pereference (Lower-L,Upper-U,Middle-M)");
                    String name = sc.next();
                    int age = sc.nextInt();
                    String berthPreference = sc.next();
                    Passenger p = new Passenger(name,age,berthPreference);
                    bookTicket(p);
                }
                break;
                case 2:
                {
                    System.out.println("Enter the passenger id to cancel");
                    int id = sc.nextInt();
                    cancelTicket(id);
                }
                break;
                case 3:
                {
                    TicketBooker booker = new TicketBooker();
                    booker.printAvaliable();
                }
                break;
                case 4:
                {
                    TicketBooker booker = new TicketBooker();
                    booker.printAvailable();
                }
                break;
                case 5:
                {
                    loop = false;
                }
                break;
                default:
                break;
            }
        }
    }
}