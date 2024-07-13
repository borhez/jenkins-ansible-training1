#!/bin/bash
CONTAINERS_NET=$2
let "nSegments=$1 - 2"

echo $nSegments
echo $CONTAINERS_NET
echo -e "\033[35mupdate ansible-server on localhost (${HOSTNAME})\033[30m"

netID=$(docker network ls |grep $CONTAINERS_NET | awk '{print $1}')
patternIP=$(ip addr show | grep "inet.*$netID.*" | awk '{print $2}' | cut -d"/" -f1 | sed '$ s/.$//')

echo -e -n "segments:\n" > ../ansible/hosts.yaml
n=1
endIP=2   #ip for container starts from 2 (172.20.0.2)
while [[ $n -le ${nSegments} ]]
do
  echo "put ssh-key on ${patternIP}$endIP"
  ssh-copy-id ansible@${patternIP}$endIP
  echo -e "\thost$n:\n\t\tip: ${patternIP}$endIP\n" >> ../ansible/hosts.yaml
  (( n++ ))
  (( endIP++ ))
done

  echo "put ssh-key on Master ${patternIP}$endIP"
  ssh-copy-id ansible@${patternIP}$endIP
  echo -e "\nmaster:\n\thost$n:\n\t\tip: ${patternIP}$endIP\n" >> ../ansible/hosts.yaml
  
  (( n++ ))
  (( endIP++ ))

  echo "put ssh-key on Standby ${patternIP}$endIP"
  ssh-copy-id ansible@${patternIP}$endIP
  echo -e -n "\nstandbymaster:\n\thost$n:\n\t\tip: ${patternIP}$endIP\n" >> ../ansible/hosts.yaml

