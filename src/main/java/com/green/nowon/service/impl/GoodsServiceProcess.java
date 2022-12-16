package com.green.nowon.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.green.nowon.domain.dto.goods.GoodsDTO;
import com.green.nowon.domain.dto.goods.GoodsInsertDTO;
import com.green.nowon.domain.entity.GoodsEntity;
import com.green.nowon.domain.entity.GoodsEntityRepository;
import com.green.nowon.domain.entity.GoodsImgEntity;
import com.green.nowon.domain.entity.GoodsImgEntityRepository;
import com.green.nowon.service.GoodsService;
import com.green.nowon.utils.MyFileUtils;

@Service
public class GoodsServiceProcess implements GoodsService{

	

	@Override
	public void save(GoodsInsertDTO dto) {
		
	}

	//스테틱으로접근
		//나뭇잎에있는건 벨류를 통해서 가져올 수 있음
		@Value("${file.location.temp}")//내가지정한경로가 로케이션탬프에 삽입되는거임
		private String locationTemp;
		
		
		@Override
		public Map<String, String> fileTempUpload(MultipartFile gimg) {
			//이렇게 접근하는건 클래스이름으로 접근 
			return MyFileUtils.fileUpload(gimg, locationTemp);//업로드할거 , 업로드할 위치
		}
		
		@Value("${multipart.upload.temp}")
		private String TEMP_PATH;
		
		@Value("${multipart.upload.path}")
		private String GOODS_PATH;
		
		@Autowired
		private GoodsEntityRepository goodsRepository;

		@Override
		public String tempUpload(MultipartFile img) {
			
			return MyFileUtils.fileUpload(img, TEMP_PATH);
		}
		
		//원본이미지+새로운이름까지 저장하는경우
		@Override
		public void save(GoodsInsertDTO dto, MultipartFile[] imgs, String[] newName) {
			GoodsEntity goods=dto.toEntity();
			
			for(int i=0; i<imgs.length; i++) {
				long size=imgs[i].getSize();
				System.out.println("file-size:"+size);
				if(size==0) {
					System.out.println("정상적인 이미지가 아니어서 객체생성하지 않고 패스");
					continue;
				}
				
				// 경로/파일이름--> 파일이름만 추출
				String[] strs=newName[i].split("/");
				GoodsImgEntity imgEntity=MyFileUtils.tempToGoods(imgs[i], strs[strs.length-1], GOODS_PATH);
				//대표이미지인지 체크
				if(i==0)imgEntity.def(true);
				goods.addImg(imgEntity);
			}
			
			GoodsImgEntityRepository.save(goods);
			
		}

		///원본이미지가 저장한경우
		@Override
		public void save(GoodsInsertDTO dto, MultipartFile[] imgs) {
			
			//파일저장: 파일엔티티가 필요, temp->goods
			GoodsEntity goods=dto.toEntity();
			for(int i=0; i<imgs.length; i++) {
				long size=imgs[i].getSize();
				System.out.println("file-size:"+size);
				if(size==0) {
					System.out.println("정상적인 이미지가 아니어서 객체생성하지 않고 패스");
					continue;
				}
				GoodsImgEntity imgEntity=MyFileUtils.tempToGoods(imgs[i], GOODS_PATH);
				//대표이미지인지 체크
				if(i==0)imgEntity.def(true);
				goods.addImg(imgEntity);
			}
			
			
			goodsEntityRepository.save(goods);
			
		}

		//@Transactional : 트랙잭션적용 않하려면 fetch를 즉시로딩으로 하는방법이 있어요
		@Override
		public void findAll(Model model) {
			List<GoodsDTO> result=goodsRepository.findAll().stream()
					.map(GoodsDTO::new).collect(Collectors.toList());
			
			model.addAttribute("list", result);
			
		}

		@Override
		public void detail(long gno, Model model) {
			
			GoodsDetailDTO result=goodsEntityRepository.findById(gno)
					//findById(gno) 결과에서나오 Goods객체가
					//GoodsDetailDTO의 생성자 파라미터로 전달되어 생성된 GoodsDetailDTO객체리 리턴
					.map(GoodsDetailDTO::new)
					.orElseThrow();
			model.addAttribute("detail", result);
			
		}

		

		
}
