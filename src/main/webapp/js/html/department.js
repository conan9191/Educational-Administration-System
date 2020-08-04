$(function(){
	$.ajax({
		type:"GET",
		url:"./../edu_system/organization/getDepartments",
		dataType:"json",
		success:function(data){
			if(data.errno=="0000"){
				//数据填充
	            var html = template('department-table',data);
	            //插入生成的html
	            $('.system-department').html(html); 
			}
		}
	});

	$("#add-btn").on('click',function(){
		var id = $("#add-id").val().trim();
		var name = $("#add-name").val().trim();
		var centerId = $("#add-centerId").val().trim();
		var superiorId = $("#add-superiorId").val().trim();

		$.ajax({
			type:"POST",
			url:"./../edu_system/organization/addDepartment",
			dataType:"json",
			data:{
				id:id,
				name:name,
				centerId:centerId,
				superiorId:superiorId
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


function delOne(id){
	$.ajax({
		type:"POST",
		url:"./../edu_system/organization/deleteDepartment",
		dataType:"json",
		data:{
			id:id
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