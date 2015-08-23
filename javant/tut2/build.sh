#!/usr/bin/sh

echo "Compile Java code using 'javac' to obtai	n .class file"
javac dakside/MainApp.java dakside/common/UberLibrary.java

echo "Execute Java code using 'java' command"
java dakside.MainApp
