<template>

    <div id="container">
        <div id="LoggedInAs">Logged in as {{username}}</div>
        <div id="backButton"><router-link :to="{ name: 'LandingsPage'}">&#8617;</router-link></div>
        <h3 class="mt-4 mb-4 float-left">{{name}}</h3>
        <table class="table" id="employeeTable" data-show-toggle="false">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Credits</th>
                    <th>Teacher</th>
                </tr>
            </thead>
            <tbody>
                <template v-for="c in courseList">
                    <tr v-bind:key="c.id">
                        <td>{{c.courseName}}</td>
                        <td>{{c.maxTeams}}</td>
                        <td><button><router-link :to="{ name: 'CoursePage', params: {id: c.id, username }}">Groups</router-link></button></td>
                        <td>


                        </td>
                    </tr>
                </template>
            </tbody>
        </table>
    </div>
</template>

<script>
    export default {

        data() {
            return {
                name: 'Courses',
                username: "Jos",
                courseList: [],
            }
        },
        methods: {

        },
        mounted() {
            var self = this;
            this.axios
                .get('http://localhost:8080/course')
                .then(function (res) {
                    self.courseList = res.data;
                })
        }
    }


</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    #LoggedInAs{
        float: left;
        font-size: 14px;
    }
    #backButton{
        float: right;
    }
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
