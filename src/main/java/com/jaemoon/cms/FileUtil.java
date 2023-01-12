package com.jaemoon.cms;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileUtil {


	  private static String vuePath;
	  private static String uploadPath;
	  
	  @Value("${path.vue}")
	  private void setVuePath(String path) {
	    this.vuePath = path;
	  }
	  @Value("${path.upload}")
	  private void setUploadPath(String path) {
		  this.uploadPath = path;
	  }

	  
	private static String mkdir(String fileFolder) {
	      File outFile = new File(fileFolder);
	      if (!outFile.exists())
	          outFile.mkdirs();
	      
	      return fileFolder;
	    }

	
	private static void writeFile(String pathStr, String file, String str) {
		try {
			mkdir(pathStr);
			Path path = Paths.get(pathStr + File.separator + file);
		    Files.write(path, str.getBytes());
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

	public static void uploadFile(String pathStr, String file, String str) {
		writeFile( uploadPath +  File.separator + pathStr  , file, str);
	}
	
	public static void writeVue(String pathStr, String file, String str) {
		if( ! file.contains(".vue") ) file +=".vue";
		writeFile( vuePath +  File.separator + pathStr  , file, str);
	}
}
