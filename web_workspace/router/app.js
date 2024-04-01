import router from './router/router.js';
import HeaderComponent from './layouts/header.js';
import FooterComponent from './layouts/footer.js';


const {createApp} = Vue
/*
router-link=> router에 link걸기 => a태그로 변환 됨 to=> href로 전환
*/

let template=`
    <div>
        <HeaderComponent/>
        <router-view :key="$route.fullPath" /> <!--새로운 요청이 왔다면 같은 요청이여도 새로 열어 달라-->

        <FooterComponent/>
    </div>          
`;

createApp({
    template,
    components: {
        HeaderComponent,
        FooterComponent
    }
})
.use(router)
.mount('#app');