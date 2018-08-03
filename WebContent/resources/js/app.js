// New - others - JavaScript - JavaScriptSource
"use strict" //에러가 나면 보여주겠다.
	var router = (()=>{
		return {
			move : x =>{
				location.href = x.context +"/"
					+ x.domain + ".do?action=" + x.action + "&page=" + x.page;
			}
		};
	})();
	var service = (()=>{
		return {
			nullChecker : x => {
				var i;
				var j = {
						checker : true,
						text : '빈칸을 채워주세요.'
				};
				for(i of x){
					if(i === ""){
						j.checker = false;
					}
				}
				return j; // 값이 여러 개 이지만 제이슨으로 뭉쳐 하나로 리턴한다 > 스칼라로 리턴
				
/*				var i, check;
				for(i = 0; i < x.length ; i++){
					check = true;
					if(x[i] === ""){
						alert('빈칸을 채워주세요.');
						//document.getElementById().x[i].focus();
						check = false;
					}
				}
				return check;*/
				
			},
			addClass : (dom, cName) => {
				var arr = cName.split(" ");
				if(arr.indexOf(cName) == -1){
					dom.className += " " + cName;
				}
			}
		};
	})();
	// Java 에서의 서비스객체, DAO객체를 싱글톤으로 만들어 한 번만 만들어지게끔 하는 방식
	// Member()같은 경우는 여러 번 만들어야하기 때문에 기존 방식
	// (()=>{return{};})(); > 기본 형식을 만들고 시작한다.
	var admin = (()=>{
		return{
			check : x=>{
				router.move({
					context : x,
					domain : 'admin',
					action : 'list',
					page : 'main'})
					
				/*var isAdmin = confirm('관리자입니까?');
				// confirm은 window객체, BOM의 메소드 : 단독으로 쓰일 수 있으며 객체생성이 필요없다.
				// DOM은 앞에 document를 통해 만들어지는데, 이것도 나중엔 생략할 수 있게 될 것.
				if(isAdmin){
					var password = prompt('관리자 코드를 입력하세요.');
					if(password == 93){
						router.move({
							context : x,
							domain : 'admin',
							action : 'list',
							page : 'main'})
					}else{
						alert('비밀번호가 정확하지 않습니다.');
					}
				}else{
					alert('관리자만 접근이 허용됩니다.');
				}*/
			},
			main : x=> {
				service.addClass(
						document.getElementById('content-box-search'),
						"margin-auto width-635px");
				
				service.addClass(
						document.getElementById('list-table'),
						"margin-auto ");
				
				service.addClass(
						document.getElementById('content-box-mata'),
						"bgcolor-yellow ");
				
				document.getElementById("search-butt").addEventListener('click', function(){
					var option = document.getElementById('select-option');
					var word = document.getElementById('search-word');
					if(option.value === "none"){
						alert('검색조건을 선택해주세요');
					}else if(word.value === ""){
						alert('검색할 단어를 입력해주세요');
					}else{
						location.href = (document.getElementById('select-option').value === "userid")?
							location.href = x +"/admin.do?action=retrieve&page=member-detail&a="
								+ word.value
								: location.href = x +"/admin.do?action=search&page=main&word="
									+ word.value + "&option="+option.value;
							// post 방식은 무조건 form, get 방식은 location.href 를 이용한다.
						}
				});
				
				for(var i of document.querySelectorAll('.username')){
					i.style.color = "blue";
					i.style.cursor = 'pointer';
					i.addEventListener('click', function(){
						location.href= x + "/admin.do?action=retrieve&page=member-detail&a="+this.getAttribute('id');
						// alert('Click!\n' + this.getAttribute('id')); // callback(어떠한 object의 event에 의해서 호출되는 함수)함수에서의 this.는 그 함수를 호출한 객체를 의미한다.
					});
				}
			}
		};})();
	var member = (()=>{
		var _memberId, _password, _ssn, _name, _gender, _roll, _teamId, _age;
		var setMemberId = (memberId)=>{this._memberId = memberId;}
		var setSsn = (ssn)=>{this._ssn = ssn;}
		var setPassword = (password)=>{this._password = password;}
		var setName = (name)=>{this._name = name;}
		var setGender = x => {
			var gender;
			switch(Number(x.substr(7,1))){
				case 1 : 
				case 3 : gender = "남" ; break;
				case 2 :
				case 4 : gender = "여" ; break;
			}
			this._gender = gender;
		}
		var setRoll = (roll) => {this._roll = roll;}
		var setTeamId = (teamId) => {this._teamId = teamId;}
		var setAge = x => {this._age = new Date().getFullYear() - (1900 + Number(x.substr(0,2))) + 1;}
		var getMemberId = ()=>{return this._memberId;}
		var getSsn = ()=>{return this._ssn;}
		var getPassword = ()=>{return this._password;}
		var getName = ()=>{return this._name;}
		var getGender = () => {return this._gender;}
		var getRoll = () => {return this._roll;}
		var getTeamId = () => {return this._teamId;}
		var getAge = () => {return this._age;}
		return{
			setMemberId : setMemberId,
			setSsn : setSsn,
			setPassword : setPassword,
			setName : setName,
			setGender : setGender,
			setRoll : setRoll,
			setTeamId : setTeamId,
			setAge : setAge,
			getMemberId : getMemberId,
			getSsn : getSsn,
			getPassword : getPassword,
			getName : getName,
			getGender : getGender,
			getRoll : getRoll,
			getTeamId : getTeamId,
			getAge : getAge,
			join : x => {
				member.setAge(x[3]);
				member.setGender(x[3]);
			}
		}
	})();
		
