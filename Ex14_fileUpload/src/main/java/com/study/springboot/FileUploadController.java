package com.study.springboot;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

@Controller
public class FileUploadController {
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@RequestMapping("fileUpLoad")
	public @ResponseBody String fileUpLoad(HttpServletRequest request) {
		String result = "";
		JSONObject jObj = new JSONObject();
		try {
			String filePath = ResourceUtils.getFile("classpath:static/upload/").toPath().toString();
			
			List<Part> fileParts = request.getParts()
										  .stream()
										  .filter(part -> "files".equals(part.getName()) && part.getSize() > 0)
										  .collect(Collectors.toList());	// 읽은 파일을 리스트화 시킴
			
			// 파일이 여러개일 때
			for(Part filePart : fileParts) {
				// 파일 명칭 얻어오기
				String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
				String fpn = filePath + "//" + fileName;
				
				try(BufferedInputStream fin = new BufferedInputStream(filePart.getInputStream());
				BufferedOutputStream fout = new BufferedOutputStream(new FileOutputStream(fpn))){
					int data;
					while(true) {
						data = fin.read();
						if(data == -1)
							break;
						fout.write(data);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("Upload fileName : " + fpn);
			}
//			jObj.put("Success", "OK");
//			jObj.put("Filename", fpn);
			result = "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "fail";
		}
		return result;
	}
}
