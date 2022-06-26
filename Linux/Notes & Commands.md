[TOC]

# Ubuntu Notes & Commands

> if you want to reset your settings , like display , language and others to the default , use the bellow command

```markdown
dconf reset -f /
```

> :black_flag: to change desktop & lock screen wallpapers you should put your images in the picture folder .

-------

> :black_flag: a `famous command` to install packages and applications 

```
sudo apt-get package_name install
```

> :black_flag: to remove a package or app from the linux use the bellow command

```
sudo apt-get remove package_name
```

> :black_flag: to remove an application and all its dependencies use bellow command

```
sudo apt-get remove --auto-remove package_name
```

------------

## To Set PATH on Linux

- 1 ) change to your home directory. `cd $home`
- 2 ) open the `.bashrc` file .
- add the following line ( for example for java ) Replace the JDK directory with the name of your java installation directory . and add the bellow line to the `.bashrc` file
- 3 ) export `PATH=/usr/java/<JDK Directory>/bin:$PATH`
- now save the file and exit
- Use the source command to force Linux to reload the `.bashrc` file which normally is read only when you log in each time.
- 4 ) `source .bashrc`

------------------------------

## Linux Programms Installers's File Types

> there is `xz` & `gz`

> we also have `.tar.bz2` & `.tar.gz` , two install these two types . 

## definition & installation of `tar` `tar.gz` & `tar.bz2`

> You cannot "install" a `.tar.gz` file or `.tar.bz2` file. `.tar.gz` files are gzip-compressed tarballs, compressed archives like `.zip` files. .bz2 files are compressed with bzip2. You can extract `.tar.gz` files using:

:arrow_forward: *you can `unzip` these files by using the following commands*

:arrow_forward: *`tar xzf` is for `tar.gz` & `tar xjf` is for `tar.bz2`*

```markdown
`unwrapp it with :`
tar -zxvf jdk-8u241-linux-i586.tar.gz
`OR`
tar xzf your_file.tar.gz
`OR`
tar xjf your_file.tar.bz2
`For tar Only`
tar xf yourfile
`and install with`
xdg-open yourfile
```



- > The `first thing` you need to do is `extract the files from inside the tar archive` to a folder

- > Now you need to open your `Terminal` and navigate to that directory using bellow command

- > cd /home/username/Desktop/my_program-1.2.3

- > make sure you read the file `INSTALL`,`INSTALL.txt` or something similar like `ReadMe` if it does exist , you can check for such files by using the `ls` command .

- > now the install file can be read & opened by using the `xdg-open yourfile` 

- > this file contain the right steps to follow to continue the installation proccess .

> usually the three `classical steps` are :

```
./configure
make
sudo make install
```

> You may also need to install some dependencies if, for example, running `configure` prompted you with an error listing which dependencies you are missing.

:eight_pointed_black_star:*Remember that your mileage may vary*

> i Recommend using `sudo check install` as `sudo make install` , as the `check install` makes `Uninstalling` the application much easier .

:eight_pointed_black_star: see the description of this command in the file `Tutorial_For_Begginer` next to this file .

:arrow_forward: **OR** *use bellow command to change access and run the file at the same time .*

```
chmod 755 xampp-linux-x64-7.2.10-0-installer.run
```

## How to execute `.run` file ?

> you can execute this type of file by :
>
> - first :‌changing the access mode of the file and make it executable by using the bellow command :
> - ‍‍‍`chmod +x yourfile.run` **OR** `chmod 755 yourFile.run` **Now** `sudo ./yourfile.run`
> - then run it with bellow command

```
// assume your file is in the desktop
$ cd ~/desktop
$ sudo chmod +x yourfile.run
$ sudo ./xampp_for_linux.run
```

## Getting a Program `.db` using it's Address

- > Step One : First go to the Directory `cd /tmp`

- > Second : use the Command `wget` like bellow :

```
wget http://the_address/address/programname.db
```

-------------------------------

## Unistall Applications

### you have two ways to do so

- > Using the Ubuntu software

- > Using the Command Line (Terminal)

#### :arrow_forward: Using the Ubuntu software is easy & you know it .

> **Go to the Ubuntu Software from which you will click on the `installed` Tab**

#### :arrow_forward: Using the Terminal

> **Typing the `dpkg --list` would give you a list of your programs**

```
sudo dpkg --list
// and you would get the list of your programs
```

> **in the list you get with the `dpkg --list` Remember the name of the program you want to delete**

> **`Purge`command :  now we use the `purge` and `remove` or `rm` commands like bellow**

```
sudo apt-get --purge remove yourProgram
```



#### Deleting With Purge Command

> you can delete your installed app with the `purge` command , like bellow :

