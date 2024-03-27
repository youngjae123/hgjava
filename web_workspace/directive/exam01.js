//exam01.js => ModelComponent


let template = `
<div>
    <h1>자기소개</h1>
    <p>이름: <input type="text" v-model.lazy="myName" ></p><br>
    <label>좋아하는 색:
    <input type="radio" v-model="myColor" value="green" v-bind:disabled="myName.length == 0">초록</p>
    <input type="radio" v-model="myColor" value="red" v-bind:disabled="myName.length == 0">빨강
    <input type="radio" v-model="myColor" value="blue" v-bind:disabled="myName.length == 0">파랑
    </label>
    <p> 내 이름은 {{ myName }} 이고 좋아하는 색은 {{ myColor }} 입니다.</p>
</div>
`;

export default{
    template,
    data(){
        return{
            myName:'',
            myColor:''
        }
    }
}