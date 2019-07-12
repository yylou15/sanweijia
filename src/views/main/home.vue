<template>
    <div class="home-wrapper">
        <br><br>
        <Row class="cards-row">
            <Col span="6">

                <Card style="width:100%">
                    <h3 style="color: gray;">总计条目</h3>
                    <div class="card-icon">
                        <Icon type="md-eye" color="CornflowerBlue" size="20"/>
                    </div>
                    <br>
                    <div class="stat-num">712,345,340</div>
                    <br>
                    <div class="stat-change">
                        <div class="week-change">
                            周变化：13%
                            <Icon type="md-arrow-dropup" color="green" size="20"/>
                        </div>
                        <div class="week-change">
                            日变化：5%
                            <Icon type="md-arrow-dropdown" color="red" size="20"/>
                        </div>
                    </div>
                    <div class="card-footer">
                        <div>日均访问</div>
                        <div>27,289</div>
                    </div>
                </Card>
            </Col>
            <Col span="6">
                <Card style="width:100%">
                    <h3 style="color: gray;">总计关注</h3>
                    <div class="card-icon">
                        <Icon type="md-heart" color="#f36976" size="20"/>
                    </div>
                    <br>
                    <div class="stat-num">567,980</div>
                    <br>
                    <div class="stat-change">
                        <div class="week-change">
                            周变化：3%
                            <Icon type="md-arrow-dropup" color="green" size="20"/>
                        </div>
                        <div class="week-change">
                            日变化：1%
                            <Icon type="md-arrow-dropdown" color="red" size="20"/>
                        </div>
                    </div>
                    <div class="card-footer" style="background-color: #f36976">
                        <div>日均关注</div>
                        <div>3423</div>
                    </div>
                </Card>
            </Col>
            <Col span="6">
                <Card style="width:100%">
                    <h3 style="color: gray;">总计评论</h3>
                    <div class="card-icon">
                        <Icon type="md-chatbubbles" color="#feb848" size="20"/>
                    </div>
                    <br>
                    <div class="stat-num">48,907</div>
                    <br>
                    <div class="stat-change">
                        <div class="week-change">
                            周变化：27%
                            <Icon type="md-arrow-dropup" color="green" size="20"/>
                        </div>
                        <div class="week-change">
                            日变化：12%
                            <Icon type="md-arrow-dropdown" color="red" size="20"/>
                        </div>
                    </div>
                    <div class="card-footer" style="background-color: #feb848">
                        <div>日均评论</div>
                        <div>756</div>
                    </div>
                </Card>
            </Col>
        </Row>
        <br><br><br>
        <Row class="graph-cards-row">
            <Col span="6">
                <Card class="graph-cards">
                    <div slot="title">
                        <Icon type="md-trending-up" color="#4f9efa" size="25"/>
                        &nbsp;
                        <span style="color: #4f9efa;font-weight: bold;font-size: 16px">趋&nbsp;势&nbsp;图</span>
                    </div>
                    <div class="content" id="trend-container"></div>
                </Card>
            </Col>
            <Col span="6"></Col>
            <Col span="6">
                <Card style="width: 100%">
                    <div slot="title">
                        <Icon type="md-stats" color="#4f9efa" size="25"/>
                        &nbsp;
                        <span style="color: #4f9efa;font-weight: bold;font-size: 16px">地区房源数排行</span>
                    </div>
                    <div class="content" id="rank-container">

                    </div>
                </Card>
            </Col>
        </Row>
    </div>
</template>

<script>
    import echarts from 'echarts';

    export default {
        name: "home",
        data() {
            return {
                lineItemStyle: {
                    normal: {
                        lineStyle: {
                            width: 4//设置线条粗细
                        }
                    }
                }
            }
        },
        mounted() {

            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('trend-container'));
// 绘制图表
            myChart.setOption({

                xAxis: {
                    type: 'category',
                    data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
                },
                yAxis: {
                    type: 'value'
                },
                series: [{
                    data: [820, 932, 1400, 934, 1290, 1330, 1320],
                    type: 'line',
                    smooth: true,
                    itemStyle: this.lineItemStyle,
                    color: '#4f9efa'
                }, {
                    data: [400, 500, 650, 700, 850, 1200, 2000],
                    type: 'line',
                    smooth: true,
                    itemStyle: this.lineItemStyle,
                    color: '#f36976'
                }, {
                    data: [800, 900, 950, 1130, 1200, 1506, 1650],
                    type: 'line',
                    smooth: true,
                    itemStyle: this.lineItemStyle,
                    color: '#feb848'
                }]
            });


            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('trend-container'));
// 绘制图表
            var myChart1 = echarts.init(document.getElementById('rank-container'));
            myChart1.setOption(
                {
                    tooltip: {
                        trigger: 'axis',
                        axisPointer: {
                            type: 'shadow'
                        }
                    },
                    grid: {
                        right: '10%',
                        top: '10%',
                        bottom: '3%',
                        containLabel: true
                    },
                    xAxis: {
                        type: 'value',
                        // boundaryGap: [0, 0.01]
                    },
                    yAxis: {
                        type: 'category',
                        data: ['开福区', '天心区', '雨花区', '岳麓区', '长沙县']
                    },
                    series: [
                        {
                            name: '2011年',
                            type: 'bar',
                            data: [18203, 23489, 29034, 104970, 131744],
                            color: '#4f9efa',

                        }
                    ]
                }
            );


        }
    }
</script>

<style scoped lang="less">
    .home-wrapper {
        /*padding: 30px 50px;*/
        height: 100%;
        overflow: auto;
    }

    .cards-row {
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    .card-icon {
        position: absolute;
        top: 15px;
        right: 10px;
        width: 30px;
        height: 30px;
        display: flex;
        justify-content: center;
        align-items: center;
        background-color: #cde9fa;
        border-radius: 50%;
    }

    .stat-num {
        font-size: 30px;
    }

    .stat-change {
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    .card-footer {
        width: e("calc(100% + 32px)");
        margin-left: -16px;
        margin-bottom: -16px;
        margin-top: 16px;
        height: 50px;
        background-color: #4f9efa;
        border-radius: 0 0 3px 3px;
        padding: 15px;
        color: white;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    .graph-cards-row {
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    .graph-cards {
        width: e("calc((100vw * 5 / 6) * 9 / 16)");
    }

    .content {
        height: 350px;
    }
</style>