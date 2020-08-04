$(function(){
	

	$("#add-btn").on('click',function(){
		var job = $("#add-job").val().trim();
		var company = $("#add-company").val().trim();
		
		$.ajax({
			type:"POST",
			url:"./../edu_system/offer/signOffer",
			dataType:"json",
			data:{
				job:job,
				company:company
			},
			success:function(data){
				if(data.errno=="0000"){
					layer.msg("投掷成功!");
				}
			}
		});
	});
	
});