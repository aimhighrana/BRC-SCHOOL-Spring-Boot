/**
 * For manage user registration 
 * @author sandeep.rana
 * 
 */

/**
 * User class for store user basic details
 */
class User {
	userId;
	firstName;
	lastName;
	email;
	phone;
	password;
	isEnable;
	isExpried;
	roles;
	userInfo;
}

/**
 * Hold user role information
 */
class Roles {
	roleId;
	roleName;
	roleDesc;
}

/**
 * UserInformation class for user specific information
 */
class UserInformation {
	country;
	city;
	address;
	nickName;
	telephone;
	panNumber;
	aadharNumber;
	workingOn;
	parent;
	guardianName;
	motherName;
	previousClass;
	previousSection;
	previousMarks;
	currentClass;
	currentSection;
}

/**
 * Hold file upload informations
 */
class FileUploadHelper {
	fileName;
	file;
	helperId;
}


/**
 * Globals variables 
 */
var classAndSec;
var files;



$(function () {
	
	$('.for-common').hide();
	$('.for-parent').hide();
	$('.for-student').hide();
	$('.for-action').hide();
	
	// bind event on roles change
	$('#roles').on('change',function(){
		manageRegistrationPage(this);
		files = undefined;
	});

	// bind event on save 
	$('#user_save_btn').unbind().click(function(){
		registerUser($('#roles').val());
	});
	
	// bind on change on country selection
	$('#country').on('change',function(){
		getAllCity($(this).val());
	});
	
	// bind on change on currentClass selections
	$('#currentClass').on('change',function(){
		populateSections($(this).val());
	});
	
	// initial http calls
	getAllCountry();
});

/**
 * For manage registration form
 * @param currentRole selected role id
 * @returns
 */
function manageRegistrationPage(currentRole) {
	console.log(currentRole);
	const selectedRole = $(currentRole).val();
	
	// hide all 
	$('.for-common').hide();
	$('.for-parent').hide();
	$('.for-student').hide();
	
	if(selectedRole) {
		$('.for-common').show();
		$('.for-action').show();
		if(selectedRole === 'STUDENT'){
			$('.for-student').show();
			getAllParents();
			getAllClasses();
			$('.file-upload-container').show();
		} else if(selectedRole === 'PARENT') {
			$('.for-parent').show();
			$('.file-upload-container').show();
		}
		
	} else {
		$('.for-common').hide();
		$('.for-parent').hide();
		$('.for-student').hide();
		$('.file-upload-container').hide();
	}
	prepareFileHelper();
	
	
}

/**
 * Should call http to save / update user information * 
 */
function registerUser(type) {
	let data;
	if(type=== 'STUDENT') {
		data = getStudentData();
	} else if(type === 'PARENT') {
		data = getParentData();
	}

	console.log(data);
	
	$.ajax({
		url : contextPath + `/admin/user/save-update`,
		type : "POST",
		cache : false,
		data : JSON.stringify(data),
		processData : false,
		contentType: 'application/json',
		success : function(response) {
			showNotification('bg-green', `User ${response.userId} saved / updated successfully `, 'top', 'right', '', '');
			uploadData(response.userId);
			$('#user_form_validation')[0].reset();

		}, error: function(error) {
			console.error('Error : ' + error);
			showNotification('bg-red', `${error.message} `, 'top', 'right', '', '');
		},beforeSend: function(send) {}
		,complete: function(complete) {}
	});
}



/**
 * Should return user information
 * @returns User information
 */
function getStudentData() {

	const user = new User();
	const userInfo = new UserInformation();

	user.userId = $('#userName').val() ? $('#userName').val() : '';
	user.password = $('#password').val() ? $('#password').val() : '';
	const r = $('#roles').val() ? $('#roles').val() : '';
	const role = new Roles();
	role.roleName = r;
	user.roles = [role];
	
	user.firstName = $('#firstName').val() ? $('#firstName').val() : '';
	user.lastName = $('#lastName').val() ? $('#lastName').val() : '';
	user.email = $('#email').val() ? $('#email').val() : '';
	user.phone = $('#phone').val() ? $('#phone').val() : '';
	user.isEnable = true;
	user.isExpried = false;

	userInfo.nickName = $('#nickName').val() ? $('#nickName').val() : '';
	userInfo.telephone = $('#telephone').val() ? $('#telephone').val() : '';
	userInfo.country = $('#country').val() ? $('#country').val() : '';
	userInfo.city = $('#city').val() ? $('#city').val() : '';
	userInfo.address = $('#address').val() ? $('#address').val() : '';
	userInfo.parent = $('#parent').val() ? $('#parent').val() : '';
	userInfo.guardianName = $('#guardianName').val() ? $('#guardianName').val() : '';
	userInfo.motherName = $('#motherName').val() ? $('#motherName').val() : '';
	userInfo.previousClass = $('#previousClass').val() ? $('#previousClass').val() : '';
	userInfo.previousSection = $('#previousSection').val() ? $('#previousSection').val() : '';
	userInfo.previousMarks = $('#previousMarks').val() ? $('#previousMarks').val() : '';
	userInfo.currentClass = $('#currentClass').val() ? $('#currentClass').val() : '';
	userInfo.currentSection = $('#currentSection').val() ? $('#currentSection').val() : '';

	user.userInfo = userInfo;
	return user;
}

