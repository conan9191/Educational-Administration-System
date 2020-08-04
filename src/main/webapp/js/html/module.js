	$(function(){
		$.ajax({
			type:"GET",
			url:"./../edu_system/system/getModules",
			dataType:"json",
			success:function(data){
				if(data.errno=="0000"){
					//数据填充
		            var html = template('module-table',data);
		            //插入生成的html
		            $('.modules').html(html); 
				}
			}
		});
	});

	function addOne(id){
		$.ajax({
			type:"POST",
			url:"./../edu_system/system/addModule",
			dataType:"json",
			data:{
				id:id
			},
			success:function(data){
				if(data.errno=="0000"){
					layer.msg("启动成功!");
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
	
	
	function delOne(id){
		$.ajax({
			type:"POST",
			url:"./../edu_system/system/deleteModule",
			dataType:"json",
			data:{
				id:id
			},
			success:function(data){
				if(data.errno=="0000"){
					layer.msg("禁用成功!");
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