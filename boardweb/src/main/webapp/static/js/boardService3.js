/**
 * boardService3.js
 */

import service from './boardAjax.js'; 

let page = 1;
// 댓굴 목록 5건 출력.
service.replyList({ bno: bno, page: page },
	replyListCall,// 인자값 1
	//   function(err){
	//	   console.log('error=> ', err);
	//   }
	err => console.log('error=> ', err)
);

//5개씩 출력
function replyListCall(result) {
	let ul = $('.content>ul');
	// 기존목록 삭제.
	$('.content>ul>li:gt(1)').remove();

	console.log(result);
	//	boardService.js => let clon = document.querySelector('.content>ul>li:nth-of-type(1)').cloneNode(true);
	$(result).each(function(idx, item) {//.each = forEach == 반복문
		let clon = $('.content>ul>li').eq(0).clone()// .eq = nth-of-type(1) == 몇번째 순서에 있는걸 가져온다 / .clone == 복사
		let delBtn = $('<button>삭제</button>');
		//		delBtn.on
		// 삭제
		delBtn.click(function(e) {
			service.removeReply(item.replyNo,
				function(result) {
					if (result.retCode == 'OK') {
						alert('삭제 완료')
						service.replyList({ bno: bno, page: page },
							replyListCall,// 인자값 1
							err => console.log('error=> ', err)
						)
					} else {
						alert('삭제 실패');
					}
				},
				err => console.log('error=> ', err)
			)
		});


		clon.find('span:eq(0)').text(item.replyNo);  //find == .앞에거에 하위요소를 찾아온다 / text ==  값을 넣어준다
		clon.find('span:eq(1)').text(item.reply);
		clon.find('span:eq(2)').text(item.replyer);
		clon.find('span:eq(3)').html($(delBtn));
		ul.append(clon);
	});
	// 페이지 리스트 생성.
	service.pageList(bno,
		createPageElement,
		err => console.log('error=> ', err)
	)
}

// 페이지 목록 출력.
service.pageList(bno,
	//	function(result) {
	//		console.log(result);

	//	},
	createPageElement,
	err => console.log('error=> ', err)
)

function createPageElement(result) {
	// 기존 페이지 삭제.
	//		document.querySelector('div.pagination').innerHTML = '';
	let pagination = $('div.pagination');
	pagination.html('');

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
		//			let aTag = document.createElement('a');
		//			aTag.innerHTML = '&laquo;'; // <<
		//			aTag.href = '#';
		//			aTag.setAttribute('data-page', startPage - 1)
		//			document.querySelector('div.pagination').appendChild(aTag);
		$('<a />').attr('href', '#').attr('data-page', startPage - 1).html('&laquo;').appendTo(pagination);// Attribute = attr
	}
	for (let p = startPage; p <= endPage; p++) {
		//			let aTag = document.createElement('a');
		//			aTag.innerText = p;
		//			aTag.href = '#';
		//			aTag.setAttribute('data-page', p);
		let aTag = $('<a />').attr('href', '#').attr('data-page', p).html(p).appendTo(pagination);

		//			if (p == page) {
		//				aTag.className = 'active';
		//			}
		//			document.querySelector('div.pagination').appendChild(aTag);
		if (p == page) {
			aTag.addClass('active');
		}
	}
	if (next) {
		//			let aTag = document.createElement('a');
		//			aTag.innerHTML = '&raquo;'; // >>
		//			aTag.href = '#';
		//			aTag.setAttribute('data-page', endPage + 1)
		//			document.querySelector('div.pagination').appendChild(aTag);

		$('<a />').attr('href', '#').attr('data-page', endPage + 1).html('&raquo;').appendTo(pagination);
	}
}

// 페이지 이동.
$('.pagination').on('click', 'a', function(e) {
	page = $(this).data('page');
	service.replyList({ bno: bno, page: page },
		replyListCall,
		err => console.log('error=> ', err)
	);
})


// 등록
//let addBtn = $('<button>댓글등록</button>')
$('.addReply').click(function(e) {
	let reply = $('#reply').val();
	service.addReply({ bno, replyer, reply },
		function(result) {
			if (result.retCode == 'OK') {
				alert("등록 성공")
				//$('.content>ul').append('<li>').append('<span>').text(bno, replyer, reply);
				// 마지막 페이지로 이동 후 목록 보여주기.
				service.pageList(bno,
					result => {
						page = Math.ceil(result.totalCount / 5);
						service.replyList({ bno: bno, page: page },
							replyListCall,// 인자값 1
							err => console.log('error=> ', err)
						);
					})
			} else {
				alert('등록 실패');
			}
		}
	)
})










