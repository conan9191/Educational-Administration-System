$(function(){
	$('#find-btn').on('click',function(){
		var studentNo = $('#find-studentNo').val().trim();
		var courseName = $('#find-courseName').val().trim();

		$.ajax({
			type:"GET",
			url:"./../edu_system/grade/getOneGrade",
			dataType:"json",
			data:{
				studentNo:studentNo,
				courseName:courseName
			},
			success:function(data){
				if(data.errno=="0000"){
					layer.msg("查询成功!");
					var html = template('output-table',data);
		            //插入生成的html
		            $('.system-output').html(html); 
				}else{
					layer.msg("查询失败");

				}
				
			},
			error:function(data){
				layer.msg("服务器错误请重试!");
			}
		});
	});

});