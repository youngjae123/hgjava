import router from './router/router.js';

const {createApp} = Vue
/*
router-link=> router에 link걸기 => a태그로 변환 됨 to=> href로 전환
*/

let template=`
    <div>
        <router-link to="/home">Home</router-link><br>
        <router-link :to="{ path: '/home'}">Home2</router-link><br>
        ||<router-link :to="{ name: 'postList'}">전체조회</router-link><br>
        <router-link :to="{ name: 'postInfo'}">단권조회</router-link><br>

        <router-view :key="$route.fullPath" /> <!--새로운 요청이 왔다면 같은 요청이여도 새로 열어 달라-->
    </div>
`;

createApp({
    template
})
.use(router)
.mount('#app');