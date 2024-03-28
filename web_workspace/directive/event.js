//event.js

let template = `
<div>
    <button type="button" v-on:click="upCounter(), printMsg($event)">Add 1</button><br>
    <button type="button" v-on:click="dCounter">Add -1</button>
    <p> The counter is : {{ counter }}</p>
    <hr>

    <input type="number" v-model="num">
    <button type="button" v-on:click="increseCounter(num), printMsg($event)">Add {{ num }}</button><br>
    <input type="number" v-model="dnum">
    <button type="button" v-on:click="disCounter(dnum), printMsg($event)">Add -{{ dnum }}</button><br>
    <p> The counter is : {{ sum }}</p>
    <hr>

    <!-- .prevent 이벤트 제어-->
    .prevent 이벤트 제어
    <form style="border: 1px solid black;" v-on:click="showAlert('from')">
        <div v-on:click="showAlert('div')">
            <p style="border: 1px solid black;"  v-on:click="showAlert('p')">
                <a v-on:click.prevent href="http://www.naver.com">네이버</a>
            </p>
            click div tag
        </div>
    </form>

    <!-- .stop  버블링 제어-->
    <hr>
    .stop 버블링 제어
    <form style="border: 1px solid black;" v-on:click="showAlert('from')">
        <div v-on:click="showAlert('div')">
            <p style="border: 1px solid black;"  v-on:click="showAlert('p')">
                <a v-on:click.stop href="http://www.naver.com">네이버</a>
            </p>
            click div tag
        </div>
    </form>

    <!-- .self -->
    <hr>
    .self
    <form style="border: 1px solid black;" v-on:click="showAlert('from')">
        <div v-on:click.self="showAlert('div')">
            <p style="border: 1px solid black;"  v-on:click.self="showAlert('p')">
                <a  href="http://www.naver.com">네이버</a>
            </p>
            click div tag
        </div>
    </form>

    <!-- .once -->
    <hr>
    .once
    <form style="border: 1px solid black;" v-on:click="showAlert('from')">
        <div v-on:click.self="showAlert('div')">
            <p style="border: 1px solid black;"  v-on:click.once="showAlert('p')">
                <a v-on:click.prevent href="http://www.naver.com">네이버</a>
            </p>
            click div tag
        </div>
    </form>

    <hr>
    <input type="text" v-model="keyword" v-on:keyup.enter="showAlert(keyword)">

</div>
`;

export default {
    template,
    data() {
        return {
            counter: 0,
            num: 0,
            sum: 0,
            dnum: 0,
            keyword:''
        }
    },
    methods: {
        upCounter(data) {
            console.log(data);
            this.counter += 1;
        },
        dCounter(data) {
            console.log(data);
            this.counter -= 1;
        },
        printMsg(event) {
            console.log(event);
        },
        increseCounter(num) {
            this.sum += num;
        },
        disCounter(data) {
            this.sum -= data;
        },
        showAlert(tag) {
            alert('click ' + tag);
        }

    }
}