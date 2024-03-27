//exam02.js => Forcomponent

let template =`
<div>
    <div>
         
        <p v-for="num in 5" :key="num">
            <span v-for="star in num" :key="num">
            *
            </span>
        </p>    
        
        <!--
        <p v-for="star in stars" >
        {{star.star}}
        </p>
        -->
    </div>
    <div>
        <div v-for="dan in 9" :key="dan">
            <p v-for="num in 9" :key="num">
                {{ dan }} X {{ num }} = {{ dan * num}}
            </p>
        </div>
    </div>
</div>
`;

export default{
    template,
    data(){
        return{

            stars:[
                {
                    star:'*'
                },
                {
                    star:'**'
                },
                {
                    star:'***'
                },
                {
                    star:'****'
                }
            ]

        }
    }
}