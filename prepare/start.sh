#!/bin/bash

if [[ $# -ne 1 ]]
  then echo "Need one argument: amount of nodes which will be managed by ansible-server on localhost"
  exit 0
fi
REGEXPR="^[0-9]+$"
if [[ ! $1 =~ $REGEXPR ]]
  then echo "Argument must be a number"
  exit 0
fi

CONTAINERS_NET=tokens1
docker network create $CONTAINERS_NET
./src/hosts.sh $1 $CONTAINERS_NET
./src/server_local.sh $1 $CONTAINERS_NET

echo -e "\033[35mFINISH SUCCESS\033[30m"

