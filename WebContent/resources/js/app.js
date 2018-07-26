// New - others - JavaScript - JavaScriptSource
	function Common(){
		this.move = function (context, domain, action, page){
			location.href = context+"/"+domain+".do?action="+action+"&page="+page;
		}
	};
	
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
	};