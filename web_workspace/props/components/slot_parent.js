//slot_parent.js
import CildComponent from './slot_child.js';

let template=`
<div>
    <CildComponent>
        <template v-slot:title >
            <h1>팝업 타이틀</h1>
        </template>
           <!-- <p>다른 내용</P>  적용 안됨-->
        <template v-slot:content >
            <p>팝업 컨텐츠1</p>
            <p>팝업 컨텐츠2</p>
        </template>
        <template v-slot:default >
            <button type="button">닫기</button>
        </template>
    </CildComponent>

    <hr>
    <CildComponent>
    <template v-slot:title >
        <h1>Info</h1>
    </template>
    <template v-slot:content >
    <p>sevice</p>
     <input type="radio" v-model="select" value="A"> A 유형 <br>
     <input type="radio" v-model="select" value="B">  유형 <br>
    </template>
    <template v-slot:default >
        <button type="button">완료</button>
    </template>
</CildComponent>
</div>

`;

export default{
    template,
    data(){
        return{
            select:''
        }
    },
    components:{
        CildComponent
    }
}