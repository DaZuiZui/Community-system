<!--
 * @Author: tianleiyu
 * @Date: 2023-10-29 10:33:58
 * @LastEditTime: 2023-12-04 15:35:13
 * @LastEditors: tianleiyu
 * @Description:
 * @FilePath: /community-ui/src/components/fream/LoginTop.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
    <div class="top">
        <div class="modal fade" tabindex="-1" role="dialog" id="modal-cookies" data-backdrop="false"
            aria-labelledby="modal-cookies" aria-hidden="true">
            <div class="modal-dialog modal-dialog-aside left-4 right-4 bottom-4">
                <div class="modal-content bg-dark-dark">
                    <div class="modal-body">
                        <!-- Text -->
                        <p class="text-sm text-white mb-3">
                            We use cookies so that our themes work for you. By using our website, you agree to our use of
                            cookies.
                        </p>
                        <!-- Buttons -->
                        <a class="btn btn-sm btn-white" target="_blank">Learn more</a>
                        <button type="button" class="btn btn-sm btn-primary mr-2" data-dismiss="modal">OK</button>
                    </div>
                </div>
            </div>
        </div>
        <a class="btn btn-block btn-dark text-truncate rounded-0 py-2 d-none d-lg-block"
            style="z-index: 1000;color:aliceblue" target="_blank">
            哈尔滨广厦学院 <strong>社团管理系统 </strong> 测试版本 v0.1
        </a>

        <div>
            <nav class="navbar navbar-expand-lg navbar-light bg-white">
                <div class="container">
                    <!-- Brand -->
                    <a class="navbar-brand item" href="/h">
                        <img alt="Image placeholder" style="height:3.4rem" src="#" id="navbar-logo">
                    </a>
                    <!-- 输入框
                    v-model="activeLikeToGetByTitleBo.title"将输入的数据进行保存
                    @input="searchInfo"数据进行模糊查询
                    -->
                    <el-input placeholder="请输入内容" v-if="isActive" v-model="activeLikeToGetByTitleBo.title"
                        @input="searchInfo" class="input-with-select item">
                        <el-button slot="append" icon="el-icon-search" @click="searchInfo"></el-button>
                    </el-input>

                    <router-link to="/ActivityManagement" v-else class="item">活动页面</router-link>



                    <!-- Toggler -->
                    <button class="navbar-toggler item" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                        aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>


                    <!-- Collapse -->

                </div>
                <div class="collapse navbar-collapse" id="navbarCollapse">

                    <ul class="navbar-nav mt-4 mt-lg-0 ml-auto" v-if="username != ''">
                        <el-dropdown>
                            <router-link to="/UserCenter">
                                <li class="nav-item ">
                                    {{ username }}
                                </li>
                            </router-link>
                            <el-dropdown-menu slot="dropdown">
                                <router-link to="/MessageLists">
                                    <el-dropdown-item>
                                        <el-badge :value="count">
                                            消息
                                        </el-badge>
                                    </el-dropdown-item>
                                </router-link>
                                <div @click="loginOut()">
                                    <el-dropdown-item>退出登陆</el-dropdown-item>
                                </div>
                            </el-dropdown-menu>
                        </el-dropdown>
                    </ul>

                    <ul class="navbar-nav mt-4 mt-lg-0 ml-auto" v-else>
                        <li class="nav-item ">
                            <a class="nav-link" href="#">Help </a>
                        </li>
                        <li class="nav-item ">
                            <router-link class="nav-link" to="/Login">登入 </router-link>
                        </li>
                        <li class="nav-item ">
                            <router-link class="nav-link" to="/UserReg">注册 </router-link>
                        </li>
                    </ul>


                </div>
            </nav>

            <div class="result" v-if="searchList.length > 0">
                <div class="result-item" v-for="(item, index) in searchList" :key="index">
                    <div @click="emitBus">{{ item.title }}</div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { synRequestPost, synRequestGet } from "../../../static/request"
