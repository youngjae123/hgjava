//header.js

let template = `
<header>
    <!--<router-link to="/home">Home</router-link><br>-->
    <router-link :to="{ path: '/home'}">Home</router-link><br>
    ||<router-link :to="{ name: 'postList'}">전체조회</router-link><br>
    ||<router-link :to="{ name: 'postForm'}"> 등록 </router-link><br>
</header>
`;

export default {
    template,
    name: 'header',

}