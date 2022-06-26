##### Link is : https://www.youtube.com/watch?v=V1y-mbWM3B8

--------------------

> Linux is also the name of a kernel that documents and videos and programms and ... run on it 

> the designers can modify the linux kernel to design there own operation System . like `Ubunu` `debian` , `Fedora`

>NOTE : linux does not need an antivirus , it is highly secure system .

> :spiral_notepad:Linux is the operating system of choice for Server Environments due to its stability and reliablity . like `amazon`,`google`,`facebook`

> there are a variaty of linux distributions , many of them are built to run on web servers , `a network switch` ( hub ) . 

## UNIX

> the latest example of one of the most popular smartphone based [Unix] distribution is Android

> Mac is also based on UNIX .

> Linux is also based on Unix ( or even similar to it )

## File System

>linux drive structure is not like windows wich starts with c .
>
>it is like a tree , starting with root .
>
>in linux everything is a file , file is file , directory is a file , mouse is file , printer is a file and etc.

------------

#### In Windows programs and system files are stored in `C drive` , in Linux they are installed under the `File System`

-----------------

#### we have two types of files :

General Files : also called Ordinary Files :

- > Contain image , video , program or simply text .
  >
  > **ASCII**  or a **Binary** format .
  >
  > most commonly used files .

Director Files : These files are a warehouse for other file types .

- > Directory file within a directory
  >
  > like Folders found in Windows Operating System .

Another Example :

- > CD Rom in windows `is a directory named` **cdrom**

- > Removables like USB and Disk are also shown as `folders`**again** , in directory named **media**

- > Common programs ( Program Files ) in Windows is the **`bin`** directory .

- > System and Program Files are in **File System**

------------------------------------

## TERMINAL

> use CTRL + ALT + T or go to Dash and type Terminal to open the CLI

> you will be in `username@computername:homeDirectory usertype` wich is like bellow

```xml
username@computername:~$

// ~ means you are in home directory .
// you can give it with "pwd" command , print working directory .

<NOTE>
    DO NOT FORGET THE SPACE AFTER CD ( otherwise you will get error )
    Like "username@computername:~$ CD .." ( means go upwards )
    Like username@computername:~$ "CD /home/username/pictures"
    Like "username@computername:~$ CD /home/username/downloads"
    <NOTE>
        Because You are already in home directory JUST USE BELLOW :
        
        username@computername:~$ pwd
        /home/username
        
        username@computername:~$ CD pictures
        username@computername:~$ cd downloads
    </NOTE>
</NOTE>

// To change the directory type cd /whatever , like cd /bin ( wich goes to where the program file in windows is)
// To go to Root directory type cd /
// to go to home type : cd ~   or  cd /cd~

// if $ is # means you are in terminal as Root user .
```

> everything is files
>
> two types of files : ordinaly , like image , text , ASCII
>
> folders files .

> Usb drive is `media`
>
> C drive is : `File System`
>
> Program Files is : `bin`
>
> drives are in `dev`
>
> CD-ROM is : `cdrom`
>
> :warning:REMEMBER : *They are all shown as folders*

> forward slash `\` in windows is `/` backward slash in `Linux` , when addressing the path .

## Important Linux Commands

```xml
<IMPORTANT>
    <ls>
       ls is used to show the list of files and folders in a directory .
        <note>
            the directories are shown in BLOW , and the Files are Shown in White
        </note>
    </ls>
    <ls -R>
        this command wich has an extra -R shows the files and folder in th    directory , and also in it's subdirectory .
    </ls -R>
    <ls -al>
         this commands shows the list among with very detailed information :
         like :
        <1>
           file type & its access Permission .
        </1>
        <3>
           the name of the owner of the file
        </3>
    </ls -al>
