/**
 * userList.js
 */

 console.log('userList.js');
 
 let str =`{"id":1,"first_name":"Birk","last_name":"Folger","email":"bfolger0@blinklist.com","gender":"Male","salary":4246},
{"id":2,"first_name":"Tatiana","last_name":"Menico","email":"tmenico1@cnbc.com","gender":"Female","salary":4905},
{"id":3,"first_name":"Flint","last_name":"Fick","email":"ffick2@networkadvertising.org","gender":"Male","salary":4509},
{"id":4,"first_name":"Merridie","last_name":"Caulcutt","email":"mcaulcutt3@cnbc.com","gender":"Female","salary":3776},
{"id":5,"first_name":"Berri","last_name":"Ibell","email":"bibell4@flavors.me","gender":"Female","salary":2453},
{"id":6,"first_name":"Gilly","last_name":"Salmoni","email":"gsalmoni5@scribd.com","gender":"Female","salary":2108},
{"id":7,"first_name":"Nert","last_name":"Blaber","email":"nblaber6@dyndns.org","gender":"Female","salary":2994},
{"id":8,"first_name":"Raffaello","last_name":"Chatwood","email":"rchatwood7@artisteer.com","gender":"Male","salary":4220},
{"id":9,"first_name":"Jarrad","last_name":"McCleary","email":"jmccleary8@pinterest.com","gender":"Male","salary":2949},
{"id":10,"first_name":"Nickolai","last_name":"Kolodziejski","email":"nkolodziejski9@mit.edu","gender":"Male","salary":4979},
{"id":11,"first_name":"Lock","last_name":"Pimbley","email":"lpimbleya@gizmodo.com","gender":"Male","salary":3867},
{"id":12,"first_name":"Tibold","last_name":"Greatex","email":"tgreatexb@google.co.uk","gender":"Male","salary":3676},
{"id":13,"first_name":"Malynda","last_name":"Pratt","email":"mprattc@i2i.jp","gender":"Female","salary":4343},
{"id":14,"first_name":"Bartolomeo","last_name":"Brigshaw","email":"bbrigshawd@g.co","gender":"Male","salary":4887},
{"id":15,"first_name":"Thorin","last_name":"Bellany","email":"tbellanye@cpanel.net","gender":"Male","salary":2436}]`
 
 let json = JSON.parse(str); // 문자열 -> object로 변환.
 console.log(json);
 
 document.addEventListener('DOMContentLoaded', function(e){
   document.querySelector('#name').value='홍길동';
	 //thead 생성
	 let title = json[0];
	 for(let prop in title) {
		 let th = document.createElement('tr');
		 tn.innerText=prop;
		 tr.appendChild(th);
	 }
	 document.querySelector('#tableList thead').appendChild(tr);
	 
	 //tbody 영역
	 json.forEach(function(item, idx){
		 console.log(item, idx); // item => {}
		 let tr = document.createElement('tr');
	// 이벤트 달기
	     for(let prop in item){//student = makeRow(student)
		     let td = document.createElement('td');
		     td.innerText = item[prop];
		     tr.appendChild(td);
		 }
		document.querySelector('#talbeList tbody').aapenappendChild(tr);
	 });
 });
 