#!/usr/bin/sh

echo "Clean temp files"
rm -f *.java~ *.sh~

echo "Clean class files"
rm -f ./*.class dakside/*.class
