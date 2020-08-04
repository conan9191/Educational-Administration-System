$(function(){
	$.ajax({
		type:"GET",
		url:"./../edu_system/system/getUsers",
		dataType:"json",
		success:function(data){
			if(data.errno=="0000"){
				//数据填充
	            var html = template('user-table',data);
	            //插入生成的html
	            $('.system-user').html(html); 
			}
		}
	});

	$("#add-btn").on('click',function(){
		var username = $("#add-username").val().trim(); 
		var password = $("#add-password").val().trim();
		var roleName = $("#add-role").val().trim();

		$.ajax({
			type:"POST",
			url:"./../edu_system/system/addUser",
			dataType:"json",
			data:{
				username:username,
				password:password,
				roleName:roleName,
			},
			success:function(data){
				if(data.errno=="0000"){
					layer.msg("添加成功!");
					setTimeout(function(){
						window.location.reload();
					},1000);
				}
				if(data.errno=="0001"){
					layer.msg("添加失败,请重试");
				}
			}
		});
	});

});	

function delOne(userId){
	$.ajax({
		type:"POST",
		url:"./../edu_system/system/deleteUser",
		dataType:"json",
		data:{
			userId:userId
		},
		success:function(data){
			if(data.errno=="0000"){
				layer.msg("删除成功!");
				setTimeout(function(){
					window.location.reload();
				},1000);
			}

			if(data.errno=="0001"){
				layer.msg("删除失败,请重试!");
			}
		}
	});
}



