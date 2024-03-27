//component.js
// 참고 주소(omponent의 옵션) => https://vuejs.org/api/

let component = {
    name: '',       // 컴포넌트 이름 지정 => 필수값 아님
    template:``,    // View          " ' " 가아니라 " ` "를 쓴다= 줄바꿈을 하기 위해
    data(){},       // Data : CRUD     프로퍼티 = 컴포넌트가 가진 데이터중에 하나 CRUD가능 CRUD= 셀렉트 크리에이트 업데이트 딜리트
    computed:{},    // Data : Read     자동연산하는 데이터
    methods :{},    // Code : 기능    함수를 무조건 이 안에서 생성해서 사용해야한다 외부 함수를 못 불러 들임
    watch: {},      //Data를 감시 -> 연속행위를 정의
    components: {}  //자식 컴포넌트들 추가   *루트 컴포넌트는 이게 꼭 필요함 *
};