//ref_parent.js
import ChildComponent from './ref_child.js';

let template = `
    <div>
        <ChildComponent ref="child" />
        <hr>
        <ChildComponent ref="second" />
        <hr>
        <button type="button" @click="changeChildDate">
            Change Child Data
        </button>
        <hr>
        <button type="button" @click="clickChildEvent">
            Child Click Event
        </button>
        <hr>
        <button type="button" @click="executeChildFun">
            Child Method Excute
        </button>
        <p> {{ msg }} </p>
    </div>
`;

export default {
    template,
    data(){
        return{
            isMounted:false
        }
    },
    mounted(){
        this.isMounted=true;
    },
     computed:{
         msg(){
             return !this.isMounted ? '' : this.$refs.child.msg;
         }
     },
    methods: {
        
        changeChildDate(){
            console.log(this.$refs);
            //console.log(this.$refs.child);

            this.$refs.child.msg = 'Data Update';
            this.$refs.second.msg = 'second Update';
            
        },
        clickChildEvent(){
            // let childCom=this.$refs.child;
            // let childBtn=childCom.$refs.btn;
            // console.log(childBtn);
            // childBtn.click();

            this.$refs.child.$refs.btn.click();
        },
        executeChildFun(){
            this.$refs.child.childFunc();

        }
    },
    components: {
        ChildComponent
    }
}