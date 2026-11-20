
# View you .md files :
mdview

# Disk & Partition

> To see disk space :
df -h /

> To see the size of current folder :
du -sh .
du -sh *

# ------------------------------- My Services -----------------------------------

# --------- Run Your Service ---------
sudo IDLE_SECONDS=10 python3 /usr/local/bin/kbd-idle-lock.py
# --------- Check Your Service ---------
systemctl status kbd-idle-lock.Service  AND   journalctl -u kbd-idle-lock.service -f
# ------------ Change Timer -------------
Change the timeout later: edit Environment=IDLE_SECONDS=300 in
/etc/systemd/system/kbd-idle-lock.service
then run
sudo systemctl daemon-reload && sudo systemctl restart kbd-idle-lock.service

# --------------------------------- Tutorial -------------------------------------------
