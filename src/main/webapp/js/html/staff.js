$(function(){
	$.ajax({
		type:"GET",
		url:"./../edu_system/hr/getStaffs",
		dataType:"json",
		success:function(data){
			if(data.errno=="0000"){
				//数据填充
	            var html = template('staff-table',data);
	            //插入生成的html
	            $('.system-staff').html(html); 
			}
		}
	});

	$("#add-btn").on('click',function(){
		var id = $("#add-id").val().trim();
		var userId = $("#add-userId").val().trim(); 
		var name = $("#add-name").val().trim();
		var positionId = $("#add-positionId").val().trim();
		var departmentId = $("#add-departmentId").val().trim();

		$.ajax({
			type:"POST",
			url:"./../edu_system/hr/addStaff",
			dataType:"json",
			data:{
				id:id,
				userId:userId,
				name:name,
				positionId:positionId,
				departmentId:departmentId
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

function alterOne(){
	var id = $("#alter-id").val().trim();
	var userId = $("#alter-userId").val().trim(); 
	var name = $("#alter-name").val().trim();
	var positionId = $("#alter-positionId").val().trim();
	var departmentId = $("#alter-departmentId").val().trim();

	$.ajax({
		type:"POST",
		url:"./../edu_system/hr/updateStaff",
		dataType:"json",
		data:{
			id:id,
			userId:userId,
			name:name,
			positionId:positionId,
			departmentId:departmentId
		},
		success:function(data){
			if(data.errno=="0000"){
				layer.msg("修改成功!");
				setTimeout(function(){
					window.location.reload();
				},1000);
			}
			if(data.errno=="0001"){
				layer.msg("修改失败,请重试");
			}
		}
	});
}

function delOne(id){
	$.ajax({
		type:"POST",
		url:"./../edu_system/hr/deleteStaff",
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

function findOne(id){
	$.ajax({
		type:"GET",
		url:"./../edu_system/hr/getOneStaff",
		dataType:"json",
		data:{
			id:id
		},
		success:function(data){
			if(data.errno=="0000"){
				//数据填充
	            var html = template('alter-table',data);
	            //插入生成的html
	            $('.alter-form').html(html); 
	            $('#alterStaff').modal('show');
			}
		}
	});
}

