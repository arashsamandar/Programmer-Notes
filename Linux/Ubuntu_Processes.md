
# Processes

> get all process ids by that match a name
pgrep chrome

> see all its processes with their used RAM
pgrep chrome | xargs -r ps -o rss=,comm= --sort=-rss -p | awk '{printf "%8.2f MB  %s\n", $1/1024, $2}'

> see all and every process on system
ps -e

> with options
ps -eo pid,ppid,rss,comm

> inspect one process
ps -o pid,ppid,rss,vsz,comm -p 43030

> who is the parent of the process id ppid
ps -o ppid -p 43031

> what are all children of PID 43030
ps --ppid 43030 -o pid,rss,vsz,comm

# Group related Processes
> Even if a child process loses its parent (PPID), it almost always stays in the same Process Group ID (PGID)

> First find the Groput that your process belongs too
ps -eo pid,pgid,ppid,rss,comm | grep nvim

> List every process in that group
ps -g 62313 -o pid,rss,vsz,comm,args --sort=-rss

> Get total ram of the entire group
ps -g 62312 -o rss= | awk '{sum+=$1} END {printf "Total RAM: %.2f MB\n", sum/1024}'

# Most reliable ( use system groups )
systemd-cgls | grep -B 2 -A 15 "nvim"

> Check the cgroup total memory used ( most reliable ), When you find yours , then get memory for .scope or .service
systemctl --user status <scope-name>.scope

# Tree and Forest

> full anccestory of a process
pstree -sp 43031

> Example of using --forest :
ps -eo rss,comm --forest | grep -A3 -B3 nvim

# --------------------

> kill a process by name :
pkill

> kill a process by PID :
kill

> kill a process that is running on a port :
sudo fuser -k 3000/tcp

