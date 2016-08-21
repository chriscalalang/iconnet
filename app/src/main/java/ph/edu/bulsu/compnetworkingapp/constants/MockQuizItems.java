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
        item.setQuestion("How long is an IPv6 address?");
        item.setChoices(Arrays.asList("32 bits", "128 bytes", "64 bits", "128 bits"));
        item.setAcceptedAnswers(Arrays.asList("128 bits", "128 bytes"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("What flavor of Network Address Translation can be used to have one IP address allow many users to connect to the global Internet?");
        item.setChoices(Arrays.asList("NAT", "Static", "Dynamic", "PAT"));
        item.setAcceptedAnswers(Arrays.asList("PAT", "Port Address Translation"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("What command is used to create a backup configuration?");
        item.setChoices(Arrays.asList("copy running backup", "copy running-config startup-config", "config mem", "wr mem"));
        item.setAcceptedAnswers(Arrays.asList("copy running-config startup-config", "copy running-config startup-config"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("You have 10 users plugged into a hub running 10Mbps half-duplex. There is a server connected to the switch running 10Mbps half-duplex as well. How much bandwidth does each host have to the server?");
        item.setChoices(Arrays.asList("100 kbps", "1 Mbps", "2 Mbps", "10 Mbps"));
        item.setAcceptedAnswers(Arrays.asList("10 Mbps", "10mbps", "10 Megabyte per second"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("Which of the following is the valid host range for the subnet on which the IP address 192.168.168.188 255.255.255.192 resides?");
        item.setChoices(Arrays.asList("192.168.168.129-190", "192.168.168.129-191", "192.168.168.128-190", "192.168.168.128-192"));
        item.setAcceptedAnswers(Collections.singletonList("192.168.168.129-190"));
        items.add(item);


        item = new QuizItem();
        item.setQuestion("Which of the following commands will allow you to set your Telnet password on a Cisco router?");
        item.setChoices(Arrays.asList("line telnet 0 4", "line aux 0 4", "line vty 0 4", "line con 0"));
        item.setAcceptedAnswers(Collections.singletonList("line vty 0 4"));
        items.add(item);


        Collections.shuffle(items);
        return new ArrayList<>(items.subList(0, size));
    }
}
