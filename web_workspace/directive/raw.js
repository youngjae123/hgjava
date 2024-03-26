let template = `
<div>
    <p v-text="'Hello, '+ title + ((new Date()).getFullYear())"/>
    <p>Hello, {{ title + ' plus!!'}}! Today is ...</p>
    <!-- bind 디렉티브 -->
    <P v-bind:id="postId" 
        name="temp" 
        text="Testing"/>
        <img v-bind:src="fileName">
        <a v-bind:href="url">링크</a>
        <!-- bind 디렉티브 - style -->
        <p style="color : blue;">문자색 직접 지정</p>
        <p v-bind:style="{ color : myColor}">vue방식</p>
        <p style="color : blue; font-size : 200%;">
        두가지 속성을 직접 지정</p>
        <p v-bind:style="{ color : myColor, fontSize : myFont }">vue 방식</p>
        <p v-bind:style="myStyle">Vue 방식</p>
</div>
`;
//뷰가 자신들을 다루는 데이터 == 프로퍼티
export default{
    template,
    data(){
        return{//프로퍼티
            title:'Vue.js' ,
            postId:'raw',
            fileName:'2.jpg',
            url:'http://www.naver.com',
            myColor:'blue',
            myFont:'100px',
            myStyle:{
                color : 'green',
                fontSize : '200%'
            }  //style은 반드시 객체타입
        }
    }
}