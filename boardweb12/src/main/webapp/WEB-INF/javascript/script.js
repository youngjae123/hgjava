/*
* script.js
*/

console.log("script.js");
console.log(document);

document.querySelector('button.btn').addEventListener('click', clickFnc);

function clickFnc(e){
	console.log(e);
	let userValue = document.querySelector('input#name').value;
	let liTag = document.createElement('li');
	liTag.innerText = userValue +' '; // <li>홍길동<button>삭제</button></li>

	// button 생성.
	let btn = document.createElement('button');
	btn.innerText = '삭제';
	liTag.appendChild(btn);

	// init (버튼 눌러서 등록하기)
	document.querySelector('#list').appendChild(liTag);
	document.querySelector('#name').value = '';
	
	
}
// addRow 등록
document.querySelector('#addbtn').addEventListener('click', addRow);
function addRow(){
	let sno, sname, score;
	sno = document.querySelector('#sno').value;
	sname = document.querySelector('#sname').value;
	score = document.querySelector('#score').value;
	if (!sno|| !sname || !score){
		alert('빈값을 채워주세요.');
		return;//함수 종료
	}
	//let obj = {sno: sno, sname: sname, score: score}; 아래 처럼 작성 가능
	let obj = {sno, sname, score};
	let tr = makeRow(obj);
	//makeRow(obj);
	document.querySelector('#studList').appendChild(tr);
}

// str에 값을 활용해서 화면 출력.(학생 목록 표)
function makeTr(){
	for (let student of str){
	let tr = makeRow(student);
	// tr생성.
	//let tr = document.createElement('tr');
	
	// td * 3 생성.
	//for (let prop in student) {
		//let td1 = document.createElement('td');
        //td1.innerText = student.sno;
        //let td2 = document.createElement('td');
        //td2.innerText = student.sname;
        //let td3 = document.createElement('td');
        //td3.innerText = student.score;
		//let td = document.createElement('td');
		//td.innerText = student[prop];
		// td를 tr에 append
	    //trTag.append(td1);
	    //trTag.append(td2);
	    //trTag.append(td3);
		//tr.appendChild(td);
	//}
	// tr을 tbody.appendChild
	document.querySelector('#studList').appendChild(tr);
	}
}

function makeRow(student={sno:1, sname:'test', score:90}){
	let tr = document.createElement('tr');
	// 이벤트 달기
	tr.addEventListener('click', displayRow);// 디폴트값이 false = 버블링 / true를 하면 캡쳐링 실행
	for(let prop in student){//student = makeRow(student)
		let td = document.createElement('td');
		td.innerText = student[prop];
		tr.appendChild(td);
	}
	
	// 삭제버튼 추가.
		let btn = document.createElement('button');
		//이벤트 달기
		btn.addEventListener('click', deleteRow);//deleteRow()를 넣어버리면 바로 실행이 되기때문에 deleteRow로 써야한다
		btn.innerText = '삭제';
		let td = document.createElement('td');
		td.appendChild(btn);
		tr.appendChild(td);
	
	return tr; 
}


//상세 = 학생목록 표 클릭하면 학생정보 입력란에 추가되게
function displayRow(e){
	//e.stopPropagation();
	//console.log(e.target, this);//this를 기준으로
	//console.log(this.children[1].innerText)
	//id
	document.querySelector('#sno').value = this.children[0].innerText;
	//name
	document.querySelector('#sname').value = this.children[1].innerText;
	//score
	document.querySelector('#score').value = this.children[2].innerText;
}

//삭제 = 학생목록 표에서 삭제버튼 누르면 삭제되는 함수
function deleteRow(e){
	//e.stopPropagation();// 하위요소에서 상위요소로 이벤트가 전파 되는것을 차단한다.
	console.log(e.target);//콘솔에 출력을 통해서 확인해본다.
	e.target.parentElement.parentElement.remove();
}


//수정
document.querySelector('#editbtn').addEventListener('click', editRow);
function editRow(e){
	let list = document.querySelectorAll('#studList tr');
	
	for(let i =0; i < list.length; i++) {
		if(list[i].children[0].innerText == document.querySelector('#sno').value){
			list[i].children[1].innerText = document.querySelector('#sname').value;
			list[i].children[2].innerText = document.querySelector('#score').value;
		}
	} 
	
	
}
makeTr();