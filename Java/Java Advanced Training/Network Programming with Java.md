# Before Starting The Tutorial

<p style="font-size:20px">Before you Read This ,First Read The <b><b></b><ins style="color:red">Network Section</ins></b></p>



[TOC]

## What is Socket

> java class for Network programming lives in `java.net.Socket`, it stablishes an Stream between two program

:pushpin:**Example**

```java
socket = new Socket("4.2.2.4",80); // connect to Google on port number 80
socket = new Socket("www.google.com",80); // the same as above
```

> for sending data to another program , the sender program writes on the output of socket

```java
OutputStream out = socket.getOutputStream(); // creates a socket output object for us
```

> for receiveing data from another program , we use input of the socket

```java
InputStream input = socket.getInputStream(); // creates a socket input object for us
```

> Just like reading and writing to a file , like FileOutputStream & FileInputStream , we use above objects for reading and writing . with this different that we do on the network , we read and write from a program or ( send and receive information from another app with our app)

:pushpin:**Another Example**

```java
Socket socket = new Socket("192.168.10.21",8888);
OutputStream out = socket.getoutputStream();
// in this example we have connected to the other computer with 8888 port number , meaning we have connected to a program on that computer that uses the 8888 port number.
Foramtter formatter = new Formatter(out); // now we can write
formatter.flush();
```

#### Using Flush() method

> some programms may still hold some output data on there buffer . to clear this data from buffer we use `.flush`on our writer , also flush would send the outPut imidiately . like bellow :

```java
formatter.flush();
```

:pushpin:**An Example**

