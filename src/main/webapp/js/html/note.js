$(function(){
	$.ajax({
		type:"GET",
		url:"./../edu_system/study/getOwnNote",
		dataType:"json",
		success:function(data){
			if(data.errno=="0000"){
				$("#ownNote").text(data.note.content);
			}
		}
	});

	$("#alter-btn").on('click',function(){
		var content = $("#ownNote").val().trim();

		$.ajax({
			type:"POST",
			url:"./../edu_system/study/updateNote",
			dataType:"json",
			data:{
				content:content
			},
			success:function(data){
				if(data.errno=="0000"){
					layer.msg("修改成功!");
					setTimeout(function(){
						window.location.reload();
					},1000);
				}else{
					layer.msg("添加失败,请重试");
				}
			}
			
		});
	});
});