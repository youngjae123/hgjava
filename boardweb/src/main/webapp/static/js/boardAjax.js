/**
 * boardAjax.js 
 */

const service = {
	// 댓글목록(5개씩 보여주는)
	replyList(param = { bno: 1, page: 1 }, successCall, errorCall) {
		$.ajax({
			url: 'replyList.do',
			method: 'get',
			data: param,
			dataType: 'json'
		})
			.done(successCall)
			.fail(errorCall)
	},
	// 페이징 목록
	pageList(bno = 1, successCall, errorCall) {
		$.ajax({
			url: 'getTotal.do?bno=' + bno,
			method: 'get',
			dataType: 'json'
		})
			.done(successCall)
			.fail(errorCall)
	},
	//삭제
	removeReply(rno = 1, successCall, errorCall) {
		$.ajax({
			url: 'removeReply.do',
			method: 'post',
			data: { rno }
		})
			.done(successCall)
			.fail(errorCall)
	},
	//등록
	addReply(param = { bno, replyer, reply}, successCall, errorCall){
		$.ajax({
			url:'addReply.do',
			method:'post',
			data: param
		})
		.done(successCall)
		.fail(errorCall)
	}
}
export default service;
