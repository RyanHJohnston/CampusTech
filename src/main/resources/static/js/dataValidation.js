var elMsgFN=document.getElementById('invalid-feedbackFN');
var elMsgLN=document.getElementById('invalid-feedbackLN');
var elMsgEM=document.getElementById('invalid-feedbackEM');
var elMsgUN=document.getElementById('invalid-feedbackUN');
var elMsgAD=document.getElementById('invalid-feedbackAD');
var elMsgZIP=document.getElementById('invalid-feedbackZIP');
var elMsgCCName=document.getElementById('invalid-feedbackCCName');
var elMsgCCNum=document.getElementById('invalid-feedbackCCNum');
var elMsgCCEXP=document.getElementById('invalid-feedbackCCEXP');
var elMsgCCCVV=document.getElementById('invalid-feedbackCCCVV');

var elFN=document.getElementById('firstName');
var elLN=document.getElementById('lastName');
var elUN=document.getElementById('username');
var elEM=document.getElementById('email');
var elADD=document.getElementById('address');
var elZIP=document.getElementById('firstName');
var elCCName=document.getElementById('cc-name');
var elCCNum=document.getElementById('cc-number');
var elCCEXP=document.getElementById('cc-expiration');
var elCCCVV=document.getElementById('cc-expiration');

function checkUsername()
{                             							
	if (elUN.value.length < 5)
	{                   								
		elMsgUN.innerHTML = '<p>Username must be 5 characters or more</p>'; 
	}
	else
	{ 						
		elMsgUN.innerHTML = '';
	}
}

function checkFN()
{
	if (elFN.value.length < 2)
	{
			elMsgFN.innerHTML='<p>First Name must be at least 2 characters.</p>';
	}
	else
	{
			elMsgFN.innerHTML='';
	}
}

function checkLN()
{
	if (elLN.value.length < 2)
	{
			elMsgLN.innerHTML='<p>Last Name must be at least 2 characters.</p>';
	}
	else
	{
			elMsgLN.innerHTML='';
	}
}

function checkEmail()
{
	if (!elEM.validity.valid)
	{
			elMsgEM.innerHTML='<p>Inavlid Email</p>'
	}
	else
	{
		elMsgEM.innerHTML='';
	}
}

function checkAddress()
{
	if (elADD.value.length < 16)
	{
		elMsgAD.innerHTML='<p>Address must be at least 16 characters long.</p>'
	}
	else
	{
		elMsgAD.innerHTML='';
	}
}

function checkZIP()
{
	if (isNaN(elZIP))
	{
		elMsgZIP.innerHTML='<p>ZIP Code must consist of only numbers.</p>';
	}
	else
	{
		if (elZIP.value.length < 5 || elZIP.value.length > 5)
		{
			elMsgZIP.innerHTML='<p>Invalid ZIP Code. Must be 5 characters long.</p>';
		}
		else
		{
			elMsgZIP.innerHTML='';
		}
	}
}

function checkCCName()
{
	if (elCCName.value.length < 5)
	{
		elMsgCCName.innerHTML='<p>Card Name must be longer than 5 characters.</p>';
	}
	else
	{
		elMsgCCName.innerHTML='';
	}
}

function checkCCNum()
{
	if (isNaN(elCCNum))
	{
		elMsgCCNum.innerHTML='<p>Card number must consist of only numbers</p>';
	}
	else
	{
		if (elCCNum.value.length < 16 || elCCNum.value.length > 16)
		{
			elMsgCCNum.innerHTML='<p>Card number must be 16 digits long.</p>';
		}
		else
		{
			elMsgCCNum.innerHTML='';
		}
	}
}

function checkCCEXP()
{
	if (elCCEXP.value.length < 4 || elCCEXP.value.length > 4)
	{
		elMsgCCEXP.innerHTML='<p>Card expiration must be 4 characters long, without slashes.</p>';
	}
	else
	{
		elMsgCCEXP.innerHTML='';
	}
}

function checkCCCVV()
{
	if (elCCCVV.value.length < 3 || elCCCVV.value.length > 3)
	{
		elMsgCCCVV.innerHTML='<p>CVV must be 3 digits long.</p>';
	}
	else
	{
		elMsgCCCVV.innerHTML='';
	}
}

elUN.addEventListener('blur',checkUsername,false);
elFN.addEventListener('blur',checkFN,false);
elLN.addEventListener('blur',checkLN,false);
elEM.addEventListener('blur',checkEmail,false);
elADD.addEventListener('blur',checkAddress,false);
elZIP.addEventListener('blur',checkZIP,false);
elCCName.addEventListener('blur',checkCCName,false);
elCCNum.addEventListener('blur',checkCCNum,false);
elCCEXP.addEventListener('blur',checkCCEXP,false);
elCCCVV.addEventListener('blur',checkCCCVV,false);