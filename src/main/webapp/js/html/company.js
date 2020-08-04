$(function(){
	$.ajax({
		type:"GET",
		url:"./../edu_system/offer/getAllCompanys",
		dataType:"json",
		success:function(data){
			if(data.errno=="0000"){
				//数据填充
	            var html = template('company-table',data);
	            //插入生成的html
	            $('.system-company').html(html); 
			}
		}
	});
});