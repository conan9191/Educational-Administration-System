
function saveWordToHtml(){
    var formData = new FormData($( "#uploadPic" )[0]);  
    var ajaxUrl = "./../edu_system/study/uploadProject";
    //alert(ajaxUrl);
    //$('#uploadPic').serialize() 无法序列化二进制文件，这里采用formData上传
    //需要浏览器支持：Chrome 7+、Firefox 4+、IE 10+、Opera 12+、Safari 5+。
    $.ajax({
        type: "POST",
        dataType: "json",
        url: ajaxUrl,
        data:formData,
        async: false,  
        cache: false,  
        contentType: false,  
        processData: false,
        success: function (data) {
        	if(data.errno=="0000"){
				layer.msg("上传成功");
			}
        },
        error: function(data) {
            layer.msg("上传失败");

         }
    });
    return false;
}



    