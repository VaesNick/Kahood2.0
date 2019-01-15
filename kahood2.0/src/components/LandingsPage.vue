<template>

    <div id="container">
        <h3 class="mt-4 mb-4 float-left">{{name}}</h3>
        <isTypingIcon></isTypingIcon>
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
                        <td>{{c.name}}</td>
                        <td>{{c.credits}}</td>
                        <td>{{c.teacher}}</td>
                        <td><button type="submit" @click="openCourse(c.id)">Groups</button></td>
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
                courseList: [
                    {
                        id:'1',
                        name: 'Software engineering',
                        credits: '1',
                        teacher: 'Jos De Vroeg',
                    },
                    {
                        id:'2',
                        name: 'Software engineerin',
                        credits: '1',
                        teacher: 'Jos De Vroeg',
                    },
                    {
                        id:'3',
                        name: 'Software engineerg',
                        credits: '1',
                        teacher: 'Jos De Vroeg',
                    }
                ],
                coursesTableHeads:
                    {
                        first_name: 'First name',
                        last_name: 'Last name',
                        building: 'Building',
                        floor: 'Floor',
                        company: 'Company',
                        job: 'Job',
                    }

            }
        },
        methods: {
            openCourse(id) {
                window.location.href = "http://localhost:8081/course/" + id;
                //alert(id)
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
