<template>
    <div id="container">
        <div id="LoggedInAs">Logged in as {{username}}</div>
        <div id="backButton"><router-link :to="{ name: 'LandingsPage'}">&#8617;</router-link></div>

        <h3 class="mt-4 mb-4">{{name}}</h3>

        <table class="table" id="employeeTable" data-show-toggle="false">
            <thead>
            <tr>
                <th>Name</th>
                <th>Amount of free spots</th>
                <th></th>
                <th>
                    <button id="addGroupButton" @click="openGroupForm">Create new group</button>
                </th>
            </tr>
            </thead>
            <tbody>
            <template v-for="t in teamList">
                <tr v-bind:key="t.id">
                    <td>{{t.teamName}}</td>
                    <td>{{t.maxTeamSize}} free</td>
                    <td>
                        <button type="submit" @click="enroll($event, t.id)">Enroll</button>
                    </td>
                    <td>
                        <button type="submit" @click="showParticipants(t.id)">Participants</button>
                    </td>
                </tr>
            </template>
            </tbody>
        </table>

        <form id="addGroupForm" class="hiddenOnLoad">
            <table>
                <tr>
                    <td>
                        <h3>Add group</h3>
                    </td>
                    <td>
                        <input class="closeButton" type="button" style="float:right;" @click="hideForm" value="X"/>
                    </td>
                </tr>
                <tr>
                    <td><label name="groupNameLabel">Group name:</label></td>
                    <td><input type="text" id="groupNameText"/></td>
                </tr>
                <tr>
                    <td><label name="amountOfFreeSpotsLabel">Amount of free spots:</label></td>
                    <td><input type="text" id="amountOfFreeSpotsText"/></td>
                </tr>
                <tr>
                    <td>
                        <button type="submit" @click="createNewGroup">ADD</button>
                    </td>
                </tr>
            </table>
        </form>

        <form>
            <table id="usersInGroupTable" class="hiddenOnLoad">
                <tr>
                    <td>
                        <h3>Participants</h3>
                    </td>
                    <td>
                        <input class="closeButton" type="button" style="float:right;" @click="hideGroup" value="X"/>
                    </td>
                </tr>
                <tr>
                    <th>Student ID</th>
                </tr>

                <template v-for="tl in teamMemberList">
                    <tr v-bind:key="tl.id">
                        <td>studentId: {{tl.studentId}}</td>
                    </tr>
                </template>
            </table>
        </form>
    </div>
</template>

<script>
    export default {

        data() {
            return {
                id: this.$route.params.id,
                username: this.$route.params.username,
                selectedGroup: '',
                participantsOfSelectedGroup: [{name: "Jos"}, {name: "Bart"}],
                name: 'Groups',
                teamList: [],
                teamMemberList: [],
            }
        },
        methods: {
            showParticipants(id) {

                this.selectedGroup = id;
                var self = this;
                this.axios
                    .get('http://localhost:8080/teamStudent/' + this.selectedGroup)
                    .then(function (res) {
                        self.teamMemberList = res.data;
                    })
                document.getElementById("usersInGroupTable").style.display = "block";

            },
            enroll: function (e, id) {
                if ((e.currentTarget).innerText == "Enroll") {
                    (e.currentTarget).innerText = "Unroll";
                    var self = this;
                    this.axios
                        .post('http://localhost:8080/teamStudent/' + id + "/99999" )
                        .then(function (res) {
                            self.teamMemberList = res.data;
                        })
                } else {
                    (e.currentTarget).innerText = "Enroll";
                }
            },
            openGroupForm() {
                document.getElementById("addGroupForm").style.display = "inline";
            },
            hideForm(){
                document.getElementById("groupNameText").value="";
                document.getElementById("amountOfFreeSpotsText").value="";
                document.getElementById("addGroupForm").style.display = "none";
            },
            hideGroup(){
                document.getElementById("usersInGroupTable").style.display = "none";
            },
            createNewGroup(){
                let groupname = document.getElementById("groupNameText").value;
                let amountOfFreeSpots = document.getElementById("amountOfFreeSpotsText").value;
                var team = {"courseId": this.id,"teamName": groupname, "maxTeamSize": amountOfFreeSpots};
                var self = this;
                this.axios
                    .post('http://localhost:8080/team', team)
                    .then(function (res) {
                        self.teamMemberList = res.data;
                    })
            },
        },
        mounted() {

            var self = this;
            this.axios
                .get('http://localhost:8080/course/team/' + this.$route.params.id)
                .then(function (res) {
                    self.teamList = res.data;
                })
        }
    }


</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    #usersInGroupTable{
        margin-left: auto;
        margin-right: auto;
    }

    #container {
        width: 80%;
        background-color: #FF99;
        display: block;
        margin-left: auto;
        margin-right: auto;
    }
    .hiddenOnLoad{
        display: none;
    }

    #LoggedInAs{
        float: left;
        font-size: 14px;
    }
    #backButton{
        float: right;
    }
    #backButton a{
        text-decoration: none;
        color: black;
    }

    .closeButton{
        border-radius: 10px;
    }

    .closeButton:hover{
        background-color: red;
    }

    h1 {
        margin: 0;
        padding: 0;
        color: white;
    }

    table {
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
