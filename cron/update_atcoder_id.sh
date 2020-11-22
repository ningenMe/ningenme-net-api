#!/bin/bash
res=`curl -X POST -d "email=${email}" -d "password=${password}" --dump-header - https://api.ningenme.net/v1/login | grep x-amzn-remapped-authorization:`
header=`echo $res | awk -F : '{print $2}'`

header="\"authorization: "${header}\"
header=`echo $header | sed "s/\r//g"`
host="https://api.ningenme.net/v1/compro/sites/AtCoder/users/id"
curl="curl -X PUT -H ${header} $host"
eval ${curl}