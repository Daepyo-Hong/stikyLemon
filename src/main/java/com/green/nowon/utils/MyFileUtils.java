package com.green.nowon.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

public class MyFileUtils {

	public static String fileUpload(MultipartFile gimg, String location) {
		ClassPathResource cpr=new ClassPathResource("static"+location);	
		File folder=null;
		String fileName=null;
		try {
			folder=cpr.getFile();
			String orgName=gimg.getOriginalFilename();
			//아래주석처리 간단하게
			int idx=orgName.lastIndexOf("."); //파일이음중에서 마지막(.)의 인덱스번호
			fileName=orgName.substring(0, idx)
							+"_"+ (System.nanoTime()/100000)
							+orgName.substring(idx); // .+확장자

			/*
			//파일 이름에 쩜 있을 수 있으니까 쩜 기준으로 분리 시켰다가 다시 원본으로 합쳐주는데 
			String[] strs=orgName.split("[.]");
			fileName=strs[0];
			for(int i=1; i<strs.length; i++) {
				String sep=".";
				if(i==strs.length-1) {//마지막쩜(확장자)를 붙이기 전에 랜덤 숫자를 넣어 준다는 뜻
					long temp=System.nanoTime()/1000000;
					sep="_"+temp+".";
				}
				fileName += sep+strs[i];
			}*/
			//예를 들면 => 원본.이름_232874.jpg 이렇게 나올거임
			gimg.transferTo(new File(folder, fileName));
		
			System.out.println("임시폴더에 파일업로드"+location + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String , String> tempfile=new HashMap<>();
		//tempfile.put("location", location);
		tempfile.put("fileName", fileName);
		tempfile.put("url", location+fileName);
		return tempfile;//맵 컬렉션으로 리턴 
		//return location+fileName;
	}
	//디폴트 생성자를 미리 생성해두어 막아둔거임 더이상안생기게
	
	
	private MyFileUtils() {}
}