/**
 * Should return parent information
 * @returns
 */
function getParentData() {

	const user = new User();
	const userInfo = new UserInformation();

	user.userId = $('#userName').val() ? $('#userName').val() : '';
	user.password = $('#password').val() ? $('#password').val() : '';
	const r = $('#roles').val() ? $('#roles').val() : '';
	const role = new Roles();
	role.roleName = r;
	user.roles = [role];
	
	user.firstName = $('#firstName').val() ? $('#firstName').val() : '';
	user.lastName = $('#lastName').val() ? $('#lastName').val() : '';
	user.email = $('#email').val() ? $('#email').val() : '';
	user.phone = $('#phone').val() ? $('#phone').val() : '';
	user.isEnable = true;
	user.isExpried = false;

	userInfo.nickName = $('#nickName').val() ? $('#nickName').val() : '';
	userInfo.telephone = $('#telephone').val() ? $('#telephone').val() : '';
	userInfo.country = $('#country').val() ? $('#country').val() : '';
	userInfo.city = $('#city').val() ? $('#city').val() : '';
	userInfo.address = $('#address').val() ? $('#address').val() : '';
	userInfo.panNumber = $('#panNumber').val() ? $('#panNumber').val() : '';
	userInfo.aadharNumber = $('#aadharNumber').val() ? $('#aadharNumber').val() : '';
	userInfo.workingOn = $('#workingOn').val() ? $('#workingOn').val() : '';
	user.userInfo = userInfo;
	return user;
}

/**
 * Should call http to fetch all country list
 * @returns
 */
function getAllCountry() {
	$.ajax({
		url : contextPath + '/admin/country/list',
		type : "GET",
		cache : false,
		data : '',
		processData : false,
		contentType: 'application/json',
		success : function(response) {
			console.log(response);
			let option = ''; 
			response.forEach(res=>{
				option += `<option value="${res.countryId}">${res.countryName}</option>`;
			});
			$('#country').find('option:not(:first-child)').remove();
			$('#country').append(option);
			$("#country").selectpicker("refresh");
		}, error: function(error) {
			console.error('Error : ' + error);
		},beforeSend: function(send) {}
		,complete: function(complete) {}
	});
}

/**
 * Should call http to fetch cities by countryId
 * @param countryId id of country that we need to fetch all cities
 * @returns
 */
function getAllCity(countryId) {
	$.ajax({
		url : contextPath + `/admin/city/${countryId}`,
		type : "GET",
		cache : false,
		data : '',
		processData : false,
		contentType: 'application/json',
		success : function(response) {
			console.log(response);
			let option = ''; 
			response.forEach(res=>{
				option += `<option value="${res.cityId}">${res.cityName}</option>`;
			});
			$('#city').find('option:not(:first-child)').remove();
			$('#city').append(option);
			$("#city").selectpicker("refresh");
		}, error: function(error) {
			console.error('Error : ' + error);
		},beforeSend: function(send) {}
		,complete: function(complete) {}
	});
}


/**
 * Call http to return all parents
 * @returns
 */
function getAllParents() {
	$.ajax({
		url : contextPath + `/admin/user/list/PARENT`,
		type : "GET",
		cache : false,
		data : '',
		processData : false,
		contentType: 'application/json',
		success : function(response) {
			console.log(response);
			let option = ''; 
			response.forEach(res=>{
				option += `<option value="${res.userId}">${res.userId} --  ${res.fullName}</option>`;
			});
			$('#parent').find('option:not(:first-child)').remove();
			$('#parent').append(option);
			$("#parent").selectpicker("refresh");
		}, error: function(error) {
			console.error('Error : ' + error);
		},beforeSend: function(send) {}
		,complete: function(complete) {}
	});
}


/**
 * Call http to return all class and sections
 * @returns
 */
