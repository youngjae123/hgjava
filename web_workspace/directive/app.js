//app.js
// => Root Component 를 가기는 놈
import RawComponent from './raw.js'; // export 해온 값의 이름?
const { createApp } = Vue

const template =`
<div>
  <!-- 자식 컴포넌트 추가 -->
  <raw-component/>
</div>
`;

createApp({
    template,
    components: {
        RawComponent // 'raw-component' :RawComponent
    }
})
.mount('#app');