//app.js
// => Root Component 를 가지는 놈
import RawComponent from './raw.js'; // export 해온 값의 이름?
import InputComponent from './input.js';
import ModelComponent from './exam01.js';
import ListComponent from './list.js';
import Forcomponent from './exam02.js';
import Ifcomponent from './if.js';
import Eventcomponent from './event.js';
import Watchcomponent from './watch.js';

const { createApp } = Vue

const template = `
<div>
  <!-- 자식 컴포넌트 추가 -->
  <!--<raw-component/>-->
  <!-- <RawComponent/> -->

  <!--0327-->
  <!-- <InputComponent /> -->
  <!--<ModelComponent />-->
  <!--<ListComponent />-->
  <!--<Forcomponent />-->
  <!--<Ifcomponent />-->

  <!--0328-->
  <!--<Eventcomponent />-->

  <Watchcomponent />
</div>
`;

createApp({
  template,
  components: {
    RawComponent, // 'raw-component' :RawComponent
    InputComponent,
    ModelComponent,
    ListComponent,
    Forcomponent,
    Ifcomponent,
    Eventcomponent,
    Watchcomponent
  }
})
  .mount('#app');