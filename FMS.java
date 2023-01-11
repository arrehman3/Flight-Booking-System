import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
class BadInputException extends Exception{
    
    BadInputException(String message){
        super(message);
    }
    
}
public class FMS {

    static ArrayList<ArrayList<String>>  Data_List =  new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    
    public static void ticketGen(String name,String cnic,String airline,String departure,String arrival,String card,String seat){
        System.out.println("******************************");
        System.out.println("**********TICKET**************");
        System.out.println("*\3Name: "+name);
        System.out.println("*\3CNIC:"+cnic);
        System.out.println("*\3AIRLINE:"+airline);
        System.out.println("*\3Departure:"+departure);
        System.out.println("*\3Arrival:"+arrival);
        System.out.println("*\3Seat No: "+seat);
        System.out.println("*\3CardNo: "+card);
        System.out.println("*\3Date: "+getCurrentDate());
        System.out.println("YOUR TICKET IS BOOKED");
        System.out.println("*******************************");
    }
    public static void cancelCall(){
        String name = Name();
        String cnic = CNIC();
        String choice1 = flightclass2();
        String choice = airlines(choice1);
        String seat = seats();
        String arrival= location1();
        String departure = location();
        checkLocAndArvSame(arrival, departure);
        cancel(name, cnic, choice, seat, arrival, departure);

    }
    public static void cancel(String name,String cnic,String airlines,String seat,String arrival,String departure){
        boolean check1=false;
        boolean check2=false;
        boolean check3 = false;
        boolean check4 = false;
        boolean check5 = false;
        boolean check6 = false;
        int count=0;
        
            try{
                File f = new File("C:\\Users\\Pc\\Desktop\\files\\Booking.txt");
                BufferedReader br = new BufferedReader(new FileReader(f));
                for(int x =0;br.readLine()!=null;x++){
                    count++;
                }
                br.close();
            }
            catch(Exception e){
                e.getMessage();
                e.getStackTrace();
                System.out.println("cancellation error A1");
            }
            count -=1;
            System.out.println(count);
            String[]data = new String[count];
            String s = ""; 
            try{
                int index = 0;
                // C:\Users\Pc\Desktop\files
                File f = new File("C:\\Users\\Pc\\Desktop\\files\\Booking.txt");
                BufferedReader br = new BufferedReader(new FileReader(f));
                for(int x =0;br.readLine()!=null;x++){
                    System.out.println("Z1");
                    check1 = Files.readAllLines(Paths.get("Booking.txt")).get(x).contains(name);
                    check2 = Files.readAllLines(Paths.get("Booking.txt")).get(x).contains(cnic);
                    check3 = Files.readAllLines(Paths.get("Booking.txt")).get(x).contains(seat);
                    check4 = Files.readAllLines(Paths.get("Booking.txt")).get(x).contains(airlines);
                    check5 = Files.readAllLines(Paths.get("Booking.txt")).get(x).contains(departure);
                    check6 = Files.readAllLines(Paths.get("Booking.txt")).get(x).contains(arrival);
                    System.out.println("Z2");
                    System.out.println(name+" "+cnic+" "+seat+" "+airlines+" "+departure+" "+arrival);
                    if(check1&check2&check3&check4){
                        System.out.println(name+" "+cnic+" "+seat+" "+airlines+" "+departure+" "+arrival);
                        s = Files.readAllLines(Paths.get("Booking.txt")).get(x);
                        System.out.println("Fuck1");
                    }else{
                        System.out.println("Z3");
                        data[index] = Files.readAllLines(Paths.get("Booking.txt")).get(x);
                        index++;
                        System.out.println("Z4");
                    }
                }
            }
            catch(Exception e){
                e.getMessage();
                e.getStackTrace();
                System.out.println("A2");
            }
            try{
                BufferedWriter out = new BufferedWriter(new FileWriter("Booking.txt"));
                for(String e: data){
                    System.out.println(e);
                    out.write(e);
                    out.newLine();
                }
                out.close();
            }catch(Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            
            // try{
                
            //     File f = new File("C:\\Users\\Pc\\Desktop\\files\\Booking.txt");
            //     BufferedReader br = new BufferedReader(new FileReader(f));
            //     String line ="";
            //     while((line=br.readLine())!=null){
            //         String [] myArray = line.split(",");
            //         ArrayList<String> temp = new ArrayList<>(Arrays.asList(myArray));
            //         Data_List.add(temp);
            //     }
            //     System.out.println(Data_List);
                
            //     for (ArrayList<String> i : Data_List) {
                
            //             if ( (i.get(0).matches(name))==true && i.get(1).matches(cnic)==true && i.get(2).matches(seat)&&i.get(3).matches(airlines)&&i.get(4).matches(departure)&&i.get(5).matches(arrival)) {
            //                 Data_List.remove(i);
            //             }

            //     }
            // }catch(Exception e){
            //     System.out.println(e.getMessage());
            //     e.printStackTrace();
            // }

            //     try{
            //         BufferedWriter out = new BufferedWriter(new FileWriter("Booking.txt"));
            //         for(ArrayList<String> i : Data_List){
            //             for (String j : i) {
            //                 System.out.println(j);
            //                 // out.write(j);
            //                 // out.newLine();
            //             }
            //         }
            //         // out.close();
            //     }catch(Exception e){
            //         System.out.println(e.getMessage());
            //         e.printStackTrace();
            //     }
        }    
    
    public static String Payment(){
        
        String card;
        while(true){

        
        try{
            System.out.println("\033[31;1;1mEnter your 16 digit CardNo with dashes XXXX-XXXX-XXXX-XXXX\033[0m\4\n ");
            card = sc.next();
            if(card.length()!=19){
                throw new BadInputException("\n\4\033[31;1;1mEnter your 16 digit CardNo with dashes XXXX-XXXX-XXXX-XXXX\033[0m\4\n");
            }
            for(int i=0;i<4;i++){
                if(!Character.isDigit(card.charAt(i))){
                    throw new BadInputException("\n\4\033[31;1;1mEnter your 16 digit CardNo with dashes XXXX-XXXX-XXXX-XXXX\033[0m\4\n");
                }
            }
            for(int i=5;i<9;i++){
                if(!Character.isDigit(card.charAt(i))){
                    throw new BadInputException("\n\4\033[31;1;1mEnter your 16 digit CardNo with dashes XXXX-XXXX-XXXX-XXXX\033[0m\4\n");
                }
            }
            for(int i =10;i<14;i++){
                if(!Character.isDigit(card.charAt(i))){
                    throw new BadInputException("\n\4\033[31;1;1mEnter your 16 digit CardNo with dashes XXXX-XXXX-XXXX-XXXX\033[0m\4\n");
                }
            }
            for(int i =15;i<19;i++){
                if(!Character.isDigit(card.charAt(i))){
                    throw new BadInputException("\n\4\033[31;1;1mEnter your 16 digit CardNo with dashes XXXX-XXXX-XXXX-XXXX\033[0m\4\n");
                }
            }
            
            if(card.charAt(4)!='-'&& card.charAt(9)!='-'&& card.charAt(14)!='-'){
                throw new BadInputException("\n\4\033[31;1;1mEnter your 16 digit CardNo with dashes XXXX-XXXX-XXXX-XXXX\033[0m\4\n");
            }
            
           
            
            
        }
        catch(BadInputException x){
            System.out.println(x.toString());
            continue;
        }
        return card;
        
        }
        
        
    }
    public static void seatscheck(String airlines,String departure,String arrival,String seat){
        boolean check1=false;
        boolean check2=false;
        boolean check3 = false;
        boolean check4 = false;
        

        try{
            int y =0;
            File f = new File("C:\\Users\\Pc\\Desktop\\files\\Booking.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            for(int x =0;br.readLine()!=null;x++){
                check1 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\Booking.txt")).get(x).contains(airlines);
                check2 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\Booking.txt")).get(x).contains(departure);
                check3 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\Booking.txt")).get(x).contains(arrival);
                check4 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\Booking.txt")).get(x).contains(seat);
                
                if(check1&check2&check3&check4){
                    while(true){
                        
                        if(airlines.equals("SHAHEEN")||airlines.equals("AIRBLUE")||airlines.equals("PIA")){
                            System.out.println("\n\4\033[31;1;1mSeat is already reserved\033[0m\4\n");
                            locationsCall();
                            break;
                        }
                        else if(airlines.equals("AIRSIAL")||airlines.equals("EMIRATES")||airlines.equals("FLYJINNAH")){
                            System.out.println("\n\4\033[31;1;1mSeat is already reserved\033[0m\4\n");
                            locationsCall2();
                            break;
                        }
                        
                        
                    }
                    
                    
                }
                
                
            }
            br.close();
        }
        catch(Exception e){
            e.getMessage();
            e.getStackTrace();
            System.out.println("Seats error");
        }

    }
    public static  String seats(){
        String seats;
        while(true){
            try{
                System.out.println("Please enter your seat\nfromat S(seat no) e.g 'S01'");
                seats=sc.next();
                if(seats.equals("S01")||seats.equals("S02")||seats.equals("S03")||seats.equals("S04")||seats.equals("S05")||seats.equals("S06")||seats.equals("S07")||seats.equals("S08")||seats.equals("S09")||seats.equals("S10")){
                    return seats;
                }
                else{
                    throw new BadInputException("\n\4\033[31;1;1mInvalid Format\033[0m\4\n");
                }
            }
            catch(Exception e){
                System.out.println(e.toString());
                continue;
            }
        }
    }

    public static String location(){
        String departure;
        
        while(true){
            try{
                System.out.println("Please enter your departure location\nEnter in descriptive form");
                System.out.println("1.Karachi\n2.Lahore\n3.Islamabad\n4.Peshawar");
                departure = sc.next().toUpperCase();
                if(departure.equals("KARACHI")||departure.equals("ISLAMABAD")||departure.equals("LAHORE")||departure.equals("PESHAWAR")){
                    return departure;
                }
                else{
                    throw new BadInputException("\n\4\033[31;1;1mEnter in descriptive form 'Karachi'\033[0m\4\n");
                }
            }
            catch(BadInputException x){
                System.out.println(x.toString());
                continue;
            }
        }
       

    }
    public static String location1(){
        String arrival;
        while(true){
            try{
                System.out.println("Please enter your arrival\nEnter in descriptive form");
               
                System.out.println("1.Karachi\n2.Lahore\n3.Islamabad\n4.Peshawar");
                arrival=sc.next().toLowerCase();
                if(arrival.equals("karachi")||arrival.equals("islamabad")||arrival.equals("lahore")||arrival.equals("peshawar")){
                    return arrival;
                }
                else{
                    throw new BadInputException("\n\4\033[31;1;1mEnter in descriptive form 'Karachi'\033[0m\4\n");
                }
            }
            catch(BadInputException x){
                System.out.println(x.toString());
                continue;
            }
        }
        
    }

    public static void checkLocAndArvSame1(){
        
            String arrrival=location();
            String departure =location1();
            
            checkLocAndArvSame(arrrival, departure);
            

        
    }

    public static void checkLocAndArvSame(String arrival,String departure){
        
            if(arrival.equalsIgnoreCase(departure)){
                checkLocAndArvSame1();
    
            }
               
        
        
    }

    public static void locationsCall(){
        String name = Name();
        String cnic = CNIC();
        String departure = location();
        String arrival = location1();
        checkLocAndArvSame(arrival, departure);
        
        String choice = airlines("1");
        econDisplay(choice, departure, arrival);
        String seats = seats();
        
        seatscheck(choice, departure, arrival,seats);
        deleteecon(seats, departure, arrival, choice,name,cnic);
        String card = Payment();
        ticketGen(name, cnic, choice, departure, arrival,card,seats);
    }
    public static void locationsCall2(){
        String name = Name();
        String cnic = CNIC();
        String departure = location();
        String arrival = location1();
        checkLocAndArvSame(arrival, departure);
        
        String choice = airlines("2");
        businessDisplay(choice, departure, arrival);
        String seats = seats();
        seatscheck(choice, departure, arrival, seats);
        delete(seats, departure, arrival, choice,name,cnic);
        String card = Payment();
        ticketGen(name, cnic, choice, departure, arrival,card,seats);
    }

    public static void businessDisplay(String airlines,String departure,String arrival){
       
        boolean chk1=false;
        boolean chk2=false;
        boolean chk3=false;
        int count=0;
        int count1=0;

        
        try{
            File f = new File("C:\\Users\\Pc\\Desktop\\files\\business.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            
            for(int x=0;br.readLine()!=null;x++){
                count++;
            }
            br.close(); 
        
        
        }
        catch(Exception e){
            e.getMessage();
            e.getStackTrace();
            System.out.println("count error");

        }
        String[] data = new String[count];
        /// new try method to store specific lines
        try{
            File f = new File("C:\\Users\\Pc\\Desktop\\files\\business.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            for(int x =0;br.readLine()!=null;x++){
                chk1 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\business.txt")).get(x).contains(airlines);
                chk2 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\business.txt")).get(x).contains(departure);
                chk3 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\business.txt")).get(x).contains(arrival);
                
                if(chk1&chk2&chk3){
                    count1++;
                }    
                
            }
            br.close();
            
            
        System.out.println(count1);
        }
        catch(Exception e){
            e.getMessage();
            e.getStackTrace();
            System.out.println("count error");

        }
        String[] dataneeded = new String[count1];






        try{
            int y =0;
            File f = new File("C:\\Users\\Pc\\Desktop\\files\\business.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            for(int x =0;br.readLine()!=null;x++){
                chk1 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\business.txt")).get(x).contains(airlines);
                chk2 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\business.txt")).get(x).contains(departure);
                chk3 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\business.txt")).get(x).contains(arrival);
                
                if(chk1&chk2&chk3){
                    dataneeded[y]=Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\business.txt")).get(x);
                    y++;
                }
                
            }
            br.close();
        }
        catch(Exception e){
            e.getMessage();
            e.getStackTrace();
            System.out.println("Storing error");
        }
        try{
            
            for(String e : dataneeded){
                System.out.println(e);
            }
            
            
            
        }
        catch(Exception e){
            e.getMessage();
            e.getStackTrace();
            System.out.println("Writing error");

        }
    }

    public static void econDisplay(String airlines,String departure,String arrival){
        
        boolean chk1=false;
        boolean chk2=false;
        boolean chk3=false;
        int count=0;
        int count1=0;

        
        try{
            File f = new File("C:\\Users\\Pc\\Desktop\\files\\economy.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            
            for(int x=0;br.readLine()!=null;x++){
                count++;
            }
            br.close(); 
        
        
        }
        catch(Exception e){
            e.getMessage();
            e.getStackTrace();
            System.out.println("count error");

        }
        String[] data = new String[count];
        /// new try method to store specific lines
        try{
            File f = new File("C:\\Users\\Pc\\Desktop\\files\\economy.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            for(int x =0;br.readLine()!=null;x++){
                chk1 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\economy.txt")).get(x).contains(airlines);
                chk2 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\economy.txt")).get(x).contains(departure);
                chk3 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\economy.txt")).get(x).contains(arrival);
                
                if(chk1&chk2&chk3){
                    count1++;
                }    
                
            }
            br.close();
            
             
        
        
        }
        catch(Exception e){
            e.getMessage();
            e.getStackTrace();
            System.out.println("count error");

        }
        String[] dataneeded = new String[count1];






        try{
            int y =0;
            File f = new File("C:\\Users\\Pc\\Desktop\\files\\economy.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            for(int x =0;br.readLine()!=null;x++){
                chk1 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\economy.txt")).get(x).contains(airlines);
                chk2 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\economy.txt")).get(x).contains(departure);
                chk3 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\economy.txt")).get(x).contains(arrival);
                
                if(chk1&chk2&chk3){
                    dataneeded[y]=Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\economy.txt")).get(x);
                    y++;
                }
                
            }
            br.close();
        }
        catch(Exception e){
            e.getMessage();
            e.getStackTrace();
            System.out.println("Storing error");
        }
        try{
            
            for(String e : dataneeded){
                System.out.println(e);
            }
            
            
          
            
        }
        catch(Exception e){
            e.getMessage();
            e.getStackTrace();
            System.out.println("Writing error");

        }
    }
    
    public static void deleteecon(String seat,String departure,String arrival,String airlines,String name,String cnic){
        
        int count = 0;
        try{
            File f = new File("C:\\Users\\Pc\\Desktop\\files\\economy.txt");
        
            BufferedReader rd = new BufferedReader(new FileReader(f));
            for(int x=0; rd.readLine() !=null ;x++){
                count++;
            }
            rd.close();
        }catch(Exception e){
            e.getMessage();
            e.getStackTrace();
            System.out.println("A1");
        }
        
        
        
        String[] data = new String[count];
        String s1= "";
        boolean check1 = false;
        boolean check2 = false;
        boolean check3 = false;
        boolean check4 = false;
        
        try {


            File f = new File("C:\\Users\\Pc\\Desktop\\files\\economy.txt");
            
            BufferedReader rd = new BufferedReader(new FileReader(f));
            int y =0;
            for(int x=0; rd.readLine() !=null ;x++){
                check1 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\economy.txt")).get(x).contains(seat);
                check2 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\economy.txt")).get(x).contains(departure);
                check3 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\economy.txt")).get(x).contains(arrival);
                check4 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\economy.txt")).get(x).contains(airlines);
                if (check1&&check2&&check3&&check4){
                     s1 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\economy.txt")).get(x);
                     
                }
                else{

                
                    data[y] = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\economy.txt")).get(x);
                    y++;
                }
                
            }
           
            rd.close();
        }catch (Exception e){
            e.getMessage();
            e.getStackTrace();
            System.out.println("A2");
        }
        

        try{
            File fr = new File("C:\\Users\\Pc\\Desktop\\files\\Booking.txt");
            FileWriter fw = new FileWriter(fr,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(name+"      "+cnic+"     "+s1);
            bw.newLine();

            bw.close();
            
            
            
        }catch (Exception e){
            e.getMessage();
            e.getStackTrace();
            System.out.println("A3");
        }
    }
    public static void delete(String seat,String departure,String arrival,String airlines,String name,String cnic){
        
        int count = 0;
        try{
            File f = new File("C:\\Users\\Pc\\Desktop\\files\\business.txt");
        
            BufferedReader rd = new BufferedReader(new FileReader(f));
            for(int x=0; rd.readLine() !=null ;x++){
                count++;
            }
            rd.close();
        }catch(Exception e){
            e.getMessage();
            e.getStackTrace();
            System.out.println("A1");
        }
        
        
        
        String[] data = new String[count];
        String s1= "";
        boolean check1 = false;
        boolean check2 = false;
        boolean check3 = false;
        boolean check4 = false;
        
        try {


            File f = new File("C:\\Users\\Pc\\Desktop\\files\\business.txt");
            
            BufferedReader rd = new BufferedReader(new FileReader(f));
            int y =0;
            for(int x=0; rd.readLine() !=null ;x++){
                check1 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\business.txt")).get(x).contains(seat);
                check2 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\business.txt")).get(x).contains(departure);
                check3 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\business.txt")).get(x).contains(arrival);
                check4 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\business.txt")).get(x).contains(airlines);
                if (check1&&check2&&check3&&check4){
                     s1 = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\business.txt")).get(x);
                     
                }
                else{

                
                    data[y] = Files.readAllLines(Paths.get("C:\\Users\\Pc\\Desktop\\files\\business.txt")).get(x);
                    y++;
                }
                
            }
            
            rd.close();
        }catch (Exception e){
            e.getMessage();
            e.getStackTrace();
            System.out.println("A2");
        }

        try{
            File fr = new File("C:\\Users\\Pc\\Desktop\\files\\Booking.txt");
            FileWriter fw = new FileWriter(fr,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(name+"      "+cnic+"     "+s1);
            bw.newLine();

            bw.close();
            
            
            
        }catch (Exception e){
            e.getMessage();
            e.getStackTrace();
            System.out.println("A3");
        }
    }


    public static String Name(){
        String name;
        while(true){
            
            try{
                System.out.println("Enter your Name 'Alphabets only'");
                name = sc.next().toUpperCase();
                for(int i = 0;i<name.length();i++){
                    if(!Character.isAlphabetic(name.charAt(i))){
                        throw new BadInputException("\n\4\033[31;1;1mAlphabets only\033[0m\4\n");
                    }
                    
                    
                    
                }
                
            }
            catch(BadInputException x){
                System.out.println(x.toString());
                continue;
            }
            return name;
        }
    }

    public static String CNIC(){
        String cnic;
        while(true){

        
        try{
            System.out.println("Please enter your cnic in the following pattern\nXXXXX-XXXXXXXX-X");
            cnic = sc.next();
            if(cnic.length()!=15){
                throw new BadInputException("\n\4\033[31;1;1mEnter your 13 digit CNIC with dashes XXXXX-XXXXXXXX-X\033[0m\4\n");
            }
            for(int i=0;i<5;i++){
                if(!Character.isDigit(cnic.charAt(i))){
                    throw new BadInputException("\n\4\033[31;1;1mEnter your 13 digit CNIC with dashes XXXXX-XXXXXXXX-X\033[0m\4\n");
                }
            }
            for(int i=6;i<13;i++){
                if(!Character.isDigit(cnic.charAt(i))){
                    throw new BadInputException("\n\4\033[31;1;1mEnter your 13 digit CNIC with dashes XXXXX-XXXXXXXX-X\033[0m\4\n");
                }
            }
            
            if(cnic.charAt(5)!='-'&& cnic.charAt(13)!='-'){
                throw new BadInputException("\n\4\033[31;1;1mEnter your 13 digit CNIC with dashes XXXXX-XXXXXXXX-X\033[0m\4\n");
            }
            else if(!Character.isDigit(cnic.charAt(14))){
                throw new BadInputException("\n\4\033[31;1;1mEnter your 13 digit CNIC with dashes XXXXX-XXXXXXXX-X\033[0m\4\n");
            }
           
            
            
        }
        catch(BadInputException x){
            System.out.println(x.toString());
            continue;
        }
        return cnic;
        
        }
        
    }


    public static String getCurrentDate(){
	
		String x = (java.time.LocalDate.now()).toString();
        return x;
	}
    public static String airlines(String flightclass){
        if(flightclass.equals("1")){
            System.out.println("Enter Airlines\nEnter in descriptive form");
            System.out.println("1.Shaheen\n2.AirBlue\n3.PIA");
            String choice;
            while(true){
                
                try{
                    choice = sc.next().toUpperCase();
                    if(choice.equals("SHAHEEN")){
                        return choice;
                    }
                    else if(choice.equals("AIRBLUE")){
                        return choice;
                    }
                    else if(choice.equals("PIA")){
                        return choice;
                    }
                    else{
                        throw new BadInputException("\n\4\033[31;1;1mInvalid Choice\033[0m\4\n");
                        
                    }
                }
                catch(BadInputException x){
                    System.out.println(x.toString());
                    continue;
                }
                
            }
                   
        }
        else {
            System.out.println("Enter Airlines");
            System.out.println("1.AirSial\n2.FlyJinnah\n3.Emirates");
            System.out.println("Enter in descriptive form");
            String choice;
            while(true){
                try{
                    choice = sc.next().toUpperCase();
                    if(choice.equals("AIRSIAL")|| choice.equals("FLYJINNAH")|| choice.equals("EMIRATES")){
                        return choice;
                    }
                    else{
                        throw new BadInputException("\n\4\033[31;1;1mInvalid Choice\033[0m\4\n");

                    }
                }
                catch(BadInputException x){
                    System.out.println(x.toString());
                    continue;
                }
            }   
        }
        
    }
    public static String flightclass2(){
        while(true){
            String budget;
            try{
                System.out.println("Enter class\n1)Economy\n2)Buisness");
                System.out.println("Enter 1 or 2");
                budget = sc.next();
                if(budget.equals("1") ){
                    return budget;

                }
                else if(budget.equals("2")){
                    return budget;
                    
                }
                else{
                    throw new BadInputException("\n\4\033[31;1;1mEnter 1 or 2\033[0m\4\n");
                    
                }
            }
            catch(BadInputException x){
                System.out.println(x.toString());
                continue;
            }
            
        }

    }

    public static void flightclass(){
        while(true){
            String budget;
            try{
                System.out.println("Enter class\n1)Economy\n2)Buisness");
                System.out.println("Enter 1 or 2");
                budget = sc.next();
                if(budget.equals("1") ){
                    locationsCall();
                    break;

                }
                else if(budget.equals("2")){
                    locationsCall2();
                    break;
                    
                }
                else{
                    throw new BadInputException("\n\4\033[31;1;1mEnter 1 or 2\033[0m\4\n");
                    
                }
            }
            catch(BadInputException x){
                System.out.println(x.toString());
                continue;
            }
            
        }

    }
    
   
    public static void main(String[]args){
       
        
        
        while(true){
            String firstchoice;
            try{
            System.out.println("******************************************************");
            System.out.println("\033[34;1;1mWelcome to Airline Management System\033[0m");
            System.out.println("Press 1 for flghtBooking\nPress 2 for Information\nPress 3 to cancel booking\nPress 4 to exit");
            System.out.println("******************************************************");
            firstchoice = sc.next();
            if (firstchoice.equals("1")){
                
                flightclass();
                
            }
            else if(firstchoice.equals("2")){
                System.out.println("\033[34;1;1mThis a project created under the supervision of Proffessor Umar Iqbal as a final of the semester\nit shows different flight available of different airlines\033[0m");

            }
            else if(firstchoice.equals("3")){
                cancelCall();
            }
            else if(firstchoice.equals("4")){
                System.out.println("THANK YOU");
                break;
            }
            else if (firstchoice.length()!=1){
                throw  new BadInputException("\n\4\033[31;1;1mEnter 1,2,3 or 4\033[0m\4\n");
            }
            else if(firstchoice.charAt(0)!=1|| firstchoice.charAt(0)!=2 || firstchoice.charAt(0)!=3||firstchoice.charAt(0)!=4){
                throw new BadInputException("\n\4\033[31;1;1mEnter 1,2,3 or 4\033[0m\4\n");
            }
           
            }
            catch(BadInputException x){
                System.out.println(x.toString());
                continue;
            }
            
        }
        

    }
}
       
            
            
            
        
            
        
        
        
        






