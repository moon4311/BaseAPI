package com.jaemoon.base.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.jaemoon.cmm.model.AttachFile;

@Component
public class FileUtil {


	  private static String vuePath;
	  private static String mapperPath;
	  private static String uploadPath;
	  
	  @Value("${path.vue}")
	  private void setVuePath(String path) {
	    this.vuePath = path;
	  }
	  @Value("${path.mapper}")
	  private void setMapperPath(String path) {
		  this.mapperPath= path;
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

	public static void uploadFile(AttachFile dto , MultipartFile file ) {
		try {
			//폴더 생성
			String pathStr = uploadPath +  File.separator + dto.getFolderNm() ;
			mkdir(pathStr);
			
			//파일 생성
			String fileNm = makeFileName(dto.getFileExt());
			dto.setFileNm(fileNm);
			File upload = new File( pathStr + File.separator + fileNm);
			file.transferTo(upload);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static String makeFileName(String ext) {
		SimpleDateFormat sdf = new SimpleDateFormat();
//		sdf.setCalendar(Calendar.getInstance());
		sdf.applyPattern("yMMddhhmmsss");
		return String.format("%s.%s", sdf.format(Calendar.getInstance().getTime()), ext);
	}
	
	public static void writeVue(String pathStr, String file, String str) {
		if( ! file.contains(".vue") ) file +=".vue";
		writeFile( vuePath +  File.separator + pathStr  , file, str);
	}
	
	public static void writeMapper(String pathStr, String file, String str) {
		if( ! file.contains(".xml") ) file +=".xml";
		writeFile( mapperPath +  File.separator + pathStr  , file, str);
	}
}
