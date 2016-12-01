package ph.edu.bulsu.compnetworkingapp.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import ph.edu.bulsu.compnetworkingapp.models.QuizItem;

/**
 * Created by Sheychan on 8/21/2016.
 */
public class MockQuizItems {
    public static ArrayList<QuizItem> getQuizItems(int size) {
        ArrayList<QuizItem> items = new ArrayList<>();

        QuizItem item = new QuizItem();
        item.setQuestion("How may bits does an IP address have?");
        item.setChoices(Arrays.asList("8", "32", "128", "256"));
        item.setAcceptedAnswers(Arrays.asList("32", "32 bits"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("The address which we refer to the network.");
        item.setChoices(Arrays.asList("Network Address", "Broadcast Address", "Subnet Mask", "Hosts Address"));
        item.setAcceptedAnswers(Arrays.asList("Network Address", "Network"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("The address assigned to the end of devices on the network.");
        item.setChoices(Arrays.asList("Network Address", "Broadcast Address", "Subnet Mask", "Hosts Address"));
        item.setAcceptedAnswers(Arrays.asList("Hosts Address", "Host"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("Which determines the number of hosts in a network.");
        item.setChoices(Arrays.asList("Network Address", "Broadcast Address", "Subnet Mask", "Hosts Address"));
        item.setAcceptedAnswers(Arrays.asList("Subnet", "Subnet Mask"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("A special address that is use to send all data to all hosts on the network.");
        item.setChoices(Arrays.asList("Network Address", "Broadcast Address", "Subnet Mask", "Hosts Address"));
        item.setAcceptedAnswers(Arrays.asList("Subnet", "Subnet Mask"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("An IT expert who manages organization’s network.");
        item.setChoices(Arrays.asList("Network Systems", "Network Administrator", "Network Cisco", "Network Expert"));
        item.setAcceptedAnswers(Arrays.asList("Network Admin", "Network Administrator"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("What does SMTP means?");
        item.setChoices(Arrays.asList("Sample Mail Transfer Protocol", "Staggard Mail Transfer Protocol", "Simplex Mail Transfer Protocol", "Simple Mail Transfer Protocol"));
        item.setAcceptedAnswers(Arrays.asList("Simple Mail Transfer Protocol", "Simple Mail Transfer Protocol"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("Which of the following is a Private and Class C IP");
        item.setChoices(Arrays.asList("192.168.1.1", "192.161.1.1", "192.168.256.1", "192.166.11.200"));
        item.setAcceptedAnswers(Arrays.asList("192.168.1.1", "192.168.1.1"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("How do you represent 1011 0011 on decimal?");
        item.setChoices(Arrays.asList("176", "177", "178", "179"));
        item.setAcceptedAnswers(Arrays.asList("179", "179"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("How do represent 231 on binary?");
        item.setChoices(Arrays.asList("1110 0111", "1100 0111", "1000 1111", "1111 0011"));
        item.setAcceptedAnswers(Arrays.asList("1110 0111", "1110 0111"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("What is the dotted decimal representation of the IPv4 address 11001011.00000000.01110001.11010011?");
        item.setChoices(Arrays.asList("192.0.2.199", "192.51.100.201", "203.0.113.211", "203.0.113.211"));
        item.setAcceptedAnswers(Arrays.asList("203.0.113.211", "203.0.113.211"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("What port number does SMTP uses?");
        item.setChoices(Arrays.asList("80", "23", "25", "21"));
        item.setAcceptedAnswers(Arrays.asList("25", "25"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("Represents data to the user plus encoding and dialog control.");
        item.setChoices(Arrays.asList("Application", "Transport", "Internet", "Network Access"));
        item.setAcceptedAnswers(Arrays.asList("Application", "Application"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("Determines the best path through the network.");
        item.setChoices(Arrays.asList("Application", "Transport", "Internet", "Network Access"));
        item.setAcceptedAnswers(Arrays.asList("Internet", "Internet"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("Support communication between diverse devices across diverse networks");
        item.setChoices(Arrays.asList("Application", "Transport", "Internet", "Network Access"));
        item.setAcceptedAnswers(Arrays.asList("Internet", "Internet"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("It is use specifically designed network devices to make the interconnections between LAN.");
        item.setChoices(Arrays.asList("LAN", "MAN", "WAN", "TAN"));
        item.setAcceptedAnswers(Arrays.asList("WAN", "Wide Area Network"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("The most widely known internetwork reference model?");
        item.setChoices(Arrays.asList("OSI", "GUI", "TCIP", "IP"));
        item.setAcceptedAnswers(Arrays.asList("OSI", "OSI"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("The general term for the PDU used at the Application layer?");
        item.setChoices(Arrays.asList("Data", "Packet", "Segment", "Frame"));
        item.setAcceptedAnswers(Arrays.asList("Data", "Data"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("A PDU used when physically transmitting data over the medium.");
        item.setChoices(Arrays.asList("Data", "Packet", "Segment", "Bits"));
        item.setAcceptedAnswers(Arrays.asList("Bits", "Bits"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("What is the meaning of API?");
        item.setChoices(Arrays.asList("Application Protocol Interface", "Application Protocol Integrate", "Application Programming Interface", "Application Programming Integrate"));
        item.setAcceptedAnswers(Arrays.asList("Application Programming Integrate", "Application Programming Integrate"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("This Bus is developed for fast video cards. It is currently up to 4X mode speed.");
        item.setChoices(Arrays.asList("API", "APPC", "ARP", "AGP"));
        item.setAcceptedAnswers(Arrays.asList("AGP", "AGP"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("Uses analog signals to divide the cable into several channels with each channel at its own frequency.");
        item.setChoices(Arrays.asList("BSC", "Router", "Broadcast", "Broadcast"));
        item.setAcceptedAnswers(Arrays.asList("Broadcast", "Broadcast"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("Is a standardized telecommunication network interface for connecting voice and data equipment to a service provided by a local exchange carrier or long distance carrier.");
        item.setChoices(Arrays.asList("Registered jack (RJ)", "Coaxial cable", "Fiber Optic", "UTP Cable"));
        item.setAcceptedAnswers(Arrays.asList("Registered jack", "Registered jack (RJ)"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("Is a flexible, transparent fiber made by drawing glass (silica) or plastic to a diameter slightly thicker than that of a human hair.");
        item.setChoices(Arrays.asList("Fiber Optic", "UTP cable", "Coaxial cable", "Fiber cable"));
        item.setAcceptedAnswers(Arrays.asList("Fiber Optic", "Fiber Optic"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("A type of cable that has an inner conductor surrounded by a tubular insulating layer, surrounded by a tubular conducting shield.");
        item.setChoices(Arrays.asList("Fiber Optic", "UTP cable", "Coaxial cable", "Registered jack (RJ)"));
        item.setAcceptedAnswers(Arrays.asList("Coaxial cable", "Coaxial cable"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("Represents data to the user plus encoding and dialog control.");
        item.setChoices(Arrays.asList("Application", "Transport", "Internet", "Network Access"));
        item.setAcceptedAnswers(Arrays.asList("Application", "Application"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("Is the most common kind of copper telephone wiring. Twisted pair is the ordinary copper wire that connects home and many business computers to the telephone company. To reduce crosstalk or electromagnetic induction between pairs of wires, two insulated copper wires are twisted around each other.");
        item.setChoices(Arrays.asList("Unshielded Twisted Pair (UTP)", "Coaxial Cable", "Fiber Optic", "Registered jack (RJ)"));
        item.setAcceptedAnswers(Arrays.asList("Unshielded Twisted Pair (UTP)", "UTP"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("Is a telecommunications network which allows computers to exchange data?");
        item.setChoices(Arrays.asList("Computer Network", "Networking", "Network", "Networker"));
        item.setAcceptedAnswers(Arrays.asList("Computer Network", "Computer Network"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("A screen of numbers used for routing traffic within a subnet.");
        item.setChoices(Arrays.asList("Subnet Mask", "Subnet Byte", "Subnet length", "Subnetting"));
        item.setAcceptedAnswers(Arrays.asList("Subnet Mask", "Subnet Mask"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("It connects peripheral devices such as digital cameras, mice, keyboards, printers, scanners, media devices, external hard drives and flash drives.");
        item.setChoices(Arrays.asList("Universal Serial Bus (USB)", "UTP", "Flash drive", "HDMI"));
        item.setAcceptedAnswers(Arrays.asList("Universal Serial Bus (USB)", "Universal Serial Bus (USB)"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("What is the Broadcast Address of 192.168.1.1?");
        item.setChoices(Arrays.asList("255.256.255.255", "255.255.255.255.255", "255.255.255.255", "254.255.255.0"));
        item.setAcceptedAnswers(Arrays.asList("255.255.255.255", "255.255.255.255"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("What is the Network Address of 192.168.1.1?");
        item.setChoices(Arrays.asList("128.0.0.0", "128.1.0.0", "1288.0.0.0", "128.1.1.1"));
        item.setAcceptedAnswers(Arrays.asList("128.0.0.0", "128.0.0.0"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("What is the Broadcast Address of 90.255.0.1");
        item.setChoices(Arrays.asList("127.255.255.255", "127.255.255.2555", "127.255.255.285"));
        item.setAcceptedAnswers(Arrays.asList("128.0.0.0", "128.0.0.0"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("What is the Network Address of 90.255.0.1");
        item.setChoices(Arrays.asList("0.0.0.0", "0.0.0.1", "0.0.0.0.0"));
        item.setAcceptedAnswers(Arrays.asList("0.0.0.0", "0.0.0.0"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("What is the Broadcast Address of 192.160.2.7");
        item.setChoices(Arrays.asList("255.255.255.254", "255.255.255.255", "255.255.255.2555"));
        item.setAcceptedAnswers(Arrays.asList("255.255.255.255", "255.255.255.255"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("What is the Network Address of 192.160.2.7?");
        item.setChoices(Arrays.asList("127.0.0.0", " 128.1.0.0", "128.0.0.0"));
        item.setAcceptedAnswers(Arrays.asList("128.0.0.0", "128.0.0.0"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("What is the Broadcast Address of 255.0.1.1?");
        item.setChoices(Arrays.asList("255.255.255.254", " 255.255.255.255", "255.255.255.2555"));
        item.setAcceptedAnswers(Arrays.asList("255.255.255.255", "255.255.255.255"));
        items.add(item);



        item = new QuizItem();
        item.setQuestion("What is the Network Address of 255.0.1.1?");
        item.setChoices(Arrays.asList("127.0.0.0", " 128.1.0.0", "128.0.0.0"));
        item.setAcceptedAnswers(Arrays.asList("128.0.0.0", "128.0.0.0"));
        items.add(item);




        item = new QuizItem();
        item.setQuestion("What is the Broadcast Address of 177.25.1.1?");
        item.setChoices(Arrays.asList("255.255.255.254", " 255.255.255.255", "255.255.255.2555"));
        item.setAcceptedAnswers(Arrays.asList("255.255.255.255", "255.255.255.255"));
        items.add(item);




        item = new QuizItem();
        item.setQuestion("What is the Broadcast Address of 192.169.2.2?");
        item.setChoices(Arrays.asList("255.255.255.254", "255.255.255.255", "255.255.255.2555"));
        item.setAcceptedAnswers(Arrays.asList("255.255.255.255", "255.255.255.255"));
        items.add(item);







        item = new QuizItem();
        item.setQuestion("What is the Network Address of 90.255.0.2?");
        item.setChoices(Arrays.asList("0.0.0.1", "0.0.0.8", "0.0.0.0 "));
        item.setAcceptedAnswers(Arrays.asList("0.0.0.0 ", "0.0.0.0 "));
        items.add(item);










        item = new QuizItem();
        item.setQuestion("What is the Broadcast Address of 255.1.1.1?");
        item.setChoices(Arrays.asList("255.255.255.254", "255.255.255.255", "255.255.255.2555"));
        item.setAcceptedAnswers(Arrays.asList("255.255.255.255", "255.255.255.255"));
        items.add(item);







        item = new QuizItem();
        item.setQuestion("What is the Broadcast Address of 192.1.255.2 /27?");
        item.setChoices(Arrays.asList("192.1.255.32", "192.1.255.31", "192.0.255.31"));
        item.setAcceptedAnswers(Arrays.asList("192.1.255.31", "192.1.255.31"));
        items.add(item);











        item = new QuizItem();
        item.setQuestion("What is the Network Address of 192.1.255.2 /27?");
        item.setChoices(Arrays.asList("192.1.255.0", "192.1.265.0", "192.1.285.0"));
        item.setAcceptedAnswers(Arrays.asList("192.1.255.0", "192.1.255.0"));
        items.add(item);











        item = new QuizItem();
        item.setQuestion("What is the Broadcast Address of 192.2.255.4 /28?");
        item.setChoices(Arrays.asList("192.2.245.15", "192.2.255.15", "182.2.255.15"));
        item.setAcceptedAnswers(Arrays.asList("192.2.255.15", "192.2.255.15"));
        items.add(item);







        item = new QuizItem();
        item.setQuestion("What is the Network Address of 192.2.255.4 /28?");
        item.setChoices(Arrays.asList("192.2.255.1", "192.1.255.0", "192.2.255.0"));
        item.setAcceptedAnswers(Arrays.asList("192.2.255.0", "192.2.255.0"));
        items.add(item);







        item = new QuizItem();
        item.setQuestion("What is the Network Address of 192.1.254.1 /17?");
        item.setChoices(Arrays.asList("192.1.128.1", "192.1.128.0", "192.1.1288.0"));
        item.setAcceptedAnswers(Arrays.asList("192.1.128.0", "192.1.128.0"));
        items.add(item);










        item = new QuizItem();
        item.setQuestion("What is the Broadcast Address of 255.2.1.1?");
        item.setChoices(Arrays.asList("255.255.255.254", "255.255.255.255", "255.255.255.2555"));
        item.setAcceptedAnswers(Arrays.asList("255.255.255.255", "255.255.255.255"));
        items.add(item);









        item = new QuizItem();
        item.setQuestion("What is the Network Address of 255.2.1.1?");
        item.setChoices(Arrays.asList("127.0.0.0", "128.1.0.0", "128.0.0.0"));
        item.setAcceptedAnswers(Arrays.asList("128.0.0.0", "128.0.0.0"));
        items.add(item);








        item = new QuizItem();
        item.setQuestion("What is the Broadcast Address of 193.162.1.1?");
        item.setChoices(Arrays.asList("255.255.255.254", "255.255.255.255", "255.255.255.2555"));
        item.setAcceptedAnswers(Arrays.asList("255.255.255.255", "255.255.255.255"));
        items.add(item);









        item = new QuizItem();
        item.setQuestion("What is the Network Address of 193.162.1.1?");
        item.setChoices(Arrays.asList("127.0.0.0", "128.1.0.0", "128.0.0.0"));
        item.setAcceptedAnswers(Arrays.asList("128.0.0.0", "128.0.0.0"));
        items.add(item);








        item = new QuizItem();
        item.setQuestion("What is the Broadcast Address of 178.26.1.1 /5?");
        item.setChoices(Arrays.asList("183.255.2255.255", "183.255.255.255", "183.255.955.255"));
        item.setAcceptedAnswers(Arrays.asList("183.255.255.255", "183.255.255.255"));
        items.add(item);








        item = new QuizItem();
        item.setQuestion("What is the Network Address of 178.26.1.1 /5?");
        item.setChoices(Arrays.asList("176.0.0.8", "176.0.0.0", "176.0.0.2"));
        item.setAcceptedAnswers(Arrays.asList("176.0.0.0", "176.0.0.0"));
        items.add(item);





        item = new QuizItem();
        item.setQuestion("What is the Broadcast Address of 193.161.2.5 /6?");
        item.setChoices(Arrays.asList("195.2555.255.255", "195.255.285.255", "195.255.255.255"));
        item.setAcceptedAnswers(Arrays.asList("195.255.255.255", "195.255.255.255"));
        items.add(item);







        item = new QuizItem();
        item.setQuestion("What is the Network Address of 193.161.2.5 /6?");
        item.setChoices(Arrays.asList("192.0.0.1", "192.0.0.0", "195.0.0.0"));
        item.setAcceptedAnswers(Arrays.asList("192.0.0.0", "192.0.0.0"));
        items.add(item);






        item = new QuizItem();
        item.setQuestion("What is the Broadcast Address of 198.151.1.1 /7?");
        item.setChoices(Arrays.asList("195.2555.255.255", "195.255.285.255", "199.255.255.255"));
        item.setAcceptedAnswers(Arrays.asList("199.255.255.255", "199.255.255.255"));
        items.add(item);






        item = new QuizItem();
        item.setQuestion("What is the Broadcast Address of 255.198.5.1 /9?");
        item.setChoices(Arrays.asList("255.255.255.254", "255.255.255.255", "255.255.255.2555"));
        item.setAcceptedAnswers(Arrays.asList("255.255.255.255", "255.255.255.255"));
        items.add(item);




        item = new QuizItem();
        item.setQuestion("What is the Network Address of 255.198.5.1 /9?");
        item.setChoices(Arrays.asList("255.255.255.254", "255.128.0.0", "255.255.255.2555"));
        item.setAcceptedAnswers(Arrays.asList("255.128.0.0", "255.128.0.0"));
        items.add(item);




        Collections.shuffle(items);
        return new ArrayList<>(items.subList(0, size));
    }
}
