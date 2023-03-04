/**
 * 
 */
console.log('Content loaded !!');


let toggleSideBar = () =>{
	if($('.sidebar').is(':visible')){
		$('.sidebar').css('display','none');
		$('.after-login-content').css('margin-left','0%');
		$('.after-login-content').css('width','100%');
	}else{
		$('.sidebar').css('display','block');
		$('.after-login-content').css('margin-left','15%');
		$('.after-login-content').css('width','85%');
	}
}