```
sudo apt-get purge google-chrome-stable
// and to remove it's ( configs or dependencies ) completely
rm ~/.config/google chrome/ -rf
```

## Finding where the App is installed

> you can find where your application is installed by using `whereis` command
>
> or you can use ( de package query ) `dpkg-query -l progral` like bellow examples

```
whereis firefox
// or
dpkg-query -l firefox
```





## installing `.sh` or `Shell Script` files

> you need only to run `bash` as administrator , like bellow

```
sudo bash myfile.sh
```

----------------------------------------

## :white_check_mark: Important :‌ How to see your PATH

> see the bellow link

> https://www.wikihow.com/Set-Up-Your-Java_Home-Path-in-Ubuntu

## Run PhpStorm 2019

> i have added `PhpStorm` to the `PATH` , so you can run it with `sudo pstorm`
>
> also you can go to `PATH` with `sudo su` and then provide the password .

## Check java installation

> check java installation with `java -version`

## Running `.jar` java files

> you can run .jar files with the bellow command .

```
java -jar Minecraft.jar
```

## Copying Files With cp

> if you want to copy a file to a directory , simply use the `cp` command , or `sudo cp file.jar  /home/arash/picuters`

```
sudo cp myjava.jar /home/arash/pictures
```

-----------------------

## chmod ( change the access mode of a file )

> you can change by using `number` or `r` , `w` , `x` .

```
$ chmod 755 [package name]
```

:musical_note:*xampp would be installed in /opt/lampp*

## :file_folder: How To Open `root` folders from the terminal with `nautilus`

> `nautilus` : what an excelent command .

> :jack_o_lantern: For Example : **To Open The Location Of One Of Your Applications**
>
> First get it with `whereis` command , then `sudo nautilus /usr/bin/typora` , and you are there :slightly_smiling_face:

### :file_folder: How to go to `home` Directories

> Using `~`you can always direct between home directories , like `cd ~/desktop` which goes to your desktop

```
$ cd ~/pictures
$ cd ~/downloads
```

## Creating a Partition for `/home` directory .

> if you define a partition for your `/home` directory , if you loose the `Ubuntu OS` , your file wouldn't loose

> BUT you need to do some work if you want to install the Ubuntu again . :arrow_down:

https://www.howtogeek.com/116742/how-to-create-a-separate-home-partition-after-installing-ubuntu/

# Setting Environment Variables

> :computer: you can use two options

- using `sudo nano /etc/environments`
- Better use the `export`command , like bellow

:computer_mouse: *this Example is for setting the JDK Java environment variable*

:star: **If you use `echo $JAVA_HOME`and you get nothing it means you need to set it up like bellow**

- Step One

```
sudo apt install openjdk-8-jdk
```

- Step Two ( Set Java_home Path )

```
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64

```

- Step Three to make sure its set use : `echo $JAVA_HOME`
- Step Four : Add JAVA bin directory to the PATH variable

```
export PATH=$PATH:$JAVA_HOME/bin
```

- Step Five ( Test JAVA setup )

```
java -version
```

:star: **You can use Bellow to Update the values in environment**

```
$ cd /etc
$ source environment
```

## Install `Shortcuts`For your application

> first you need to install `gnome-panel`, with bellow command :arrow_down:

```xml
sudo apt-get install --no-install-recommentds gnome-panel
```

> After installing `gnome-panel`, use following command to create a launcher.

```
gnome-desktop-item-edit --create-new ~/Desktop
```

![](/home/arash/Downloads/havij_faliur.png)

> - In **Type field** "Application" will be a default value. If you're creating launcher for application which has no gui, that runs in terminal like VIM editor then you need to select "Application in Terminal".
> - In **Name field** type application name.
> - In **Command field** type the executable command which open your application.
> - **Comment field** is optional.

# Changing PHP Version

> take a look bellow maybe help

https://www.ostechnix.com/how-to-switch-between-multiple-php-versions-in-ubuntu/

> :star: **Install php 7 with the bellow command**

```
$ sudo apt install python-software-properties
$ sudo add-apt-repository ppa:ondrej/php
$ sudo apt install php7.0
```

> you can change apache version but try to do only the last line

```
$ sudo a2dismod php7.2$ a2enmod php7.0
$ sudo service apache2 restart
$ sudo update-alternatives --set php /usr/bin/php7.2
```

> now you can use `PATH=$PATH:/usr/bin`to change the `php`version

> :ear: To Stop the `apache2`run the bellow command .
>
> Your Mysql will return with bellow command .

```
sudo service apache2 stop
```

## `apache2` folder & `where its installed`

> your appache2 is installed in `/etc/php/7.0/apache2`

> so if you want to edit the `php.ini` go to above folder edit it and uncomment the 

https://stackoverflow.com/questions/31206186/call-to-undefined-function-simplexml-load-string/35820787