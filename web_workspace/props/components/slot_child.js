//sol_child.js

let template =`
<div>
    <h1>고정 데이터1</h1>
    <header>
        <slot name="title"></slot>
    </header>
    <main>
        <slot name="content"></slot>
    </main>
    <footer>
        <slot></slot>
    </footer>
</div>
`;

export default{
    template,
    data(){
        return{

        }
    }
}