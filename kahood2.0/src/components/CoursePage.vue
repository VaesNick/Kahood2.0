<template>
    <div id="container">
        <input type="hidden" id="idField" :value="$route.params.id">
        <h3 class="mt-4 mb-4 float-left">{{name}}</h3>

        <table class="table" id="employeeTable" data-show-toggle="false">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Amount of free spots</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <template v-for="g in groups">
                        <tr v-bind:key="g.id">
                            <td>{{g.name}}</td>
                            <td>{{g.spots}} free</td>
                            <td><button type="submit" @click="enroll($event)">Enroll</button></td>
                            <td><button type="submit" @click="showParticipants(g.id)">Participants</button></td>
                        </tr>
                </template>
            </tbody>
        </table>
        <div id="participantsField" type="text" style="display:none"></div>
    </div>
</template>

<script>
    export default {

        data() {
            return {
                name: 'Groups',
                groups: [
                    {id:'1', name: 'Group 1', spots: '5',participants: [{name:"Jos"}, {name:"Fred"}]},
                    {id:'2', name: 'Group 2', spots: '5'},
                    {id:'3', name: 'Group 3', spots: '5'}]
            }
        },
        methods: {
            showParticipants(id){
                var participantsField = document.getElementById("participantsField");
                participantsField.style.display = "block";

                for(var i = 0; i < this.groups.length; i++){

                    alert(this.groups[id - 1].id == id);
                    if(this.groups.id == id){
                        for (var j = 0; j < this.groups[id - 1].participants.length; j++){
                            participantsField.innerHTML += this.groups[id - 1].participants[j].name;
                        }
                    }
                }
            },
            enroll: function (e) {
                if((e.currentTarget).innerText == "Enroll"){
                    (e.currentTarget).innerText = "Unroll";
                } else{
                    (e.currentTarget).innerText = "Enroll";
                }
            },
            mounted() {
                var self = this;
                this.axios
                    .get('http://localhost:8080/students/getAllCourses')
                    .then(function (res) {
                        self.courseList = res.data;
                    })
            }
        }
    }


</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    #container {
        width: 80%;
        background-color: #FF99;
        display: inline-block;
    }

    h1 {
        margin: 0;
        padding: 0;
        color: white;
    }

    table{
        width: 90%;
        display: inline;
    }
    th {
        text-align: left;
    }
    td {
        text-align: left;
        padding-right: 10px;
    }

</style>
