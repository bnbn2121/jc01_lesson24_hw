package com.edu.less17.institute.util;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import com.edu.less17.institute.model.TrainingCourse;

public class CourseWriter {
	
	public void writeToFile(TrainingCourse course, String path) throws IOException{
	    try (
	    	BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)))) {
	        bWriter.write(CourseParser.getStringData(course));
	    } catch (FileNotFoundException e) {
	        throw e;
	    } catch (IOException e) {
	        throw new IOException("Failed to write data to file: " + e.getMessage(), e);
	    }
	}
	
	public void writeToFile(List<TrainingCourse> courses, String path) throws IOException{
	    try (
	    	BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)))) {
	        for(TrainingCourse course:courses) {
	        	bWriter.write(CourseParser.getStringData(course));
	        }
	    } catch (IOException e) {
	        throw e;
	    }
	}
}
