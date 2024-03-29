[TOC]



## Fixing `phpmyadmin` error & bug

In the new MySQL client, if the password is left empty while installing then, it is based on the `auth_socket` plugin.

The correct way is to log in to MySQL with the `sudo` privilege.

```none
sudo mysql -u root -p
```

And then updating the password using:

```none
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'new-password';
```

Once this is done, *stop and start* the MySQL server.

```none
sudo service mysql stop
sudo service mysql start
```

For complete details, you can refer to [this link](https://www.percona.com/blog/2016/03/16/change-user-password-in-mysql-5-7-with-plugin-auth_socket/).

> more at bellow address :
>
> https://stackoverflow.com/questions/39281594/error-1698-28000-access-denied-for-user-rootlocalhost?noredirect=1&lq=1

## NOTE : Removing an application

> some times there is an older version of the app which is conflicting with the new one you are trying to install

> in that case use bellow command to `remove` the older version and install the new one

```
> sudo apt remove libcurl4
> sudo apt install curl
```

### NOTE : To install `Nvidia` Driver use bellow Commands ;

```
sudo add-apt-repository ppa:kelebek333/nvidia-legacy
sudo apt-get update
sudo apt install nvidia-340 xorg-modulepath-fix 
```

> also for seeing the installed drivers use :
>
> ```
> ubuntu-drivers devices
> // you can also use :
> sudo lshw -c display
> // remove Nvidia Drivers with
> sudo apt-get remove --purge nvidia-*
> // also remove ppa
> sudo apt-get install ppa-purge
> ```

> if above command didn't work use try bellow install command

```
sudo apt-get install nvidia-340

sudo apt install nvidia-340
```

### Change the Keyboard Layout `Farsi & English`

> to change the keyboard use `Win + Space`

### Extract a `tar.gz` file :

> to extract a tar file run
>
> ```
> tar xzvf file.tar.gz
> ```

### in `/etc/hosts` you can delete

> everything after `1.2.3.4 bs.studycoder.com`

> you can delete everything after it.

----------

-------------------

### Changing `PHP` version in ubuntu

> to show the version simply type :
>
> ```
> sudo apt show php
> // or
> sudo apt show php -a
> ```

> more at bellow address :
>
> https://www.tecmint.com/install-different-php-versions-in-ubuntu/

### Changing permission in ubuntu

> Remember : changin `ownership` with `chown` , changing the permission with `chmod`
>
> you can pass the permission to user , using bellow code :
>
> ```
> sudo chown -R $USER:$USER /var/www/     // changing the ownership
> ```

> Assign execute permission with :
>
> ```
> sudo chmod +X /usr/local/bin/composer   // changing the permission
> ```

> change the owner ship with :
>
> ```
> sudo chown -R www-data:www-data /var/www/html/laravelapp
> ```
>
> change the permission with :
>
> ```
> sudo chmod -R 775 /var/www/html/laravelapp/storage
> ```

### Find the Location of a Package

> run bellow commad :
>
> ```
> which "npm"
> ```

### Getting `Permission Denied`

> if you get permission error when running `npm start` 
>
> then `Delete` the `node_modules` folder and run bellow command :
>
> ```
> npm install react-scripts --save
> ```
>
> after this you can run with :
>
> ```
> npm start
> ```

## Important Note

## Processes Using BandWith

> using nethogs
>
> ```
> sudo apt-get install nethogs
> ```
>
> and then
>
> ```
> nethogs
> ```
>
> you can find out which pricesses are using the network and then kill them

# NOTE

> i have stopped the snapd from this address :
>
> https://askubuntu.com/questions/1045542/how-to-stop-snapd-from-auto-updating
>
> visit it and you can return it `snapd` to normal .
>
> i have also unchecked the update of the system from `daily` to `never`
