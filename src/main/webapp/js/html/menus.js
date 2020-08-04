$(function(){
	$('.navi').hide();
});

$.ajax({
	type:"GET",
	url:"./../edu_system/getMenus",
	dataType:"json",
	success:function(data){
		if(data.errno == 404){
			window.location.href="./../edu_system/404.html";
		}else{
			var html = template('system-navi',data);
	        //插入生成的html
	        $('.navi').html(html);
	        $('.navi').fadeIn(300);
		}

	}
});