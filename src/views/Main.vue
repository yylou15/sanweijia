<template>
    <div class="home">
        <Row>
            <Col span="4" class="logo-wrapper">
                <Icon type="logo-github" size="40"/>
                <span class="logo-text"><a href="https://github.com/yylou15" target="_blank"
                                           style="color: #464c5b!important;">By CSUers</a></span>
            </Col>
            <Col span="20" class="head-wrapper">
                <Row>
                    <Input class="head-search" size="large" search placeholder="搜索..."/>
                </Row>
            </Col>
        </Row>
        <Row>
            <Col span="4">
                <Menu :active-name="this.$route.name" :open-names='["菜单"]' class="menu" @change="changeView(this.activeName)">
                    <template v-for="(item,index) in menuItem">
                        <Submenu :name="item.name">
                            <template slot="title" class="menu-title">
                                <Icon :type="item.icon" :color="item.color"/>
                                <strong>{{item.name}}</strong>
                            </template>
                            <MenuItem :name="subItem.router" v-for="subItem in item.submenu" :to="subItem.router">
                                <Icon :type="subItem.icon"/>
                                {{subItem.name}}
                            </MenuItem>
                        </Submenu>
                    </template>
<!--                    <Submenu name="2">-->
<!--                        <template slot="title">-->
<!--                            <Icon type="md-radio-button-off" color="green"/>-->
<!--                            <strong>配置</strong>-->
<!--                        </template>-->
<!--                        <MenuItem name="2-1">-->
<!--                            <Icon type="ios-color-palette"/>-->
<!--                            主题-->
<!--                        </MenuItem>-->
<!--                        <MenuItem name="2-2">-->
<!--                            <Icon type="ios-happy"/>-->
<!--                            偏好-->
<!--                        </MenuItem>-->
<!--                        <MenuItem name="2-3">-->
<!--                            <Icon type="ios-analytics"/>-->
<!--                            数据-->
<!--                        </MenuItem>-->
<!--                    </Submenu>-->
                </Menu>
            </Col>
            <Col span="20" class="content-main">
                <router-view></router-view>
            </Col>
        </Row>
    </div>
</template>

<script>
    export default {
        name: 'common',
        components: {},
        data() {
            return {
                openNames:[]
            }
        },
        computed: {
            menuItem() {
                return this.$store.state.menuItem
            }
        },
        method: {
            changeView(a){
                console.log(a)

            }
        },
        beforeMount(){
        },
        mounted() {
            let menuItems = this.$store.state.menuItem;
            let arr = [];
            menuItems.forEach((item) => {
                item.submenu.forEach((subItem)=>{
                    if(subItem.router === this.$route.name){
                        arr = [item.name];
                    }
                })
            });
            this.openNames = arr;
            console.log(arr)
            console.log(this.$route)
        }
    }
</script>
<style scoped lang="less">
    .header {
        padding: 0;
        background-color: white;
    }

    .logo-wrapper {
        border-right: 1px #ccc solid;
        border-bottom: 1px #ccc solid;
        height: 75px;
        padding: 15px;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .head-wrapper {
        border-bottom: 1px #ccc solid;
        height: 75px;
        padding: 15px;
    }

    .menu {
        width: 100% !important;
        height: e("calc(100vh - 75px)")
    }

    .logo-text {
        font-weight: bold;
        font-size: 20px;
        margin-left: 5px;
    }

    .head-search {
        width: 500px;
        height: 100% !important;
    }

    .content-main {
        background-color: #eee;
        height: e("calc(100vh - 75px)")
    }
</style>
