package com.sprunk.projects.musicapplication.filereading;

import java.io.File;
import java.io.FilenameFilter;

public class Filter implements FilenameFilter {
    static final String FILE_FORMAT = ".mp3";    
    
    private String musicTitle; 

    public Filter(String musicTitle) {
        this.musicTitle = musicTitle;
    }

    @Override
    public boolean accept(File directoryPath, String name) {
        if (name.endsWith(musicTitle + FILE_FORMAT)) {
            return true;
        } else {
            return false;
        }    
    }
}