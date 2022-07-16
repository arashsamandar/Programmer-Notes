run > sudo lshw -c display


// and in the bellow look that driver=nouveau

sudo apt-get install nvidia-340

sudo apt install nvidia-340

510
then
440 added


*-display
                description: VGA compatible controller
                product: G96C [GeForce 9500 GT]
                vendor: NVIDIA Corporation
                physical id: 0
                bus info: pci@0000:01:00.0
                logical name: /dev/fb0
                version: a1
                width: 64 bits
                clock: 33MHz
                capabilities: pm msi pciexpress vga_controller bus_master cap_list rom fb
                configuration: depth=32 driver=nouveau latency=0 resolution=1920,1080
                
//--------------------------------- one near Solution ---------------------------

bellow commands whould change your device driver to nvidia

sudo add-apt-repository ppa:kelebek333/nvidia-legacy
sudo apt-get update
sudo apt install nvidia-340 xorg-modulepath-fix 
