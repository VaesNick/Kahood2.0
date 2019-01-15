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
                    <button id="addGroupButton" @click="addGroup">Create new group</button>
                </th>
            </tr>
            </thead>
            <tbody>
            <template v-for="g in groups">
                <tr v-bind:key="g.id">
                    <td>{{g.name}}</td>
                    <td>{{g.spots}} free</td>
                    <td>
                        <button type="submit" @click="enroll($event)">Enroll</button>
                    </td>
                    <td>
                        <button type="submit" @click="showParticipants(g.id)">Participants</button>
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
                        <h3>Add group</h3>
                    </td>
                    <td>
                        <input class="closeButton" type="button" style="float:right;" @click="hideGroup" value="X"/>
                    </td>
                </tr>
                <tr>
                    <th>name</th>
                </tr>

                <template v-for="g in participantsOfSelectedGroup">
                    <tr v-bind:key="g.name">
                        <td>{{g.name}}</td>
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
                participantsOfSelectedGroup: [{name: "Jos"}, {name:"Bart"}],
                name: 'Groups',
                groups: [
                    {id: '1', name: 'Group 1', spots: '5', participants: [{name: "Jos"}, {name: "Fred"}]},
                    {id: '2', name: 'Group 2', spots: '5'},
                    {id: '3', name: 'Group 3', spots: '5'}]
            }
        },
        methods: {
            showParticipants(id) {
                this.selectedGroup = id;
                document.getElementById("usersInGroupTable").style.display = "inline";
            },
            enroll: function (e) {
                if ((e.currentTarget).innerText == "Enroll") {
                    (e.currentTarget).innerText = "Unroll";
                    this.participantsOfSelectedGroup.push({name: this.username});
                } else {
                    (e.currentTarget).innerText = "Enroll";
                }
            },
            addGroup() {
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
                var name = document.getElementById("groupNameText").value;
                var amountOfSpots = document.getElementById("amountOfFreeSpotsText").value;

                alert("new group with name: " + name + " and " + amountOfSpots + " amount of free spots.")
            },
            mounted() {

                var self = this;
                this.axios
                    .get('http://localhost:8080/course/' + this.$route.params.id)
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
