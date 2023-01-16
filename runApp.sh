#!/bin/bash
echo "Music-Applivation"
mkdir -p bin

javac `find src -name *.java` -d bin && java -cp bin com.sprunk.projects.musicapplication.Main
