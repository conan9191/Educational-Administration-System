$(function(){
	$('#add-btn').on('click',function(){
		var leaveType = $('#add-case option:selected').val();
		$.ajax({
		type:"POST",
		url:"./../edu_system/attendance/askForLeave",
		dataType:"json",
		data:{
			leaveType:leaveType
		},
		success:function(data){
			if(data.errno=="0000"){
				layer.msg("上传成功");
			}
		}
	});
	});
});

function savePic(){
    var formData = new FormData($( "#uploadPic" )[0]);  
    var ajaxUrl = "./../edu_system/attendance/uploadPhoto";
    //alert(ajaxUrl);
    //$('#uploadPic').serialize() 无法序列化二进制文件，这里采用formData上传
    //需要浏览器支持：Chrome 7+、Firefox 4+、IE 10+、Opera 12+、Safari 5+。
    $.ajax({
        type: "POST",
        dataType: "json",
        url: ajaxUrl,
        data: formData,
        async: false,  
        cache: false,  
        contentType: false,  
        processData: false,
        success: function (data) {
        	$("#photo").attr("src","./../edu_system/upload/file/"+data.fileName);
        	$("#photo").css("opacity","1");
        },
        error: function(data) {
            
         }
    });
    return false;
}