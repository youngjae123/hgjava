/**
 * boardService.js
 */
// .pagination>a click이벤트.
let page = 1;
function pagingFunc() {
	document.querySelectorAll('.pagination>a') // NodeList
		.forEach(item => {

			item.addEventListener('click', function(e) {
				e.preventDefault(); // 링크의 기능 차단.
				//page = item.innerText; // page로 사용.
				page = item.dataset.page; // item.getAttribute('data-page');
				replyList(page); //링크를 클릭할때마다 목록을 새롭게 그리고.
				pageList(); // 페이지목록을 새롭게 그리고.
			})
		});
}


// 등록이벤트.
document.querySelector('.addReply').addEventListener('click', addReplyFnc);
function addReplyFnc(e) {
	let reply = document.querySelector('input[name="reply"]').value;
	if (!reply) {
		alert('댓글입력하세요.')
		return;
	}
	const addHtp = new XMLHttpRequest();
	addHtp.open('post', 'addReply.do');
	addHtp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	addHtp.send('bno=' + bno + '&reply=' + reply + '&replyer=' + replyer);

	addHtp.onload = function(e) {
		let result = JSON.parse(addHtp.responseText);

		if (result.retCode == 'OK') {
			alert('등록성공')
			//document.querySelector('.reply ul').appendChild(makeRow2(result.retVal));
			document.querySelector('#reply').value = '';

			// 건수 계산하기위한 ajax 호출.
			const cntHtp = new XMLHttpRequest();
			cntHtp.open('get', 'getTotal.do?bno=' + bno);
			cntHtp.send()
			cntHtp.onload = function(e) {
				let result = JSON.parse(cntHtp.responseText);
				page = Math.ceil(result.totalCount / 5);
				replyList(page);
				pageList();
			}

		} else {
			alert('처리실패')
		}
	} // end of onload


}

// 댓글 목록.
function makeRow(obj = {}) {
	let fields = ['replyNo', 'reply', 'replyer'];
	let liTag = document.createElement('li');
	liTag.setAttribute('data-rno', obj.replyNo);
	fields.forEach(prop => {
		let span = document.createElement('span');
		span.innerText = obj[prop];
		if (prop == 'reply') {
			span.className = 'col-sm-6';
		} else {
			span.className = 'col-sm-2';
		}
		liTag.appendChild(span);
	});
	// 삭제버튼.
	let span = document.createElement('span');
	span.className = 'col-sm-2';
	let btn = document.createElement('button');
	btn.addEventListener('click', deleteRow);
	btn.innerText = '삭제';
	span.appendChild(btn);
	liTag.appendChild(span);
	return liTag;
}

function makeRow2(obj = {}) {
	let clon = document.querySelector('.content>ul>li:nth-of-type(1)')//
		.cloneNode(true);
	clon.setAttribute('data-rno', obj.replyNo);
	clon.querySelector('span:nth-of-type(1)').innerText = obj.replyNo;
	clon.querySelector('span:nth-of-type(2)').innerText = obj.reply;
	clon.querySelector('span:nth-of-type(3)').innerText = obj.replyer;
	// 삭제버튼.
	let btn = document.createElement('button');
	btn.addEventListener('click', deleteRow);
	btn.innerText = '삭제';
	clon.querySelector('span:nth-of-type(4)').innerText = '';
	clon.querySelector('span:nth-of-type(4)').appendChild(btn);
	return clon;
}

// 삭제함수.
function deleteRow(e) {
	let rno = this.parentElement.parentElement.dataset.rno;
	let li = this.parentElement.parentElement;
	// 작성자와 로그인 비교.
	console.dir(this.parentElement);
	let writer = this.parentElement.previousElementSibling.innerText;
	writer = li.querySelector('span:nth-of-type(3)').innerText;
	if (replyer != writer) {
		alert('삭제권한이 없습니다.')
		return;
	}
	const delHtp = new XMLHttpRequest();
	delHtp.open('post', 'removeReply.do');
	delHtp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	delHtp.send('rno=' + rno);
	delHtp.onload = (e) => {
		const result = JSON.parse(delHtp.responseText);
		if (result.retCode == 'OK') {
			alert(result.retMsg);
			//this.parentElement.parentElement.remove();
			replyList(page);
			pageList();
		} else {
			alert(result.retMsg);
		}
	}
}

// 목록함수.
function replyList(rpage = 1) {
	const xhtp = new XMLHttpRequest();
	xhtp.open('get', 'replyList.do?bno=' + bno + '&page=' + rpage);
	xhtp.send();
	xhtp.onload = function(e) {

		const data = JSON.parse(xhtp.responseText);
		// 기존목록 삭제.
		document.querySelectorAll('li[data-rno]').forEach(item => item.remove());
		// 목록.
		data.forEach(item => {
			document.querySelector('.reply ul').appendChild(makeRow2(item));
		})
		// 목록이 없을 경우에..
		if (!data.length) {
			page--;
			replyList(page);
			pageList();
		}
	}
}
replyList();

// 페이징 목록.
function pageList() {
	const plistHtp = new XMLHttpRequest();
	plistHtp.open('get', 'getTotal.do?bno=' + bno);
	plistHtp.send();
	plistHtp.onload = function(e) {
		// 기존 페이지 삭제.
		document.querySelector('div.pagination').innerHTML = '';

		let result = JSON.parse(plistHtp.responseText);
		let totalCnt = result.totalCount;
		let startPage, endPage; // 1~5, 6~10
		let next, prev;
		let realEnd = Math.ceil(totalCnt / 5);
		endPage = Math.ceil(page / 5) * 5;
		startPage = endPage - 4;
		endPage = endPage > realEnd ? realEnd : endPage;
		next = endPage < realEnd ? true : false;
		prev = startPage > 1;

		if (prev) {
			let aTag = document.createElement('a');
			//aTag.innerText = startPage - 1;
			aTag.innerHTML = '&laquo;'; // <<
			aTag.href = '#';
			aTag.setAttribute('data-page', startPage - 1)
			document.querySelector('div.pagination').appendChild(aTag);
		}
		for (let p = startPage; p <= endPage; p++) {
			let aTag = document.createElement('a');
			aTag.innerText = p;
			aTag.href = '#';
			aTag.setAttribute('data-page', p);
			if (p == page) {
				aTag.className = 'active';
			}
			document.querySelector('div.pagination').appendChild(aTag);
		}
		if (next) {
			let aTag = document.createElement('a');
			//aTag.innerText = endPage + 1;
			aTag.innerHTML = '&raquo;'; // >>
			aTag.href = '#';
			aTag.setAttribute('data-page', endPage + 1)
			document.querySelector('div.pagination').appendChild(aTag);
		}
		pagingFunc(); // 새로 생성된 a에 이벤트 등록.
	}
}
pageList();