```java
public class Users {
    public static void main(String[] args) {
        try(Socket socket = new Socket("www.google.com",80);
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            Formatter formatter = new Formatter(outputStream);
            Scanner scanner = new Scanner(inputStream)) {

            formatter.format("in ro nemitonee peydaa koni azizake man\n");
            formatter.flush();
            System.out.println(inputStream.read());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

:pushpin:

```java
InputStream inputStream = socket.getInputStream();
Scanner scanner = new Scanner(inputStream);
while(true) {
    String next = scanner.next();
    if(next.contains("exit"))
        break;
    System.out.println("Server : " + next);
    System.out.flush();
}
```

--------

## Server Socket

> what we saw earlier what a Client_Socket , we need a ServerSocket .

> To connect to another program ( for example our Server_Socket ) , this server socket must be waiting for our call , or Listen in better word .

> Every Object of ServerSocket must be working on a port .

> ServerSocket would start to be waiting for a call ( listen ) , with `accept()`method . every time a program connects to it the `accept()`execution would terminate . with `accept`ending . an Object of the Type Socket would be created to stablish the connection .

```java
ServerSocket serverSocket = new ServerSocket(8888);
Socket socket = serverSocket.accept(); // stops the program and waits untill a program on the port is connected . and then this Stop would be finished and gives a Socket Object .
```

:pushpin:**An Example is**

```java
try(ServerSocket server = new ServerSocket(8765);
    Socket socket = server.accept();
    Formatter formatter = new Formatter(socket.getOutputStream());
    Scanner scanner = new Scanner(socket.getInputStream())) {
    
    String next;
    
    do {
        
        next = in.next();
        String translate = translate(next);// for example we have a translate method
        out.format(translate+ "\n");
        out.flush();
        
    }(while(!next.equals("exit")));
    
}
```

:round_pushpin:**And So the Client Socket code would be like**

```java
try(Socket socket = new Socket("localhost",8765);
    Scanner socketIn = new Scanner(socket.getInputStream());
    Formatter socketOut = new Formatter(socket.getOutputStream());
    Scanner systemIn = new Scanner(System.in)) {
    
    String next;
    do {
        next = systemIn.next();
        socketOut.format(next + "\n");
        socketOut.flush();
        String recieved = socketIn.next();
        System.out.println("received : " + recieved);
    }while(!next.equals("exit"));
    
}
```

> :star:we can start a server client application with Sockets in our own computer and put the 127.0.0.1 as our address ( which is the address of the local computer )

> :memo:**Usually The Server Programm is a `Multithread`Program , thats because it has to severve multiple different Clients**

---------

# Start Of Tutorial

## Introduction

>Every Software in todays world communicates with the network , from mobile apps , to desktop , to even an antivirus application has implemented network features in itself .
>
>Network can add a lot of power to a simple program . so writing software that is capabale of transfer data between inter-connected devices has become One of the `Most Important Programming Skills`Every programmer should have .

![Inter-Connected Devices](F:\Programming Notes\Java\Java Advanced Training\assets\network_programming.png)

![Here is A FlowChart](F:\Programming Notes\Java\Java Advanced Training\assets\network_programming_FlowChart.png)

## Network Fundamentals

![](F:\Programming Notes\Java\Java Advanced Training\assets\Network_Communication.png)

<p style="font-size:20px">what is a network ?</p>

> A Network is a group of inter-connected Computers & Peripherals that is capable of Sharing software and hardware resources between many users . network can range between connecting Two Computers to millions of devices.
>
> Simple networks installed in homes enable sharing of resources such as printers , documents . pictures , music etc... between a few local devices . 
>
> The internet is the largest Network in Existance . the term internet means the network of networks
>
> The type of software installed on a computer determines which role the computer Plays .

## TCP/IP Model

![](F:\Programming Notes\Java\Java Advanced Training\assets\tcpipmodel.png)

> Communications between computers on a network is done through protocol suits. The most widely used and most widely available protocol suite is TCP/IP protocol suite.
>
> A protocol suit consists of a layered architecture where each layer depicts some functionality which can be carried out by a protocol. Each layer usually has more than one protocol options to carry out the responsibility that the layer adheres to .

> TCP/IP is normally considered to be a 4 layer system. The 4 layers are as shown in above picture

![](F:\Programming Notes\Java\Java Advanced Training\assets\protocol_layers_and_thre_functionality.png)

### `Application Layer`

> This layer will form the data intended to be actually read by the destination PC , and this layer also defines the application and format the data accordingly.
>
> For example, if the sender PC uses a web-browser to communicate with PC at the destination, then it will use the application layer protocol "HTTP".
>
> Another example of application layer protocol is FTP (File Transfer Protocol).
>
> Let us understand that this layer in the source PC will define application, the data format and the actual data, intended to be read only by the destination PC. Data coded according to application layer protocols are then encapsulated into one or  more transport layer protocols which in turn use lower layer protocols to effect actual data transfer.

-----------

### `Transfer Layer`

> This layer helps to identify The application for which the data belongs and hence provides end to end data transfer. The identifier of the application is known as the Port Number, which is of 16 bits.
>
> For example when you are browsing web, the destination port number will be 80. There are specific port numbers for specific standard application. It s sufficient to understand that port numbers help to identify and differentiate among different processes in a computer.
>
> Essentially, this layer adds one header to the original data; which carry certain information needed to deliver correctly to the right application
>
> properly. This header is one of the two types : TCP (Transmission Control Protocol) or UDP ( User Datagram Protocl ) .

---------

### `Internet Layer`

> This layer gets data from a source network to the destination network. This generally involves routing the packets across a network of networks.
>
> This is where IP(Internet Protocol) comes in. IP performs the basic task of getting packets of data from source to destination.
>
> This layer again adds one header to the segment carrying certain more information, to make data find its route to the destination computer. This header gives identification to the computers involved and some other information, helping its to find its path to the destination
>
> in this wide network. The most important fields in the IP header are the Source IP address and the Destination IP address.

-------

### `Network Interface Layer`

> This layer is responsible for encoding and transmitting data over network communications media. It operates with data in the form of bytes which are sent from the Network Interface layer of the sending source and received at the Network interface layer of a destination source.
>
> When you hook up a computer using an Ethernet cable you are connecting that computer on the Network Interface layer. This Physical layer is the lowest level of the TCP/IP Model.
>
> In a Ethernet link, this layer adds one header and one trailer.
>
> The most important information being carried over here are the hardware addresses, media access control addresses.  the MAC address

---------------

###  And When The Packet Arrives at the destination

> When the packet arrives at the destination computer, the destination computer will strip off frame header and trailer and look into the IP header.
>
> It discovers that the packet is meant for it only. It now has the explicit right to strip off the Network/IP header and look further into Transport layer header and see into the port address, to identify the application for which the data is meant for ( Different web-pages in a same computer are also differentiated by port numbers).
>
> Finally the transport layer header (TCP or UDP) is stripped off and the data is sent to the relevant application for final processing.

------------------------

## TCP/IP Communication

> The transport layer is responsible for managing reliability requirements of a conversation. Different applications have different transport reliability requirements.

### IP & TCP/IP

> IP is concerned only with the structure, addressing, and routing of packets. IP does not specify how the delivery or transportation of the packets takes place.
>
> Transport protocols specify how to transfer messages between hosts.
>
> TCP/IP provides two transport layer protocols, Transmission Control Protocol (TCP) and User Datagram Protocol (UDP).
>
> IP uses these transport protocols to enable hosts to communicate and transfer data.
>
> TCP is considered a reliable transport protocol, which means that TCP includes processes to ensure reliable delivery between applications through the use of acknowledged delivery.
>
> TCP transport is analogous to sending packages that are tracked from source to destination.

#### With TCP, the three basic operations of reliability are :

- Tracking transmitted data segments
- Acknowledging received data
- Retransmitting any unacknowledged data

> TCP breaks up a message into small pieces known as segments.
>
> The segments are numbered in sequence and passed to the IP process for assembly into packets.
>
> TCP keeps track of the number of segments that have been sent to a specific host from a specific application. If the sender does not receive an acknowledgement within a certain period of time, it assumes that the segments were lost and retransmits them.
>
> Only the portion of the message that is lost is resent, not the entire message.

> On the receiving host, TCP is responsible for reassembling the message segments and passing them to the application.

*Examples*

> The File Transfer Protocol (FTP) and the Hypertext Transfer Protocol (HTTP) are examples of applications that use TCP to ensure data delivery.

### Where To Use UDP

> These reliability processes (that we read about above) place additional overhead on network resources due to the processes of acknowledgement, tracking, and retransmission. To support these reliability processes, more control data is exchanged between the sending and receiving hosts. This control information is contained in a TCP header.
>
> While the TCP reliability functions provide more robust communication between applications, they also incur additional overhead and possible delays in transmission.
>
> so There is a trade-off between the value of reliability and the burden it places on network resources. Imposing overhead to ensure reliability for some applications could reduce the usefulness of the application and can even be detrimental to the application.

> In such cases, UDP is a better transport protocol. 

> UDP provides just the basic functions for delivering data segments between the appropriate applications, with very little overhead and data checking.

> UDP is known as a best-effort delivery protocol. In the context of networking, best-effort delivery is referred to as unreliable, because there is no acknowledgement that the data is received at the destination.
>
> With UDP, there are no transport layer processes that inform the sender if successful delivery has occurred.

> UDP is similar to placing a regular, non-registered, letter in the mail. The sender of the letter is not aware of whether a receiver is available to receive the letter, nor is the post office responsible for tracking the letter or informing the sender if the letter does not arrive at the final destination.

-----------

##  IP ( Internet Protocol )

> IP was designed as a protocol with low overhead. It provides only the functions that are necessary to deliver a packet from a source to a destination over an interconnected system of networks.
>
> The protocol was not designed to track and manage the flow of packets. These functions which required are performed by other protocols in other layers.

### The Basic Charachteristics Of `IP` are

- > `Connectionless` no connection with the destination is established before sending data packet.

- > `Best effort` package delivery is not guaranteed.

- > `Media independent` operation is independent of the media carrying the data.

----------

> An `ipv4` packet header consists of field containing important information about the packet. 
>
> The most important fields in the `IP header` are the source IP address and the destination IP address.

> An IP address is analogous to a street address of telephone number and that is used to uniquely identify an entry. Each computer known as a host, on the Internet has at least one IP address that uniquely identifies it from all other computers on the internet.

> An IP address consists of four numbers each of which contains one two three digits with a single dot separating each number or set of digits . Each of the four numbers can range from 0 to 255

-----------

## Loopback Interface

> is a special virtual network interface that your computer uses to communicate with itself. It is used mainly for diagnosis on troubleshooting and to connect to servers running on the local machine.
>
> Loopback interfaces are always up regardless of the state of physical interfaces.
>
> Loopback address is a special IP number 127.0.0.1 that is designated for the software loopback interface of a machine. Commonly the loopback address is mapped to the host names: localhost or lookback.

![](F:\Programming Notes\Java\Java Advanced Training\assets\Loop_Back_Interface.png)

# Socket Programming

## Java Socket Programming Introduction

> Java is a Premier Language for Network Programming

> Socket Programming is one of the most important areas of Java programming language, especially for those programmers, who are working in client/server based applications.

> The `java.net` package&nbsp;contains classes and interfaces that provide a powerful infrastructure for networking in Java.
>
> Java&nbsp; networking&nbsp;API makes it easy to communicate via TCP/IP sockets.

> Sockets allow the programmer to treat a network connection as just another stream onto which bytes can be written to and from which bytes can be read.

> A&nbsp;socket&nbsp;is one endpoint of a two-way communication link between two programs running on the network.

> A socket is bound to a port number so that the TCP layer can identify the application that data is destined to be sent to.

**Socket Can Perform 7 Different Operations :**

- Connect to a remote machine
- Send data
- Receive data
- Close a connection
- Bind to a port
- Listen for incoming data
- Accept connections from remote machines on the bound port

> The&nbsp;Socket&nbsp;class sits on top of a platform-dependent implementation, hiding the details of any particular system from your Java program.

> Java's Socket class is used by both clients and servers. The Socket class is part of&nbsp;the java.net.*  package.

### Java programs normally use client sockets in the following fashion:

![](F:\Programming Notes\Java\Java Advanced Training\assets\Socket_Fasion.png)

#### Description Of this diagram is

> `1)` The program creates a new socket object with a constructor.

> `2)` The socket attempts to connect to the remote host.

> `3)`Once the connection is established, the local and remote hosts get input and output streams from      the socket and use those streams to send data to each other.
>
> :star: `This connection is full-duplex. Both hosts can send and receive data simultaneously.` ( **This Is The Feature You need To Create messaging and Phone Apps** )
>
> What the data means depends on the protocol.
>
> Different commands are sent to an FTP server than to an HTTP server.

>`4)`When the transmission of data is complete, one or both sides close the connection. Some protocols, such as HTTP,  require the connection to be closed after each request is serviced.
>
>Others, such as FTP, allow multiple requests to be processed in a single connection.

-------

## ServerSocket Class

![](F:\Programming Notes\Java\Java Advanced Training\assets\Server_Socket_Class.png)

### ServerSocket Class Definition

> The ServerSocket class contains everything needed to write servers in Java.

> It has constructors that create new ServerSocket objects

> methods that listen for connections on a specified port and methods that configure the various server socket options.

#### In Java, the basic life cycle of a server program is:

> `1)`A new ServerSocket is created on a particular port using a `ServerSocket( )` constructor.

>`2)`The ServerSocket listens for incoming connection attempts on that port using its `accept()` method. `accept( )` blocks until a client attempts to make a connection, at which point `accept()` returns a Socket object connecting the client and the server.

> `3)`Depending on the type of server, either the Socket's getInputStream() method, getOutputStream() method, or both are called to get input and output streams that communicate with the client.

> `4)`The server and the client interact according to an agreed-upon protocol until it is time to close the connection.

> `5)`The server, the client, or both close the connection.

> The server returns to step 2 and waits for the next connection.

------------

# :memo:Starting Socket Programming Examples

## Local Port Scanner

<p style="text-size:15px"><b>To Get All Of The Oppening Ports in CMD Type : <em style="color:red">netstat -a</em></b></p>

:pushpin: *Example*

```java
// first check in cmd and see the ports that are open and are in Listening State
// because you can not use them .
// another treat is that a hacker can use open ports to attack
// Now The Example
public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234); // make sure it is not used
        } catch(IOException e) {
            System.out.println("Port Is Already Open..!");
        }
    }
}
```

<p style="text-size:20px;font-weight:bold">And Example To See Which Ports Are Open :</p>

```java
// pay attention that in the list netstat -a ( The Listening Ports Are Dangeous)
public class Users {
    public transient String myName = "Arash";
    public static void main(String[] args) {
        int port = 1;
        while(port <= 65535) {
            try {
                ServerSocket server = new ServerSocket(port);
            } catch (IOException e) {
                System.out.println("Port : " + port + " Is Open");
            }
            port++;
        }
    }
}
```

> in the <b>netstat -a</b> the listening ports are dangerous .

> a `Socket` is a simple `Object` that wraps a single `TCP` connection

```java
public static void main(String[] args) {
    ServerSocket serverSocket = new ServerSocket(1234);
    System.out.println("Wating For Clients");
    Socket socket = serverSocket.accept();
}
```

> `accept()` method blocks the caller untill a connection is present

## Windows Telnet Client

> because we haven't leaned yet how to make a client in java , we will use something called `Telnet Client` .

> `Telnet`is a terminal emulation program and it runs on our computer and connects our pc to a server on the network .
>
> `Telnet`data is sent in ClearText ( you have seen it in android ) and in this example our application also sends data in ClearText . we can open our telnet connection by typing `telnet` in the cmd .
>
> if `Cmd`doesn't recognize the telnet , go to `Windows Freatures`and anable the `Telnet` there

:pushpin:*A Complete Example*

```java
public class Users {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7854);
        System.out.println("wating for caller....");
        Socket socket = serverSocket.accept();
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true );// WARNING : Second Argument "true" is Verry Verrryyy IMPORTANT , it is the command that sends the output emidiately , without it , the data wouldn't be sent .
        out.println("Hello Baby Welcome");
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String clientInput = input.readLine();
        System.out.println(clientInput);
        input.close();
        out.close();
        socket.close();
    }
}
```

<div style="float:left;font-size:17px"><img src="F:\Programming Notes\Java\Java Advanced Training\assets\icons8_more_than_50px.png">Now Open The Cmd and Write <b><em>telnet localhost 7854</em></b></div>

:pushpin:**Here Is My First Working Program , Works With `Telnet`**

```java
public class Users {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket socket = serverSocket.accept();
        PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
        writer.println("Hello Type Your Words : ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String userInput = "";
        while(!(userInput = bufferedReader.readLine()).equals("exit")) {
            writer.println("Input From LocalHost Is : " + userInput);
            writer.println("Your Input Has : " + userInput.length() + "Charachters");
            writer.println();
        }
        writer.close();
        bufferedReader.close();
        socket.close();
    }
}
// after this ( make sure telnet is installed ) then open cmd , type
// telnet localhost 1234 (and hit enter)
// now type any word you want
```

> make the program accepts different users ( Meaning it Shall not exit after the first user types "exit" ) , like bellow :

<div style="font-size:17px;"><img src="F:\Programming Notes\Java\Java Advanced Training\assets\icons8_comments_40px.png"><span style="font-weight:bold">Note :</span> For Working with Streams , whether It is a File Stream , or it is a Network Stream , Or even if it is a ByteArray Stream , the note is that We Need <b> Reader & Writers </b> to read from them or write to them , Thus We Need <B> InputStreamReaders And OutPutStreamWriters</B></div>

```java
public class Users {
    public static void main(String[] args) {
        try {
            boolean stop = false;
            ServerSocket serverSocket = new ServerSocket(1234);
            while(!stop) {
                System.out.println("Program is Waiting For a Call....");
                Socket socket = serverSocket.accept();
                System.out.println("Call Stablished");
                PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
                writer.println("Hello Type Your Words : ");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String userInput = "";
                while(!(userInput = bufferedReader.readLine()).equals("exit")) {
                    writer.println("Input From LocalHost Is : " + userInput);
                    writer.println("Your Input Has : " + userInput.length() + "Charachters");
                    writer.println();
                }
                writer.close();
                bufferedReader.close();
                socket.close();
            }
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
```

<div style="font-size:17px;"><img src="F:\Programming Notes\Java\Java Advanced Training\assets\icons8_more_than_50px_2.png">Create a Thread With <b>Lambdas</b> Expression</div>

```java
public static void main(String[] args) {
   Thread thread = new Thread(() -> {
       System.out.println("hello i am in a thread");
   });
   thread.start();
}
```

## Creating Multithreaded Application

<div style="fond-size:17px;"><img src="F:\Programming Notes\Java\Java Advanced Training\assets\icons8_question_mark_24px.png">What is the rule of <b>Thread</b> in Network Programming</div>

> without `Multithreading`there is open one signle connection that means its not possible to connect another client at the same time to communicate with server .

> Suppose we have many clients trying to connect to the web server , in this case we shall implement Multithreading , the basic idea behind Multithreading , is whenever the server gets a connection request from client , the server creates a seperate independent thread for each Client request , that means for each client there is a client the is a seperate client thread in the Server , so the Client can communicate Independently with their own client thread in server .

![](F:\Programming Notes\Java\Java Advanced Training\assets\MultiNetwork.png)

<div style="font-size:17px;"><img src="F:\Programming Notes\Java\Java Advanced Training\assets\icons8_about_50px.png"><b>The Waiting State</b> of a Thread is Important , Specially in the Networking .</div>

> sometimes a thread enters the waiting state while the thread waits for another thread to perform a task . a thread transition back to the runnable state only when another thread signals the waiting thread to continue executing . *The Waiting State Is Important* when you are creatng a network application . a server application should be in the waiting state when its waiting for a client request . when the client is connected to the server the server transitions back to the runnable state in order to process client request . and after the process is done the server could go back in the waiting state *We Have Seen This when we created the `stop`boolean in above examples*.
>
> also a thread would enter its *terminated*state , when its tast is finished , just like ServerSocket

## Sleep A Thread

### Definition

> The thread class has a useful method called `sleep()`. Sleep method causes the current thread to suspend execution for a specified period.
>
> This is an efficient method to make processor time available to the other threads of an application or other applications that might be running on a computer system.

-------------

## Multithread Network ( Socket ) Programming

> `Note`: Do remember that to read from a `File`or fro a `Network`or even from a `ByteArray`(which is in the memory ) , for all of this , we need `Readers`& `Writers`to work with them , and for this porpuse we use `InputReader`Or `OutputWriter`, Or more precisly `InputStreamReader`& `OutPutStreamWriter` , and or `BufferedReader`& `BufferedWriter`, this are all for working with them , reading and writing to them . manipulate them .

-------------

### :pushpin:Writing an Example

**In The `MultithreadedServer` Class we have**

```java
public class MultiThreadedServer {

    public static void main(String[] args) {
        try {
            boolean flag = false;
            ServerSocket server = new ServerSocket(1234);
            while(!flag) {
                System.out.println("Waiting For A Call....");
                Socket socket = server.accept();
                System.out.println("A Call Just Stablished");
                ClientThread clientThread = new ClientThread(socket);
                clientThread.start();
            }
            server.close();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
```

**Now In The `ClientThread` Class we have**

```java
public class ClientThread extends Thread {
    
    private Socket socket;
    
    ClientThread(Socket socket) {
        this.socket = socket;
    }
    
    public void run() {
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            writer.println("Welcome To My Client_Server Based Application");
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String userInput = "";
            while(!(userInput = reader.readLine()).equals("exit")) {
                writer.println("Input From LocalHost Is : " + userInput);
                writer.println("Your Input Has : " + userInput.length() + "Charachters");
                writer.println();
            }
            writer.close();
            reader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
```

<div style="font-size:17px"><img src="F:\Programming Notes\Java\Java Advanced Training\assets\icons8_checkmark_48px.png"> Now We Have Written A MultiThreaded Client_Server Base Application that works with Sockets</div>

## InetAddress Class

>The Java InetAddress class is java's encapsulation of an IP address. It is used by most of the other networking classes including Socket, ServerSocket, URL, DatagramSocket, DatagramPacket and more.

> Inetaddress consist of IP addresses and possibly its corresponding hostname.

> This class provides methods to resolve hostnames and their IP addresses and vice versa.

> This class uses domain name system (DNS) to return information about a host.

> The InetAddress class has no visible constructors. To create an InetAddress object you have to use one of the available factory methods.

:pushpin:**For Example you can obtain the ip address of the localhost**

```java
public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostAddress()); // returns 192.168.1.23 for me on cable
        System.out.println(address.getHostName()); // returns the name of my computer , in my case DESKTOP-AC7VH8I
    }
```

:pushpin:**And thus we can get the ip address of any host just like :**

```java
public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("soft98.ir");
        System.out.println(address.getHostName());
        System.out.println(address.getHostAddress());
    }
```

> `NOTE`: The InetAddress can be used by the socket class .

> you can create a socket object by passing in the InetAddress object into the socket class Constructor .

:pushpin:**Example of building a Socket Object by Passing in the InetAddress Object into Socket Constructor**

```java
public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName("soft98.ir");
        Socket socket = new Socket(address,80);
    }
```

--------------

## How To Create A TCP Client

> We have already created the Server Socket Application in above example , now we create the Socket Client Application . The first Stp to create a Socket Client Application is to create the Socket Object .

<div style="font-size:17px"><img src="F:\Programming Notes\Java\Java Advanced Training\assets\icons8_marker_48px.png">To Get And Show All <b>Exceptions</b> when you are connecting to a server ( or using <b>Socket</b> in general) from client app , try to add all exeptions you can . as you see bellow</div>

```java
public static void main(String[] args) throws IOException {

        try {
            InetAddress serverAddress = InetAddress.getLocalHost();
            System.out.println("Server Ip Address : " + serverAddress.getAddress());
            Socket socket = new Socket(serverAddress,1234);
        }catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("UnknownHostException " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
        }

    }
}
```

-------

> In Bellow Example you Will See a Two Way , A True ( Client _ Server ) Based Application

:pushpin:**Here In The Server App , We Open The Port And Do The Neccessary Things :**

```java
public class MultiThreadedServer {

    public static void main(String[] args) throws IOException {

        try {
            boolean flag = false;
            ServerSocket server = new ServerSocket(1234);
            while(!flag) {
                System.out.println("Waiting For A Call....");
                Socket socket = server.accept();
                System.out.println("A Call Just Stablished");

                PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
                writer.println("Welcome To My Client_Server Based Application");
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(reader.readLine());
                writer.close();
                reader.close();
                socket.close();

            }
            server.close();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}
```

:round_pushpin:**And Here Is The Client Application Code ( Notice they Are In Two Different IntelliJ IDEA Project )**

```java
public class Client {
    public static void main(String[] args) {
        try {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            System.out.println("server ip address : " + serverAddress.getHostAddress());
            Socket socket = new Socket(serverAddress,1234);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(input.readLine());
            out.println("Hello Baby Server");
            input.close();
            out.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

----------

## Remote Port Scanner

> in this chapter we will learn how to create a port scanner that scans remote hosts for open TCP Ports

<div style="text-size:17px"><img src="F:\Programming Notes\Java\Java Advanced Training\assets\icons8_info_50px.png">To Scan for Our local ports we used <b>ServerSocket</b> , For scanning remote host open TCP Ports we use <b>Socket</b></div>

> before Starting the example , first lets see an example of how I have managed program flow with Exceptions ( or better said : how i have manaegd The Exception ) , like bellow example which in it the program continues even if user enters a wrong value , it continues untill the user enters a Number , that is between 50 to 100 

:pushpin:

```java
public class Client {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = false;
        while(!flag) {
            try {
                System.out.print("Please Enter a number Between 50 and 100 : ");
                String stringNumber = reader.readLine();
                int number = Integer.valueOf(stringNumber);
                if(number >= 50 && number <= 100) {
                    System.out.println("Your Answer Is Write , While Loop Will End With The Program");
                    flag = true;
                }
            } catch (IOException e) {
                System.out.println("I/O Exception Wih Message : " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Your Value is not a Number ! With error " + e.getMessage());
            }
        }
    }
}
```

--------------

-------------

<div style="font-size:17px"><img src="F:\Programming Notes\Java\Java Advanced Training\assets\icons8_forward_filled_50px.png">Example of checking a Remote Server For Open ( Listening ) Ports</div>

> There are 4 steps for writing a program that checks a Remote Server Ports and Determine if any of it's Port *Are Open ( In **Listening** state )*

1. > Get the Remote server Ip address by using  `InetAddress` , as in the example bellow . then use this address to build your socket
2. > build a `while loop`to check with building the socket with every port one by one .
3. > If the build process of your socket is successfull and you can go to next line of your code , it means that this port you entered to create this Socket object is `Open` and in `Listening State`
4. > If the process of building socket is not successfull , it means this port is closed , and the application would throw an `IOException` , which you can get and handle (for example print a message that this port number is closed) , and then just your loop would continue .

:memo:This is One Example that you see just How much managing `Exceptions`is Important

:pushpin:**This Is Your Example :**

```java
public class Client {
    public static void main(String[] args) {

        System.out.println("Please Enter The Name Of The Remote Server : ");
        Scanner scanner = new Scanner(System.in);
        String serverName = scanner.nextLine();
        try {
            InetAddress address = InetAddress.getByName(serverName);
            System.out.println(address.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        String targetIp = "";
        int fromPort = 0;
        int toPort = 0;

        System.out.println("Please Enter The Target IP Address : ");
        try {
            targetIp = reader.readLine();
        } catch (Exception e) {
            System.out.println("Cannot read the IP Address...! " + e.getMessage());
        }

        // boolean value to Controll the validation process
        boolean isValid = false;
        while(!isValid) {
            try {
                System.out.println("Please Enter The First Port Number : ");
                String portString = reader.readLine();
                fromPort = Integer.parseInt(portString);
                if(fromPort >= 0 && fromPort <= 65536) {
                    isValid = true;
                } else  {
                    System.out.println("Invalid port number..! range is from 0 to 65536");
                }
            } catch (IOException e) {
                System.out.println("I/O Exception When Entering Your Port Number . " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Please Enter A Number...! " + e.getMessage());
            }
        }

        isValid = false;
        while (!isValid) {
            try {
                System.out.println("Please Enter The last port : ");
                String portString = reader.readLine();
                toPort = Integer.parseInt(portString);
                if(toPort >= 0 && toPort <= 65536) {
                    if(toPort >= fromPort) {
                        isValid = true;
                    }
                } else {
                    System.out.println("Invalid port , Port range is from 0 to 65536");
                }
            } catch (IOException e) {
                System.out.println("IOException Is : " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Please Enter A Number..." + e.getMessage());
            }
        }

        int port = fromPort;
        while(port >= fromPort && port <= toPort) {
            try {
                Socket socket = new Socket(targetIp,port);
                System.out.println("Port " + port + " is in Listening state..!");
                socket.close();
            } catch (UnknownHostException e) {
                System.out.println("Unknown Host Exception " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Port " + port + " is not opened...!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            port++;
        }
    }
}
```

--------------

---------------

# Build A Chat Application With Java

