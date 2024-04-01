//postForm.js

let template = `
<div>
    <table>
         <tr>
             <th>id</th>
             <td><input type="text" v-model="post.id" readonly></td>
         </tr>
         <tr>
             <th>title</th>
             <td><input type="text" v-model="post.title"></td>
         </tr>
         <tr>
             <th>userId</th>
             <td><input type="text" v-model="post.userId"></td>
         </tr>
         <tr>
             <th>body</th>
             <td>
                 <textarea v-model="post.body" />
             </td>
         </tr>
         <tr>
            <button type="button" @click="isUpdated ? updatePostInfo() : createPostInfo()">저장</button>
         </tr>
    </table>
 </div>
`;

export default{
    template,
    data(){
        return{
            post:{
                id:'',
                title:'',
                userId:'',
                body:''
            },
            isUpdated: false
        }
    },
    created(){
        let id =  this.$route.query.id;
        if(id >0){
            this.getPostInfo(id);
            this.isUpdated = true;
        }
    },
    methods:{
        async getPostInfo(id){
            this.post = await fetch('https://jsonplaceholder.typicode.com/posts/'+id)
                                .then(res => res.json())
                                .catch(err => console.log(err));
        },
        createPostInfo(){
            let data = {
                title: this.post.title,
                body: this.post.body,
                userId: this.post.userId
            }

            fetch('https://jsonplaceholder.typicode.com/posts',{
                method:'post',
                headers: {
                    'content-type' : 'application/json'
                },
                body:JSON.stringify(data)
            })
            .then(res => res.json())
            .then(data => {
                if(data != null){
                    alert('정상적으로 저장되었습니다.');
                    this.post.id = data.id;
                }else{
                    alert('저장되지 않았습니다.\n 데이터를 확인해 주세요.');
                }
            })
            .catch(err => console.log(err));
        }
        ,updatePostInfo(){
            let data = {
                id: this.post.id,
                title: this.post.title,
                body: this.post.body,
                userId: this.post.userId
            }

            fetch('https://jsonplaceholder.typicode.com/posts/'+data.id,{
                method:'put',
                headers: {
                    'content-type' : 'application/json'
                },
                body:JSON.stringify(data)
            })
            .then(res => res.json())
            .then(data => {
                if(data != null){
                    alert('정상적으로 수정되었습니다.');
                }else{
                    alert('수정되지 않았습니다.\n 데이터를 확인해 주세요.');
                }
            })
            .catch(err => console.log(err));
        }
    }
}