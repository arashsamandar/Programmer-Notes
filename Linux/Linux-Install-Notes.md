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
