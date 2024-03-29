/*
    라우팅(Routing) :특정 엔드 포인트에 대한 클라이언트 요청에 애플리케이션이 응답하는 방법을 결정하는 것
                    (엔드포인트= 메소드(Method) + 경로(Path))

    -메소드(Method)-Get,Post
    단건조회    : GET   + empInfoo?employeeId=100
    전체조회    : GET   + empList 
    등록        : POST + empInsert
    수정        : POST + empUpdate
    삭제        : GET  + empDelete?employeeId=100


    REST  (Restfull Server)
    = URI(접근하고자 하는 자원) + Method(내가 하고자하는 기능) / JSON
    REST에서 사용하는 Method => GET(조회), POST(등록), PUT(수정), DELETE(삭제)

    단건조회    : GET       + emps/100
    전체조회    : GET       + emps
    등록        : POST      + emps
    수정        : PUT       + emps/100 (post 변형 body 필요)
    삭제        : DELETE    + emps/100 (get 변형 body X)
    
    
*/ 

//https://jsonplaceholder.typicode.com/posts
//전체조회

fetch('https://jsonplaceholder.typicode.com/posts')
.then(response => {
    console.log(response);
    return response.json();
})
.then(data => {
    console.log(data);
})
.catch(err => console.log(err));

/*
$.ajax('https://jsonplaceholder.typicode.com/posts')
.done(data => {
    consol.log(data);
})
.fail(err => console.log(err));
*/

//단건 조회
fetch('https://jsonplaceholder.typicode.com/posts/'+1)
.then(res => res.json())
.then(data => {
    console.log(data);
})
.catch(err => console.log(err));

//등록 JSON: {}, []
let post ={
    id:100,
    title: 'Hello!!',
    userId: 10,
    body: 'Today is Friday!!!'
}

fetch('https://jsonplaceholder.typicode.com/posts/',{
    method:'post',
    headers :{
        'Content-type': 'application/json'
    },
    body: JSON.stringify(post)
})
.then(res => res.json())
.then(data => {
    console.log(data);

})
.catch(err => console.log(err));

//수정
fetch('https://jsonplaceholder.typicode.com/posts/'+1,{
    method:'put',
    headers :{
        'Content-type': 'application/json'
    },
    body: JSON.stringify({
        title:'Welecome',
        userId: 20,
        body: 'Test!'
    })
})
.then(res => res.json())
.then(data => {
    console.log(data);

})
.catch(err => console.log(err));

//삭제
fetch('https://jsonplaceholder.typicode.com/posts/'+1,{
    method:'delete'
})
.then(res => res.json())
.then(data => {
    console.log(data);
})
.catch(err => console.log(err));

