<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script src="${js}/app.js"></script>

<!-- <script>
	/* anonymous function */
	var common = new (function(){
		this.move = function (domain, action, page){
			location.href = "${context}/"+domain+".do?action="+action+"&page="+page;
		}
	});
	
	var member = new (function(){
		var memberId, password, ssn, name;
		this.setMemberId = function(x){
			this.memberId = x;
		}
		this.setSsn = function(x){
			this.ssn = x;
		}
		this.setPassword = function(x){
			this.password = x;
		}
		this.setName = function(x){
			this.name = x;
		}
		this.getMemberId = function(){
			return this.memberId;
		}
		this.getSsn = function(){
			return this.ssn;
		}
		this.getPassword = function(){
			return this.password;
		}
		this.getName = function(){
			return this.name;
		}
		this.loginValidation = function(){
			if(this.memberId === ""){
				alert('ID를 입력하세요.');
				document.getElementById('login-form').userid.focus();
				return false;
			}else if(this.password === ""){
				alert('PW를 입력하세요.');
				document.getElementById('login-form').password.focus();
				return false;
			}else{
				return true;
			}
		}
		this.overlabValidation = function(){
			return true;
		}
		this.joinValidation = function(){
			if(this.memberId === ""){
				alert('ID를 입력하세요.');
				document.getElementById('join-form').userid.focus();
				return false;
			}else if(this.overlabValidation){
				//alert('중복된 ID입니다.');
				//return false;
			}else if(this.password === ""){
				alert('PW를 입력하세요.');
				document.getElementById('join-form').password.focus();
				return false;
			}else if(this.name === ""){
				alert('이름을 입력하세요.');
				document.getElementById('join-form').username.focus();
				return false;
			}else if(this.ssn === ""){
				alert('생년월일을 입력하세요.');
				document.getElementById('join-form').userssn.focus();
				return false;
			}else{}
		}
	});

</script> -->

<!-- <script>
	function Common(){
		this.move = function (domain, action, page){
			location.href = "${context}/"+domain+".do?action="+action+"&page="+page;
			return;
		}
	}
	function Member(){
	/* this.memberId, teamId, name, ssn, roll, password; */
	this.loginValidation = function(){return "Validation Check";}
	/* this.loginValidation = loginValidation; 은 서로 이름이 같으며 function을 주고있으니 = function(){} 을 줄 수있다. */
	}
	
	var member = new Member();
	// new Member() 를 new (function(){}) 의 형태로 줄 수 있다. anonymous function
	var loginValidation = function(){
	var loginValidation = function loginValidation(){} 은 서로 이름이 같아 var loginValidation = function(){}이 될 수 있다.
	return ;
	프로시저는 값을 반환할 수 없다(== setter). 함수를 만들려면 return문이 있어야한다(== getter).
} 
</script> -->

<!-- <script>
function move(domain, action, page){
	//alert("${context}/"+domain+".do?action="+action+"&page="+page");
	//java의 sysout과 같음
	location.href = "${context}/"+domain+".do?action="+action+"&page="+page;
	//href 는 a tag에서 속성값이었다. location은 객체로 볼 수 있다.
}
function sendForm(){
	return true;
}
</script> -->