export default {
    name: 'Foot',
    data() {
        return {
            username:"",
            // username: ,
            token: getCookie("token"),
            //登陆状态
            isLogin: false,
            //是否为活动面板
            isActive: false,
            //模糊查询
            activeLikeToGetByTitleBo: {
                token: "",
                title: '',
                status: 0,
                delFlag: 0
            },
            //查询
            searchList: [],
            messageList: [],
            count: 0,

            // //websockt
            // ws: {},


            // socket: null,

            // webSocketIp: "127.0.0.1",
            // webSocketPort: 8008,

        }
    },
    mounted() {
        this.username = JSON.parse(localStorage.getItem("user")).username ? JSON.parse(localStorage.getItem("user")).username : ''
        
    },
    //从MessageLists接收一个空的this.handleMessageListEmpty，
    created() {
        // this.isLoginInfo();
        this.isActiveInfo();
        // this.setupWebSocket();
        this.$bus.$on('messageListEmpty', this.handleMessageListEmpty);
    },
    methods: {

        // setupWebSocket() {
        //     // const contestId = 80; // 用于示例的contest_id
        //     // alert(this.getHashVariable("contestId"));
        //     this.socket = new WebSocket("ws://" + this.webSocketIp + ":" + this.webSocketPort + `/websocket/${this.token}`);
        //     console.log(this.socket);
            
        //     this.socket.onopen = () => {
        //         this.socketStatus = '已连接';
        //         console.log("oks");
        //         console.log(event);
        //     };

        //     this.socket.onmessage = (event) => {
        //         // console.log(event);
                 
        //         let obj = JSON.parse(event.data);
        //         console.log(obj);
        //     };

        //     this.socket.onclose = () => {
        //         this.socketStatus = '已关闭';
        //         console.log("close");
        //         this.setupWebSocket();
        //     };
        // },

        //判断是否为登陆
        // async isLoginInfo() {
            
        //     if (this.$route.path != "/Login" || this.$route.path != "/UserReg") {
        //         // console.log(111);
        //         var user = JSON.parse(localStorage.getItem("user"))
        //         if (user && user.username) {
        //             this.username = user.username;
        //             this.isLogin = true;
        //             // this.getMessageList()
        //         } else {
        //             this.$router.push("/Login");
        //             this.isLogin = false;
        //         }
        //     }
        // },
        //获取message List
        async getMessageList() {
            try {
                // 查询是否有消息
                let res = await synRequestPost(`/notice/select?token=${this.token}`);
                this.messageList = res.data.list;
                this.count = res.data.noReadCounts;
                // console.log(22222+this.messageList);
            } catch (error) {
                console.error('获取消息列表失败:', error);
            }
        },
        // 判断是否为活动面板
        isActiveInfo() {
            if (this.$route.path == '/ActivityManagement') {
                this.isActive = true;
            } else {
                this.isActive = false;
                this.activeLikeToGetByTitleBo.title = ''
                this.searchList = ''
            }
        },
        // 模糊查询
        async searchInfo() {
            this.activeLikeToGetByTitleBo.token = this.token;
            let obj = await synRequestPost("/activity/likeToGet", this.activeLikeToGetByTitleBo);
            if (obj.code == "0x200") {
                this.searchList = obj.data;

            }
        },
        //发送给searchList组件给ActivityManagement
        emitBus() {
            this.$bus.$emit('searchList', this.searchList);
            this.searchList = [];
        },
        //退出登陆的方法实现
        loginOut() {
            this.username = "";
            localStorage.removeItem('user')
            delCookie('token')
            this.$router.push('/Login');
        },
        //接收完空MessageLists，获取数据后在将其发送回MessageLists
        handleMessageListEmpty() {
            this.getMessageList().then(() => {

                if (this.messageList.length > 0) {
                    this.$bus.$emit('MessageList', this.messageList);
                }

            })
        }
    },
    watch: {
        '$route': 'isActiveInfo',
        // 'username': 'isLoginInfo'

    }
}

</script>

<style scoped>
.container {
    width: 100%;
    flex-wrap: nowrap;
}

.item {
    width: 33.333%;
}

/deep/ .el-input-group {
    width: 50%;
}

.ml-auto {
    margin-right: auto;
}
</style>
