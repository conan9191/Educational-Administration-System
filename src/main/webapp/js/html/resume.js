
$("#preViewResume").css("opacity","0");
    function saveWordToHtml(){
        var formData = new FormData($( "#uploadPic" )[0]);  
        var ajaxUrl = "./../edu_system/offer/uploadResume";
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
            	
            	$("#preViewResume").attr("href","./../edu_system/upload/file/"+data.fileName);
            	$("#preViewResume").css("opacity","1");
            },
            error: function(data) {
                

             }
        });
        return false;
    }


    