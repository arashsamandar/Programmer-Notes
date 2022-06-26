## Mail

> you have changed the `.env` file for send email with gmail

> you have changed `mail.php`  for sending with gmail.

> add these in `.env` after mail options

```
'default' => env('MAIL_MAILER', 'smtp'), //and more in your mail.php
//  also check the .env file .
```





## server options

> you have changed the name in /etc/hostname and /etc/hosts | to `arash`

```markdown
sudo nano /etc/hostname
sudo nano /etc/hosts
> Exit & SaveChanges with > CTRL + X   and then   press y and enter
```