$(function(){
	$.ajax({
		type:"GET",
		url:"./../edu_system/student/getStudents",
		dataType:"json",
		success:function(data){
			if(data.errno=="0000"){
				//数据填充
	            var html = template('studentInfo-table',data);
	            //插入生成的html
	            $('.system-studentInfo').html(html); 

	            for(var i=0;i<data.studentList.length; i++){
	            	var birthDate = fmtDate(data.studentList[i].birthDate);
	            	$('#student-' + data.studentList[i].id).text(birthDate);
	            }
			}
		}
	});

});	


function delOne(id){
	$.ajax({
		type:"POST",
		url:"./../edu_system/student/deleteStudent",
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

function fmtDate(obj){
    var date =  new Date(obj);
    var y = 1900+date.getYear();
    var m = "0"+(date.getMonth()+1);
    var d = "0"+date.getDate();
    return y+"-"+m.substring(m.length-2,m.length)+"-"+d.substring(d.length-2,d.length);
}