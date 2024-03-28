//check.js

let ChildComponent = {
    template: `
        <div>
            <p> 숫자    : {{ num }} </p>
            <p> 문자열  : {{ str }} </p>
            <p> 짝수?    : {{ even }} </p> <!-- 계산안됨 -->
            <p> 객체    : {{ obj }} </p>
        </div>
    `,
    props: {
        num: {
            type: [Number, String],// 여러개일 경우 배열
            required: true // 필수값일경우 사용
        },
        str: {
            type: String,
            default: 'Hello!'// 문자열을 그대로 쓰겠다
        },
        even: {
            validator(value) {//유효성 검사하는 함수
                return (value % 2 == 0);
            }
        },
        //obj: Object 이렇게 사용가능
        obj: {
            type: Object,
            default: () => {
                return {
                    name: 'Hong',
                    age: 20
                }
            }
        }
    }
};

export default {
    template: `
    <div>
        <ChildComponent :num="myNumber" :str="sendMsg" :even="myNumber" />
        <hr>
        <ChildComponent :num="myNumber" :str="sendMsg" :even="myNumber" :obj="newObj"/>
    </div>
    `,
    data() {
        return {
            myNumber: 55,
            sendMsg: 'Hello, World!',
            newObj: null

        }
    },
    components: {
        ChildComponent
    }
}