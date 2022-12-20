var idx=1;
$(document).ready(function() {
    $('#summernote').summernote();
});
function gimgChanged(el){
    var fileData = $(el)[0].files[0];
    console.log(fileData);

    var formData = new FormData();
    formData.append('gimg',fileData);

    $.ajax({

        url:"/admin/temp-upload",
        type:"post",
        data:formData,
        contentType:false,
        processData:false,
        success:function (map){//서버에 업로드 성공시에 url주소를 받아서처리
            console.log(map);

            $(el).siblings(".img").css("background-image", "url("+map.url+")");
            $(el).siblings(".newName").val(map.fileName);
            //대표이미지 와 추가이미지 구분
            if($(el).prop("id")=="defimg") return; //대표이미지 처리는 여기서끝
            //추가이미지인경우 처리
            if(idx < 3)addTag();
        }
    });
}


function addTag() {
    // class="addimg" 인 모든 태그 (복수형)
    var addimgs = $(".addimg")

    var tag=	//자바스크립트 백틱 이용하여 변수적용 가능합니다~
        `
					<div class="addimg">
						<label class="img" for="addimg_${idx}">+</label>
						<input id="addimg_${idx}" class="gimg" type="file" name="gimg" onchange="gimgChanged(this)">
						<input type="hidden" class="newName" name="newName">
					</div>
					`;

    addimgs.last().after(tag);
    idx++;
}