#!/usr/bin/sh

# Compile source code & build executable file
ant build

# Run application
java -jar dist/dakalgo.jar
