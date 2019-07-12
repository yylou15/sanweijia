<template>
    <div class="main-wrapper">
        <Row v-show="showLoading" class="content-loading" >
            <Spin size="large"></Spin>
            &nbsp;&nbsp;
            <h2> 拉取数据中...</h2>
        </Row>
        <Row v-show="!showLoading" class="content-loading">
            <h2>共获取到{{this.list.length}}条数据</h2>
<!--            <Button class="detail" type="primary" @click="ifShowDrawer = true">详情</Button>-->
<!--            <Drawer title="详情" :closable="false" v-model="ifShowDrawer" width="700">-->
<!--                <Table :columns="tableColumns" :data="list"></Table>-->
<!--            </Drawer>-->
        </Row>
        <br><br>
        <Row class="content-row">
            <Col span="10">
                <div id="totalPriceRank">

                </div>
            </Col>
            <Col span="10">
                <div id="unitPriceRank">

                </div>
            </Col>
        </Row>
        <Row class="content-row">
        </Row>
        <Row class="content-row">
        </Row>
    </div>
</template>

<script>
    import axios from 'axios'
    import echarts from 'echarts'
    export default {
        name: "graph",
        data(){
            return{
                showLoading: false,
                ifShowDrawer: false,
                list:[],
                tableColumns:[
                    {title:"名称",key:"name",width:200,},
                    {title:"售价(万元)",key:"totalPrice",width:150},
                    {title:"单价(元/m2)",key:"unitPrice",width:150},
                    {title:"地址",key:"address",width:200}
                ],
                graphOptions:[

                ],
                groupByRegionTotalPrice:[],
                groupByRegionUnitPrice:[]
            }
        },
        mounted(){
            this.showLoading = true;
            axios.get("//localhost:8081/house/info").then((res)=>{
                this.list = res.data;
                this.showLoading = false
            })
            axios.get("//localhost:8081/house/groupByRegion").then((res)=>{
                let totalPriceRank = echarts.init(document.getElementById('totalPriceRank'));

                let cities= [];
                res.data.sort((a,b)=>{
                   return -(a.maxTotalPrice - b.maxTotalPrice)
                });
                res.data.forEach((item)=>{
                    this.groupByRegionTotalPrice.push([
                        item.minTotalPrice,item.maxTotalPrice,item.totalPrice,
                    ]);
                    cities.push(item.region)
                });
                let data = this.groupByRegionTotalPrice;
                var barHeight = 50;
                totalPriceRank.setOption({
                    title: {
                        text: '长沙二手房均价',
                        subtext: '单位：万元'
                    },
                    legend: {
                        show: true,
                        data: ['价格范围', '均值']
                    },
                    grid: {
                        top: 100
                    },
                    angleAxis: {
                        type: 'category',
                        data: cities
                    },
                    tooltip: {
                        show: true,
                        formatter: function (params) {
                            var id = params.dataIndex;
                            return cities[id] + '<br>最低：' + data[id][0] + '<br>最高：' + data[id][1] + '<br>平均：' + data[id][2];
                        }
                    },
                    radiusAxis: {
                    },
                    polar: {
                    },
                    series: [{
                        type: 'bar',
                        itemStyle: {
                            normal: {
                                color: 'transparent'
                            }
                        },
                        data: data.map(function (d) {
                            return d[0];
                        }),
                        coordinateSystem: 'polar',
                        stack: '最大最小值',
                        silent: true
                    }, {
                        type: 'bar',
                        data: data.map(function (d) {
                            return d[1] - d[0];
                        }),
                        coordinateSystem: 'polar',
                        name: '价格范围',
                        stack: '最大最小值'
                    }, {
                        type: 'bar',
                        itemStyle: {
                            normal: {
                                color: 'transparent'
                            }
                        },
                        data: data.map(function (d) {
                            return d[2] - barHeight;
                        }),
                        coordinateSystem: 'polar',
                        stack: '均值',
                        silent: true,
                        z: 10
                    }, {
                        type: 'bar',
                        data: data.map(function (d) {
                            return barHeight * 2
                        }),
                        coordinateSystem: 'polar',
                        name: '均值',
                        stack: '均值',
                        barGap: '-100%',
                        z: 10
                    }],
                    legend: {
                        show: true,
                        data: ['A', 'B', 'C']
                    }
                })

                //---------------------------------------------------------------------------
                let unitPriceRank = echarts.init(document.getElementById('unitPriceRank'));

                let cities1= [];
                res.data.sort((a,b)=>{
                    return -(a.maxUnitPrice - b.maxUnitPrice)
                });
                res.data.forEach((item)=>{
                    this.groupByRegionUnitPrice.push([
                        item.minUnitPrice,item.maxUnitPrice,item.unitPrice,
                    ]);
                    cities1.push(item.region)
                });
                let data1 = this.groupByRegionUnitPrice;
                unitPriceRank.setOption({
                    title: {
                        text: '长沙二手房均价',
                        subtext: '单位：每平米'
                    },
                    legend: {
                        show: true,
                        data: ['价格范围', '均值']
                    },
                    grid: {
                        top: 100
                    },
                    angleAxis: {
                        type: 'category',
                        data: cities1
                    },
                    tooltip: {
                        show: true,
                        formatter: function (params) {
                            var id = params.dataIndex;
                            return cities1[id] + '<br>最低：' + data1[id][0] + '<br>最高：' + data1[id][1] + '<br>平均：' + data1[id][2];
                        }
                    },
                    radiusAxis: {
                    },
                    polar: {
                    },
                    series: [{
                        type: 'bar',
                        itemStyle: {
                            normal: {
                                color: 'transparent'
                            }
                        },
                        data: data1.map(function (d) {
                            return d[0];
                        }),
                        coordinateSystem: 'polar',
                        stack: '最大最小值',
                        silent: true
                    }, {
                        type: 'bar',
                        data: data1.map(function (d) {
                            return d[1] - d[0];
                        }),
                        coordinateSystem: 'polar',
                        name: '价格范围',
                        stack: '最大最小值'
                    }, {
                        type: 'bar',
                        itemStyle: {
                            normal: {
                                color: 'transparent'
                            }
                        },
                        data: data1.map(function (d) {
                            return d[2] - barHeight;
                        }),
                        coordinateSystem: 'polar',
                        stack: '均值',
                        silent: true,
                        z: 10
                    }, {
                        type: 'bar',
                        data: data1.map(function (d) {
                            return barHeight * 2
                        }),
                        coordinateSystem: 'polar',
                        name: '均值',
                        stack: '均值',
                        barGap: '-100%',
                        z: 10
                    }],
                    legend: {
                        show: true,
                        data: ['A', 'B', 'C']
                    }
                })


            })
        }
    }
</script>

<style scoped lang="less">
    .main-wrapper {
        width: 100%;
        padding: 20px;
        margin: 30px;
        background-color: white;
    }

    .content-loading {
        display: flex;
    }

    .detail {

    }

    .content-row {
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    #totalPriceRank , #unitPriceRank{
        width: 100%;
        height: 300px;
    }
</style>