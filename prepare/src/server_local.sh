#!/bin/bash
AMOUNT_HOSTS=$1
CONTAINERS_NET=$2

echo -e "\033[35mupdate ansible-server on localhost (${HOSTNAME})\033[30m"

netID=$(docker network ls |grep $CONTAINERS_NET | awk '{print $1}')
patternIP=$(ip addr show | grep "inet.*$CONTAINERS_NET.*" | awk '{print $2}' | cut -d"/" -f1 | sed '$ s/.$//')
n=1
endIP=2   #ip for container starts from 2 (172.20.0.2)
while [[ $n -le ${AMOUNT_HOSTS} ]]
do
  echo "put ssh-key on ${patternIP}$endIP"
  ssh-copy-id ansible@${patternIP}$endIP
  (( n++ ))
  (( endIP++ ))
done 
