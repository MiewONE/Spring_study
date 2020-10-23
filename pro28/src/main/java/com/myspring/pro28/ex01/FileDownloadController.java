package com.myspring.pro28.ex01;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@Controller
public class FileDownloadController 
{
	private static String CURR_IMAGE_REPO_PATH="c:\\spring\\image_repo";
	
	@RequestMapping("/download")
	public void download(@RequestParam("imageFileName") String imageFileName,HttpServletResponse res) throws Exception 
	{
		OutputStream out = res.getOutputStream();
		String downFile = CURR_IMAGE_REPO_PATH+"\\"+imageFileName;
		File file = new File(downFile);
		
		res.setHeader("Cache-Control", "no-cache");
		res.addHeader("Content-disposition", "attachment; fileName="+imageFileName);
		FileInputStream in = new FileInputStream(file);
		byte[] buffer = new byte[1024*8];
		while(true)
		{
			int cnt = in.read(buffer);
			if(cnt == -1) break;
			out.write(buffer,0,cnt);
		}
		in.close();
		out.close();
	}
}
