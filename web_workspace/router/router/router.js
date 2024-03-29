/* 
router는 get방식만 쓴다 

*/
//router.js
import HomeComponent from '../views/home.js';
import PostListComponent from '../views/postList.js';
import PostInfoComponent from '../views/postInfo.js';

const { createRouter, createWebHistory } = VueRouter

let routes = [
    {
        path:'/index.html', //정규식
        redirect: '/home'
    },
    {
        path:'/home',
        name:'home', //없어도 됨
        component: HomeComponent,
    },
    {
        path:'/postList',
        name:'postList',
        component: PostListComponent
    },
    {
        path:'/postInfo',
        name:'postInfo',
        component: PostInfoComponent
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;