function getAllClasses() {
	if(classAndSec === undefined) {
		$.ajax({
			url : contextPath + `/admin/get-all-classes`,
			type : "GET",
			cache : false,
			data : '',
			processData : false,
			contentType: 'application/json',
			success : function(response) {
				console.log(response);
				classAndSec = response;
				let option = ''; 
				response.forEach(res=>{
					option += `<option value="${res.classId}">${res.className}</option>`;
				});
				$('#currentClass').find('option:not(:first-child)').remove();
				$('#currentClass').append(option);
				$("#currentClass").selectpicker("refresh");
			}, error: function(error) {
				console.error('Error : ' + error);
			},beforeSend: function(send) {}
			,complete: function(complete) {}
		});
	}
}

/**
 * Populate sections based on class selections
 * @param classId
 * @returns
 */
function populateSections(classId) {
	if(classAndSec) {
		const sec = classAndSec.filter(fil=> fil.classId === classId)[0];
		let option = ''; 
		sec.sections.forEach(se=>{
			option += `<option value="${se.sectionId}">${se.sectionName}</option>`;
		});
		$('#currentSection').find('option:not(:first-child)').remove();
		$('#currentSection').append(option);
		$("#currentSection").selectpicker("refresh");
	}
}

function prepareFileHelper() {
	if(files) {
		let html = '';
		
		files.forEach((file,index)=>{
			html+= `<div class="row clearfix" id="row_${index}">
					 <div class="col-sm-4">
						<div class="form-group form-float">
							<div class="form-line">
								<input type="text" class="form-control" name="fileName" value="${file.fileName}" id="fileName_${index}"  placeholder="Enter file name"  onkeyup="onChangeFileName(${index},this)"  />
							</div>
						</div>
					</div>
					<div class="col-sm-6">
						<div >
							<div class="form-line">
								<input style="display:none" type="file" class="form-control" name="file" id="file_${index}" value="${file.file.name}" placeholder="${file.file.name}" onchange="onFileChange(${index},this)" />
								${textAccording(index,file)}
							</div>
						</div>
					</div>	
					<div class="col-sm-2">
						<div>
							<div class="form-line">
								<button type="button" class="btn btn-danger waves-effect" onclick="removeFile(${index})">Remove</button>
							</div>
						</div>
					</div>
				  </div>`;
		});
		$('#fileContainer').html(html);
		
	} else {
		$('#fileContainer').html('');
		
	}	
}

function textAccording(index,file) {
	if(file.file && file.file.name) {
		return `<button type="button" class="btn btn-info waves-effect" id="file_btn_${index}" onclick="uploadFile(${index})">${file.file.name}</button>`;
	} else {
		return `<button type="button" class="btn btn-info waves-effect" id="file_btn_${index}" onclick="uploadFile(${index})">Upload File</button>`;
	}
}

/**
 * Add more attachments 
 * @returns
 */
function addMoreFile() {
	const file = new FileUploadHelper();
	file.fileName = '';
	file.file = '';
	file.helperId = new Date().getTime();
	
	files = files ? files : [];
	files.push(file);
	prepareFileHelper();
}

/**
 * Remove attachment row based on row index
 * @param index
 * @returns
 */
function removeFile(index) {
	files.splice(index,1);
	prepareFileHelper();
}

function onChangeFileName(index, currentObj) {
	const val = $(currentObj).val();
	
	const file = files[index];
	file.fileName = val;
	files.splice(index,1,file);
//	prepareFileHelper();
}

function onFileChange(index,currentObj) {
	console.log(currentObj);
	const selFile = $(currentObj).context.files[0];	
	const file = files[index];
	file.file = selFile;
	
	$('#file_btn_'+index).text(file.file.name);
	files.splice(index,1,file);
}

function uploadFile(index) {
	$('#file_'+index).click();
}

function uploadData(userName) {
	if(files) {
		files.forEach((file,index)=>{
			const formData = new FormData();
			formData.append('fileName', file.fileName);
			formData.append('file', file.file);
			
			$.ajax({
				url : contextPath + `/admin/upload-documents?userName=${userName}`,
				type : "POST",
				cache : false,
				data : formData,
				processData : false,
				contentType: false,
				success : function(response) {
					console.log(response);
					if(response) {
						files.splice(index,1);
						$('#row_'+index).remove();
					}
				}, error: function(error) {
					console.error('Error : ' + error);
				},beforeSend: function(send) {}
				,complete: function(complete) {}
			});
			
			
		});
	} else {
		console.error(`Unable to found files `);
	}
}
