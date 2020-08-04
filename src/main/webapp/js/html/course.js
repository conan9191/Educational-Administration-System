$(function(){
	$.ajax({
		type:"GET",
		url:"./../edu_system/education/getCourses",
		dataType:"json",
		success:function(data){
			var html = template('course-table',data);
	        //插入生成的html
	        $('.system-course').html(html); 
		},
		error:function(){
			//不做处理
		}
	});
});

$("#add-btn").on('click',function(){
	var name = $("#add-name").val().trim();
	var courseHour = $("#add-courseHour").val().trim();
	var courseFile = $("#add-courseFile").val().trim();
	var proportion = $("#add-proportion").val().trim();
	var courseTypeId = $("#add-courseTypeId").val().trim();
	$.ajax({
		type:"POST",
		url:"./../edu_system/education/addCourse",
		dataType:"json",
		data:{
			name:name,
			courseHour:courseHour,
			courseFile:courseFile,
			proportion:proportion,
			courseTypeId:courseTypeId
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
	url:"./../edu_system/education/deleteCourse",
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