</IMPORTANT>
```

#### :warning: ONE Of the important Commands is the `cat` Command

> it is used specially to deal with the text files .

- Display
- Copy
- Combine
- Create text files

> the `cat`command is used to `display` **Text** files , it can also be used to `copy`, `combine` , .and `create` new text files

```xml
<CAT>
   <Display_File>
         username@computername:~$ cat arash 
   </Display_File>
   <Create_Text>
         username@computername:~$ cat > fileOne
         hello my name is arash samandar
         CTRL + D ( to finish writing )
    </Create_Text>
    <Copy_Text>
        username@computername:~$ cat > fileTwo
        this is my file number Two.
        CTRL + D
    </Copy_Text>
    <Combine_Text>
        username@computername:~$ cat fileOne fileTwo > newFile
    </Combine_Text>
    <Delete_File>
        username@computername:~$ ls // thus getting all the files .
        Desktop Downloads fileOne Music fileTwo
        username@computername:~$ rm fileOne
    </Delete_File>
    <Moving+Files>
        username@computername:~$ mv fileOne /Files // we don't need to use the full path
        the path is /home/username/Files
        // using full path
        username@computername:~$ mv fileOne /home/username/Files
        // you will get an error , you need #Root permission .
        <Using_sudo>
            // to overcome the permission we use "sudo" , it will ask the password
            username@computername:~$ sudo mv myfile /home/username/files
            [sudo] password for username : // you can enter any password for yourself
            // sudo password remains 15 miniuts per terminal .
        </Using_sudo>
        <Change_File_name>
            username@computername:~$ mv test testOne // change test name to testOne .
        </Change_File_name>
    </Moving+Files>
</CAT>
```

------------

## Manipulating Directories

### Creating Directories

```xml
<Creating_Directory>
    username@computername:~$ mkdir /test/music // creates music directory at test folder .
    username@computername:~$ mkdir directoryOne directoryTwo directoryThree // Creates 3 dr
    username@computername:~$ mkdir havij // created directory in your /home/username/havij
</Creating_Directory>
<Remove_Directory>
    username@computername:~$ rmdir mydirectory // make sure there is no subdirectory in it
</Remove_Directory>
<Rename_Directory>
    username@computername:~$ mv directoryOne renamedOne // renames the directory
</Rename_Directory>
```

##### :black_circle:*To get help with any command use `man`* like :

```xml
username@computername:~$ man ls
```

##### :black_circle:*getting the history of your commands using `history`or simply the :arrow_double_up: arro key*

```xml
username@computername:~$ history
```

##### :black_circle:*The Clear Command to clear the terminal *

----------

## Security & Authorization

> There Are Two Levels of Authoriazation :arrow_double_down:

- *Ownership*
- *Permission*

## `chmode` Changing The Permission ( Symbolic mode ) 

![](F:\Programming Notes\Linux\assets\chmod.png)

#### Examples of how to set permission :

- > **First : **we have `3`Group Of Permission .
  >
  > - user
  > - group
  > - all

- > **Second : **
  >
  > - `r`means `read`
  > - `w`means `write`
  > - `x`means `execute`

- >thats why when we use `ls -l`to see the **file list details** we see bellow image
  >
  >:black_nib:the `first - sign` shows it is a file , otherwise you can see `d`is the first letter .
  >
  >There are three parts
  >
  >- first `-`is related to `user`
  >- second `-` is related to `group`
  >- third `-` is related to `other` or `all`
  >- and the first letter is `r read`then `w write` then `x execute` for that group of authentications 

![](F:\Programming Notes\Linux\assets\permissions-1579802690610.png)

#### Example :

```xml
<Change_Permission_For_The_Other_UserGroup>
     arash@home:~$ chmod o=rwx test
