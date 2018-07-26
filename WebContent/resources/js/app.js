// New - others - JavaScript - JavaScriptSource
	var router = (()=>{
		return {move : x =>{
			location.href = x[0]+"/"+x[1]+".do?action="+x[2]+"&page="+x[3];
		}};
	})();
	var service = (()=>{
		return {
			loginValidation : x => {
				if(x.getMemberId() === ""){
					alert('ID를 입력하세요.');
					document.getElementById('login-form').userid.focus();
					return false;
				}else if(x.getPassword() === ""){
					alert('PW를 입력하세요.');
					document.getElementById('login-form').password.focus();
					return false;
				}else{
					return true;
				}
			},
			joinValidation : x => {
				if(x.getMemberId() === ""){
					alert('ID를 입력하세요.');
					document.getElementById('join-form').userid.focus();
					return false;
				}else if(x.getPassword() === ""){
					alert('PW를 입력하세요.');
					document.getElementById('join-form').password.focus();
					return false;
				}else if(x.getName() === ""){
					alert('이름을 입력하세요.');
					document.getElementById('join-form').username.focus();
					return false;
				}else if(x.getSsn() === ""){
					alert('생년월일을 입력하세요.');
					document.getElementById('join-form').userssn.focus();
					return false;
				}else{
					return true;
				}
			}
		};
	})();
	// Java 에서의 서비스객체, DAO객체를 싱글톤으로 만들어 한 번만 만들어지게끔 하는 방식
	// Member()같은 경우는 여러 번 만들어야하기 때문에 기존 방식
	function Member(){
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
	}
	// function(){}() // syntax error
	// (function(){})(); // Goofy!
	// (function(){}()); // Groovy!
	