/**
 * 
 */
console.log('center.js')

let url = 'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=I4Tmn89XDY5ivDYDROK1VgjBsMm%2FgNc3jUrYvnhaF64YrzhIggYK7TvzHMBCVPiA3F%2BFzANXJSOwkzWrB2bxYg%3D%3D'

let showFields = ['id','centerName', 'phoneNumber','sido'];
let tbody = document.querySelector('#list');
fetch(url)
.then(resolve => resolve.json())
.then(result =>{
	console.log(result.data[0]);
	result.data.forEach(center => {
		let tr = document.createElement('tr');
		showFields.forEach(field => {
			let td = document.createElement('td');
			if(field == 'centerName'){
			td.innerText = center[field].substring('코로나19 '.length);
			} else{
				td.innerText=center[field];
			}
			tr.append(td);
		})
		tbody.append(tr);
	})
})
.catch(err => console.log(err));

// 조회이벤트 처리
document.querySelector('#searchBtn').addEventListener('click', searchFnc);
 async function searchFnc(e) {
	 
 let search = document.querySelector('sido').value;
 if(!search) {
	 alert('입력xx');
	 return;
 }
 
 fetch(search)
 .then(resolve => resolve.json())
 .then(result =>{
	 
 })
 
} 