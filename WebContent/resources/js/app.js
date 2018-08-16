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
	var members = (()=>{
		return{
			main : x=>{
				// login box script
				
				document.getElementById('move-login')
				.addEventListener('click',function(){ //콜백함수 : 연이어서 호출되는 함수
					// var x = ['${context}','member','move','user-login-form'];
					router.move({
								context: x,
								domain : 'member',
								action : 'move',
								page : 'login'})
								//JSON으로 넘겨준다. 배열은 loop을 돌릴때에나 쓴다.
				});
				
				document.getElementById('move-add')
				.addEventListener('click',function(){ 
					router.move({
								context: x,
								domain : 'member',
								action : 'move',
								page : 'add'})
				});
				
				// menu box script
				document.getElementById('move-home').addEventListener('click',function(){ 
					router.move({context:x,
								domain : 'common',
								action : '',
								page : ''})
				});
				
				document.getElementById('move-about').addEventListener('click',function(){ 
					router.move({context:x,
								domain : 'member',
								action : 'move',
								page : 'retrieve'})
				});
				
				document.getElementById('move-admin').addEventListener('click',function(){ 
					router.move({
						context : x,
						domain : 'admin',
						action : 'search',
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
				});
				
				// retrieve
				for(var i of document.querySelectorAll('.retrieve-butt')){
					i.addEventListener('click', function(){
						var y = this.getAttribute('id');
						if(y === 'logout'){
							router.move({context : x,
								domain : 'common',
								action : 'login',
								page : ''})
						}else{
							router.move({context : x,
								domain : 'member',
								action : 'move',
								page : y === 'update' ?
										'modify' : 'remove'})
						}
					})
				}
				
				var team = document.getElementById('team');
				for(var i of document.querySelectorAll('.team-opt')){
					if(i.getAttribute('value') === team.getAttribute('class')){
						i.setAttribute("selected","selected");
					}
				}
					
				var roll = document.getElementById('roll');
				for(var i of document.querySelectorAll('.roll-opt')){
					if(i.getAttribute('value') === roll.getAttribute('class')){
						i.setAttribute("selected","selected");
					}
				}	
				
				// form-butt script
				for(var i of document.querySelectorAll('.form-butt')){
					i.addEventListener('click', function(){
						var y = this.getAttribute('id');
						switch(y){
							case 'login-form-btn':
								var form = document.getElementById('login-form');
								var z = service.nullChecker([form.userid.value, form.password.value]);
								if(z.checker){
									form.action = x + "/member.do";
									form.method = "post";
									form.submit();
								}else{
									alert(z.text);
								}
								break;
							case 'join-form-btn':
								var form = document.getElementById('join-form');
								var arr = [form.userid.value,form.password.value,form.username.value,form.userssn.value];
								var z = service.nullChecker(arr)
								if(z.checker){
									member.join(arr);
									var arr = [{name : "action", value : "add"},
											{name : "gender", value : member.getGender()},
											{name : "age", value : member.getAge()}];
									
									for(var i in arr){
										var node = document.createElement('input');
										// node.innerHTML = '<input type="hidden" name="'+arr[i].name+'" value="'+arr[i].value+'"/>';
										// String값은 덜 쓰도록 한다.
										node.setAttribute('type', 'hidden');
										node.setAttribute('name', arr[i].name);
										node.setAttribute('value', arr[i].value);
										form.appendChild(node);
									}
									form.action = x + "/member.do";
									form.method = "post";	
									form.submit();
								}else{
									alert(z.text);
								}
								break;
							case 'update-btn' :
								var form = document.getElementById('update-form');
								alert(form.password.value)
								if(form.password.value === ""){
									form.password.value = form.password.placeholder;
								}
								var node = document.createElement('input');
								node.setAttribute('type', 'hidden');
								node.setAttribute('name', 'action');
								node.setAttribute('value', 'modify');
								form.appendChild(node);
								form.action = x + '/member.do';
								form.method ='post';
								form.submit();
								break;
							case 'file-upload-btn' : break;
							case 'delete-btn' :
								var form = document.getElementById('delete-form');
								if(form.confirm.value === form.confirm.id){
									form.action = x + '/member.do';
									form.method = 'post';
									
									var node = document.createElement("input"); // 없던 속성을 만든다.
									node.setAttribute("type","hidden");
									node.setAttribute("name","action");
									node.setAttribute("value","remove");
									form.appendChild(node); // form 에 node를 자식속성으로 추가한다.
									
									form.submit();
								}else{
									alert('비밀번호 불일치');
								}
								break;
						}
					}) /* Click function end */
				}
				
				//modify script
				
				

				/* 	var teamid = document.getElementById('teamid');
				for(var i = 0; i < teamid.options.length ; i++){
					if((teamid.teamid_i.value === '${user.teamId}')){
						document.getElementById('teamid_' + i).checked = true;
					}
				} */
			}
		};
	})();
	var common = (()=>{
		return{
			main : x=>{
				
					// login box script
					document.getElementById('move-login')
					.addEventListener('click',function(){ //콜백함수 : 연이어서 호출되는 함수
						// var x = ['${context}','member','move','user-login-form'];
						router.move({
									context: x,
									domain : 'member',
									action : 'move',
									page : 'login'})
									//JSON으로 넘겨준다. 배열은 loop을 돌릴때에나 쓴다.
					});
					
					document.getElementById('move-add')
					.addEventListener('click',function(){ 
						router.move({
									context: x,
									domain : 'member',
									action : 'move',
									page : 'add'})
					});
					
					// menu box script
					document.getElementById('move-home').addEventListener('click',function(){ 
						router.move({context:x,
									domain : 'common',
									action : '',
									page : ''})
					});
					
					document.getElementById('move-about').addEventListener('click',function(){ 
						router.move({context:x,
									domain : 'member',
									action : 'move',
									page : 'retrieve'})
					});
					
					document.getElementById('move-admin').addEventListener('click',function(){ 
						router.move({
							context : x,
							domain : 'admin',
							action : 'search',
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
					});
					
			}
		};	
	})();
	var admin = (()=>{
		return{
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
				
				document.getElementById("search-butt").addEventListener('click', ()=>{
					var option = document.getElementById('search-option');
					var word = document.getElementById('search-word');
					if(option.value === "none"){
						alert('검색조건을 선택해주세요');
					}else if(word.value === ""){
						alert('검색할 단어를 입력해주세요');
					}else{
						location.href = (option === "userid")?
							 x + "/admin.do?action=retrieve&page=main&a="
								+ word.value
									: x +"/admin.do?action=search&page=main&word="
										+ word.value + "&option="+option.value;
							// post 방식은 무조건 form, get 방식은 location.href 를 이용한다.
						}
				});
				
				for(var i of document.querySelectorAll('.username')){
					i.style.color = "blue";
					i.style.cursor = 'pointer';
					i.addEventListener('click', function(){ // this.를 쓰는 function 은 ()=> 이 되지 않는다.
						location.href= x 
							+ "/member.do?action=retrieve&page=main&a="
								+ this.getAttribute('id');
						// alert('Click!\n' + this.getAttribute('id'));
						// callback(어떠한 object의 event에 의해서 호출되는 함수)함수에서의 this.는 그 함수를 호출한 객체를 의미한다.
					});
				}
				
				for(var i of document.querySelectorAll('.pagenum')){
					i.addEventListener('click', function(){
						location.href= 
							x + "/admin.do?action=search&page=main&pagenum="
								+ this.getAttribute('id');
					});
				}
				
				for(var i of document.querySelectorAll('.order')){
					i.addEventListener('click', function(){
						location.href =
							x + "/admin.do?action=search&page=main&pagenum="
								+ ( this.getAttribute('id') * 1 );
					});
				}
			}
		};
	})();
	
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
		};
	})();