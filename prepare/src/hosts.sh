#!/bin/bash
echo "start file hosts.sh"
N_HOSTS=$1
CONTAINERS_NET=$2
# PATH_TO_FILE=$(realpath ./src/container-hosts.sh)
PATH_TO_FILE="./src/container-hosts.sh"

n=1
while [ $n -le $N_HOSTS ]
do
  HOSTNAME=host$n
  echo -e "\033[35mupdate ${HOSTNAME}\033[30m"
  docker run -d -it -h $HOSTNAME --network $CONTAINERS_NET -v $PATH_TO_FILE:/installme.sh ubuntu:latest
  ID=$(docker ps -a | head -2 | awk 'NR>1 {print $1}')
  docker exec -i ${ID} /bin/bash ./installme.sh

  let "n=$n + 1"
  # (( n++ )) another variant
done

