$(function(){
	$.ajax({
		type:"GET",
		url:"./../edu_system/education/getClasses",
		dataType:"json",
		
		success:function(data){
			var html = template('class-table',data);
	        //插入生成的html
	        $('.system-class').html(html); 
		},
		error:function(){
			//不做处理
		}
	});
});

$("#add-btn").on('click',function(){
	var name = $("#add-name").val().trim();
	var centerId = $("#add-centerId").val().trim();
	var schoolYearId = $("#add-schoolYearId").val().trim();
	var professionId = $("#add-professionId").val().trim();
	$.ajax({
		type:"POST",
		url:"./../edu_system/education/addClass",
		dataType:"json",
		data:{
			name:name,
			centerId:centerId,
			schoolYearId:schoolYearId,
			professionId:professionId
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


function delOne(id){
$.ajax({
	type:"POST",
	url:"./../edu_system/education/deleteClass",
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