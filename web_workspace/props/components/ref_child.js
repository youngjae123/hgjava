//ref_child.js

let template=`
<div>
<button id="cBtn"
        type="button" 
        @click="childClick()" 
        ref="btn">
    Click
</button>
<p> {{ msg }}</p>
</div>
`;

export default{
    template,
    data(){
        return{
            msg:''
        }
    },
    mounted(){
        this.$refs.btn.click();
    },
    methods : {
        childClick(){
            console.log('click 이벤트가 발생');
        },
        childFunc(){
            console.log('child methods가 실행')
        }
    }

}