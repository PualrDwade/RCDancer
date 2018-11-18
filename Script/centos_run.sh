#!/bin/bash
# @copyright create by PualrDwade on 2018-11-18
# @note: this script file is use to run the RCDancer-FontEnd project using the cenos env

# notice! before you run this script file , please use shell cmd:chmod 777 [filename] to make sure this file is executeable!

echo "RCDancer script file for cenos start..."

# first install the node env for the fond end project
curl -sL https://rpm.nodesource.com/setup_10.x | sudo -E bash -

# install the node env
sudo yum install -y nodejs

# change the directory to the fond-end project 
cd ../RCDancer-FontEnd

#changge the taobao npm registry
npm config set registry https://registry.npm.taobao.org

# use the npm script to install the whole dependences of the vue-project
npm install

# use the vue-cli tools to run the project
npm run serve

# then you can try the UI demo at http://localhost:8080
# if you there is any issue,please try to run this script file again!
