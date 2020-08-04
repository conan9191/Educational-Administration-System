$(function(){
	$.ajax({
		type:"GET",
		url:"./../edu_system/education/getSemesters",
		dataType:"json",
		success:function(data){
			var html = template('semester-table',data);
	        //插入生成的html
	        $('.system-semester').html(html); 
		},
		error:function(){
			//不做处理
		}
	});
});

$("#add-btn").on('click',function(){
	var schoolYearId = $("#add-schoolYearId").val().trim();
	var trainingType = $("#add-trainingType").val().trim();
	var name = $("#add-name").val().trim();
	$.ajax({
		type:"POST",
		url:"./../edu_system/education/addSemester",
		dataType:"json",
		data:{
			schoolYearId:schoolYearId,
			trainingType:trainingType,
			name:name,
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
	url:"./../edu_system/education/deleteSemester",
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