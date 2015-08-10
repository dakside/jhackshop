#!/usr/bin/sh

echo "Clean temp files"
rm -f *.java~ *.sh~

echo "Clean build folder"
rm -rf ./build/
rm -rf ./dist/
