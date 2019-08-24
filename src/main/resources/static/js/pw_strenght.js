$(document).ready(function() {
	var password1 		= $('#password1'); //id of first password field
	var password2		= $('#password2'); //id of second password field
	var passwordsInfo 	= $('#pass-info'); //id of indicator element
	
	passwordStrengthCheck(password1,password2,passwordsInfo); //call password check function
	
});

function passwordStrengthCheck(password1, password2, passwordsInfo)
{
	//必须包含5个或更多字符
	var WeakPass = /(?=.{5,}).*/; 
	//必须包含小写字母和至少一个数字。
	var MediumPass = /^(?=\S*?[a-z])(?=\S*?[0-9])\S{5,}$/; 
	//必须包含至少一个大写字母、一个小写字母和一个数字。
	var StrongPass = /^(?=\S*?[A-Z])(?=\S*?[a-z])(?=\S*?[0-9])\S{5,}$/; 
	//必须包含至少一个大写字母、一个小写字母和一个数字
	var VryStrongPass = /^(?=\S*?[A-Z])(?=\S*?[a-z])(?=\S*?[0-9])(?=\S*?[^\w\*])\S{5,}$/; 
	
	$(password1).on('keyup', function(e) {
		if(VryStrongPass.test(password1.val()))
		{
			passwordsInfo.removeClass().addClass('vrystrongpass').html("非常强! (太棒了，不要忘记你的密码!)");
		}	
		else if(StrongPass.test(password1.val()))
		{
			passwordsInfo.removeClass().addClass('strongpass').html("强! (数入特殊字符更加安全");
		}	
		else if(MediumPass.test(password1.val()))
		{
			passwordsInfo.removeClass().addClass('goodpass').html("中等! (输入大写字母更安全)");
		}
		else if(WeakPass.test(password1.val()))
    	{
			passwordsInfo.removeClass().addClass('stillweakpass').html("很弱! (输入数字作为密码)");
    	}
		else
		{
			passwordsInfo.removeClass().addClass('weakpass').html("非常弱! (必须大于5个字符)");
		}
	});
	
	$(password2).on('keyup', function(e) {
		
		if(password1.val() !== password2.val())
		{
			passwordsInfo.removeClass().addClass('weakpass').html("密码不匹配");
		}else{
			passwordsInfo.removeClass().addClass('goodpass').html("密码匹配!");
		}
			
	});
}