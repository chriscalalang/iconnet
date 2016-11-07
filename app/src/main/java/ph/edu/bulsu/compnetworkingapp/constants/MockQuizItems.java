package ph.edu.bulsu.compnetworkingapp.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        item.setQuestion("What is often used to refer to a private connection of LANs and WANs that belongs to an organization, and is designed to be accessible only by the organization's members, employees, or others with authorization?");
        item.setChoices(Arrays.asList("Internetwork", "Intranet", "Internet", "Intranetworking"));
        item.setAcceptedAnswers(Arrays.asList("Intranet", "Intranet"));
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
        item.setQuestion("It is usually administered by a single organization.");
        item.setChoices(Arrays.asList("Application", "Transport", "Internet", "Network Access"));
        item.setAcceptedAnswers(Arrays.asList("Network Access", "Network Access"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("Controls the hardware devices and media that make up the network");
        item.setChoices(Arrays.asList("LAN", "MAN", "WAN", "TAN"));
        item.setAcceptedAnswers(Arrays.asList("LAN", "Local Area Network"));
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
        item.setQuestion("Manages the flow of data between two established socket connections.");
        item.setChoices(Arrays.asList("ASDP", "AED", "AFP", "AGP"));
        item.setAcceptedAnswers(Arrays.asList("ASDP", "ASDP"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("Uses echoes to tell if a computer, or node is available.");
        item.setChoices(Arrays.asList("ASDP", "AED", "AFP", "AGP"));
        item.setAcceptedAnswers(Arrays.asList("AED", "AED"));
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

        Collections.shuffle(items);
        return new ArrayList<>(items.subList(0, size));
    }
}
