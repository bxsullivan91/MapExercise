import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PetHotel
{
    private Map<Integer, String> currentOccupants = new TreeMap<>();

    public static void main(String[] args)
    {
        PetHotel petHotel = new PetHotel();
        petHotel.run();
    }

    private void run()
    {
        Scanner in = new Scanner(System.in);


        printMenu();


        boolean wishToExit = false;

        do
        {
            System.out.println("Enter a command: ");
            String commandEntered = in.nextLine();

            String[] words = commandEntered.split(" ");

            String command = words[0];
            command = command.toUpperCase();
            try
            {
                switch (command)
                {
                    case "CHECKIN":
                        String petName = words[1];
                        int roomNumber = Integer.parseInt(words[2]);
                        checkIn(petName, roomNumber);
                        break;
                    case "CHECKOUT":
                        roomNumber = Integer.parseInt(words[1]);
                        checkOut(roomNumber);
                        break;
                    case "MOVE":
                        roomNumber = Integer.parseInt(words[1]);
                        int newRoomNumber = Integer.parseInt(words[2]);
                        moveRooms(roomNumber, newRoomNumber);
                        break;
                    case "OCCUPANCY":
                        checkOccupancy();
                        break;
                    case "ROOMS":
                        checkRooms();
                        break;
                    case "CLEAR":
                        clearRooms();
                        break;
                    case "EXIT":
                        wishToExit = true;
                        break;

                }
            } catch (Exception e)
            {
                System.out.println("Invalid User Input");
            }

        } while (!wishToExit);

    }

    private void printMenu()
    {
        System.out.println("WELCOME TO THE PET HOTEL!!");
        System.out.println("Checking in? Type 'CheckIn'");
        System.out.println("Checking out? Type 'CheckOut'");
        System.out.println("Want to move rooms? Type 'move'");
        System.out.println("Check occupancy: Type 'occupancy'");
        System.out.println("Check empty rooms: Type 'rooms'");
        System.out.println("Close All Rooms: Type 'close'");
        System.out.println("Type 'exit' to Exit Program");
        System.out.println();
    }

    private void checkIn(String petName, int roomNumber)
    {
        boolean roomEmpty = !currentOccupants.containsKey(roomNumber);

        if (roomNumber >= 100 && roomNumber <= 109)
        {
            if (roomEmpty)
            {
                currentOccupants.put(roomNumber, petName);
                System.out.println(petName + " is now in Room " + roomNumber);
            }
            else
            {
                System.out.println("Sorry! That room is currently taken. Try another room.");
            }
        }
        else
        {
            System.out.println("Invalid Room Number!  Available rooms are between 100 - 109");
        }

    }

    private void checkOut(int roomNumber)
    {
        boolean roomOccupied = currentOccupants.containsKey(roomNumber);
        if (roomOccupied)
        {
            if (currentOccupants.containsKey(roomNumber))
            {
                currentOccupants.remove(roomNumber);
                System.out.println("Room " + roomNumber + " is now vacant. Hope you enjoyed your stay!");
            }
            else
            {
                System.out.println("Sorry, but that room number is invalid.");
            }
        }
        else
        {
            System.out.println("No pets are currently in that room!");
        }
    }

    private void moveRooms(int oldRoomNumber, int newRoomNumber)
    {
        boolean fromRoomOccupied = currentOccupants.containsKey(oldRoomNumber);
        boolean toRoomEmpty = !currentOccupants.containsKey(newRoomNumber);

        if (fromRoomOccupied)
        {
            if (toRoomEmpty)
            {
                String petName = currentOccupants.get(oldRoomNumber);
                currentOccupants.remove(oldRoomNumber);
                currentOccupants.put(newRoomNumber, petName);
                System.out.println(petName + " has now moved to room " + newRoomNumber);

            }
            else
            {
                System.out.println("Sorry, but room " + newRoomNumber + " is currently occupied. Try a different room");

            }
        }
        else
        {
            System.out.println("Sorry, there is no pet in room " + oldRoomNumber);
        }
    }

    private void checkOccupancy()
    {
        for (Map.Entry<Integer, String> entry : currentOccupants.entrySet())
        {
            int roomNumber = entry.getKey();
            String petName = entry.getValue();
            System.out.println("Room " + roomNumber + " : " + petName);
        }
    }

    private void checkRooms()
    {
        boolean roomOccupied;
        String petName;

        for (int i = 100; i <= 109; i++)
        {
            roomOccupied = currentOccupants.containsKey(i);

            System.out.print("Room " + i + " : ");

            if (roomOccupied)
            {
                petName = currentOccupants.get(i);
                System.out.print(petName);
            }
            else
            {
                System.out.print("empty");
            }
            System.out.println();

        }

    }

    private void clearRooms()
    {
        currentOccupants.clear();
        System.out.println("The hotel is now closed! All Rooms are Empty!");
    }
}
