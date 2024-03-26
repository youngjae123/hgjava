//typicode_vue.js
//https://ko.vuejs.org/ options(객체 방식)로 할것 /conposition(함수형으로 쓰는거) 안씀 
//crom에서 웹스토어 vew.dev검색 추가 확장프로그램 고정시키기
const { createApp } = Vue

let template =`
<div>
    <table>
        <thead>
            <tr>
                <th>id</th>
                <th>title</th>
                <th>userId</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(post, idx) in postList" :key="idx"
                v-on:click="getPostInfo(post.id)">
                <td>{{post.id}}</td>
                <td>{{post.title}}</td>
                <td>{{post.userId}}</td>
            </tr>
        </tbody>
    </table>
</div>
`;

createApp({
  template, // template: template
  data() {
    return {
      postList : []
    }
  },
  created(){
    this.getPostList();
  },
  methods : {
    async getPostList(){
        this.postList = await fetch('https://jsonplaceholder.typicode.com/posts')
                              .then(res => res.json());
    },
    getPostInfo(id){
        fetch('https://jsonplaceholder.typicode.com/posts/'+id)
        .then(res => res.json())
        .then(data =>{
            console.log(data);
        });
    }
  }
}).mount('#list')