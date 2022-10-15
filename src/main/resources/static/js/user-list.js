/**
*@author sandeep.rana
*
*/
$(function () {
	
	getAllUsers(undefined);
	
	$('#searchUsers').on('keyup', function(){
		getAllUsers($(this).val());
	});
	
});


function getAllUsers(qryString) {
	if(qryString== undefined) {
		qryString = '';
	}
	$.ajax({
		url : contextPath + `/admin/user/list?qryString=${qryString}`,
		type : "GET",
		cache : false,
		data : '',
		processData : false,
		contentType: 'application/json',
		success : function(response) {
			console.log(response);
			if(response) {
				const data = prepareUsersCard(response);
				$('#main_container').html('');
				$('#main_container').html(data);
			}
		}, error: function(error) {
			console.error('Error : ' + error);
		},beforeSend: function(send) {}
		,complete: function(complete) {}
	});
	
}


function prepareUsersCard(response) {
	if(response) {
		let cardList = '';
		response.forEach(res=>{
			let roles = '';
			res.roles.forEach(sec=>{
				roles += `<span class="label ${getRandomLabelsColor()}" style="margin-left:6px;">${sec.roleName}</span>`;	
			});
			
			let card = `<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
				<div class="card">
					<div class="header bg-cyan">
						<h2>
							${res.fullName} <small>${res.email}</small>
						</h2>
						<ul class="header-dropdown m-r--5">
							<li><a href="javascript:void(0);"> <i
									class="material-icons">delete</i>
							</a></li>
							<li class="dropdown"><a href="javascript:void(0);"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false"> <i
									class="material-icons">more_vert</i>
							</a>
								<ul class="dropdown-menu pull-right">
									<li><a href="javascript:void(0);">Edit</a></li>
								</ul></li>
						</ul>
					</div>
					<div class="body">
						${roles}
					</div>
				</div>
			</div>`;
			cardList += card;
		});
		return cardList;
	}
}
