## Installing Lamp

https://www.digitalocean.com/community/tutorials/how-to-install-linux-apache-mysql-php-lamp-stack-on-ubuntu-20-04

> watch the `above link`

## in this chapter we will see , how to install Xampp (Lampp) `&` How to Lunch it using `Terminal`

> Open The Terminal and type bellow command :arrow_down:

```xml
$ sudo /opt/lampp/lampp start
```

:spiral_notepad: **If you get the bellow error you need to install net-tools**

--------------------

:desktop_computer: **Installing `net-tools`**

```
$ sudo apt install net-tools
```

> Remember Too Start `lampp` use `sudo /opt/lampp/lampp start`

## Verify Installation

> :computer: Verify Installation by going to the `http://localhost` or `http://localhost/phpmyadmin`

## Check Services Like `Apache2`

> to check or reload a service run bellow command :
>
> ```
> sudo service mysql restart
> 
> sudo service apache2 stop
> 
> sudo systemctl reload apache2
> 
> sudo systemctl start mysql.service   // or for starting the services
> 
> sudo systemctl status mysql.service | grep "active" // or for seeing the status
> ```
>
> above command would reload the `apache2` service

## IMPORTANT BUG FIX

> if you installed `phpmyadmin` and you couldn't enter the phpmyadmin with your Credentials , do the following :
>
> https://stackoverflow.com/questions/5555328/error-1396-hy000-operation-create-user-failed-for-jacklocalhost

### Changing The User Privileges To Access the `var/www`

> use the Following command :
>
> ```
> sudo chown -R $USER:$USER /var/www
> ```

## Enable Debug for `apache`

> to see debug information for `apache` . user bellow command

```
tail -f /var/log/apache2/error.log
```

### Reconfiguring `PhpMyAdmin`

```
sudo dpkg-reconfigure phpmyadmin
```

### Delete `Phpmyadmin`

```
apt purge phpmyadmin -y
```

--------------------

### changing Permissions

```
chmod 755 -R /var/www/html
```

### Changing `PHP` Version

> to change the default `php` for server use bellow commad :

```
sudo update-alternatives --set php /usr/bin/php7.0
```

> alternatively you may use :

```
sudo update-alternatives --config php
```

## Remove & ReInstall a Service in Ubuntu

```
sudo apt-get --purge remove apache2
sudo apt-get autoremove
sudo apt-get install apache2
sudo /etc/init.d/apache2 restart
```

------------------

---------------

### Path to `html` directory

```
sudo nano /var/www/html/test.php
```

## PHP Extensions

> just run `php --ini`

## php.ini file

> is in `/etc/php/7.4/cli` , just run `php --ini` and then come one folder up , and you should find it there .
