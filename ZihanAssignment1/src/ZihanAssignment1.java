/*
This is the program of Assignment1:
• Write a java program that reads input from the keyboard.
• Use a loop to accept keyboard command input.
• Quit if a ‘q’ character command is entered.
• Use a switch statement to perform the following actions based on input commands:
• Input ‘1’ – For the numeric range from 1 to 9 print the number and the number cubed.
Print the sum of all displayed cubed values.
• Input ‘2’ – Convert the input key value to integer form and print its value.
• Input ‘3’ – Print a history of the last three inputs. Display an asterisk (*) for empty entries.
• Bonus: Create a key word based on your first name initial and at least two characters from your last name. The key word must be 3+ characters in length. If the user types your key word characters in the correct sequence, print the phrase “Password accepted”.
*/
class ZihanAssignment1{
    public static void main(String args[])
    throws java.io.IOException{
	char password[]={'Z','Z','h','a','n','g','\n'};
    char passbuf,ignore;
    int passcount=0;
    outerloop:                      //reference:textbook page 94
    for(;;){
    	passcount=0;
    	System.out.println("Please input the password");
    	do{
    		passbuf=(char)System.in.read();
    		if(passbuf==password[passcount])
    			passcount++;
    		else {
    			System.out.println("This password is not correct");
    			do{
    				ignore=(char)System.in.read();
    			}while(ignore!='\n');
    			continue outerloop;
    		}
    	}while(passbuf!='\n');
    	break;
    }
    System.out.println("Password accepted!");
    System.out.println("Welcome!\n");
    char inputsrecords[]={'*','*','*'};
    int inputsnum=0;
    int inputscount=inputsnum%3;
    for(;;){
    System.out.println("1. For the numeric range from 1 to 9 print the number and the number cubed, then print the sum of all displayed cubed values");
    System.out.println("2. Convert the input key value to interger form and print its value.");
    System.out.println("3. Print a history of the last three inputs. Display an asterisk for empty entries");
    System.out.println("Press q to quit!");
    System.out.println("\nPlease input the number:");
    int num,sum=0;
    int key;
    num=(char)System.in.read();
    do{
    	ignore=(char)System.in.read();
    }while(ignore!='\n');
    switch(num){
    case '1':
    	inputsrecords[inputscount]='1';
    	inputsnum++;
    	inputscount=inputsnum%3;
    	for(int i=1;i<=9;i++){
    	System.out.println(i+" "+i*i*i);
    	sum+=i*i*i;
    	}
    	System.out.println("Sum of all displayed cubed value is:"+sum);
    	break;
    case '2':
    	inputsrecords[inputscount]='2';
    	inputsnum++;
    	inputscount=inputsnum%3;
    	System.out.println("Please input the key:");
    	key=System.in.read();
    	do{
    		ignore=(char)System.in.read();
    	}while(ignore!='\n');
    	System.out.println("This interger form of the key is:"+key);
    	break;
    case '3':
    	inputsrecords[inputscount]='3';
    	inputsnum++;
    	inputscount=inputsnum%3;
    	System.out.println("1. "+inputsrecords[0]);
    	System.out.println("2. "+inputsrecords[1]);
    	System.out.println("3. "+inputsrecords[2]);
    	break;
    case 'q':
    	inputsrecords[inputscount]='q';
    	inputsnum++;
    	inputscount=inputsnum%3;
    	System.exit(0);
    default:break;
    }
    }
    }
}