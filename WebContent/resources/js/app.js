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
				for(i in x){
					if(x[i] === ""){
						j.checker = false;
					}
				}
				return j;
				
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
			updateChecker : x => {
				var i;
			},
			validation : x => {}
		};
	})();
	// Java 에서의 서비스객체, DAO객체를 싱글톤으로 만들어 한 번만 만들어지게끔 하는 방식
	// Member()같은 경우는 여러 번 만들어야하기 때문에 기존 방식
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
		
