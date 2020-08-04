

$.ajax({
	type:"GET",
	url:"./../edu_system/system/getMenus",
	dataType:"json",
	success:function(data){
		var html = template('menu-table',data);
        //插入生成的html
        $('.system-menu').html(html); 
	},
	error:function(){
		//不做处理
	}
});


$("#add-btn").on('click',function(){
	var item = $("#add-item").val().trim();
	var parentId = $("#add-parentId").val().trim();
	$.ajax({
		type:"POST",
		url:"./../edu_system/system/addMenu",
		dataType:"json",
		data:{
			item:item,
			parentId:parentId
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
	url:"./../edu_system/system/deleteMenu",
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