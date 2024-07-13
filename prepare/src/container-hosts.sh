#!/bin/bash
apt update
echo -e "\033[35minstall openssh-server\033[30m"
apt install openssh-server -y
service ssh start

echo -e "\033[35madduser ansible:\033[30m"
adduser ansible

