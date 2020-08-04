$(function(){
	$('#add-btn').on('click',function(){
		var studentNo = $('#add-studentNo').val().trim();
		var courseName = $('#add-courseName').val().trim();
		var grade = $('#add-grade').val().trim();

		$.ajax({
			type:"POST",
			url:"./../edu_system/grade/addGrade",
			dataType:"json",
			data:{
				studentNo:studentNo,
				courseName:courseName,
				grade:grade
			},
			success:function(data){
				if(data.errno=="0000"){
					//录入成功
					layer.msg("成绩录入成功");
					setTimeout(function(){
						window.location.reload();
					},2000);
				}else{
					//注册失败
					layer.msg("成绩录入失败");
				}
				
			},
			error:function(data){
				layer.msg("服务器错误请重试!");
			}
		});
	});

});