</Change_Permission_For_The_Other_UserGroup>
```

![image-20200123215726431](F:\Programming Notes\Linux\assets\image-20200123215726431.png)

> adding an authorize method to a group like bellow :

![image-20200123220620900](F:\Programming Notes\Linux\assets\image-20200123220620900.png)

> removing the permission for the user

![image-20200123220701198](F:\Programming Notes\Linux\assets\image-20200123220701198.png)

> change the file ownership to someone else

![image-20200123220921565](F:\Programming Notes\Linux\assets\image-20200123220921565.png)

> now lets see the commands owner

![image-20200123221015920](F:\Programming Notes\Linux\assets\image-20200123221015920.png)

> in above picture the owner and the writer of the file is root . we can change it buy

``` xml
guru99@computername:~$ sudo chown guru99:guru99 commands . the result would be
```

![image-20200123221418606](F:\Programming Notes\Linux\assets\image-20200123221418606.png)

--------------

--------------------

## See what group you belong by typing the command => `groups`

#### Changing Your Group

![image-20200123221752905](F:\Programming Notes\Linux\assets\image-20200123221752905.png)

```xml
first : username@computername:~$ newgrp cdrom
now we create a test file : username@computername:~$ cat > test
getting the details of this file : username@computername:~$ ls -dl test
```

-------------

### Summary

![image-20200123222054609](F:\Programming Notes\Linux\assets\image-20200123222054609.png)

![image-20200123222159948](F:\Programming Notes\Linux\assets\image-20200123222159948.png)

-----------------------

## Print , E-mail & Install Software On Linux

> you can print with `pr` command . you can see more at the video provided at the top of the page at minites 
>
> 1:05

### Installing Software

> in Linux or Unix , installation files are distributed as packages . mostly with `.xz` extension

![image-20200123223239709](F:\Programming Notes\Linux\assets\image-20200123223239709.png)

#### we can use the `apt` commands like `apt-get` to install or remove softwares .

```xml
sudo apt-get install SoftwareName
```

![image-20200123223428507](F:\Programming Notes\Linux\assets\image-20200123223428507.png)

> the easy and popular way on `Ubuntu` is by usin the `Software packages` , Like Bellow :arrow_double_down:

![image-20200123223622299](F:\Programming Notes\Linux\assets\image-20200123223622299.png)

## Sending Emails

> you will need to install the `package` , `mailx` on Terminal

```xml
samandar@computerName:~$ sudo apt-get install mailx
```

> to send the email look at bellow image .

> :warning:Note that Once your body of your message is done press `CTRL + D`

![image-20200123223958863](F:\Programming Notes\Linux\assets\image-20200123223958863.png) 

## Summary

![image-20200123224350280](F:\Programming Notes\Linux\assets\image-20200123224350280.png)

--------------

## INPUT / OUTPUT

> for example you can put the result of an `ls -al` file to a text file with bellow command

```xml
username@computername:~$ ls -al > mylist
// and then viewing it with
username@computername:~$ cat mylist
```

![image-20200123224946142](F:\Programming Notes\Linux\assets\image-20200123224946142.png)

> **INPUT IS : ** **`>`** and **OUTPUT IS : ** **`<`** , for example sending email with an attached file using `mailx` like bellow

```xml
username@computername:~$ mail -s "News Today" abs@gmail.com < NewsFlash
```

#### :white_flag: Do Remember That in `Linux or Unix` Everything is a File .

![image-20200123225619604](F:\Programming Notes\Linux\assets\image-20200123225619604.png)

### Descriptor

> Every File has an associated Number Called `FD` File Descriptor .

------------

> Thus Whenever we execute a command or any program , `3 files are always Open` like bellow :

![image-20200124211837166](F:\Programming Notes\Linux\assets\image-20200124211837166.png)

> they are in the bellow files

![image-20200124212239186](F:\Programming Notes\Linux\assets\image-20200124212239186.png)

## Error Redirecting to a File

![image-20200124212537455](F:\Programming Notes\Linux\assets\image-20200124212537455.png)

```xml
// above writes the error of the program "telnet" to the "errorfile" , like bellow
.........$~ telnet localhost 2 > errorFile // writes the error to the "errorFile"
.........$~ cat errorFile  // will open the "errorFile" and you can read it .
```

#### How To Search With `find`

```xml
<find>
   ........$~ find . -name 'my*'  // find the file that has the "name" starting with "my" 
</find>

<write_error_to_a_file>
    ........$~ find . -name 'my*' 2> error.log  // now printing it to the terminal bellow
    ........$~ cat error.log
</write_error_to_a_file>

<how_to_list


```

-------------------------------

# Things You Need To Do After Installing Ubuntu

## Updating the system

> if you don't want to hit the wall while installing a program you must first update the ubuntu 

```xml
type "software" and "software update would come up"
```

> or you can use

```
sudo apt update && sudo apt upgrade
```

---------------------

# 10 Basic Commands You Need To Know

## ls

> by typing ls at first , you will see your home directory and files .
>
> so lets see `/etc` , where the linux system's configuration files live
>
> `$ ls /etc`

## hidden files

> hidden files are starting with `.`sign , like `.bash_profile`  .

### Listing hidden files too with

```
$ ls -a
```

## `man` displays manual pages

> if you want information about a command simply use `man ls` for example .
>
> you can use `Enter`to advance One line at a time .
>
> you can go back with `b` key .
>
> `space` for full page .
>
> and finally `q` to exit .

## `cat` concatenates files

```
$ cat <filename>
```

>The `cat` command is important as a basic command because it serves two very important functions: concatenating (merging) files (as the name suggests) and printing the contents of a file to the screen

> For example, you might type the following to display the contents of the system's `passwd` file on the screen:

```markdown
$ cat /etc/passwd  `you can see the password of the system now`
```

> file concatination

```markdown
$ cat fileOne fileTwo > fileOnefileTwo  `copies the two file together to the third one`
```

>For example, to redirect the contents of `grocerylist.txt` and `todo_list.txt` into the `Saturday.txt` file:

```markdown
$ cat grocerylist.txt todo_list.txt > saturdat.txt
```

