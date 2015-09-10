#!/usr/bin/sh

# Compile source code & build executable file
ant build

# Define classpath
# CLASSPATH=
# for i in `ls dist/lib/*.jar`
# do
  # CLASSPATH=${CLASSPATH}:${i}
# done

# Run application
java -jar dist/algodemo.jar
