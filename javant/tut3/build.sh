#!/usr/bin/sh

BUILD_DIR=build
SOURCE_DIR=src
DIST_DIR=dist

#-------------------------------------------------------------------------------------
function CreateIfNotExist {
    DIR_NAME=$1
    if [ ! -d ${DIR_NAME} ]; then
	mkdir ${DIR_NAME}
    fi
}

#-------------------------------------------------------------------------------------
echo "Preparing"
# Create build directory
CreateIfNotExist ${BUILD_DIR}
CreateIfNotExist ${DIST_DIR}

#-------------------------------------------------------------------------------------
echo "Compiling"
# Compile Java code using 'javac' to obtain .class file
javac -d ${BUILD_DIR} ${SOURCE_DIR}/MainApp.java ${SOURCE_DIR}/dakside/UberLibrary.java

#-------------------------------------------------------------------------------------
echo "Creating JAR file"
# Create a executable JAR file
#         JAR filename | entry point=MainApp | Go to build folder | Include all files
# jar cfe dist/tut3.jar  MainApp               -C build             .
jar cfe dist/tut3.jar MainApp -C build .

#-------------------------------------------------------------------------------------
echo "Executing from build directory"
# Execute Java code using 'java' command
java -cp ${BUILD_DIR} MainApp

#-------------------------------------------------------------------------------------
echo "Executing JAR file"
java -jar dist/tut3.jar
