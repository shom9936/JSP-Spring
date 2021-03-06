package com.ex.tiles.ex01;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FileDownloadController2 {
	private static String CURR_IMAGE_REPO_PATH ="c:\\spring\\image_repo";
	
	@RequestMapping("/download2")
	public void download(@RequestParam("imageFileName") String imageFilename, HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String downFile = CURR_IMAGE_REPO_PATH + "\\" + imageFilename;
		File file = new File(downFile);
		
		response.setHeader("Cache-Control" , "no-cache");
		response.addHeader("Content-disposition", "attachment; filename=" + imageFilename);
		FileInputStream in = new FileInputStream(file);
		
		byte[] buffer = new byte[1024 * 8];
		while(true) {
			int count = in.read(buffer);
			if(count == -1) break;
			out.write(buffer, 0, count);
		}
		
		in.close();
		out.close();
	}
}
